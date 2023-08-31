'use strict';

var app = require('../../server/server');

module.exports = function(Treinogruporede) {

    Treinogruporede.AtualizaTemData = function(idGrupo, callback) {
        let sql = "select TreinoRede.id as idTreinoRede, diaNumFinalTeste -date_format(maiorDataProcessamento,'%Y%m%d') as diferenca " +
            " from TreinoRede " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " where treinoGrupoRedeId = " + idGrupo
        //console.log('sql1' , sql);
        let ds = Treinogruporede.dataSource;
        ds.connector.query(sql, (err,result) => {
            let x = 0;
            for (let i=0; i<result.length;i++) {
                let valor = (result[i]['diferenca']>0?0:1)
                let sql2 = "update TreinoRede set temDataParaTreinar = " + valor + " where id = " + result[i]['idTreinoRede'];
                //console.log(sql2);
                ds.connector.query(sql2, (err,result2) => {
                    //console.log('err:' , err);
                    x++;
                    if (x==result.length) {
                        let sqlPontos = "  update TreinoRede " +
                                " set prontoDataTreino =  " +
                                " ( " +
                                " select  " +
                                " case  " +
                                " when diaNumFinalTreino < date_format(maiorDataProcessamento,'%Y%m%d') then 1 " +
                                " else 0 " +
                                " end " +
                                " from PeriodoTreinoRede, RegraProjecao " +
                                " where PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId and " +
                                " RegraProjecao.id = TreinoRede.regraProjecaoId " +
                                " ) , " +
                                " prontoDataTeste =  " +
                                " ( " +
                                " select  " +
                                " case  " +
                                " when diaNumFinalTeste < date_format(maiorDataProcessamento,'%Y%m%d') then 1 " +
                                " else 0 " +
                                " end " +
                                " from PeriodoTreinoRede, RegraProjecao " +
                                " where PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId and " +
                                " RegraProjecao.id = TreinoRede.regraProjecaoId " +
                                " ) , " +
                                " prontoSaidaFinalizado =  " +
                                " ( " +
                                " select  " +
                                " case  " +
                                " when ultimaInsercao is not null then 1 " +
                                " else 0 " +
                                " end " +
                                " from RegraProjecao " +
                                " where RegraProjecao.id = TreinoRede.regraProjecaoId " +
                                " ) " +
                                " where TreinoRede.treinoGrupoRedeId = " + idGrupo
                        ds.connector.query(sqlPontos, (err,result) => {
                            console.log(result);
                            callback(err,{'total' : result.length});      
                        })
                    }
                })
            }
           
        })
    }
   

    Treinogruporede.LimpaTreino = function(idGrupo, callback) {
        let ds = Treinogruporede.dataSource;

        let sqlTeste = " select * from  TreinoRede " +
            " where treinoGrupoRedeId = " + idGrupo + 
            " and dataTreinamento is not null " +
            " limit 1";
        ds.connector.query(sqlTeste, (err,result) => {
            if (result.length==0) {
                let sqlDelete = " delete from  TreinoRede " +
                    " where treinoGrupoRedeId = " + idGrupo;
                ds.connector.query(sqlDelete, callback);
            } else {
                callback({"msg" : "tem item treinado"},null);
            }

        })
    }


    Treinogruporede.CriaTreino = function(idGrupo, callback) {
        console.log('ID' , idGrupo);

        let sqlLimpa = "delete from TreinoRede " +
            " where treinoGrupoRedeId = " + idGrupo +
            " and dataTreinamento is null";

        let ds = Treinogruporede.dataSource;
        
        let yourDate = new Date();
        let dataInsercao = yourDate.toISOString().split('T')[0];


        ds.connector.query(sqlLimpa, (err,result) => {
            Treinogruporede.findById(idGrupo, (err,grupoTreino) => {
                //console.log('Err1' , err);
                let filtroRede = {'include' : 'redeNeural', 'where' : {'grupoRedeId' : grupoTreino.grupoRedeId }};
                let filtroRegra = {'where' : {'grupoRegraId' : grupoTreino.grupoRegraId }};
                console.log('filtroRede:' , JSON.stringify(filtroRede));
                app.models.GrupoRedeRel.find(filtroRede, (err,grupoRedeRel) => {
                    //console.log('Err2' , err);
                    //console.log('grupoRedeRel.length=' , grupoRedeRel.length);
                    grupoRedeRel.forEach((itemGrupoRedeRel) => {
                        app.models.GrupoRegraRel.find(filtroRegra, (err,grupoRegraRel) => {
                            //console.log('Err3' , err);
                            grupoRegraRel.forEach((itemGrupoRegraRel) => {
                                let treino = {
                                    'limiteParaEntrada' : 0.5,
                                    'redeNeuralId' : itemGrupoRedeRel.redeNeuralId,
                                    'grupoAcaoId' : grupoTreino.grupoAcaoId,
                                    'periodoTreinoRedeId' : grupoTreino.periodoTreinoRedeId,
                                    'regraProjecaoId' : itemGrupoRegraRel.regraProjecaoId,
                                    'treinoGrupoRedeId' : grupoTreino.id,
                                    'dataCriacaoGmt' : new Date(),
                                    'tipoExemploTreinoId' : itemGrupoRedeRel.redeNeural.tipoExemploTreino1Id,
                                }
                                //console.log(treino);
                                let filtro = {'where' : {'and' : [
                                    {'redeNeuralId' : treino.redeNeuralId},
                                    {'regraProjecaoId' : treino.regraProjecaoId },
                                    {'treinoGrupoRedeId' : treino.treinoGrupoRedeId },
                                    {'periodoTreinoRedeId' : treino.periodoTreinoRedeId },
                                    {'grupoAcaoId' : treino.grupoAcaoId }
                                ]}}
                                app.models.TreinoRede.find(filtro,(err,result) => {
                                    if (result.length==0) {
                                        console.log(treino);
                                        app.models.RegraProjecao.findById(treino.regraProjecaoId, (err,regra) => {
                                            treino['tipoCompraVenda'] = regra.tipoCompraVenda;
                                            app.models.TreinoRede.create(treino)
                                        })
                                       
                                    }
                                })
                               
                            })
                        })
                    })
                })
                callback(err,grupoTreino);
            })
        })
       
    }
};

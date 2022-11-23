'use strict';

var app = require('../../server/server');

module.exports = function(Treinogruporede) {

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
        let ds = Treinogruporede.dataSource;
        
        let yourDate = new Date();
        let dataInsercao = yourDate.toISOString().split('T')[0];
       
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
                                'tipoExemploTreinoId' : itemGrupoRedeRel.redeNeural.tipoExemploTreino1Id
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
                                    app.models.TreinoRede.create(treino)
                                }
                            })
                           
                        })
                    })
                })
            })
            callback(err,grupoTreino);
        })
    }
};

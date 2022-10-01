'use strict';

var app = require('../../server/server');

module.exports = function(Treinorede) {


    Treinorede.LigaMelhoresPrevisao = function(quantidade,tipo,callback) {
        let sqlLimpa = "update TreinoRede " +
                " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
                " set ativoPrevisao = 0 " +
                " where RegraProjecao.tipoCompraVenda = '" + tipo + "' " +
                " and TreinoRede.treinoGrupoRedeId is not null ";
        let sql1 = "select TreinoRede.* from TreinoRede " +
                " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
                " where RegraProjecao.tipoCompraVenda = '" + tipo + "' " + 
                " order by pontuacaoTeste desc, qtdePrejuizoTeste asc, id " +
                " limit " + quantidade;
        let ds = Treinorede.dataSource;
        ds.connector.query(sqlLimpa, (err,result) => {
            if (!err) {
                ds.connector.query(sql1, (err,result) => {
                    if (result.length) {
                        result.forEach(element => {
                            let sql2 = "update TreinoRede set ativoPrevisao = 1 where id = " + element.id;
                            console.log(sql2)
                            ds.connector.query(sql2, (err,result) => {
                                if (err) console.log(err);
                            })
                        });
                    }
                }); 
            } else {
                console.log(err);
            }
        })
        callback(null,{'terminou': 'ok'})
    }




    Treinorede.RecebeListaTeste = function(listaId, callback) {
        let listaIdStr = listaId.toString();
        let sql = "update TreinoRede set dataTeste = now() where id in (" + listaIdStr + ")";
        console.log(sql);
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.DesligaTesteGrupo = function(idGrupoTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoTeste = 0 " +
            " where treinoGrupoRedeId = " + idGrupoTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.AlteraAtivaTeste = function(idTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoTeste = case when ativoTeste = 0 then 1 else 0 end " +
            " where id = " + idTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }
    Treinorede.AlteraAtivaPrevisaoTeste = function(idTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoPrevisaoTeste =  case when ativoPrevisaoTeste = 0 then 1 else 0 end  " +
            " where id = " + idTreino;
        let sql2 = "update PrevisaoTeste " +
            " set pontuacao = null, " +
            " resultado = null, " +
            " diaNumSaida = null, " +
            " precoSaida = null " +
            " where treinoRedeId = " + idTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql2, (err,result) => {
            ds.connector.query(sql,callback);
        })
       
    }


    Treinorede.ExecutouTreinamento = function(id,callback) {
        let sql = "update TreinoRede " +
            " set dataTreinamento = now(), " +
            " ativoTeste = 1 " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ExecutouDadoTeste = function(id,callback) {
        let sql = "update TreinoRede " +
            " set dataTeste = now(), " +
            " ativoTeste = 0, " +
            " mediaValorTeste = (select avg(valorPrevisao) from PrevisaoTeste where PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " desvioValorTeste = (select STDDEV(valorPrevisao) from PrevisaoTeste where PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " ativoPrevisaoTeste = 1 " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ExecutouPrevisaoTeste = function(id,callback) {
        let sql = "update TreinoRede " +
            " set qtdeTradeTeste = (select count(*) from PrevisaoTeste where precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " pontuacaoTeste = (select sum(pontuacao*100) from PrevisaoTeste where precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdeLucroTeste = (select count(*) from PrevisaoTeste where resultado = 1 and precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdePrejuizoTeste = (select count(*) from PrevisaoTeste where resultado = -1 and precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " dataPrevisaoTeste = now(), " +
            " ativoPrevisaoTeste = 0 " +         
            " where id = "  + id;
        let sqlAjusteMaximos = "update TreinoRede " +
                " inner join PeriodoTreinoRede on TreinoRede.periodoTreinoRedeId = PeriodoTreinoRede.id " +
                " set limiteParaEntrada = limiteParaEntrada + 0.01, " +
                " ativoPrevisaoTeste = 1 " +
                " where TreinoRede.id = " + id + " and qtdeTradeTeste > maximoTradeTeste";
        let sqlAjusteMinimos = "update TreinoRede " +
                " inner join PeriodoTreinoRede on TreinoRede.periodoTreinoRedeId = PeriodoTreinoRede.id " +
                " set limiteParaEntrada = limiteParaEntrada - 0.01, " +
                " ativoPrevisaoTeste = 1 " +
                " where TreinoRede.id = " + id + " and qtdeTradeTeste < minimoTradeTeste and limiteParaEntrada > 0";        
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,(err,result) => {
            ds.connector.query(sqlAjusteMaximos, (err,result) => {
                ds.connector.query(sqlAjusteMinimos, callback);
            });
        });
    }

    Treinorede.AtualizaPontuacaoTreino = function(id,callback) {
        let sql = "update TreinoRede " +
            " set qtdeLucroTeste = (select count(*) from PrevisaoTeste where resultado = 1 and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdePrejuizoTeste = (select count(*) from PrevisaoTeste where resultado = -1 and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " pontuacaoTeste = (select sum(pontuacao) from PrevisaoTeste where pontuacao <> 0 and PrevisaoTeste.treinoRedeId = TreinoRede.id) " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.ObtemListaParaTreino = function(callback) {
        let filtro = {'include' : ['redeNeural' , 'periodoTreinoRede' , 'tipoExemploTreino']}
        Treinorede.find(filtro,callback);
    } 

    Treinorede.ObtemListaParaPrevisao = function(callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " where ativoPrevisao = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 
 
    Treinorede.ObtemListaPrevisaoExecucaoComTradeAberto = function(callback) {
        let filtro = {
            'include' : [
                'regraProjecao',
                'periodoTreinoRede'
            ],
            'where' : {'ativoPrevisao' : 1}
        }
        Treinorede.find(filtro,callback);

        /*
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste, " +
                    " PeriodoTreinoRede.maximoTradeTeste, PeriodoTreinoRede.minimoTradeTeste , PeriodoTreinoRede.simultaneoTradeTeste, " +
                    " PeriodoTreinoRede.diaNumInicioExecucao, PeriodoTreinoRede.diaNumFinalExecucao " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where ativoPrevisao = 1";
            let ds = Treinorede.dataSource;
            ds.connector.query(sql,callback);
        */
    } 
    Treinorede.ObtemListaPrevisaoTeste = function(callback) {
        let sqlLimpeza = "update PrevisaoTeste  " +
                    " inner join TreinoRede on TreinoRede.id = PrevisaoTeste.treinoRedeId " +
                    " set resultado = 0, pontuacao = 0, diaNumSaida = null, precoSaida = null " +
                    " where ativoPrevisaoTeste = 1";
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste, " +
                    " PeriodoTreinoRede.maximoTradeTeste, PeriodoTreinoRede.minimoTradeTeste , PeriodoTreinoRede.simultaneoTradeTeste, " +
                    " PeriodoTreinoRede.diaNumInicioExecucao, PeriodoTreinoRede.diaNumFinalExecucao " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where ativoPrevisaoTeste = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sqlLimpeza,(err,result) => {
            ds.connector.query(sql, callback);
        });
    } 
    Treinorede.ObtemListaParaTestePorGrupo = function(id,callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where ativoTeste = 1 and treinoGrupoRedeId = " + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 

    Treinorede.ListaPrevisaoDiaTreino = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let filtro = {
                'order' : 'pontuacaoTeste desc',
                'where' : {'ativoPrevisao' : 1},
                'include' : 
                [
                    'redeNeural' , 'regraProjecao',
                    { 
                    'relation' : 'previsaoRedes',
                    'scope' : 
                        {'where' : { 'and' : [ {'valor' : {'gt' : 0.25 }} , {'diaNumPrevisao' : result.diaNum }] }, 
                        "order" : "valorPrevisao desc" , 'limit' : 10} 
                    },
                ], 
            }
            Treinorede.find(filtro,callback);
        });       
    }
}

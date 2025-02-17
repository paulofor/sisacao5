'use strict';

var app = require('../../server/server');

module.exports = function(Treinorede) {

    Treinorede.AtualizaScore1Teste = function(treino,callback) {
        console.log(treino);
        let sql = "update TreinoRede " +
            " set score1QtdeLucro = " + treino.score1QtdeLucro + ", " +
            " score1QtdePrejuizo = " + treino.score1QtdePrejuizo + ", " +
            " score1Pontuacao = " + treino.score1Pontuacao + 
            " where id = " + treino.id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.AtualizaScore2Teste = function(treino,callback) {
        console.log(treino);
        let sql = "update TreinoRede " +
            " set score2QtdeLucro = " + treino.score2QtdeLucro + ", " +
            " score2QtdePrejuizo = " + treino.score2QtdePrejuizo + ", " +
            " score2Pontuacao = " + treino.score2Pontuacao + 
            " where id = " + treino.id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ListaPendentePontuacaoFaseTeste = function(callback) {
        let filtro = {
            'where' : {'pendentePontuacaoFaseTeste' : 1},
            'limit' : 100
        }
        Treinorede.find(filtro,callback);
    }



    Treinorede.AtualizaValoresReais = function(callback) {
        let sql = "update TreinoRede " +
            " set financeiroReal = ( " +
            " select sum(lucroPrejuizo) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and  " +
            " posicaoAtual = 0 " +
            " ), " + 
            " qtdeTradeReal = ( " +
            " select count(*) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and  " +
            " posicaoAtual = 0 " +
            " ), " +
            " mediaPercentualReal = ( " +
            " select avg(percentual) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and  " +
            " posicaoAtual = 0 " +
            " ), " +
            " qtdeLucroReal = ( " +
            " select count(*) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and  " +
            " posicaoAtual = 0 and lucroPrejuizo > 0 " +
            " ), " +
            " qtdePrejuizoReal = ( " +
            " select count(*) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and " +
            " posicaoAtual = 0 and lucroPrejuizo < 0 " +
            " ), " +
            " mediaPercentualReal = ( " +
            " select avg(percentual) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and  " +
            " posicaoAtual = 0 " +
            " ), " +
            " desvioPercentualReal = ( " +
            " select STDDEV(percentual) from TradeReal " +
            " where TreinoRede.id = TradeReal.treinoRedeId and " +
            " posicaoAtual = 0 " +
            " ) "
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.ObtemSelecionadoComPeriodoExecucao = function(callback) {
        let filtro = {
                'where' : {'ativoPrevisao' : 1 },
                'include' : 'periodoTreinoRede'
            }
        Treinorede.find(filtro, callback);
    }

    Treinorede.ObtemPorGrupoComPeriodoExecucao = function(idGrupo, callback) {
        let filtro = {
                'where' : {'treinoGrupoRedeId' : idGrupo },
                'include' : 'periodoTreinoRede'
            }
        Treinorede.find(filtro, callback);
    }


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
        //ds.connector.query(sqlLimpa, (err,result) => {
        //    if (!err) {
        ds.connector.query(sql1, (err,result) => {
            if (result.length) {
                result.forEach(element => {
                    let sql2 = "update TreinoRede set ativoPrevisao = 1 where id = " + element.id;
                    //console.log(sql2)
                    ds.connector.query(sql2, (err,result) => {
                        if (err) console.log(err);
                    })
                });
            }
        }); 
        //    } else {
        //       console.log(err);
        //    }
        //})
        callback(null,{'terminou': 'ok'})
    }


    Treinorede.ContagemMes = function(callback) {
        let sql = "select  date(DATE_SUB(dataTeste,INTERVAL DAYOFMONTH(dataTeste)-1 DAY)) as dataReferencia, " +
            " count(*) as qtdeTreino " +
            " from TreinoRede " +
            " where dataTeste is not null " +
            " group by date(DATE_SUB(dataTeste,INTERVAL DAYOFMONTH(dataTeste)-1 DAY)) ";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
        
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
            " set ativoTeste = case when ativoTeste = 0 then 1 else 0 end, " +

            " where id = " + idTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }
    Treinorede.AlteraAtivaPrevisaoTeste = function(idTreino,callback) {
        console.log('Entrou no metodo');
        let sql = "update TreinoRede " +
            " set ativoPrevisaoTeste = 1,  " +
            " dataPrevisaoTeste = null, " +
            " pontuacaoTeste = null, " +
            " qtdeLucroTeste = null, " +
            " qtdePrejuizoTeste = null, " +
            " qtdeTradeTeste = null, " +
            " limiteParaEntrada = 0.5 " +
            " where id = " + idTreino;
        let sql2 = "update PrevisaoTeste " +
            " set pontuacao = null, " +
            " resultado = null, " +
            " diaNumSaida = null, " +
            " precoSaida = null " +
            " where treinoRedeId = " + idTreino;
        let ds = Treinorede.dataSource;
        console.log(sql)
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
            console.log('err1' , err);
            ds.connector.query(sqlAjusteMaximos, (err,result) => {
                console.log('err2', err);
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

    Treinorede.AtualizaPontuacaoExecucao = function(id,callback) {
        let sql = "update TreinoRede " +
            " set qtdeLucroExecucao = (select count(*) from TradeTreinoRede where resultado = 1 and TradeTreinoRede.treinoRedeId = TreinoRede.id), " +
            " qtdePrejuizoExecucao = (select count(*) from TradeTreinoRede where resultado = -1 and TradeTreinoRede.treinoRedeId = TreinoRede.id), " +
            " pontuacaoExecucao = (select sum(pontuacao) from TradeTreinoRede where pontuacao <> 0 and TradeTreinoRede.treinoRedeId = TreinoRede.id) " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ObtemListaParaTreino = function(callback) {
        let filtro = {'include' : ['redeNeural' , 'periodoTreinoRede' , 'tipoExemploTreino']}
        Treinorede.find(filtro,callback);
    } 

    Treinorede.ObtemListaParaPrevisao = function(callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, T1.qtdeDias qtdeDias1 , T2.qtdeDias qtdeDias2 from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join RedeNeural on RedeNeural.id = TreinoRede.redeNeuralId " + 
            " inner join TipoExemploTreino T1 on T1.id = RedeNeural.tipoExemploTreino1Id " +
            " left outer join TipoExemploTreino T2 on T2.id = RedeNeural.tipoExemploTreino2Id " +
            " where ativoPrevisao = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 
 
    Treinorede.ObtemListaPrevisaoExecucaoComTradeAberto = function(callback) {
        let filtro = {
            'include' : [
                'regraProjecao',
                'periodoTreinoRede',
                {'relation' : 'tradeTreinoRedes' , 'scope' : {'where' : { 'precoSaida' : null } } }
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
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste, " +
            "  Tipo1.qtdeDias as tipo1QtdeDias " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " inner join RedeNeural on RedeNeural.id = TreinoRede.redeNeuralId " +
            " inner join TipoExemploTreino as Tipo1 on Tipo1.id = RedeNeural.tipoExemploTreino1Id " +
            " where ativoTeste = 1 and treinoGrupoRedeId = " + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 
    Treinorede.ObtemListaParaTeste = function(callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste, " +
            "  Tipo1.qtdeDias as tipo1QtdeDias , Tipo2.qtdeDias as tipo2QtdeDias " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " inner join RedeNeural on RedeNeural.id = TreinoRede.redeNeuralId " +
            " inner join TipoExemploTreino as Tipo1 on Tipo1.id = RedeNeural.tipoExemploTreino1Id " +
            " left outer join TipoExemploTreino as Tipo2 on Tipo2.id = RedeNeural.tipoExemploTreino2Id " +
            " where ativoTeste = 1 ";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 

    Treinorede.ListaPrevisaoDiaTreino = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let filtro = {
                'order' : 'pontuacaoExecucao desc',
                'where' : {'ativoPrevisao' : 1},
                'include' : 
                [
                    'redeNeural' , 'regraProjecao', 
                    {'relation' : 'tradeTreinoRedes' ,
                    'scope' : 
                        {
                            'order' : 'diaNumEntrada',
                            'include' : 'previsaoRede'
                        } 
                    }, 
                    { 
                    'relation' : 'previsaoRedes',
                    'scope' : 
                        {
                        'where' : { 'and' : [ {'valor' : {'gt' : 0.25 }} , {'diaNumPrevisao' : result.diaNum }] }, 
                        "order" : "valorPrevisao desc" , 'limit' : 10,
                        } 
                    },
                ], 
            }
            Treinorede.find(filtro,callback);
        });       
    }
}

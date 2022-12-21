'use strict';

var app = require('../../server/server');

module.exports = function(Tradetreinorede) {

/*
update TradeTreinoRede
set precoAtual = (select valor from CotacaoIntradayAcao where TradeTreinoRede.ticker = CotacaoIntradayAcao.ticker 
order by dataHora desc limit 1)
where diaNumSaida is null

update TradeTreinoRede
set percentualAtual = ((precoEntrada - precoAtual) / precoEntrada) * 100
where diaNumSaida is null and tipoCompraVenda = 'V'

update TradeTreinoRede
set percentualAtual = ((precoAtual - precoEntrada) / precoEntrada) * 100
where diaNumSaida is null and tipoCompraVenda = 'C'
*/

    Tradetreinorede.AtualizaTreino = function(listaTrade,callback) {
        if (listaTrade.length>0) {
            let sql = 'delete from TradeTreinoRede where treinoRedeId = ' + listaTrade[0].treinoRedeId;
            let ds = Tradetreinorede.dataSource;
            ds.connector.query(sql, (err,result) => {
                if (!err) {
                    let i=listaTrade.length;
                    listaTrade.forEach(trade => {
                        Tradetreinorede.create(trade, (err,result) => {
                            i--;
                            if (i==0) {
                                console.log('Atualiza Treino Raiz');
                                let sqlLast = "update TreinoRede " +
                                    " set pontuacaoExecucao = (select sum(pontuacao) from TradeTreinoRede where TradeTreinoRede.treinoRedeId = TreinoRede.id), " +
                                    " qtdeLucroExecucao = (select count(*) from TradeTreinoRede where TradeTreinoRede.treinoRedeId = TreinoRede.id and resultado=1), " +
                                    " qtdePrejuizoExecucao = (select count(*) from TradeTreinoRede where TradeTreinoRede.treinoRedeId = TreinoRede.id and resultado=-1) " +
                                    " where TreinoRede.id = " + listaTrade[0].treinoRedeId;
                                ds.connector.query(sqlLast, (errL,resultL) => {
                                    console.log('Err - final' , err);
                                })
                            }
                        })
                    });
                }
            });
            callback(null,{'recebeu' : 'ok'});
        }
    }


    Tradetreinorede.InsereTrade = function(trade,callback) {
        Tradetreinorede.create(trade,callback);
    }

    Tradetreinorede.FinalizaTrade = function(trade,callback) {
        let sql = "update TradeTreinoRede " +
            " set precoSaida = " + trade.precoSaida + " , " +
            " diaNumSaida = " + trade.diaNumSaida +  " , " +
            " pontuacao = " + trade.pontuacao +  " , " +
            " resultado = " + trade.resultado + 
            " where ticker = '" + trade.ticker + "' and " +
            " diaNumEntrada = " + trade.diaNumEntrada + " and " +
            " treinoRedeId = " + trade.treinoRedeId;
        let ds = Tradetreinorede.dataSource;
        ds.connector.query(sql,(err,result) => {
            app.models.TreinoRede.AtualizaPontuacaoExecucao(trade.treinoRedeId,callback);
        });
    }

    Tradetreinorede.AtualizaTrade = function(callback) {
        let sql = " update TradeTreinoRede " +
                " set precoAtual = (select valor from CotacaoIntradayAcao where TradeTreinoRede.ticker = CotacaoIntradayAcao.ticker " +
                " order by dataHora desc limit 1), " +
                " diaNumAtual = (select diaNum from CotacaoIntradayAcao where TradeTreinoRede.ticker = CotacaoIntradayAcao.ticker " +
                " order by dataHora desc limit 1) " +
                " where diaNumSaida is null ";
        let sql1 = " update TradeTreinoRede " +
                " set percentualAtual = ((precoEntrada - precoAtual) / precoEntrada) * 100 " +
                " where diaNumSaida is null and tipoCompraVenda = 'V' " ;
        let sql2 = " update TradeTreinoRede " +
                " set percentualAtual = ((precoAtual - precoEntrada) / precoEntrada) * 100 " +
                " where diaNumSaida is null and tipoCompraVenda = 'C' " ;
        let ds = Tradetreinorede.dataSource;
        console.log(sql);
        ds.connector.query(sql,(err,result) => {
            ds.connector.query(sql1, (err,result) => {
                ds.connector.query(sql2, callback);
            })
        });
    }
};

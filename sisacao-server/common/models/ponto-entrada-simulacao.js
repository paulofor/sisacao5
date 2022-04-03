'use strict';

var app = require('../../server/server');

module.exports = function(Pontoentradasimulacao) {

    Pontoentradasimulacao.PreparaProximoDia = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let sql = "insert into PontoEntradaSimulacao (ticker, diaNum, periodoExperimentoId, tipo, valor, valorLimite, votantes, votos) " +
                " select ticker, diaNumEntrada, periodoExperimentoId, tipo , min(valorEntrada), max(valorEntrada), " +
                " ( " +
                " select count(*) from ValorMonitoria V2 " +
                " where V1.ticker = V2.ticker  " +
                " and V1.periodoExperimentoId = V1.periodoExperimentoId " +
                " and V1.tipo = V1.tipo " +
                " and V2.diaNumEntrada = V1.diaNumEntrada) as votantes, " +
                " (select count(*) from ValorMonitoria V2 " +
                " where V1.ticker = V2.ticker  " +
                " and V1.periodoExperimentoId = V1.periodoExperimentoId " +
                " and V1.tipo = V1.tipo " +
                " and V2.diaNumEntrada = V1.diaNumEntrada and valorEntrada>0) as votos " +
                " from ValorMonitoria V1 " +
                " where execucaoSimulacaoId in " +
                " ( " +
                " select id " +
                " from ExecucaoSimulacao E1 " +
                " where diaNumEntrada = " + result.diaNum +
                " )  " +
                " and valorEntrada > 0 " +
                " group by ticker, diaNumEntrada, periodoExperimentoId, tipo ";
            let ds = Pontoentradasimulacao.dataSource;
            ds.connector.query(sql,callback);
        })
    }


    Pontoentradasimulacao.SituacaoAtual = function(callback) {
        let sql = "select *, " +
            " 100 * ((atual-valor) / atual) as diferenca " + 
            " from " +
            " ( " +
            " SELECT * , " +
            " (select valor from CotacaoIntradayAcao c where c.ticker = p.ticker order by dataHora desc limit 1) atual , " +
            " (select dataHora from CotacaoIntradayAcao c where c.ticker = p.ticker order by dataHora desc limit 1) dataHora " +
            " FROM lojadigicom35.PontoEntradaSimulacao p " +
            " where diaNum = 20220404 " +
            " ) as compra " +
            " order by diferenca";
        let ds = Pontoentradasimulacao.dataSource;
        ds.connector.query(sql,callback);
    }
};

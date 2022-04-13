'use strict';

var app = require('../../server/server');

module.exports = function(Pontoentradasimulacao) {

    Pontoentradasimulacao.PreparaProximoDia = function(callback) {

        app.models.DiaPregao.ObtemProximoB3((err,result) => {
            let sql = "insert into PontoEntradaSimulacao (ticker, diaNum, periodoExperimentoId, tipo, valor, valorLimite, votantes, votos, execucaoSimulacaoId) " +

                " select *,  " +
                " (select execucaoSimulacaoId from ValorMonitoria vm  " +
                " where vm.ticker = duplo.ticker and  " +
                " vm.periodoExperimentoId = duplo.periodoExperimentoId and  " +
                " vm.diaNumEntrada = duplo.diaNumEntrada and  " +
                " vm.tipo = duplo.tipo and  " +
                " vm.valorEntrada = coalesce(valor,0) limit 1) as execucaoSimulacaoId  " +
                " from " +           
                " ( " +

                " select ticker, diaNumEntrada, periodoExperimentoId, tipo , min(valorEntrada) valor, max(valorEntrada) valorLimite, " +
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
                " group by ticker, diaNumEntrada, periodoExperimentoId, tipo " +
                " union all " +
                " select tab.ticker, tab.diaNumEntrada, tab.periodoExperimentoId, tab.tipo , 0, 0 , " +
                " (select count(*) from ValorMonitoria V2  " +
                " where V2.ticker = tab.ticker  " +
                " and V2.periodoExperimentoId = tab.periodoExperimentoId  " +
                " and V2.tipo = tab.tipo " +
                " and V2.diaNumEntrada = tab.diaNumEntrada) as votantes,  " +
                " (select count(*) from ValorMonitoria V2  " +
                " where V2.ticker = tab.ticker  " +
                " and V2.periodoExperimentoId = tab.periodoExperimentoId " +
                " and V2.tipo = tab.tipo  " +
                " and V2.diaNumEntrada = tab.diaNumEntrada and valorEntrada>0) as votos " +
                " from " +
                " ( " +
                " select ticker, diaNumEntrada, periodoExperimentoId, tipo, sum(valorEntrada) as soma " +
                " from ValorMonitoria " +
                " where diaNumEntrada =  " + result.diaNum +
                "  group by ticker, diaNumEntrada, periodoExperimentoId, tipo " +
                " )  tab " +
                " where soma = 0 " +
                
                ") as duplo ";
            let ds = Pontoentradasimulacao.dataSource;
            console.log(sql);
            ds.connector.query(sql,callback);
        })
    }


    Pontoentradasimulacao.SituacaoAtual = function(callback) {
        app.models.DiaPregao.ObtemProximoB3((err,result) => {
            let sql = "select *, " +
                " 100 * ((atual-valor) / atual) as diferenca " + 
                " from " +
                " ( " +
                " SELECT * , " +
                " (select valor from CotacaoIntradayAcao c where c.ticker = p.ticker order by dataHora desc limit 1) atual , " +
                " (select dataHora from CotacaoIntradayAcao c where c.ticker = p.ticker order by dataHora desc limit 1) dataHora " +
                " FROM lojadigicom35.PontoEntradaSimulacao p " +
                " where diaNum = " + result.diaNum +
                " ) as compra " +
                " order by diferenca";
            let ds = Pontoentradasimulacao.dataSource;
            ds.connector.query(sql,callback);
        })
    }
};

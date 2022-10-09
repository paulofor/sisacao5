'use strict';

module.exports = function(Cotacaodiarioacao) {


    Cotacaodiarioacao.LimitesPeriodo = function(ticker,diaInicio,diaFinal,callback) {
        let sql = "select min(minimo) as minimo, max(maximo) as maximo " +
                " from CotacaoDiarioAcao " +
                " where ticker = '" + ticker + "' " +
                " and diaNum >= " + diaInicio +
                " and diaNum < " + diaFinal;
        let ds = Cotacaodiarioacao.dataSource;
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    }

    Cotacaodiarioacao.CotacaoDia = function(ticker, diaNum, callback) {
        let filtro = {'where' : {'and' : [{'ticker':ticker},{'diaNum':diaNum}] }}
        Cotacaodiarioacao.findOne(filtro,callback);
    }
};

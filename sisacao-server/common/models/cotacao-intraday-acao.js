'use strict';

module.exports = function (Cotacaointradayacao) {


    /**
    * 
    * @param {number} valor 
    * @param {string} horario 
    * @param {Function(Error, object)} callback
    */

    Cotacaointradayacao.InsereValorHorario = function (ticker, valor, horario, callback) {
        let sql = "insert into CotacaoIntradayAcao (ticker,dataHora,valor,dataHoraNegStr, dia, posicaoDia, intervalo) " +
        "values ('" + ticker + "' , now(), " + valor + ", '" + horario + "' , now(), 0, 0 )"
        let ds = Cotacaointradayacao.dataSource;
        ds.connector.query(sql, callback);
    };


    /**
    * 
    * @param {string} dia 
    * @param {string} ticker 
    * @param {Function(Error, array)} callback
    */
    Cotacaointradayacao.ObtemPorDiaTicker = function(dia, ticker, callback) {
        var cotacao;

        let ds = Cotacaointradayacao.dataSource;

        var sql1 = " select dia from CotacaoIntradayAcao " +
            " where ticker = '" + ticker + "' " +
            " group by dia " +
            " order by dia desc " +
            " limit " + dia;

        ds.connector.query(sql1, (err,result) => {
            for (let i=0; i < result.length; i++) {
                console.log('linha:' , JSON.stringify(result[i]));
            }
        })
        
        callback(null, cotacao);
    };

};

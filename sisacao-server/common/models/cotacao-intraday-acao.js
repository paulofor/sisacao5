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
            "values ('" + ticker + "' , now(), " + valor + ", '" + horario + "' , null, 0, 0 )"
        let ds = Cotacaointradayacao.dataSource;
        ds.connector.query(sql, callback);
    };

};

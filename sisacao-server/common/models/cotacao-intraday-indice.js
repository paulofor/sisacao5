'use strict';

module.exports = function (Cotacaointradayindice) {

    /**
  * 
  * @param {number} valor 
  * @param {string} horario 
  * @param {Function(Error, object)} callback
  */

  Cotacaointradayindice.InsereValorHorarioIndice = function (ticker, valor, horario, callback) {
        let sql = "insert into CotacaoIntradayIndice (ticker,dataHora,valor,dataHoraNegStr, dia) " +
            "values ('" + ticker + "' , now(), " + valor + ", '" + horario + "' , now())"
        let ds = Cotacaointradayopcao.dataSource;
        ds.connector.query(sql, callback);
  };
};

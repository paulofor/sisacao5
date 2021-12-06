'use strict';

module.exports = function(Cotacaointradayacaoresultadovalor) {

    /**
    *  @param {array} lista 
    * @param {Function(Error, object)} callback
    */
    Cotacaointradayacaoresultadovalor.InsereLista = function(lista, callback) {
        let conta = 0;
        lista.forEach((item) => {
            item.dataHoraInsercao = new Date();
            Cotacaointradayacaoresultadovalor.create(item);
            conta++;
            if (conta==lista.length) {
                callback(null, { 'result': 'ok' });
            }
        });
    };


    /**
 * 
 * @param {string} ticker 
 * @param {number} idRegra 
 * @param {Function(Error, array)} callback
 */

  Cotacaointradayacaoresultadovalor.ObtemListaTickerRegra = function(ticker, idRegra, callback) {
    let filtro = {
        'fields' : { 
            'ticker' : true, 
            'diaNum' : true,
            'hora' : true,
            'resultado' : true,
            'dias' : true,
            'valorSaida' : true,
            'valorEntrada' : true,
            'diaNumSaida' : true,
            'dataHora' : true,
            'valorSuperior' : true,
            'valorInferior' : true
        },
        'where' : { 'and' : [{'ticker' : ticker}, {'regraProjecaoId' : idRegra}]},
        'order' : ['diaNum' , 'hora']
    };
    Cotacaointradayacaoresultadovalor.find(filtro,callback);
  };
  
};

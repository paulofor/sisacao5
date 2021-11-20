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
};

'use strict';

module.exports = function(Cotacaointradayfoxbit) {


/**
 * 
 * @param {array} listaCotacao 
 * @param {Function(Error, object)} callback
 */
 Cotacaointradayfoxbit.InsereListaFonteFoxbit = function(listaCotacao, callback) {
   console.log('lista ' , listaCotacao)
    for (item in listaCotacao) {

        Cotacaointradayfoxbit.create(item, (err,result) => {
          console.log('err:' , err);
        });
    }
    var resultado = {'saida' : 'ok'}
    callback(null, resultado);
  };
  

};

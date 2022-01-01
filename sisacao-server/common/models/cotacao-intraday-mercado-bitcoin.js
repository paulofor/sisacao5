'use strict';

module.exports = function(Cotacaointradaymercadobitcoin) {



    /**
    * 
    * @param {object} item 
    * @param {Function(Error, object)} callback
    */
    Cotacaointradaymercadobitcoin.InsereItem = function(item, callback) {
        console.log('mb:', item);
        Cotacaointradaymercadobitcoin.create(item,callback);
    };
  
};

'use strict';

module.exports = function(Exemplotreinoindiceacaoentrada) {


    Exemplotreinoindiceacaoentrada.InsereExemploEntradaIndice = function(exemplo,callback)  {
        //console.log('exemplo-entrada: ' , exemplo);
        Exemplotreinoindiceacaoentrada.create(exemplo, (err,result) => {
            //console.log('Err:' , err);
            //console.log('Result:' , result);
            callback(null,exemplo);
        });
    }
};

'use strict';

module.exports = function(Exemplotreinoacaoentrada) {


    Exemplotreinoacaoentrada.InsereExemploEntrada = function(exemplo,callback)  {
        console.log('exemplo-entrada: ' , exemplo);
        Exemplotreinoacaoentrada.create(exemplo, (err,result) => {
            console.log('Err:' , err);
            console.log('Result:' , result);
            callback(null,exemplo);
        });
    }
};

'use strict';

module.exports = function(Exemplotreinoacao) {

    Exemplotreinoacao.InsereExemplo = function(exemplo,callback)  {
        console.log('exemplo: ' , exemplo);
        Exemplotreinoacao.create(exemplo, (err,result) => {
            console.log('Err:' , err);
            console.log('Result:' , result);
            callback(null,exemplo);
        });
    }
};

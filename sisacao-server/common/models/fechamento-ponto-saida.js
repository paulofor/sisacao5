'use strict';

module.exports = function(Fechamentopontosaida) {

    Fechamentopontosaida.RegistraSaida = function(saida,callback) {
        Fechamentopontosaida.create(saida,(err,result) => {
            if (err) console.log('erro:', err);
            callback(err,result);
        });
    } 
};

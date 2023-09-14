'use strict';

module.exports = function(Indiceacao) {


    Indiceacao.ListaIntradayResultado = function(callback) {
        Indiceacao.findById('ibov', callback);
    }
};

'use strict';

module.exports = function(Fechamentoregradia) {


    Fechamentoregradia.ListaVerificacaoDiaria = function(callback) {
        Fechamentoregradia.find(callback);
    }
};

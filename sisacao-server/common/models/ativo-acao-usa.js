'use strict';

module.exports = function(Ativoacaousa) {


    Ativoacaousa.InsereSeNaoExiste = function(ativo, callback) {
        Ativoacaousa.upsert(ativo,callback);
    }

};

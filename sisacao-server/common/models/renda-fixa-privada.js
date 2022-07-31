'use strict';

module.exports = function(Rendafixaprivada) {

    Rendafixaprivada.RecebeDado = function(rendaFixa,callback) {
        rendaFixa.dataInsercao = new Date();
        Rendafixaprivada.create(rendaFixa,callback);
    }
};

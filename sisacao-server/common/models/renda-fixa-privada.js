'use strict';

module.exports = function(Rendafixaprivada) {

    Rendafixaprivada.RecebeDado = function(rendaFixa,callback) {
        rendaFixa.dataInsercao = new Date();
        Rendafixaprivada.create(rendaFixa,callback);
    }

    Rendafixaprivada.InsereSeNaoExisteFixaPrivada = function(listaItem,callback) {
        //console.log('Tam:' , listaItem.length);
        let yourDate = new Date()
        let dataInsercao = yourDate.toISOString().split('T')[0]
        listaItem.forEach(element => {
            element['dataInsercao'] = dataInsercao;
            Rendafixaprivada.create(element);
        });
        callback(null,{'enviado':'ok'});
    }
};

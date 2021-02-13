'use strict';

module.exports = function(Relgrupoacao) {



    /**
     * 
     * @param {number} idGrupo 
     * @param {array} listaAtivo 
     * @param {Function(Error, object)} callback
     */

    Relgrupoacao.AtualizaPorGrupoAcao = function (idGrupo, listaAtivo, callback) {
        var sqlDelete = "delete from RelGrupoAcao where grupoAcaoId = " + idGrupo;
        //console.log('sql: ', sqlDelete);
        var ds = Relgrupoacao.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
            //console.log('Retorno 1: ', result1, " - Erro: ",)
            if (err1) {
                callback(err1, null);
                return;
            }
            listaAtivo.forEach((ativo) => {
                if (ativo.relGrupoAcaos.length > 0) {
                    //delete etapa.processoNegocioEtapaProjetos.id;
                    //console.log('create: ', ativo.relGrupoAcaos[0]);
                    Relgrupoacao.create(ativo.relGrupoAcaos[0]);
                }
            });
            callback(null, { 'result': 'ok' });
        });
    };


};

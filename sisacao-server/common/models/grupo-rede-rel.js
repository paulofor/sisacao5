'use strict';

module.exports = function(Gruporederel) {


    Gruporederel.AtualizaPorGrupoRede = function (idGrupo, listaRede, callback) {
        var sqlQuantidade = "update GrupoRede " +
                        " set quantidade = (select count(*) from GrupoRedeRel where GrupoRede.id = GrupoRedeRel.grupoRedeId) ";
        var sqlDelete = "delete from GrupoRedeRel where grupoRedeId = " + idGrupo;
        var ds = Gruporederel.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
            //console.log('Retorno 1: ', result1, " - Erro: ",)
            if (err1) {
                callback(err1, null);
                return;
            }
            let conta = 0;
            listaRede.forEach((rel) => {
                //delete etapa.processoNegocioEtapaProjetos.id;
                //console.log('create: ', ativo.relGrupoAcaos[0]);
                Gruporederel.create(rel);
                conta++;
                //console.log('Conta:' , conta , ' - Tamanho:' , listaAtivo.length);
                if (conta==listaRede.length) {
                    ds.connector.query(sqlQuantidade, (err2,result2) => {
                        callback(null, { 'result': 'ok' });
                    })
                }
            });
        });
    };
};

'use strict';

module.exports = function(Gruporegrarel) {



    Gruporegrarel.AtualizaPorGrupoRegra = function (idGrupo, listaRegra, callback) {
        var sqlQuantidade = "update GrupoRegra " +
                        " set quantidade = (select count(*) from GrupoRegraRel where GrupoRegra.id = GrupoRegraRel.grupoRegraId) ";
        var sqlDelete = "delete from GrupoRegraRel where grupoRegraId = " + idGrupo;
        var ds = Gruporegrarel.dataSource;
        ds.connector.query(sqlDelete, (err1, result1) => {
            //console.log('Retorno 1: ', result1, " - Erro: ",)
            if (err1) {
                callback(err1, null);
                return;
            }
            let conta = 0;
            listaRegra.forEach((rel) => {
                //delete etapa.processoNegocioEtapaProjetos.id;
                //console.log('create: ', ativo.relGrupoAcaos[0]);
                Gruporegrarel.create(rel);
                conta++;
                //console.log('Conta:' , conta , ' - Tamanho:' , listaAtivo.length);
                if (conta==listaRegra.length) {
                    ds.connector.query(sqlQuantidade, (err2,result2) => {
                        callback(null, { 'result': 'ok' });
                    })
                }
            });
        });
    };

};

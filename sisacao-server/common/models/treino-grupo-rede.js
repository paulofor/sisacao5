'use strict';

var app = require('../../server/server');

module.exports = function(Treinogruporede) {

    Treinogruporede.CriaTreino = function(idGrupo, callback) {
        //console.log('ID' , idGrupo);
        let yourDate = new Date();
        let dataInsercao = yourDate.toISOString().split('T')[0];
       
        Treinogruporede.findById(idGrupo, (err,grupoTreino) => {
            //console.log('Err1' , err);
            let filtroRede = {'where' : {'grupoRedeId' : grupoTreino.grupoRedeId }};
            let filtroRegra = {'where' : {'grupoRegraId' : grupoTreino.grupoRegraId }};
            app.models.GrupoRedeRel.find(filtroRede, (err,grupoRedeRel) => {
                grupoRedeRel.forEach((itemGrupoRedeRel) => {
                    app.models.GrupoRegraRel.find(filtroRegra, (err,grupoRegraRel) => {
                        grupoRegraRel.forEach((itemGrupoRegraRel) => {
                            let treino = {
                                'limiteParaEntrada' : 0.5,
                                'redeNeuralId' : itemGrupoRedeRel.redeNeuralId,
                                'grupoAcaoId' : grupoTreino.grupoAcaoId,
                                'periodoTreinoRedeId' : grupoTreino.periodoTreinoRedeId,
                                'regraProjecaoId' : itemGrupoRegraRel.regraProjecaoId,
                                'treinoGrupoRedeId' : grupoTreino.id,
                                'dataCriacaoGmt' : new Date()
                            }
                            //console.log(treino);
                            app.models.TreinoRede.create(treino)
                        })
                    })
                })
            })
            callback(err,grupoTreino);
        })
    }
};

'use strict';

module.exports = function(Experimentopreredetreinadacontrole) {

    Experimentopreredetreinadacontrole.Insere = function(controle,callback) {
        Experimentopreredetreinadacontrole.create(controle,callback);
    }

    Experimentopreredetreinadacontrole.ReinicializaExperimento = function(experimentoId,callback) {
        const ds = Experimentopreredetreinadacontrole.dataSource;
        const sql = "delete from ExperimentoPreRedeTreinadaControle where experimentoPreRedeTreinadaId = " + experimentoId;
        ds.connector.query(sql,callback);
    }
};

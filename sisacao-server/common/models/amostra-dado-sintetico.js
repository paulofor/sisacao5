'use strict';

var app = require('../../server/server');

module.exports = function(Amostradadosintetico) {




    Amostradadosintetico.ListaDisponivelParaPreRedeVersao1 = function(idVersao, callback) {
        const ds = Amostradadosintetico.dataSource;
        app.models.VersaoPreRede.findById(idVersao, (err,versao) => {
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err2,preRede) => {
                const sql = "select AmostraDadoSintetico.* " +
                    " from AmostraDadoSintetico " +
                    " inner join TipoExemploTreino on TipoExemploTreino.id = AmostraDadoSintetico.tipoExemploTreinoId " +
                    " where AmostraDadoSintetico.id not in ( " +
	                " select amostraDadoSinteticoEntrada1Id from ExperimentoPreRede " +
                    " where versaoPreRedeId = " + versao.id + " ) " +
                    " and TipoExemploTreino.id = " + preRede.tipoExemploTreino1Id;
                ds.connector.query(sql,callback);
            })
            
        })
    }
    Amostradadosintetico.ListaDisponivelParaPreRedeVersao2 = function(idVersao, callback) {
        const ds = Amostradadosintetico.dataSource;
        app.models.VersaoPreRede.findById(idVersao, (err,versao) => {
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err2,preRede) => {
                const sql = "select AmostraDadoSintetico.* " +
                    " from AmostraDadoSintetico " +
                    " inner join TipoExemploTreino on TipoExemploTreino.id = AmostraDadoSintetico.tipoExemploTreinoId " +
                    " where AmostraDadoSintetico.id not in ( " +
	                " select amostraDadoSinteticoEntrada2Id from ExperimentoPreRede " +
                    " where versaoPreRedeId = " + versao.id + " ) " +
                    " and TipoExemploTreino.id = " + preRede.tipoExemploTreino2Id;
                ds.connector.query(sql,callback);
            })
            
        })
    }
    Amostradadosintetico.ListaDisponivelParaPreRedeVersaoIndice1 = function(idVersao, callback) {
        const ds = Amostradadosintetico.dataSource;
        app.models.VersaoPreRede.findById(idVersao, (err,versao) => {
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err2,preRede) => {
                const sql = "select AmostraDadoSintetico.* " +
                    " from AmostraDadoSintetico " +
                    " inner join TipoExemploTreino on TipoExemploTreino.id = AmostraDadoSintetico.tipoExemploTreinoId " +
                    " where AmostraDadoSintetico.id not in ( " +
	                " select amostraDadoSinteticoIndice1Id from ExperimentoPreRede " +
                    " where versaoPreRedeId = " + versao.id + " ) " +
                    " and TipoExemploTreino.id = " + preRede.tipoExemploTreino1Id;
                ds.connector.query(sql,callback);
            })
            
        })
    }
    Amostradadosintetico.ListaDisponivelParaPreRedeVersaoIndice2 = function(idVersao, callback) {
        const ds = Amostradadosintetico.dataSource;
        app.models.VersaoPreRede.findById(idVersao, (err,versao) => {
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err2,preRede) => {
                const sql = "select AmostraDadoSintetico.* " +
                    " from AmostraDadoSintetico " +
                    " inner join TipoExemploTreino on TipoExemploTreino.id = AmostraDadoSintetico.tipoExemploTreinoId " +
                    " where AmostraDadoSintetico.id not in ( " +
	                " select amostraDadoSinteticoIndice2Id from ExperimentoPreRede " +
                    " where versaoPreRedeId = " + versao.id + " ) " +
                    " and TipoExemploTreino.id = " + preRede.tipoExemploTreino2Id;
                ds.connector.query(sql,callback);
            })
            
        })
    }
};

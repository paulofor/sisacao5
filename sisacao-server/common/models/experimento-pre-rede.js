'use strict';

module.exports = function(Experimentoprerede) {

    Experimentoprerede.CalculaResultadoTeste = function(id,callback) {
        const ds = Experimentoprerede.dataSource;
        const sql = "update ExperimentoPreRede " +
            " set " +
            " mediaY0 = ( " + 
            " select avg(score)  " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '0' " +
            " ), " +
            " mediaY1 = ( " +
            " select avg(score)  " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '1' " +
            " ), " +
            " qtdeY0 = ( " +
            " select count(*) " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '0' " +
            " ), " +
            " qtdeY1 = ( " +
            " select count(*) " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '1' " +
            " ), " +
            " mediaResultadoPositivo = ( " +
            " select avg(score)  " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = 1 " +
            " ), " +
            " mediaResultadoNegativo = ( " +
            " select avg(score) " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = -1 " +
            " ), " +
            " mediaResultadoNeutro = ( " +
            " select avg(score)  " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = 0 " +
            " ), " +
            " mediaTotal = ( " +
            " select avg(score) " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " ), " +
            " desvioY0 = ( " +
            " select STDDEV(score) " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '0' " +
            " ), " +
            " desvioY1 = ( " +
            " select STDDEV(score)  " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.campoY = '1' " +
            " ), " +
            " desvioResultadoPositivo = ( " +
            " select STDDEV(score)  " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = 1 " +
            " ), " +
            " desvioResultadoNegativo = ( " +
            " select STDDEV(score)  " +
            " from ExperimentoPreRedeResultado " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = -1 " +
            " ), " +
            " desvioResultadoNeutro = ( " +
            " select STDDEV(score)  " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " where ExemploDadoSinteticoTeste.resultado = 0 " +
            " ), " +
            " desvioTotal = ( " +
            " select STDDEV(score) " +
            " from ExperimentoPreRedeResultado  " +
            " inner join ExemploDadoSinteticoTeste on ExperimentoPreRedeResultado.exemploDadoSinteticoTesteId = ExemploDadoSinteticoTeste.id " +
            " ) " +
        " where ExperimentoPreRede.id = " +  id;
        ds.connector.query(sql,callback);
    }

    Experimentoprerede.ListaExperimentoParaTreino = function(callback) {
        const filtro = {
            'include' : [
                {'relation' : 'amostraDadoSinteticoEntrada1'},
                {'relation' : 'amostraDadoSinteticoEntrada2'},
                {'relation' : 'versaoPreRede' , 'scope' : {'include' : 'preRedeNeural'}}
            ]
        }
        Experimentoprerede.find(filtro,callback);
    }

    Experimentoprerede.ProximoExperimentoParaPontuar = function(callback) {
        //const filtro = {'limit' : 1};
        Experimentoprerede.find(callback);
    }
};

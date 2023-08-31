'use strict';

module.exports = function(Experimentopreredetreinada) {

    Experimentopreredetreinada.ListaParaScore = function(callback) {
        const ds = Experimentopreredetreinada.dataSource;
        const sql = "select ExperimentoPreRedeTreinada.*, ExperimentoPreRede.nomeArquivoRede , tipo1.qtdeDias qtdeDias1, tipo2.qtdeDias qtdeDias2 " +
            " from ExperimentoPreRedeTreinada " +
            " inner join ExperimentoPreRede on ExperimentoPreRede.id = ExperimentoPreRedeTreinada.experimentoPreRedeId " +
            " inner join VersaoPreRede on VersaoPreRede.id = ExperimentoPreRede.versaoPreRedeId " +
            " inner join PreRedeNeural on PreRedeNeural.id = VersaoPreRede.preRedeNeuralId " +
            " inner join TipoExemploTreino tipo1 on tipo1.id = PreRedeNeural.tipoExemploTreino1Id " +
            " left join TipoExemploTreino tipo2 on tipo2.id = PreRedeNeural.tipoExemploTreino2Id " +
            " where geraScore = 'S' ";
        ds.connector.query(sql,callback);
    }

    Experimentopreredetreinada.ObtemProximoParaResultado = function(callback) {
        const filtro = {'include' : 'regraProjecao'}
        Experimentopreredetreinada.findOne(filtro,callback);
    }

    Experimentopreredetreinada.CalculaResultadoControle = function(experimentoId,callback) {
        console.log('id:' , experimentoId);
        const ds = Experimentopreredetreinada.dataSource;
        Experimentopreredetreinada.findById(experimentoId, (err,experimento) => {
            console.log('experimento:' , experimento);
            const numControle = experimento.posicaoCtrl + 1;
            const sql1 = "update ExperimentoPreRedeTreinada  " +
            " set totalResultadoPositivoCtrl" + numControle + " = (select count(*) from ExperimentoPreRedeTreinadaControle where experimentoPreRedeTreinadaId = " + experimentoId + " and resultado = 1), " +
            " totalResultadoNegativoCtrl" + numControle + " = (select count(*) from ExperimentoPreRedeTreinadaControle where experimentoPreRedeTreinadaId = " + experimentoId + "  and resultado = -1), " +
            " totalResultadoNeutroCtrl" + numControle + " = (select count(*) from ExperimentoPreRedeTreinadaControle where experimentoPreRedeTreinadaId = " + experimentoId + "  and resultado = 0) " +
            " where id = " + experimentoId;
            const sql2 = "update ExperimentoPreRedeTreinada " +
                " set percentualPositivoCtrl" + numControle + " = (totalResultadoPositivoCtrl" + numControle + " / (totalResultadoPositivoCtrl" + numControle + " + totalResultadoNeutroCtrl" + numControle + " + totalResultadoNegativoCtrl" + numControle + ") * 100) " +
                " , percentualNeutroCtrl" + numControle + " =  (totalResultadoNeutroCtrl" + numControle + " / (totalResultadoPositivoCtrl" + numControle + " + totalResultadoNeutroCtrl" + numControle + " + totalResultadoNegativoCtrl" + numControle + ") * 100) " +
                " , percentualNegativoCtrl" + numControle + " =  (totalResultadoNegativoCtrl" + numControle + " / (totalResultadoPositivoCtrl" + numControle + " + totalResultadoNeutroCtrl" + numControle + " + totalResultadoNegativoCtrl" + numControle + ") * 100) " +
                " , posicaoCtrl = " + numControle +
                " where experimentoPreRedeId = " + experimentoId;
            ds.connector.query(sql1,(err1,result1) => {
                ds.connector.query(sql2,(err1,result2) => {
                    Experimentopreredetreinadacontrole.ReinicializaExperimento(experimentoId,callback);
                });
            })
        })
       
    }


    Experimentopreredetreinada.CalculaResultado = function(experimentoId,callback) {
        const ds = Experimentopreredetreinada.dataSource;
        const sql = "update ExperimentoPreRedeTreinada \n" +
            " set totalResultadoPositivo = \n" +
            " (select count(*) from ExperimentoPreRedeTreinadaScore where ExperimentoPreRedeTreinadaScore.experimentoPreRedeTreinadaId = ExperimentoPreRedeTreinada.id \n" +
            " and resultado = 1), \n" +
            " totalResultadoNeutro = \n" +
            " (select count(*) from ExperimentoPreRedeTreinadaScore where ExperimentoPreRedeTreinadaScore.experimentoPreRedeTreinadaId = ExperimentoPreRedeTreinada.id \n" +
            " and resultado = 0), \n" +
            " totalResultadoNegativo = \n" +
            " (select count(*) from ExperimentoPreRedeTreinadaScore where ExperimentoPreRedeTreinadaScore.experimentoPreRedeTreinadaId = ExperimentoPreRedeTreinada.id \n" +
            " and resultado = -1) \n" +
            " where experimentoPreRedeId = " + experimentoId;
        //console.log(sql);
        const sql2 = "update ExperimentoPreRedeTreinada " +
            " set percentualResultadoPositivo = (totalResultadoPositivo / (totalResultadoPositivo + totalResultadoNeutro + totalResultadoNegativo) * 100) " +
            " , percentualResultadoNeutro =  (totalResultadoNeutro / (totalResultadoPositivo + totalResultadoNeutro + totalResultadoNegativo) * 100) " +
            " , percentualResultadoNegativo =  (totalResultadoNegativo / (totalResultadoPositivo + totalResultadoNeutro + totalResultadoNegativo) * 100) " +
            " where experimentoPreRedeId = " + experimentoId;
        ds.connector.query(sql,(err1,result1) => {
            ds.connector.query(sql2,callback);
        });
    }
};

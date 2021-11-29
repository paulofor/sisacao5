'use strict';

module.exports = function(Execucaosimulacaomelhoresvalidacao) {


    /**
    * 
    * @param {number} idPeriodo 
    * @param {Function(Error, object)} callback
    */
     Execucaosimulacaomelhoresvalidacao.CriaMelhorValidacaoPeriodo = function(idPeriodo, callback) {
        app.models.PeriodoExperimento.findById(idPeriodo, (err,result) => {
            console.log('result:', result )
            let periodo = result;
            let sql = 
            " insert into ExecucaoSimulacaoMelhoresValidacao (  " +
            "    execucaoSimulacaoId,  " +
            "    ticker,  " +
            "    resultado,  " + 
            "    simulacaoQtdeLucro,  " +
            "    simulacaoQtdePrejuizo,  " +
            "    target,  " +
            "    stop,  " +
            "    tipo,  " +
            "    experimentoSimulacaoId,  " +
            "    validacaoQtdeLucro,  " +
            "    validacaoQtdePrejuizo,  " +
            "    validacaoDiferenca,  " +
            "    periodoExperimentoId  " +
            "    )  " +
            " select distinct simulacao.id as simulacaoId, " +
            " simulacao.ticker as ticker, " +
            " simulacao.resultado as simulacaoResultado, " + 
            " simulacao.quantidadeLucro as simulacaoLucro, " +
            " simulacao.quantidadePrejuizo as simulacaoPrejuizo, " + 
            " simulacao.target as target, " +
            " simulacao.stop as stop, " +
            " simulacao.tipo as tipo, " +
            " simulacao.experimentoSimulacaoId as experimentoSimulacaoId, " +
            " validacao.quantidadeLucro as validacaoLucro, " +
            " validacao.quantidadePrejuizo as validacaoPrejuizo, " +
            " (validacao.quantidadeLucro - validacao.quantidadePrejuizo) as saldoValidacao " +
            " simulacao.periodoExperimentoId " +
            " from ExecucaoSimulacao simulacao " +
            " left outer join ExecucaoSimulacaoValidacao  validacao on " + 
            " simulacao.id = validacao.execucaoSimulacaoId " +
            " where simulacao.periodoExperimentoId = " + idPeriodo +
            " and simulacao.resultado >= " + periodo.minimoPontoValidacao;
            console.log('sql: ' , sql);
            let ds = Execucaosimulacao.dataSource;
            ds.connector.query(sql,(err,result) => {
                console.log('erro', err);
                console.log('obteve resultado' , result);
                callback(err,result);
            });
        });
    };

};

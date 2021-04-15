'use strict';

module.exports = function(Periodoexperimento) {


/**
 * 
 * @param {number} idExperimento 
 * @param {Function(Error, object)} callback
 */
 Periodoexperimento.ObtemPeriodoParaExecucao = function(idExperimento, callback) {
    let sql = "select PeriodoExperimento.* from PeriodoExperimento " +
        " inner join ExperimentoSimulacaoPeriodo on ExperimentoSimulacaoPeriodo.periodoExperimentoId = PeriodoExperimento.id " +
        " where concluido = 0 and experimentoSimulacaoId = " + idExperimento +
        " order by dataNumFinal"
        " limit 1 "
    let ds = Periodoexperimento.dataSource;
    ds.connector.query(sql, (err,result) => {
        if (result.length>0) {
            callback(null,result[0])
        } else {
            callback(null,null);
        }
    })
  };
  
};

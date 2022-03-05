'use strict';

module.exports = function(Periodoexperimento) {


  Periodoexperimento.observe('after save', function updateInicioColeta(ctx, next) {
    Periodoexperimento.CalculaInicioColeta((err,result) => {
      next();
    })
    
  })

 /**
 * 
 * @param {Function(Error, object)} callback
 */
  Periodoexperimento.CalculaInicioColeta = function(callback) {
    let sql = " update PeriodoExperimento " +
        " set dataNumInicioColeta = DATE_FORMAT(DATE_SUB(STR_TO_DATE(dataStrInicial, '%d-%m-%Y'),INTERVAL 2 MONTH) , '%Y%m%d')";
    let ds = Periodoexperimento.dataSource;
    ds.connector.query(sql,callback);
  };

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
  

  Periodoexperimento.LigaMonitoradoPeriodo = function(idPeriodo, limitePorTicker, callback) {
    let ds = Periodoexperimento.dataSource;
    Periodoexperimento.findById(idPeriodo, (err1,result1) => {
      let periodo = result1;
      let sqlDesliga = "update ExecucaoSimulacao set monitorar = 0 where periodoExperimentoId = " + idPeriodo;
      ds.connector.query(sqlDesliga, (err2, result2) => {
        let sqlTicker = "select distinct ticker from ExecucaoSimulacao where resultado >= " + periodo.minimoPontoValidacao +
          " and periodoExperimentoId = " + idPeriodo;
        ds.connector.query(sqlTicker, (err3,result3) => {
          let conta = 0
          for (let i=0; i<result3.length; i++) {
            let sqlMelhores = "update ExecucaoSimulacao set monitorar = 1 " +
              " where id in (select id from ExecucaoSimulacao where idPeridodoExperimento = " + idPeriodo + " and " +
              " ticker = '" + result3[i].ticker + "' order by result desc limit " + limitePorTicker + " ) ";
            ds.connector.query(sqlMelhores, (err4,result4) => {
              console.log(result3[i].ticker);
              console.log('Err' , err4);
              if (++conta==result3.length) {
                callback(null,{'result' : 'ok'})
              }
            })
          }
        })

      })
    })
  }
};

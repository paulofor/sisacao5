'use strict';

module.exports = function(Periodoexperimento) {



  Periodoexperimento.ListaComDetalhe = function(callback) {
    let sql = "SELECT *, " +
        " (select count(*) from ExecucaoSimulacao where ExecucaoSimulacao.periodoExperimentoId = PeriodoExperimento.id " +
        " and tipo = 'C' and monitorar=1) as quantidadeCompra, " +
        " (select count(*) from ExecucaoSimulacao where ExecucaoSimulacao.periodoExperimentoId = PeriodoExperimento.id " +
        " and tipo = 'V' and monitorar=1) as quantidadeVenda , " +
        " (select count(distinct ticker) from ExecucaoSimulacao where ExecucaoSimulacao.periodoExperimentoId = PeriodoExperimento.id " +
        " and tipo = 'C' and monitorar=1) as tickerCompra, " +
        " (select count(distinct ticker) from ExecucaoSimulacao where ExecucaoSimulacao.periodoExperimentoId = PeriodoExperimento.id " +
        " and tipo = 'V' and monitorar=1) as tickerVenda " +
        " FROM PeriodoExperimento " +
        " order by dataNumFinal desc";
    let ds = Periodoexperimento.dataSource;
    ds.connector.query(sql,callback);
  }



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
          result3.forEach((itemAcao) => {
            var sqlMelhores = "select id from ExecucaoSimulacao where periodoExperimentoId = " + idPeriodo + " and " +
              " ticker = '" + itemAcao.ticker + "' order by resultado desc limit " + limitePorTicker;
            //console.log('sqlMelhores:' , sqlMelhores);
            ds.connector.query(sqlMelhores, (err4,result4) => {
              result4.forEach((idUpdate) => {
                var sqlUpdate = "update ExecucaoSimulacao set monitorar = 1 where id = " + idUpdate.id;
                //console.log('sqlUpdate:' , sqlUpdate);
                ds.connector.query(sqlUpdate, (err5,result5) => {
                  //console.log('err5' , err5);
                })
              })
            })
          })
        })
      })
      callback(null,{'result' : 'ok'})
    })
  }
};

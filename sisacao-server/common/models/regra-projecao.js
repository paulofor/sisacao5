'use strict';

module.exports = function(Regraprojecao) {


/**
 * 
 * @param {number} idRegraProjecao 
 * @param {Function(Error, object)} callback
 */

 Regraprojecao.ObtemProcessando = function(callback) {
    let filtro = {
          'where' : {'processando' : 1} ,
          'include' : {'relation' : 'grupoAcao' , 'scope' : {
            'include' : {'relation' : 'relGrupoAcaos' , scope : {
              'include' : 'ativoAcao'
              }
            } 
            } 
          }
        }
    Regraprojecao.findOne(filtro,callback);
 };
  

  /**
  * 
  * @param {number} id 
  * @param {Function(Error, object)} callback
  */
  Regraprojecao.ObtemPorId = function(id, callback) {
    let filtro = { 'where' : {'id' : id } }
    Regraprojecao.findOne(filtro,callback);

  };

  Regraprojecao.TickerPerformance = function(dataNumInicio, dataNumFinal, grupoAcao, codigoRegra, callback) {
    let sql = "select CotacaoIntradayAcaoResultado.ticker, count(*) as ticks, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = 1 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as positivos, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = -1 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as negativos, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = 0 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as zero " +
          " from CotacaoIntradayAcaoResultado " +
          " inner join RelGrupoAcao on RelGrupoAcao.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and GrupoAcao.nome = '" + grupoAcao + "' " +
          " group by CotacaoIntradayAcaoResultado.ticker" ;
     let ds = Regraprojecao.dataSource;
     ds.connector.query(sql,callback);
  }

  /**
  * 
  * @param {string} codigo 
  * @param {Function(Error, object)} callback
  */
  Regraprojecao.ObtemPorCodigoRegra = function(codigo, callback) {
    let filtro = { 'where' : {'codigoRegraProjecao' : codigo } }
    Regraprojecao.findOne(filtro,callback);
  };

  /**
 * 
 * @param {number} idRegraProjecao 
 * @param {Function(Error, object)} callback
 */

  Regraprojecao.LigaProcessando = function(idRegraProjecao, callback) {
    let sql1 = 'update RegraProjecao set processando = 0';
    let sql2 = 'update RegraProjecao set processando = 1 where id = ' + idRegraProjecao;
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql1, (err,result) => {
        if (!err) {
            ds.connector.query(sql2,callback);
        }
    })
  };
};

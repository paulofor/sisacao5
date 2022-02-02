'use strict';

module.exports = function(Cotacaointradayacaoresultadovalor) {



    /**
    * 
    * @param {number} idRegra 
    * @param {number} diaNum 
    * @param {Function(Error, array)} callback
    */
     Cotacaointradayacaoresultadovalor.ObtemPorRegraData = function(idRegra, diaNum, callback) {
        let sql = "select ticker, resultado, count(*) as qtde " +
                " from CotacaoIntradayAcaoResultadoValor " +
                " where regraProjecaoId = "  + idRegra + " and " +
                " diaNum >= " + diaNum + 
                " group by ticker, resultado " +
                " order by ticker, resultado";
        let ds = Cotacaointradayacaoresultadovalor.dataSource;
        ds.connector.query(sql, callback);
    };


    /**
    *  @param {array} lista 
    * @param {Function(Error, object)} callback
    */
    Cotacaointradayacaoresultadovalor.InsereLista = function(lista, callback) {
        let conta = 0;
        lista.forEach((item) => {
            item.dataHoraInsercao = new Date();
            Cotacaointradayacaoresultadovalor.create(item);
            conta++;
            if (conta==lista.length) {
                callback(null, { 'result': 'ok' });
            }
        });
    };


    /**
 * 
 * @param {string} ticker 
 * @param {number} idRegra 
 * @param {Function(Error, array)} callback
 */

  Cotacaointradayacaoresultadovalor.ObtemListaTickerRegra = function(ticker, idRegra, callback) {
    let filtro = {
        'fields' : { 
            'ticker' : true, 
            'diaNum' : true,
            'hora' : true,
            'resultado' : true,
            'dias' : true,
            'valorSaida' : true,
            'valorEntrada' : true,
            'diaNumSaida' : true,
            'dataHora' : true,
            'valorSuperior' : true,
            'valorInferior' : true
        },
        'where' : { 'and' : [{'ticker' : ticker}, {'regraProjecaoId' : idRegra}]},
        'order' : ['diaNum' , 'hora']
    };
    Cotacaointradayacaoresultadovalor.find(filtro,callback);
  };
  

  Cotacaointradayacaoresultadovalor.ObtemDatasPorGrupo = function(codigoGrupo, callback) {
      let sql = " select ticker, RegraProjecao.codigoRegraProjecao, ultimo from " +
            " (select CotacaoIntradayAcaoResultadoValor.ticker, regraProjecaoId, max(dataHora) as ultimo " +
            " from CotacaoIntradayAcaoResultadoValor " +
            " inner join RelGrupoAcao on RelGrupoAcao.ticker = CotacaoIntradayAcaoResultadoValor.ticker " +
            " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
            " where GrupoAcao.nome = '" + codigoGrupo + "' " +
            " group by ticker, regraProjecaoId " +
            " order by regraProjecaoId, ticker) as tab " +
            " inner join RegraProjecao on RegraProjecao.id = tab.regraProjecaoId " +
            " order by codigoRegraProjecao, ultimo desc ";
        let ds = Cotacaointradayacaoresultadovalor.dataSource;
        ds.connector.query(sql, callback);
    
  }


  Cotacaointradayacaoresultadovalor.ObtemDatasPorGrupoComAtraso = function(codigoGrupo, callback) {
        let sql = "  ";
        let ds = Cotacaointradayacaoresultadovalor.dataSource;
        ds.connector.query(sql, callback);
  
    }


};

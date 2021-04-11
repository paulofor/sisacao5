'use strict';

module.exports = function(Tradereal) {


    let CUSTO_OPERACAO = 11;

    /**
    * 
    * @param {number} idTrade 
    * @param {Function(Error, object)} callback
    */
    Tradereal.CalculaEstimativa = function(idTrade, callback) {
        let sql1 = "update TradeReal " +
            " set valorTarget = precoTarget * quantidade, " +
            " valorStop = precoStop * quantidade, " +
            " valorEntrada = precoEntrada * quantidade " +
            " where id = " + idTrade;
        let sql2 = "update TradeReal " +
            " set valorExposicao = (valorEntrada - valorStop + " + CUSTO_OPERACAO + ") , " +
            " lucroAlvo = (valorTarget - valorEntrada) -  " + CUSTO_OPERACAO +
            " where id = " + idTrade;
        let ds = Tradereal.dataSource;
        ds.connector.query(sql1,(err,result) => {
            ds.connector.query(sql2,callback);
        });
    };


    /**
    * 
    * @param {Function(Error, number)} callback
    */
    Tradereal.TotalExposicao = function(callback) {
        let sql = " select sum(valorExposicao) as valor from TradeReal " +
                " where posicaoAtual = 1 ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    };
};

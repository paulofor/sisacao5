'use strict';

module.exports = function (Fundoimobiliario) {


    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Fundoimobiliario.Melhores6M = function(quantidade, callback) {
        let sql = " SELECT * FROM lojadigicom35.FundoImobiliario " +
                " where mediaNegocio1 >= 250 " +
                //" and percentual12 > 0 " +
                " order by percentual6 desc " +
                " limit " + quantidade;
                var ds = Fundoimobiliario.dataSource;
        ds.connector.query(sql, callback)
    };


    /**
     * 
     * @param {object} fundo 
     * @param {Function(Error, object)} callback
     */

    Fundoimobiliario.InsereSeNaoExiste = function (fundo, callback) {
        Fundoimobiliario.upsert(fundo, (err,result) => {
            callback(err,result);
        })
    };

    /**
    * 
    * @param {Function(Error, object)} callback
    */
     Fundoimobiliario.AtualizaMetricaFundoImobiliario = function(callback) {
        let sqlMediaNegocio1 = " update FundoImobiliario " +
            " set mediaNegocio1 = ( " +
            " select avg(negocios) from CotacaoDiarioAcao " +
            " where ticker = FundoImobiliario.ticker " +
            " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
            ") ";
        let sqlMediaNegocio3 = " update FundoImobiliario " +
            " set mediaNegocio3 = ( " +
            " select avg(negocios) from CotacaoDiarioAcao " +
            " where ticker = FundoImobiliario.ticker " +
            " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
            ") ";
        let sqlMediaNegocio4 = " update FundoImobiliario " +
            " set mediaNegocio4 = ( " +
            " select avg(negocios) from CotacaoDiarioAcao " +
            " where ticker = FundoImobiliario.ticker " +
            " and data >= (select DATE_SUB(now(), INTERVAL 4 month)) " +
            ") ";
        let sqlPrecoAtual = "update FundoImobiliario " +
            " set precoAtual = ( " +
            " select fechamento from CotacaoDiarioAcao " +
            " where CotacaoDiarioAcao.ticker = FundoImobiliario.ticker " + 
            " order by data desc " +
            " limit 1)";
        let sqlPreco6 = "update FundoImobiliario " +
            " set preco6 = ( " +
            " select fechamento from CotacaoDiarioAcao " + 
            " where CotacaoDiarioAcao.ticker = FundoImobiliario.ticker " + 
            " and data <= (select DATE_SUB(now(), INTERVAL 6 month)) " +
            " order by data desc " +
            " limit 1)";
        let sqlPreco12 = "update FundoImobiliario " +
            " set preco12 = ( " +
            " select fechamento from CotacaoDiarioAcao " + 
            " where CotacaoDiarioAcao.ticker = FundoImobiliario.ticker " + 
            " and data <= (select DATE_SUB(now(), INTERVAL 12 month)) " +
            " order by data desc " +
            " limit 1)";
        let sqlPercentual = "update FundoImobiliario " +
            " set percentual6 = ((precoAtual - preco6) / preco6) * 100, " +
            " percentual12 = ((precoAtual - preco12) / preco12) * 100"
        
        var ds = Fundoimobiliario.dataSource;
        ds.connector.query(sqlMediaNegocio1, (err1, result1) => {
        })
        ds.connector.query(sqlMediaNegocio3, (err1, result1) => {
        })
        ds.connector.query(sqlMediaNegocio4, (err1, result1) => {
        })
        ds.connector.query(sqlPrecoAtual, (err,result) => {
            ds.connector.query(sqlPreco6, (err,result) => {
                ds.connector.query(sqlPreco12, (err,result) => {
                    ds.connector.query(sqlPercentual, callback)
                })
            })
        })
        
    };
  


};

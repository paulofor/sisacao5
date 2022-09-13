'use strict';


var app = require('../../server/server');


module.exports = function (Fundoimobiliario) {


    Fundoimobiliario.ListaIntradayFundo = function(callback) {
        let filtro = {'where' : {'intraday' : 1}}
        Fundoimobiliario.find(filtro,callback);
    }

    Fundoimobiliario.AtualizaIntraday = function(callback) {
        let ds = Fundoimobiliario.dataSource;
        let sql = "update FundoImobiliario set intraday = 1 " +
            " where dataAtual = '2022-07-04' " +
            " and mediaNegocio1 >= 300"

        ds.connector.query(sql,callback);
    }



    /**
    * 
    * @param {Function(Error, object)} callback
    */
    Fundoimobiliario.AtualizaDiarioFII = function(callback) {
        let sqlMaximo1 = " update FundoImobiliario " +
                    " set maximo1 = ( " +
                    " select max(maximo) from CotacaoDiarioAcao " +
                    " where ticker = FundoImobiliario.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
                    ") ";   
        let sqlMinimo1 = " update FundoImobiliario " +
                    " set minimo1 = ( " +
                    " select min(minimo) from CotacaoDiarioAcao " +
                    " where ticker = FundoImobiliario.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
                    ") "; 
        let sqlMaximo3 = " update FundoImobiliario " +
                    " set maximo3 = ( " +
                    " select max(maximo) from CotacaoDiarioAcao " +
                    " where ticker = FundoImobiliario.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") ";   
        let sqlMinimo3 = " update FundoImobiliario " +
                    " set minimo3 = ( " +
                    " select min(minimo) from CotacaoDiarioAcao " +
                    " where ticker = FundoImobiliario.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") "; 
        let sqlAluguel3 = " update FundoImobiliario " +
                    " set totalAluguel3 = ( " +
                    " select sum(valor) from AluguelFundoImobiliario " +
                    " where ticker = FundoImobiliario.ticker and tipo='Rendimento' " +
                    " and dataPagamento >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") "; 
        let sqlAluguel6 = " update FundoImobiliario " +
                    " set totalAluguel6 = ( " +
                    " select sum(valor) from AluguelFundoImobiliario " +
                    " where ticker = FundoImobiliario.ticker and tipo='Rendimento' " +
                    " and dataPagamento >= (select DATE_SUB(now(), INTERVAL 6 month)) " +
                    ") "; 
        let sqlPercMedia3 = " update FundoImobiliario " +
                    " set mediaPercentualAluguel3 = ( " +
                    " select avg(percentual) from AluguelFundoImobiliario " +
                    " where ticker = FundoImobiliario.ticker and tipo='Rendimento' " +
                    " and dataPagamento >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") "; 
        let sqlPercMedia6 = " update FundoImobiliario " +
                    " set mediaPercentualAluguel6 = ( " +
                    " select avg(percentual) from AluguelFundoImobiliario " +
                    " where ticker = FundoImobiliario.ticker and tipo='Rendimento' " +
                    " and dataPagamento >= (select DATE_SUB(now(), INTERVAL 6 month)) " +
                    ") "; 
        app.models.FundoImobiliarioCarteria.AtualizaDiario((err,result) => {});
        var ds = Fundoimobiliario.dataSource;
        ds.connector.query(sqlMaximo1, (err,result) => {
           ds.connector.query(sqlMinimo1, (err,result) => {
               ds.connector.query(sqlMaximo3, (err,reult) => {
                   ds.connector.query(sqlMinimo3,(err,reult) => {
                        ds.connector.query(sqlAluguel3,(err,result) => {
                            ds.connector.query(sqlAluguel6, (err,result) => {
                                ds.connector.query(sqlPercMedia3, (err,result) => {
                                    ds.connector.query(sqlPercMedia6,callback)
                                })
                            })
                        })
                   })
               })
           })
        })
        
    };
  


    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Fundoimobiliario.ListaAluguel = function(callback) {
        Fundoimobiliario.find(callback);
    };
  


    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Fundoimobiliario.Melhores6M = function(quantidade, callback) {
        app.models.DiaPregao.ObtemAtualB3((err,result) => {
            let sql = " SELECT * FROM FundoImobiliario " +
            " where dataAtual = '" + result.dataDbStr + "' " +
            " and mediaNegocio1 >= 50 " +
            //" and percentual12 > 0 " +
            " order by percentual6 desc " +
            " limit " + quantidade;
            console.log(sql);
            var ds = Fundoimobiliario.dataSource;
            ds.connector.query(sql, callback)
        })
    };


    /**
    * 
    * @param {number} quantidade 
    * @param {Function(Error, array)} callback
    */
    Fundoimobiliario.MelhoresAluguel = function(quantidade, callback) {
        app.models.DiaPregao.ObtemAtualB3((err,result) => {
            let sql = " SELECT * FROM FundoImobiliario " +
            " where dataAtual = '" + result.dataDbStr + "' " +
            " order by mediaPercentualAluguel6 desc " +
            " limit " + quantidade;
            console.log('sql:' , sql)
            var ds = Fundoimobiliario.dataSource;
            ds.connector.query(sql, callback)
        })
       
    };
  

    /**
     * 
     * @param {object} fundo 
     * @param {Function(Error, object)} callback
     */

    Fundoimobiliario.InsereSeNaoExiste = function (fundo, callback) {
        fundo.dataInsercao = new Date();
        Fundoimobiliario.upsert(fundo, (err,result) => {
            callback(err,result);
        })
    };


    Fundoimobiliario.RegistraDiario = function(callback) {
        let sql = "insert into FundoImobiliarioDiario " +
            " select * from FundoImobiliario " + 
            " where dataAtual = (select date_sub(date(now()),interval 1 day))";
        let ds = Fundoimobiliario.dataSource;
        ds.connector.query(sql,callback);
    }


    /**
     * 
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
        let sqlDataAtual = "update FundoImobiliario " +
            " set dataAtual = ( " +
            " select data from CotacaoDiarioAcao " +
            " where CotacaoDiarioAcao.ticker = FundoImobiliario.ticker " + 
            " order by data desc " +
            " limit 1)";
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

        let sqlMaximoMinimo = "update FundoImobiliario " +
                " set " +
                " maximo12m = ( " +
                " select max(maximo) from CotacaoDiarioAcao  " +
                " where FundoImobiliario.ticker = CotacaoDiarioAcao.ticker " +
                " and data >=  DATE_SUB(now(), INTERVAL 12 month) " +
                " ), " +
                " minimo12m = ( " +
                " select min(minimo) from CotacaoDiarioAcao  " +
                " where FundoImobiliario.ticker = CotacaoDiarioAcao.ticker " +
                " and data >=  DATE_SUB(now(), INTERVAL 12 month) " +
                " ), " +
                " maximo24m = ( " +
                " select max(maximo) from CotacaoDiarioAcao  " +
                " where FundoImobiliario.ticker = CotacaoDiarioAcao.ticker " +
                " and data >=  DATE_SUB(now(), INTERVAL 24 month) " +
                " ), " +
                " minimo24m = ( " +
                " select min(minimo) from CotacaoDiarioAcao  " +
                " where FundoImobiliario.ticker = CotacaoDiarioAcao.ticker " +
                " and data >=  DATE_SUB(now(), INTERVAL 24 month) " +
                ")";
        let sqlVariacao = "update FundoImobiliario " +
                " set variacao12m = (maximo12m - minimo12m) / maximo12m * 100," +
                " variacao24m = (maximo24m - minimo24m) / maximo24m * 100";
        
        var ds = Fundoimobiliario.dataSource;
        Fundoimobiliario.AtualizaDiarioFII((err,result) => {
            ds.connector.query(sqlMediaNegocio1, (err1, result1) => {
                console.log('err1' , err1);
                ds.connector.query(sqlMediaNegocio3, (err2, result1) => {
                    console.log('err2' , err2);
                    ds.connector.query(sqlMediaNegocio4, (err3, result1) => {
                        console.log('err3' , err3);
                        ds.connector.query(sqlMaximoMinimo, (err4,result) => {
                            console.log('err4' , err4);
                            ds.connector.query(sqlVariacao, (err5,result) => {
                                console.log('err5' , err5);
                                ds.connector.query(sqlDataAtual, (err6,result) => {
                                    console.log('err6' , err6);
                                    ds.connector.query(sqlPrecoAtual, (err7,result) => {
                                        console.log('err7' , err7);
                                        ds.connector.query(sqlPreco6, (err8,result) => {
                                            console.log('err8' , err8);
                                            ds.connector.query(sqlPreco12, (err9,result) => {
                                                console.log('err9' , err9);
                                                ds.connector.query(sqlPercentual, (err10,result) => {
                                                    console.log('err10' , err10);
                                                    Fundoimobiliario.RegistraDiario(callback);
                                                })
                                            })
                                        })
                                    })
                                })
                            })
                        })
                    })
                })
            })
    
        })
       
       
       
       
       
       
        
    };
  


};

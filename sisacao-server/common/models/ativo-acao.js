'use strict';

module.exports = function (Ativoacao) {


    /**
     * 
     * @param {Function(Error, array)} callback
     */

    Ativoacao.ListaColetaIntraday = function (callback) {
        var lista;
        // TODO
        callback(null, lista);
    };




    /**
     * 
     * @param {Function(Error, object)} callback
     */

    Ativoacao.AtualizaPosDiario = function (callback) {
        let sqlFechameentoAtual = " update AtivoAcao " +
                    " set fechamentoAtual = ( " +
                    " select fechamento from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data = (select max(data) from CotacaoDiarioAcao where ticker = AtivoAcao.ticker ) " +
                    " ) ";
        let sqlMaximo3 = " update AtivoAcao " +
                    " set max3Mes = ( " +
                    " select max(maximo) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") ";   
        let sqlMinimo3 = " update AtivoAcao " +
                    " set min3Mes = ( " +
                    " select min(minimo) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") "; 
        let sqlMediaNegocio3 = " update AtivoAcao " +
                    " set mediaNegocio3Mes = ( " +
                    " select avg(negocios) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 3 month)) " +
                    ") "; 
        let sqlSpread3 = "update AtivoAcao " +
                    " set spread3Mes = ((max3Mes - min3Mes) / max3Mes) * 100;"
        
        let sqlMaximo1 = " update AtivoAcao " +
                    " set max1Mes = ( " +
                    " select max(maximo) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
                    ") ";   
        let sqlMinimo1 = " update AtivoAcao " +
                    " set min1Mes = ( " +
                    " select min(minimo) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
                    ") "; 
        let sqlMediaNegocio1 = " update AtivoAcao " +
                    " set mediaNegocio1Mes = ( " +
                    " select avg(negocios) from CotacaoDiarioAcao " +
                    " where ticker = AtivoAcao.ticker " +
                    " and data >= (select DATE_SUB(now(), INTERVAL 1 month)) " +
                    ") "; 
        let sqlSpread1 = "update AtivoAcao " +
                    " set spread1Mes = ((max1Mes - min1Mes) / max1Mes) * 100;";

        var ds = Ativoacao.dataSource;
        ds.connector.query(sqlFechameentoAtual, (err1, result1) => {
            ds.connector.query(sqlMaximo1, (errMax1, resultMax1) => {
                ds.connector.query(sqlMinimo1, (errMin1, resultMin1) => {
                    ds.connector.query(sqlSpread1, (errSpread1, resultSpread1)=> {

                    })
                })
            });
            ds.connector.query(sqlMediaNegocio1, (errMediaNegocio1,resultMediaNegocio1) => {

            });
            ds.connector.query(sqlMaximo3, (errMax3, resultMax3) => {
                ds.connector.query(sqlMinimo3, (errMin3, resultMin3) => {
                    ds.connector.query(sqlSpread3, (errSpread3, resultSpread3) => {
                        
                    })
                })
            });
            ds.connector.query(sqlMediaNegocio3, (errMediaNegocio3,resultMediaNegocio3) => {
                
            })
            callback(null,{'result' : 'ok'})
        });
    };


    /**
    * 
    * @param {string} ticker 
    * @param {string} nome 
    * @param {string} tipo 
    * @param {number} quantidadeTeorica 
    * @param {number} participacao 
    * @param {string} indice 
    * @param {Function(Error, object)} callback
    */
    Ativoacao.InsereAcaoIndice = function (ticker, nome, tipo, quantidadeTeorica, participacao, indice, callback) {
        var saida;
        // TODO
        callback(null, saida);
    };


};

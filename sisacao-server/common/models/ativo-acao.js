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
        var ds = Ativoacao.dataSource;
        ds.connector.query(sqlFechameentoAtual, (err1, result1) => {
            callback(err1,result1);
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

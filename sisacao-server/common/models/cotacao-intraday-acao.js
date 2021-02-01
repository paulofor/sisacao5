'use strict';

module.exports = function (Cotacaointradayacao) {


    /**
    * 
    * @param {number} valor 
    * @param {string} horario 
    * @param {Function(Error, object)} callback
    */

    Cotacaointradayacao.InsereValorHorarioAcao = function (ticker, valor, horario, callback) {
        let sql = "insert into CotacaoIntradayAcao (ticker,dataHora,valor,dataHoraNegStr, dia, posicaoDia, intervalo, diaNum) " +
        "values ('" + ticker + "' , now(), " + valor + ", '" + horario + "' , now(), 0, 0 , date_format(now(),'%Y%m%d'))"
        let ds = Cotacaointradayacao.dataSource;
        ds.connector.query(sql, callback);
    };


    /**
    * 
    * @param {string} dia 
    * @param {string} ticker 
    * @param {Function(Error, array)} callback
    */
    Cotacaointradayacao.ObtemPorDiaTicker = function(dia, ticker, callback) {
        var cotacao;

        let ds = Cotacaointradayacao.dataSource;

        var sql1 = " select date(dia) as data from CotacaoIntradayAcao " +
            " where ticker = '" + ticker + "' " +
            " group by dia " +
            " order by dia desc " +
            " limit " + dia;

        ds.connector.query(sql1, (err,result) => {
            let x = 0;
            cotacao = result;
            for (let i=0; i < result.length; i++) {
                //console.log('linha:' , JSON.stringify(result[i]));
                var sql2 = " select valor, dataHora, dataHoraNegStr from CotacaoIntradayAcao where ticker = '" + ticker + "' and " +
                    " dia = '" + formatDate(result[i].data) + "' ";
                //console.log('sql2: ', sql2);
                ds.connector.query(sql2, (err, result2) => {
                    cotacao[i]['cotacao'] = result2;
                    //console.log('cotacao' , JSON.stringify(cotacao));
                    x++;
                    if (x==result.length) {
                        callback(null,cotacao);
                    }
                })
            }
        })
        
    };

    function formatDate(date) {
        var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();
    
        if (month.length < 2) 
            month = '0' + month;
        if (day.length < 2) 
            day = '0' + day;
    
        return [year, month, day].join('-');
    }

};

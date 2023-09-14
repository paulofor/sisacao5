'use strict';

var app = require('../../server/server');

module.exports = function(Cotacaointradayindiceresultado) {

    Cotacaointradayindiceresultado.GravaVaziaComAnteriorIndice = function(ticker, callback) {
        Cotacaointradayindiceresultado.ObtemProximoHorarioVazio(ticker, (err, cotacao) => {
            console.log('cotacao: ' , cotacao);
            if(cotacao) {
                let sql = " update CotacaoIntradayIndiceResultado " +
                    " set valor = " + 
                    " ( " +
                    " select valor from CotacaoIntradayIndice " +
                    " where CotacaoIntradayIndice.ticker = CotacaoIntradayIndiceResultado.ticker " +
                    " and CotacaoIntradayIndice.dataHora <= CotacaoIntradayIdniceResultado.dataHora " +
                    " order by CotacaoIntradayIndice.dataHora desc " +
                    " limit 1 " +
                    " ) " +
                    " where ticker = '" + ticker + "' and diaNum = " + cotacao.diaNum + " and hora = '" + cotacao.hora + "' ";
                console.log('sql:' , sql);
                var ds = Cotacaointradayindiceresultado.dataSource;
                ds.connector.query(sql, (err,result) => {
                    callback(err,cotacao)
                });    
            } else {
                console.log('nao tem');
                callback(null,null);
            }
           
        })

    };


    Cotacaointradayindiceresultado.CriaIndiceResultadoAno = function(ticker, ano, callback) {
        //console.log('entrou aqui' + ano);
        let filtroAno = { 'where' : {'ano' : ano}}
        let horarios = ['10:40:00' , '11:00:00' , '11:30:00' , '12:00:00' , '12:30:00' , '13:00:00' , '13:30:00' , '14:00:00' , '14:30:00' ,
                        '15:00:00' , '15:30:00' , '16:00:00' , '16:30:00' , '17:30:00' , '18:00:00'];
        let posicao = [-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0];
        app.models.DiaPregao.find(filtroAno, (err,result) => {
            for (var i=0 ; i<result.length; i++) {
                let dia = result[i];
                for (var x=0; x<horarios.length; x++) {
                   let hora = horarios[x];
                   let dataHora = new Date(dia.data);
                   let horaDate = horarios[x].substring(0,2);
                   let minutoDate = horarios[x].substring(3,5);
                   dataHora.setUTCHours(horaDate);
                   dataHora.setUTCMinutes(minutoDate);
                   let diaHoraNumTicker = dia.diaNum + hora + ticker;
                   let item = {'ticker' : ticker , 'diaNum' : dia.diaNum , 'hora' : hora, 'dataHora' : dataHora, 'dia' : dia.data , 
                            'diaHoraNumTicker' : diaHoraNumTicker , 'posicaoDia' : posicao[x]};
                   console.log('item' , item);
                   Cotacaointradayindiceresultado.create(item, (err,result) => {
                        console.log('err:', err);
                        if (err) return
                   })
                }
            }
            //let sql = " update CotacaoIntradayAcaoResultado "  +
            //    " set diaHoraNumTicker = concat(diaNum,hora,ticker) where ticker = '" + ticker + "'";
            //let ds = Cotacaointradayacaoresultado.dataSource;
            //ds.connector.query(sql, callback);
            callback(null,{'concluido' : ticker});
        })
     };
};

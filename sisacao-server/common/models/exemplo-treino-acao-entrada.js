'use strict';

var app = require('../../server/server');


module.exports = function(Exemplotreinoacaoentrada) {


    Exemplotreinoacaoentrada.InsereExemploEntrada = function(exemplo,callback)  {
        //console.log('exemplo-entrada: ' , exemplo);
        Exemplotreinoacaoentrada.create(exemplo, (err,result) => {
            //console.log('Err:' , err);
            //console.log('Result:' , result);
            callback(null,exemplo);
        });
    }

    Exemplotreinoacaoentrada.ObtemPorDiaTicker = function(diaNum,ticker, callback){
        let sql = "select campoX , ticker, diaNumPrevisao from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao = " + diaNum + " and " +
            " ticker = '" + ticker + "'"
        let ds = Exemplotreinoacaoentrada.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err,result);
        })
    }

    Exemplotreinoacaoentrada.ObtemPorDia = function(diaNum,callback){
        let sql = "select campoX , ticker, diaNumPrevisao from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao = " + diaNum 
            
        let ds = Exemplotreinoacaoentrada.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err,result);
        })
    }

    Exemplotreinoacaoentrada.ObtemProximoDia = function(callback){
        app.models.DiaPregao.ObtemProximoB3((err,result) => {
            let sql = "select campoX , ticker, diaNumPrevisao from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao = " + result.diaNum 
            console.log(sql)
            let ds = Exemplotreinoacaoentrada.dataSource;
            ds.connector.query(sql, (err,result) => {
                callback(err,result);
            })
        })
       
    }

    /*
select 
*
from
(
select 
ent.*,
sai.ticker as tickerSaida
from 
ExemploTreinoAcaoEntrada ent
left outer join ExemploTreinoAcaoSaida sai on 
(ent.ticker = sai.ticker and ent.diaNumPrevisao = sai.diaNumPrevisao)
where
ent.ticker = 'AZUL4' and
ent.qtdeDias = 120 and
ent.posicaoReferencia = 0 and
(sai.regraProjecaoId = 2 or sai.regraProjecaoId is null)
order by ent.diaNumPrevisao
) as tab
where tab.tickerSaida is null

select diaNumPrevisao
from ExemploTreinoAcaoEntrada where ticker = 'ABEV3'
and qtdeDias = 120
and posicaoReferencia = 0
and diaNumPrevisao not in 
(
select diaNumPrevisao
from ExemploTreinoAcaoSaida where ticker = 'ABEV3'
and regraProjecaoId = 30
order by diaNumPrevisao desc
)
order by diaNumPrevisao desc


    */



    Exemplotreinoacaoentrada.ListaSemResultado = function(ticker,regraId,qtdeDias,posicaoReferencia, callback) {
        let sql = " select * "  +
            " from ExemploTreinoAcaoEntrada where ticker = '" + ticker + "'" +
            " and qtdeDias = " + qtdeDias +
            " and posicaoReferencia = " + posicaoReferencia +
            " and diaNumPrevisao not in " +
            " ( " +
            " select diaNumPrevisao " +
            " from ExemploTreinoAcaoSaida where ticker = '" + ticker + "'" +
            " and regraProjecaoId = " + regraId + " ) " +
            " order by diaNumPrevisao asc ";
        let ds = Exemplotreinoacaoentrada.dataSource;
        console.log(sql);
        ds.connector.query(sql,callback);
    }
};

'use strict';

var app = require('../../server/server');


module.exports = function(Exemplotreinoacaoentrada) {


    Exemplotreinoacaoentrada.ListaParaTreino = function(idGrupoAcao,idTipoExemplo,diaNumInicioTreino,diaNumFinalTreino,callback) {

        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            let sql = "select diaNumPrevisao, ticker , campoX from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao >= " + diaNumInicioTreino + " and  diaNumPrevisao <=" + diaNumFinalTreino +
            " and ticker in (select ticker from RelGrupoAcao where grupoAcaoId = " + idGrupoAcao + " ) " +
            " and qtdeDias = " + tipo.qtdeDias + " and posicaoReferencia = " + tipo.posicaoReferencia +
            " order by diaNumPrevisao, ticker";
            let ds = Exemplotreinoacaoentrada.dataSource;
            ds.connector.query(sql, (err,result) => {
                callback(err,result);
            })
        })
       
    }

    Exemplotreinoacaoentrada.ListaParaTreinoComIndice = function(idGrupoAcao,idTipoExemplo,diaNumInicioTreino,diaNumFinalTreino,callback) {

        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            let sql = "select acao.diaNumPrevisao, acao.ticker , acao.campoX , indice.campoX as campoXIndice from ExemploTreinoAcaoEntrada acao " +
            " inner join ExemploTreinoIndiceAcaoEntrada indice on indice.diaNumPrevisao = acao.diaNumPrevisao " +
            " where acao.diaNumPrevisao >= " + diaNumInicioTreino + " and  acao.diaNumPrevisao <=" + diaNumFinalTreino +
            " and acao.ticker in (select ticker from RelGrupoAcao where grupoAcaoId = " + idGrupoAcao + " ) " +
            " and acao.qtdeDias = " + tipo.qtdeDias + " and acao.posicaoReferencia = " + tipo.posicaoReferencia +
            " and indice.ticker = 'ibov' and indice.tipoExemploTreinoId = " + idTipoExemplo + 
            " order by acao.diaNumPrevisao, acao.ticker";
            let ds = Exemplotreinoacaoentrada.dataSource;
            ds.connector.query(sql, (err,result) => {
                callback(err,result);
            })
        })
       
    }

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

    Exemplotreinoacaoentrada.ObtemPorDiaNum = function(diaNum,qtdeDias, callback){
        let sql = "select campoX , ticker, diaNumPrevisao from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao = " + diaNum + " and qtdeDias = " + qtdeDias;
            
        let ds = Exemplotreinoacaoentrada.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err,result);
        })
    }
    Exemplotreinoacaoentrada.ObtemPorPeriodoIdTreinoTipoComIndice = function(idPeriodo,idGrupoAcao,idTipoExemplo, callback){
        app.models.PeriodoTreinoRede.findById(idPeriodo, (err,periodo) => {
            app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
                let sql = "select acao.diaNumPrevisao, acao.ticker , acao.campoX , indice.campoX as campoXIndice from ExemploTreinoAcaoEntrada acao " +
                    " inner join ExemploTreinoIndiceAcaoEntrada indice on indice.diaNumPrevisao = acao.diaNumPrevisao " +
                    " where acao.diaNumPrevisao >= " + periodo.diaNumInicioTeste + " and  acao.diaNumPrevisao <=" + periodo.diaNumFinalTeste +
                    " and acao.ticker in (select ticker from RelGrupoAcao where grupoAcaoId = " + idGrupoAcao + " ) " +
                    " and acao.qtdeDias = " + tipo.qtdeDias + " and acao.posicaoReferencia = " + tipo.posicaoReferencia +
                    " and indice.ticker = 'ibov' and indice.tipoExemploTreinoId = " + idTipoExemplo + 
                    " order by acao.diaNumPrevisao, acao.ticker";
                let ds = Exemplotreinoacaoentrada.dataSource;
                ds.connector.query(sql, (err,result) => {
                    callback(err,result);
                })
            })
        })
    }

    Exemplotreinoacaoentrada.ObtemPorDiaNumIdTreinoTipoComIndice = function(diaNum,idGrupoAcao,idTipoExemplo, callback){
        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            let sql = "select acao.diaNumPrevisao, acao.ticker , acao.campoX , indice.campoX as campoXIndice from ExemploTreinoAcaoEntrada acao " +
                " inner join ExemploTreinoIndiceAcaoEntrada indice on indice.diaNumPrevisao = acao.diaNumPrevisao " +
                " where acao.diaNumPrevisao = " + diaNum +
                " and acao.ticker in (select ticker from RelGrupoAcao where grupoAcaoId = " + idGrupoAcao + " ) " +
                " and acao.qtdeDias = " + tipo.qtdeDias + " and acao.posicaoReferencia = " + tipo.posicaoReferencia +
                " and indice.ticker = 'ibov' and indice.tipoExemploTreinoId = " + idTipoExemplo + 
                " order by acao.diaNumPrevisao, acao.ticker";
            let ds = Exemplotreinoacaoentrada.dataSource;
            ds.connector.query(sql, (err,result) => {
                callback(err,result);
            })
        })
    }


    Exemplotreinoacaoentrada.ObtemPorDiaNumTipoExemplo = function(diaNum, idTipo, callback) {
        app.models.TipoExemploTreino.findById(idTipo, (err,tipo) => {
            Exemplotreinoacaoentrada.ObtemPorDiaNum(diaNum,tipo.qtdeDias, callback);
        })
    }

    Exemplotreinoacaoentrada.ObtemProximoDia = function(qtdeDias, callback){
        app.models.DiaPregao.ObtemProximoB3((err,result) => {
            let sql = "select campoX , ticker, diaNumPrevisao from ExemploTreinoAcaoEntrada " +
            " where diaNumPrevisao = " + result.diaNum + " and qtdeDias = " + qtdeDias;
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
        let sql = " select ticker, diaNumInicio, diaNumPrevisao, valorReferencia, qtdeDias, posicaoReferencia "  +
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

    Exemplotreinoacaoentrada.ListaSemResultadoSimples = function(ticker,regraId, callback) {
        let sql = " select distinct ticker, diaNumPrevisao "  +
            " from ExemploTreinoAcaoEntrada where ticker = '" + ticker + "'" +
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

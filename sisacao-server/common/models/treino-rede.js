'use strict';

var app = require('../../server/server');

module.exports = function(Treinorede) {


    Treinorede.AtivaTeste = function(idTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoTeste = case when ativoTeste = 0 then 1 else 0 end " +
            " where id = " + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.ExecutouTreinamento = function(id,callback) {
        let sql = "update TreinoRede " +
            " set dataTreinamento = now() " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.AtualizaPontuacaoTreino = function(id,callback) {
        let sql = "update TreinoRede " +
            " set qtdeLucroTeste = (select count(*) from PrevisaoTeste where resultado = 1 and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdePrejuizoTeste = (select count(*) from PrevisaoTeste where resultado = -1 and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " pontuacaoTeste = (select sum(pontuacao) from PrevisaoTeste where pontuacao <> 0 and PrevisaoTeste.treinoRedeId = TreinoRede.id) " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.ObtemListaParaTreino = function(callback) {
        let filtro = {'include' : ['redeNeural' , 'periodoTreinoRede' , 'tipoExemploTreino']}
        Treinorede.find(filtro,callback);
    } 

    Treinorede.ObtemListaParaPrevisao = function(callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " where ativoPrevisao = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 

    Treinorede.ObtemListaPrevisaoTeste = function(callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where ativoTeste = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 
    Treinorede.ListaTestePorGrupo = function(id,callback) {
        let sql = "select TreinoRede.* , RegraProjecao.tipoCompraVenda, PeriodoTreinoRede.diaNumInicioTeste, PeriodoTreinoRede.diaNumFinalTeste " +
            " from TreinoRede " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where ativoTeste = 1 and treinoGrupoRedeId = " + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 

    Treinorede.ListaPrevisaoDiaTreino = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let filtro = {
                'where' : {'ativoPrevisao' : 1},
                'include' : 
                [
                    'redeNeural' , 'regraProjecao',
                    { 
                    'relation' : 'previsaoRedes',
                    'scope' : 
                        {'where' : { 'and' : [ {'valor' : {'gt' : 0.25 }} , {'diaNumPrevisao' : result.diaNum }] }, 
                        "order" : "valorPrevisao desc" , 'limit' : 10} 
                    },
                ], 
            }
            Treinorede.find(filtro,callback);
        });       
    }
}

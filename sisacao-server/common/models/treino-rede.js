'use strict';

var app = require('../../server/server');

module.exports = function(Treinorede) {

    Treinorede.RecebeListaTeste = function(listaId, callback) {
        let listaIdStr = listaId.toString();
        let sql = "update TreinoRede set dataTeste = now() where id in (" + listaIdStr + ")";
        console.log(sql);
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.DesligaTesteGrupo = function(idGrupoTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoTeste = 0 " +
            " where treinoGrupoRedeId = " + idGrupoTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }


    Treinorede.AlteraAtivaTeste = function(idTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoTeste = case when ativoTeste = 0 then 1 else 0 end " +
            " where id = " + idTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }
    Treinorede.AlteraAtivaPrevisaoTeste = function(idTreino,callback) {
        let sql = "update TreinoRede " +
            " set ativoPrevisaoTeste = 1 " +
            " where id = " + idTreino;
        let sql2 = "update PrevisaoTeste " +
            " set pontuacao = null, " +
            " resultado = null, " +
            " diaNumSaida = null, " +
            " precoSaida = null " +
            " where treinoRedeId = " + idTreino;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql2, (err,result) => {
            ds.connector.query(sql,callback);
        })
       
    }


    Treinorede.ExecutouTreinamento = function(id,callback) {
        let sql = "update TreinoRede " +
            " set dataTreinamento = now() " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ExecutouDadoTeste = function(id,callback) {
        let sql = "update TreinoRede " +
            " set dataTeste = now(), " +
            " mediaValorTeste = (select avg(valorPrevisao) from PrevisaoTeste where PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " desvioValorTeste = (select STDDEV(valorPrevisao) from PrevisaoTeste where PrevisaoTeste.treinoRedeId = TreinoRede.id) " +
            " where id = "  + id;
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Treinorede.ExecutouPrevisaoTeste = function(id,callback) {
        let sql = "update TreinoRede " +
            " set qtdeTradeTeste = (select count(*) from PrevisaoTeste where precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " pontuacaoTeste = (select sum(pontuacao*100) from PrevisaoTeste where precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdeLucroTeste = (select count(*) from PrevisaoTeste where resultado = 1 and precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " qtdePrejuizoTeste = (select count(*) from PrevisaoTeste where resultado = -1 and precoSaida is not null and PrevisaoTeste.treinoRedeId = TreinoRede.id), " +
            " dataPrevisaoTeste = now(), " +
            " ativoPrevisaoTeste = 0 " +         
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
            " where ativoPrevisaoTeste = 1";
        let ds = Treinorede.dataSource;
        ds.connector.query(sql,callback);
    } 
    Treinorede.ObtemListaParaTestePorGrupo = function(id,callback) {
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

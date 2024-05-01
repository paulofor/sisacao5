'use strict';

var app = require('../../server/server');

module.exports = function(Previsaoteste) {

    Previsaoteste.ObtemPorIdTreino = function(idTreino,callback) {
        const sql = "select ticker, diaNumPrevisao, campoY, valorPrevisao from PrevisaoTeste where treinoRedeId = " + idTreino;
        const ds = Previsaoteste.dataSource;
        ds.connector.query(sql,callback);
    }

    Previsaoteste.AtualizaResultadoCampoY = function(idTreino, callback) {
        console.log('id: ' , idTreino);
        const ds = Previsaoteste.dataSource;
        app.models.TreinoRede.findById(idTreino, (err,treino) => {
            console.log('err: ' , err);
            console.log('treino: ' , treino);
            const sql = "update PrevisaoTeste set campoY = (select campoY from ExemploTreinoAcaoSaida " +
                " where regraProjecaoId = " + treino.regraProjecaoId + " and ExemploTreinoAcaoSaida.diaNumPrevisao = PrevisaoTeste.diaNumPrevisao " +
                " and ExemploTreinoAcaoSaida.ticker = PrevisaoTeste.ticker) " +
                " where treinoRedeId = " + idTreino;
            ds.connector.query(sql,callback);
        })
    }


    Previsaoteste.InsereListaItemPrevisao = function(treinoRedeId, valorScore, ticker, diaNum,callback) {
        //console.log(treinoRedeId);
        //console.log(ticker);
        //console.log(valorScore);
        for (let i=0; i<diaNum.length; i++) {
            //console.log('dia-> ' , diaNum[i]);
            Previsaoteste.InsereItemPrevisao(treinoRedeId,valorScore[i],ticker,diaNum[i], (err,result) => {
                //console.log('erro:' , err)
            })
        }
        callback(null, {'result' : 'ok'})
    }


    Previsaoteste.InsereItemPrevisao = function(treinoRedeId,valorScore,ticker,diaNum, callback) {
        const sql = "select * from PrevisaoTeste where ticker = '" + ticker + "' and diaNumPrevisao = " + diaNum + 
            " and treinoRedeId = " + treinoRedeId;
        const ds = Previsaoteste.dataSource;
        ds.connector.query(sql, (err,result) => {
            if (result.length==0) {
                const sql2 = "insert into PrevisaoTeste (ticker, diaNumPrevisao, treinoRedeId, valorPrevisao ) values " +
                    "('" + ticker + "' , " + diaNum + " , " + treinoRedeId + " , " + valorScore + ")";
                console.log(sql2);
                ds.connector.query(sql2,callback)
            } else {
                const sql2 = "update PrevisaoTeste set valorPrevisao = " + valorScore + " where ticker = '" + ticker + "' and diaNumPrevisao = " + diaNum + 
                " and treinoRedeId = " + treinoRedeId;
                console.log(sql2);
                ds.connector.query(sql2,callback);
            }
        })
    }


    Previsaoteste.AtualizaPosicaoDiaPorTreino = function(idTreino, callback) {
        let sql1 = " SET @rank=1"; 
        let sql2 = " SET @data_anterior=NULL";
        let sql3 = " UPDATE PrevisaoTeste t  " +
            " JOIN (  " +
            " SELECT diaNumPrevisao, pontuacao, id,  " +
                " @rank := IF(@data_anterior = diaNumPrevisao , @rank+1, 1) AS nova_ordem,  " +
                " @data_anterior := diaNumPrevisao,  " +
                " @pontuacao_anterior := pontuacao  " +
            " FROM PrevisaoTeste, (SELECT @rank:=0, @data_anterior:=NULL, @pontuacao_anterior:=NULL) AS temp  " +
            " where treinoRedeId = " + idTreino + " " +
            " ORDER BY diaNumPrevisao, pontuacao DESC, id  " +
            " ) AS temp  " +
            " ON t.diaNumPrevisao = temp.diaNumPrevisao AND t.pontuacao = temp.pontuacao AND t.id = temp.id  " +
            " SET t.posicaoDia = temp.nova_ordem;";
        let ds = Previsaoteste.dataSource;
        //console.log(sql);
        ds.connector.query(sql1,(err1,retorno1) => {
            ds.connector.query(sql2, (err2,retorno2) => {
                ds.connector.query(sql3,callback);
            })
        });
    }


    Previsaoteste.RecebePrevisaoTreinoTeste = function(ticker, resultado, diaNumPrevisao, treinoRedeId, 
        valorEntrada, valorReferencia,  tipoCompraVenda, callback) {
        let cont=0;
        for (let i=0;i<ticker.length;i++) {
            let novo = {'ticker' : ticker[i] , 'valorPrevisao' : resultado[i] , 
                        'diaNumPrevisao' : diaNumPrevisao[i] , 'treinoRedeId' : treinoRedeId[i], 
                        'precoEntrada' : valorEntrada[i], 'precoReferencia' : valorReferencia[i], 
                        'tipoCompraVenda' : tipoCompraVenda[i]};
            console.log(cont, ') ' ,novo);
            Previsaoteste.create(novo);
            if (++cont==ticker.length) {
                callback(null,{'resultado' : ticker.length})
            }
        }
    }
   

    Previsaoteste.ListaComDiarioTargetStopTeste = function(treinoRedeId, diaNumInicial, diaNumFinal , limiteValor, callback) {
        let sql = "select PrevisaoTeste.* , diario.maximo maximoDiario , diario.minimo minimoDiario, RegraProjecao.target, RegraProjecao.stop, PrevisaoTeste.tipoCompraVenda, " +
            " PrevisaoTeste.valorPrevisao " +
            " from PrevisaoTeste " +
            " inner join CotacaoDiarioAcao as diario on " + 
            " diario.ticker = PrevisaoTeste.ticker and diario.diaNum = PrevisaoTeste.diaNumPrevisao " +
            " inner join TreinoRede on TreinoRede.id = PrevisaoTeste.treinoRedeId " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " where treinoRedeId = " + treinoRedeId +
            " and diaNumPrevisao >= "  + diaNumInicial +
            " and diaNumPrevisao <= "  + diaNumFinal +
            " and valorPrevisao >= "  + (limiteValor) +
            " order by PrevisaoTeste.diaNumPrevisao, PrevisaoTeste.valorPrevisao desc"
        let ds = Previsaoteste.dataSource;
        ds.connector.query(sql,callback);
    }

    Previsaoteste.ListaComDiarioTargetStopPeriodoTesteScore = function(treinoRedeId, qtdeScore, callback) {
        let sql = "select PrevisaoTeste.* , diario.maximo maximoDiario , diario.minimo minimoDiario, RegraProjecao.target, RegraProjecao.stop, PrevisaoTeste.tipoCompraVenda,  " +
            " PrevisaoTeste.valorPrevisao  " +
            " from PrevisaoTeste " +
            " inner join CotacaoDiarioAcao as diario on  " +
            " diario.ticker = PrevisaoTeste.ticker and diario.diaNum = PrevisaoTeste.diaNumPrevisao  " +
            " inner join TreinoRede on TreinoRede.id = PrevisaoTeste.treinoRedeId  " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " + 
            " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " where treinoRedeId = "  + treinoRedeId + 
            " and diaNumPrevisao >= PeriodoTreinoRede.diaNumInicioTeste " +
            " and diaNumPrevisao <= PeriodoTreinoRede.diaNumFinalTeste " +
            " and valorPrevisao >= TreinoRede.limiteParaEntrada " +
            " and posicaoDia <= " + qtdeScore +
            " order by PrevisaoTeste.diaNumPrevisao, PrevisaoTeste.valorPrevisao desc "; 
        let ds = Previsaoteste.dataSource;
        ds.connector.query(sql,callback);
    }

    
    Previsaoteste.AtualizaResultadoTeste = function(previsao, callback) {
        let ds = Previsaoteste.dataSource;
        let sql1 = "update PrevisaoTeste set resultado = " + previsao.resultado + " , " +
                " pontuacao = " + previsao.pontuacao + 
                " where id = " + previsao.id;
        //console.log('sql1:',sql1);
        ds.connector.query(sql1,(err,result) => {
            //console.log('err', err);
            if (previsao.resultado!=0) {
                let sql2 = "update PrevisaoTeste set precoSaida = " + previsao.precoSaida + " , " +
                    " diaNumSaida = " + previsao.diaNumSaida +
                    " where id = " + previsao.id;
                ds.connector.query(sql2,callback)   
            } else {
                callback(err,result);
            }
        })
    }


};

'use strict';

var app = require('../../server/server');


module.exports = function(Previsaorede) {


    Previsaorede.PrevisaoHistorico = function(dias, callback) {
        let sql = " select data, diaNum, " +
                " (select count(distinct treinoRedeId) from PrevisaoRede where PrevisaoRede.diaNumPrevisao = DiaPregao.diaNum) " +
                " as qtdeTreino " +
                " from DiaPregao " +
                " where diaNum <= (select max(diaNumPrevisao) from PrevisaoRede) " +
                " order by data desc " +
                " limit " + dias;
        let ds = Previsaorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Previsaorede.RecebePrevisaoTreinoExecucao = function(ticker, resultado, diaNumPrevisao, treinoRedeId, 
        valorEntrada, valorReferencia,  tipoCompraVenda, callback) {
        let cont=0;
        for (let i=0;i<ticker.length;i++) {
            let novo = {'ticker' : ticker[i] , 'valorPrevisao' : resultado[i] , 
                        'diaNumPrevisao' : diaNumPrevisao[i] , 'treinoRedeId' : treinoRedeId[i], 
                        'precoEntrada' : valorEntrada[i], 'precoReferencia' : valorReferencia[i], 
                        'tipoCompraVenda' : tipoCompraVenda[i]};
            console.log(cont, ') ' ,novo);
            Previsaorede.create(novo);
            if (++cont==ticker.length) {
                callback(null,{'resultado' : ticker.length})
            }
        }
    }

    Previsaorede.AtualizaResultado = function(previsao, callback) {
        let ds = Previsaorede.dataSource;
        let sql1 = "update PrevisaoRede set resultado = " + previsao.resultado + 
                " where id = " + previsao.id;
        //console.log('sql1:',sql1);
        ds.connector.query(sql1,(err,result) => {
            //console.log('err', err);
            if (previsao.resultado!=0) {
                let sql2 = "update PrevisaoRede set precoSaida = " + previsao.precoSaida + " , " +
                    " diaNumSaida = " + previsao.diaNumSaida +
                    " where id = " + previsao.id;
                ds.connector.query(sql2,callback)   
            } else {
                callback(err,result);
            }
        })
    }
    Previsaorede.ObtemPorTreinoDiaAnterior = function(treinoRedeId,  callback) {
        app.models.DiaPregao.ObtemAtual((err,result) => {
            console.log('dia:' , result);
            let filtro = {
                'order' : 'valorPrevisao desc',
                'limit' : 5,
                'where' : {
                    'and' : [
                        { 'treinoRedeId' : treinoRedeId },
                        { 'diaNumPrevisao' : result.diaNum }
                    ]
                }
            }
            Previsaorede.find(filtro,callback);
        })
    }
    Previsaorede.ObtemPorDiaTreino = function(diaNumPrevisao, treinoRedeId,  callback) {
        let filtro = {

            'where' : {
                'and' : [
                    { 'treinoRedeId' : treinoRedeId },
                    { 'diaNumPrevisao' : diaNumPrevisao }
                ]
            }
        }
        Previsaorede.find(filtro,callback);
    }
    Previsaorede.ObtemPorDiaTreinoSelecionada = function(diaNumPrevisao, treinoRedeId,  callback) {
        let sql = "select PrevisaoRede.ticker, PrevisaoRede.valorPrevisao, PrevisaoRede.precoEntrada, PrevisaoRede.diaNumPrevisao , "  +
            " diario.maximo as maximoDiario, diario.minimo as minimoDiario, regra.target, regra.stop, PrevisaoRede.tipoCompraVenda " +
            " from PrevisaoRede " +
            " inner join CotacaoDiarioAcao as diario on " + 
            " diario.ticker = PrevisaoRede.ticker and diario.diaNum = PrevisaoRede.diaNumPrevisao " +
            " inner join TreinoRede on " + 
            " TreinoRede.id = PrevisaoRede.treinoRedeId " +
            " inner join RegraProjecao as regra on " + 
            " regra.id = TreinoRede.regraProjecaoId " +
            " where diaNumPrevisao = " + diaNumPrevisao +
            " and treinoRedeId = " + treinoRedeId +
            " and valorPrevisao > (select limiteParaEntrada from TreinoRede where id = " + treinoRedeId + " ) " +
            " order by valorPrevisao desc";
        let ds = Previsaorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Previsaorede.ObtemPorDiaTreinoComDiario = function(diaNumPrevisao, treinoRedeId,  callback) {
        let sql = "select PrevisaoRede.ticker, PrevisaoRede.valorPrevisao, PrevisaoRede.precoEntrada, diario.maximo, diario.minimo " +
            " from PrevisaoRede " +
            " inner join CotacaoDiarioAcao as diario on " + 
            " diario.ticker = PrevisaoRede.ticker and diario.diaNum = PrevisaoRede.diaNumPrevisao " +
            " where treinoRedeId = " + treinoRedeId +
            " and diaNumPrevisao = "  + diaNumPrevisao +
            " order by valorPrevisao desc"
        let ds = Previsaorede.dataSource;
        ds.connector.query(sql,callback);
    }

    Previsaorede.ListaComDiarioTargetStop = function(treinoRedeId, diaNumInicial, diaNumFinal , limiteValor, callback) {
        let sql = "select PrevisaoRede.* , diario.maximo maximoDiario , diario.minimo minimoDiario, RegraProjecao.target, RegraProjecao.stop, PrevisaoRede.tipoCompraVenda " +
            " from PrevisaoRede " +
            " inner join CotacaoDiarioAcao as diario on " + 
            " diario.ticker = PrevisaoRede.ticker and diario.diaNum = PrevisaoRede.diaNumPrevisao " +
            " inner join TreinoRede on TreinoRede.id = PrevisaoRede.treinoRedeId " +
            " inner join RegraProjecao on RegraProjecao.id = TreinoRede.regraProjecaoId " +
            " where treinoRedeId = " + treinoRedeId +
            " and diaNumPrevisao >= "  + diaNumInicial +
            " and diaNumPrevisao <= "  + diaNumFinal +
            " and valorPrevisao >= "  + (limiteValor) +
            " order by PrevisaoRede.diaNumPrevisao"
        let ds = Previsaorede.dataSource;
        ds.connector.query(sql,callback);
    }
    
    Previsaorede.RecebePrevisao = function(ticker, resultado, diaNumPrevisao, redeId,  callback) {
        let cont=0;
        for (let i=0;i<ticker.length;i++) {
            let novo = {'ticker' : ticker[i] , 'valorPrevisao' : resultado[i] , 
                        'diaNumPrevisao' : diaNumPrevisao[i] , 'redeNeuralId' : redeId[i]};
            console.log(cont, ') ' ,novo);
            Previsaorede.create(novo);
            if (++cont==ticker.length) {
                callback(null,{'resultado' : ticker.length})
            }
        }
    }

    Previsaorede.RecebePrevisaoTreino = function(ticker, resultado, diaNumPrevisao, treinoRedeId, 
        valorEntrada, valorReferencia,  tipoCompraVenda, callback) {
        let cont=0;
        for (let i=0;i<ticker.length;i++) {
            let novo = {'ticker' : ticker[i] , 'valorPrevisao' : resultado[i] , 
                        'diaNumPrevisao' : diaNumPrevisao[i] , 'treinoRedeId' : treinoRedeId[i], 
                        'precoEntrada' : valorEntrada[i], 'precoReferencia' : valorReferencia[i], 
                        'tipoCompraVenda' : tipoCompraVenda[i]};
            console.log(cont, ') ' ,novo);
            Previsaorede.create(novo);
            if (++cont==ticker.length) {
                callback(null,{'resultado' : ticker.length})
            }
        }
    }
    
};

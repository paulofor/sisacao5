'use strict';

module.exports = function(Previsaoteste) {

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

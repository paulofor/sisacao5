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
};

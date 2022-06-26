'use strict';

module.exports = function(Previsaorede) {
    
    
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

 
    
};

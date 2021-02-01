'use strict';

module.exports = function(Diapregao) {


    /**
    * 
    * @param {number} ano 
    * @param {Function(Error, object)} callback
    */
    Diapregao.CriaDatasAno = function(ano, callback) {
        var data = new Date(ano, 0, 1, 3, 0, 0, 0);
        var ind = 0;
        //console.log('anos: ', ano, " - ", data);
        while (data.getUTCFullYear() == ano) {
            //console.log((data.getUTCDay()));
            if (data.getUTCDay() != 0 && data.getUTCDay() != 6) {
                ind++;
                var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
                var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
                var diaNum = data.getUTCFullYear() + mesComp + diaComp;
                var dataStr =  diaComp + '-' + mesComp + '-' + data.getUTCFullYear()
                var dataSimples = data.getUTCFullYear() + '-' + mesComp + '-' + diaComp;
                var dia = new Diapregao({ "diaNum": diaNum, "ano": data.getUTCFullYear(), "mes": data.getUTCMonth() + 1, "dataStr" : dataStr , "data" : dataSimples});
                console.log('dia: ', JSON.stringify(dia));
                Diapregao.create(dia);
            }
            data.setDate(data.getDate() + 1);
        }

        callback(null, null);
    };

    Diapregao.ObtemDiaTicker = function(diaNum, ticker,quantidadeDia, callback) {
        filtro = {'where' : {'diaNum' : ''}}
    }

    Diapregao.ObtemIntradayPorTicker = function(ticker, callback) {
        //console.log('entrou na funcao', ticker);
        let filtro = {'include' : 
            { 
                'relation' : 'cotacaoIntradayAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" , "fields" : { valor:true, ticker: true, dataHora: true }} 
            }, 'order' : 'diaNum'
        }
        Diapregao.find(filtro,callback);
    }
};

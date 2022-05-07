'use strict';

var app = require('../../server/server');

module.exports = function(Diapregao) {

   
    Diapregao.ProximoParaValidador = function(tickerm,idPeriodo,callback) {
        app.models.PeriodoExperimento.findById(idPeriodo, (err,periodo) => {
            let sql = "select * from DiaPregao where diaNum >= " + periodo.dataNumInicioValidacao + " and data <= now() order by data";
            let ds = Diapregao.dataSource;
            ds.connector.query(sql,callback);
        })
     
    }


    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Diapregao.ComFalhaDiario = function(callback) {
        let sql = "select * from DiaPregao " +
                " where data <= now() and " +
                " diaNum not in (select diaNum from CotacaoDiarioAcao where ticker = 'AZUL4')";
        let ds = Diapregao.dataSource;
        ds.connector.query(sql,callback);
    };
  

    /**
    * 
    * @param {number} idExecucao 
    * @param {Function(Error, array)} callback
    */
    Diapregao.PeriodoAtualizacaoMonitoria = function(idExecucao, callback) {
        let sql = " select DiaPregao.* from DiaPregao " +
                " where diaNum > ( " +
                " select PeriodoExperimento.dataNumFinal from PeriodoExperimento " + 
                " inner join ExecucaoSimulacao on ExecucaoSimulacao.periodoExperimentoId = PeriodoExperimento.id " +
                " where ExecucaoSimulacao.id = " + idExecucao +
                " ) " +
                " and data <= now() " +
                " order by data ";
        let ds = Diapregao.dataSource;
        //console.log(sql);
        ds.connector.query(sql,callback);
    };

    Diapregao.ObtemAnteriorB3 = function(callback) {
        var data = new Date();
        data.setUTCMinutes(0);
        data.setUTCHours(0);
        data.setUTCSeconds(0);
        data.setUTCMilliseconds(0);
        //console.log(data);
        let filtro = { 
            "where" : 
                {"data" : {"lt": data } },
            "order" : "data desc" 
        }
        Diapregao.findOne(filtro, callback);
    }


    /**
    * 
    * @param {Function(Error, object)} callback
    */
    Diapregao.ObtemProximo = function(callback) {
        var data = new Date();
        data.setUTCMinutes(0);
        data.setUTCHours(0);
        data.setUTCSeconds(0);
        data.setUTCMilliseconds(0);
        //console.log(data);
        let filtro = { 
            "where" : {"data" : {"gte": data } },
            "order" : "data" 
        }
        Diapregao.findOne(filtro, callback);
    };

    Diapregao.ObtemProximoB3 = function(callback) {
        Diapregao.ObtemProximoAntesMeiaNoite(5,callback); 
    };
  
    Diapregao.ObtemProximoAntesMeiaNoite = function(horas,callback) {
        var data = new Date();
        data.setDate(data.getDate()-1);
        data.setHours(data.getHours() - (data.getTimezoneOffset()/60) + horas);
        //data.setUTCMinutes(0);
        //data.setUTCHours(0);
        //data.setUTCSeconds(0);
        //data.setUTCMilliseconds(0);
        console.log('data:' , data);
        console.log(data);
        let filtro = { "where" : {"data" : {"gte": data } } }
        Diapregao.findOne(filtro, callback);
    };


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
                //console.log('dia: ', JSON.stringify(dia));
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
            [
                { 
                'relation' : 'cotacaoIntradayAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" , "fields" : { valor:true, ticker: true, dataHora: true, dataHoraNegStr: true }} 
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum'
        }
        Diapregao.find(filtro,callback);
    }


    Diapregao.ObtemIntradayTickerPeriodo = function(ticker, dataNumInicio, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" , "fields" : { valor:true, ticker: true, dataHora: true, dataHoraNegStr: true}} 
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum',
            'where' : { and : [{'diaNum' : { 'gte' : dataNumInicio }}, {'diaNum': {'lte' : diaNum}} ]}
        }
        Diapregao.find(filtro,callback);
    };
      

    Diapregao.ObtemIntradayResultadoTickerPeriodo = function(ticker, dataNumInicio, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaoResultados',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" } 
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum',
            'where' : { and : [{'diaNum' : { 'gte' : dataNumInicio }}, {'diaNum': {'lte' : diaNum}} ]}
        }
        Diapregao.find(filtro,callback);
    };


    Diapregao.ObtemIntradayResultadoTickerPeriodoQuantidade = function(ticker, qtdeDia, dataNumFinal, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaoResultados',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" } 
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum desc',
            'limit' : qtdeDia,
            'where' : {'diaNum': {'lte' : dataNumFinal}} 
        }
        Diapregao.find(filtro, (err,result) => {
            callback(err,result.reverse())
        });
    };
  
    Diapregao.ObtemIntradayResultadoTickerQuantidade = function(ticker, qtdeDia, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
         let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaoResultados',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" } 
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum desc',
            'limit' : qtdeDia,
            'where' : {'diaNum': {'lte' : diaNum}} 
        }
        Diapregao.find(filtro, (err,result) => {
            callback(err,result.reverse())
        });
    };


    /**
    * 
    * @param {string} ticker 
    * @param {number} dataNumInicio 
    * @param {number} idRegraProjecao 
    * @param {Function(Error, array)} callback
    */
    Diapregao.ObtemIntradayResultadoValor = function(ticker, dataNumInicio, idRegraProjecao, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getMonth()+1)<10?'0' + (data.getMonth()+1): '' + (data.getMonth()+1);
        var diaNum = Number(data.getFullYear() + mesComp + diaComp) -1;
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaoResultados',
                'scope' : 
                    {
                        'where' : {'ticker' : ticker } , 
                        "order" : "dataHora" ,
                        'include' : {
                            'relation' : 'cotacaoIntradayAcaoResultadoValors' ,
                            'scope' :
                              {'where' : {'regraProjecaoId' : idRegraProjecao }},
           
                        }
                    } 
                    
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum',
            'where' : { and : [{'diaNum' : { 'gte' : dataNumInicio }}, {'diaNum': {'lte' : diaNum}} ]}
        }
        //console.log('filtro:' , filtro);
        Diapregao.find(filtro,callback);
    };
  

     /**
    * 
    * @param {string} ticker 
    * @param {number} dataNumInicio 
    * @param {number} regraProjecaoId 
    * @param {Function(Error, array)} callback
    */
      Diapregao.ObtemIntradayResultadoDataset = function(ticker, dataNumInicio, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayAcaoResultados',
                'scope' : 
                    {
                        'where' : {'ticker' : ticker } , 
                        "order" : "dataHora" 
                    } 
                    
                },
                { 
                'relation' : 'cotacaoDiarioAcaos',
                'scope' : 
                    {'where' : {'ticker' : ticker }} 
                }
            ], 
            'order' : 'diaNum',
            'where' : { and : [{'diaNum' : { 'gte' : dataNumInicio }}, {'diaNum': {'lte' : diaNum}} ]}
        }
        Diapregao.find(filtro,callback);
    };
  
};

'use strict';

var app = require('../../server/server');

module.exports = function(Diapregao) {


    Diapregao.ObtemComPrevisaoRedePorIdTreino = function(idTreino,  callback) {
        let ds = Diapregao.dataSource;
        let sql = "select PeriodoTreinoRede.*, TreinoRede.limiteParaEntrada from TreinoRede " +
                " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
                " where TreinoRede.id = " + idTreino;
        ds.connector.query(sql, (err,result) => {
            let hoje = new Date();
            hoje.setMinutes(0);
            hoje.setHours(0);
            hoje.setSeconds(0);
            hoje.setMilliseconds(0);
            let filtro = {
                'where' : 
                    { 'and' : 
                        [
                            {'diaNum' : {'gte' :  result[0].diaNumInicioExecucao } },
                            {'data' : {'lte' : hoje }}
                        ]
                    }
                ,
                'order' : 'diaNum' ,
                'include' : {'relation' : 'previsaoRedes' , 'scope' : {
                    'order' : 'valorPrevisao desc',
                    'where' : {'and' : [
                        {'treinoRedeId' : idTreino},
                        {'valorPrevisao' : {'gte' : result[0].limiteParaEntrada  }}
                    ] },
                    "include" : {"relation" : "treinoRede" , "scope" : {
                        "include" : "regraProjecao"
                    }}
                }}
            }
            Diapregao.find(filtro,callback);
        })
    }

    Diapregao.ObtemAnteriorQuantidade = function(quantidade,callback) {
        let ds = Diapregao.dataSource;
        if (quantidade <= 0) {
            let sql = "select * from DiaPregao where data <= now() order by data desc limit " + ((quantidade*-1) + 1);
            console.log(sql);
            ds.connector.query(sql,(err,result) => {
                callback(err,result[result.length-1])
            })
        } else {
            callback(null,null)
        }
       
    }

    Diapregao.ObtemAnteriorPorDia = function(diaNum,callback) {
        let ds = Diapregao.dataSource;
        let sql = "select * from DiaPregao " +
                " where diaNum < " + diaNum +
                " order by diaNum desc limit 1";
        ds.connector.query(sql,(err,result) => {
            callback(err,result[result.length-1])
        })
    }

   
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

    Diapregao.ObtemPeriodoPrevisaoTeste = function(idPeriodoTreinoRede, callback) {
        let sql = " select DiaPregao.* " +
                " from PeriodoTreinoRede, DiaPregao " +
                " where PeriodoTreinoRede.id = " + idPeriodoTreinoRede +
                " and DiaPregao.diaNum >= PeriodoTreinoRede.diaNumInicioTeste " +
                " and DiaPregao.diaNum <= PeriodoTreinoRede.diaNumFinalTeste " +
                " and DiaPregao.data < date(now()) " +
                " order by data";
        let ds = Diapregao.dataSource;
        ds.connector.query(sql,callback);
    };
  
    Diapregao.ObtemPeriodoPrevisaoExecucao = function(idPeriodoTreinoRede, callback) {
        let sql = " select DiaPregao.* " +
                " from PeriodoTreinoRede, DiaPregao " +
                " where PeriodoTreinoRede.id = " + idPeriodoTreinoRede +
                " and DiaPregao.diaNum >= PeriodoTreinoRede.diaNumInicioExecucao " +
                " and DiaPregao.diaNum <= PeriodoTreinoRede.diaNumFinalExecucao " +
                " and DiaPregao.data < date(now()) " +
                " order by data";
        let ds = Diapregao.dataSource;
        console.log(sql);
        ds.connector.query(sql,callback);
    };
    Diapregao.ObtemPeriodoPrevisaoExecucaoPendente = function(idTreinoRede, callback) {
        let sql = " select DiaPregao.* " +
            " from DiaPregao, PeriodoTreinoRede, TreinoRede " +
            " where TreinoRede.id = " + idTreinoRede +
            " and PeriodoTreinoRede.id = TreinoRede.periodoTreinoRedeId " +
            " and DiaPregao.diaNum >= PeriodoTreinoRede.diaNumInicioExecucao " + 
            " and DiaPregao.diaNum <= PeriodoTreinoRede.diaNumFinalExecucao " +
            " and DiaPregao.data < date(now()) " +
            " and DiaPregao.diaNum not in (select diaNumPrevisao from PrevisaoRede where PrevisaoRede.treinoRedeId = TreinoRede.id) " +
            " order by data ";
        let ds = Diapregao.dataSource;
        console.log(sql);
        ds.connector.query(sql,callback);
    };

    Diapregao.ObtemIntradayResultadoTickerAteFinal = function(ticker, diaNumInicio, tamanhoAmostra, callback) {
        Diapregao.ObtemProximo((err,result) => {
            let filtro = {
                'limit' : tamanhoAmostra,
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
                'where' : { and : [{'diaNum' : { 'gte' : diaNumInicio }}, {'diaNum': {'lt' : result.diaNum}} ]}
            }
            Diapregao.find(filtro,callback);
        });
    }

    Diapregao.ObtemIntradayResultadoTickerAteFinalInicioAnterior = function(ticker, diaNumInicio, tamanhoAmostra, callback) {
        let sql = "select * from DiaPregao where diaNum < " + diaNumInicio + " order by diaNum desc limit 1";
        console.log('sql:' , sql);
        let ds = Diapregao.dataSource;
        ds.connector.query(sql, (err,resultDia) => {
            console.log('inicio em :' , resultDia[0]);
            Diapregao.ObtemProximo((err,result) => {
                let filtro = {
                    'limit' : tamanhoAmostra + 2,
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
                    'where' : { and : [{'diaNum' : { 'gte' : resultDia[0].diaNum }}, {'diaNum': {'lt' : result.diaNum}} ]}
                }
                Diapregao.find(filtro,callback);
            });
        })
       
    }

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
        Diapregao.ObtemProximoAntesMeiaNoite(-48+5,callback); 
    }

    Diapregao.ObtemAtualB3 = function(callback) {
        Diapregao.ObtemProximoAntesMeiaNoite(-24+5,callback);
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
    Diapregao.ObtemAtual = function(callback) {
        var data = new Date();
        data.setMinutes(0);
        data.setHours(0);
        data.setSeconds(0);
        data.setMilliseconds(0);
        console.log(data);
        let filtro = { 
            "where" : {"data" : {"lte": data } },
            "order" : "data desc" 
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
        let ds = Diapregao.dataSource;
        var feriados = ['01-01','04-21','05-01','09-07','10-12','11-02','11-15','07-09','11-20','01-25','12-25'];
        for (let i=0;i<feriados.length;i++) {
            let sql = "delete from DiaPregao where data = '" + ano + "-" + feriados[i] + "'";
            console.log(sql);
            ds.connector.query(sql,(err,result) => {

            })
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
      


    Diapregao.ExemploTreinoEntradaMaisRecenteIndice = function(qtde, callback) {
        let sql = " select dia.*, " + 
            " (select count(*) from ExemploTreinoIndiceAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and tipoExemploTreinoId = 1) as tipoExemplo1, " +
            " (select count(*) from ExemploTreinoIndiceAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and tipoExemploTreinoId = 5) as tipoExemplo5 " +
            " from DiaPregao dia " +
            " where dia.diaNum <= (select max(diaNumPrevisao) from ExemploTreinoIndiceAcaoEntrada) " +
            " order by dia.diaNum desc " +
            " limit " + qtde;
        let ds = Diapregao.dataSource;
        ds.connector.query(sql,callback);
    }

    Diapregao.ExemploTreinoEntradaMaisRecente = function(qtde, callback) {
        let sql = " select dia.*, " + 
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 120) as quantidadeAcao120, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 60) as quantidadeAcao60, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 40) as quantidadeAcao40, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 25) as quantidadeAcao25, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 20) as quantidadeAcao20, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 15) as quantidadeAcao15, " +
            " (select count(*) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum  and qtdeDias = 10) as quantidadeAcao10, " +
            " (select count(distinct ticker) from ExemploTreinoAcaoEntrada as exemplo " +
            " where exemplo.diaNumPrevisao = dia.diaNum ) as exemploSaida " +
            " from DiaPregao dia " +
            " where dia.diaNum <= (select max(diaNumPrevisao) from ExemploTreinoAcaoEntrada) " +
            " order by dia.diaNum desc " +
            " limit " + qtde;
        let ds = Diapregao.dataSource;
        ds.connector.query(sql,callback);
    }



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


    Diapregao.ObtemIntradayResultadoTickerPeriodoQuantidade = function(ticker, qtdeDia, diaNumPrevisao, callback) {
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
            'limit' : qtdeDia + 1,
            'where' : {'diaNum': {'lte' : diaNumPrevisao}} 
        }
        Diapregao.find(filtro, (err,result) => {
            callback(err,result.reverse())
        });
    };

    Diapregao.ObtemIntradayResultadoIndicePeriodoQuantidade = function(ticker, qtdeDia, diaNumPrevisao, callback) {
        var data = new Date();
        var diaComp = (data.getDate()<10?'0' + data.getDate(): '' + data.getDate());
        var mesComp = (data.getUTCMonth()+1)<10?'0' + (data.getUTCMonth()+1): '' + (data.getUTCMonth()+1);
        var diaNum = Number(data.getUTCFullYear() + mesComp + diaComp);
        let filtro = {
            'include' : 
            [
                { 
                'relation' : 'cotacaoIntradayIndiceResultados',
                'scope' : 
                    {'where' : {'ticker' : ticker } , "order" : "dataHora" } 
                }
               
            ], 
            'order' : 'diaNum desc',
            'limit' : qtdeDia + 1,
            'where' : {'diaNum': {'lte' : diaNumPrevisao}} 
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

    Diapregao.ObtemIntradayResultadoTickerQuantidadeB3 = function(ticker, qtdeDia, callback) {
        Diapregao.ObtemProximoB3((err,result) => {
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
                'limit' : qtdeDia + 1,
                'where' : {'diaNum': {'lte' : result.diaNum}} 
            }
            Diapregao.find(filtro, (err,result) => {
                callback(err,result.reverse())
            });
        })
       
    };

    Diapregao.ListaDataPeriodo = function(diaNumInicio,diaNumFinal, callback) {
        let filtro = {
            'where' : {'and' : [
                {'diaNum' : {'gte' : diaNumInicio}},
                {'diaNum' : {'lte' : diaNumFinal }}
            ]},
            'order' : 'diaNum'
        }
        Diapregao.find(filtro,callback);
    }
    Diapregao.ListaDataPeriodoAteOntem = function(diaNumInicio, callback) {
        const sql = "select * from DiaPregao where diaNum >= " + diaNumInicio + " and data < date(now()) ";
        const ds = Diapregao.dataSource;
        ds.connector.query(sql,callback);
    }

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

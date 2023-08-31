'use strict';

module.exports = function(Tradereal) {


    let CUSTO_OPERACAO = 11;


    Tradereal.LimitaTargetStop = function(percentualTarget,percentualStop,callback) {
        
    }

    /**
    * 
    * @param {Function(Error, object)} callback
    */
    Tradereal.AtualizaDiaAberto = function(callback) {
        let sql = " update TradeReal " +
            " set  dataNumEntrada = concat(substring(dataEntrada,1,4),substring(dataEntrada,6,2),substring(dataEntrada,9,2)) " +
            " where posicaoAtual = 1";
        let sql2 = " update TradeReal " +
                " set dias = (select count(*) from DiaPregao where diaNum > TradeReal.dataNumEntrada and data <= now() ) " +
                " where posicaoAtual = 1"
        let ds = Tradereal.dataSource;
        ds.connector.query(sql, (err,result) => {
            ds.connector.query(sql2, callback);
        })
    };
  


    /**
    * 
    * @param {number} idTrade 
    * @param {Function(Error, object)} callback
    */
    Tradereal.CalculaSaida = function(idTrade, callback) {
        let sqlCompra = "update TradeReal " +
            " set lucroPrejuizo = custoSaida - custoEntrada , " +
            " percentual = ((precoSaida - precoEntrada) / precoEntrada) * 100, " +
            " custoTotal = (valorSaida - valorEntrada) - (custoSaida - custoEntrada), " +
            " dataNumEntrada = concat(substring(dataEntrada,1,4),substring(dataEntrada,6,2),substring(dataEntrada,9,2)), " +
            " dataNumSaida = concat(substring(dataSaida,1,4),substring(dataSaida,6,2),substring(dataSaida,9,2)) " +
            " where id = " + idTrade + " and tipo='C' ";
        let sqlVenda = "update TradeReal " +
            " set lucroPrejuizo = custoEntrada - custoSaida , " +
            " percentual = ((precoEntrada - precoSaida) / precoEntrada) * 100, " +
            " custoTotal = (valorEntrada - valorSaida) - (custoEntrada - custoSaida), " +
            " dataNumEntrada = concat(substring(dataEntrada,1,4),substring(dataEntrada,6,2),substring(dataEntrada,9,2)), " +
            " dataNumSaida = concat(substring(dataSaida,1,4),substring(dataSaida,6,2),substring(dataSaida,9,2)) " +
            " where id = " + idTrade + " and tipo='V' ";
        let sql2 = " select count(*) as dias from DiaPregao " +
                   " where diaNum > (select dataNumEntrada from TradeReal where id = " + idTrade + ") " +
                   " and diaNum <= (select dataNumSaida from TradeReal where id = " + idTrade + ")";
        let ds = Tradereal.dataSource;
        ds.connector.query(sqlCompra,(err,result) => {
            ds.connector.query(sqlVenda,(err,result) => {
                ds.connector.query(sql2, (err,result2) => {
                    let sql3 = "update TradeReal set dias = " + result2[0].dias +
                        " where id = " + idTrade;
                    ds.connector.query(sql3, callback); 
                })
            });

        })
        
    };
  

    /**
    * 
    * @param {number} idTrade 
    * @param {Function(Error, object)} callback
    */
    Tradereal.CalculaEstimativa = function(idTrade, callback) {
        //console.log('CalculaEstimativa');
        let sql1Compra = "update TradeReal " +
            " set valorTarget = precoTarget * quantidade, " +
            " valorStop = precoStop * quantidade, " +
            " valorEntrada = precoEntrada * quantidade, " +
            " dataNumEntrada = concat(substring(dataEntrada,1,4),substring(dataEntrada,6,2),substring(dataEntrada,9,2)) " +
            " where id = " + idTrade + " and tipo='C' ";
        let sql2Compra = "update TradeReal " +
            " set valorExposicao = (valorEntrada - valorStop + " + CUSTO_OPERACAO + ") , " +
            " lucroAlvo = (valorTarget - valorEntrada) -  " + CUSTO_OPERACAO +
            " where id = " + idTrade + " and tipo='C' ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql1Compra,(err,result) => {
            ds.connector.query(sql2Compra,callback);
        });

        let sql1Venda = "update TradeReal " +
            " set valorTarget = precoTarget * quantidade, " +
            " valorStop = precoStop * quantidade, " +
            " valorEntrada = precoEntrada * quantidade, " +
            " dataNumEntrada = concat(substring(dataEntrada,1,4),substring(dataEntrada,6,2),substring(dataEntrada,9,2)) " +
            " where id = " + idTrade + " and tipo='V' ";
        let sql2Venda = "update TradeReal " +
            " set valorExposicao = (valorStop - valorEntrada + " + CUSTO_OPERACAO + ") , " +
            " lucroAlvo = (valorEntrada - valorTarget) -  " + CUSTO_OPERACAO +
            " where id = " + idTrade + " and tipo='V' ";
        ds.connector.query(sql1Venda,(err,result) => {
            ds.connector.query(sql2Venda,callback);
        });
    };


    /**
    * 
    * @param {Function(Error, number)} callback
    */
    Tradereal.TotalExposicao = function(callback) {
        let sql = " select sum(valorExposicao) as valor from TradeReal " +
                " where posicaoAtual = 1 ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    };


    Tradereal.SituacaoAtual = function(callback) {
        let sql = "select sum(lucro) as valor " +
            " from " +
            " ( " +
            " select valorEntrada, valorSaida, posicao, ((valorSaida - valorEntrada) * posicao) as lucro " +
            " from  " +
            " ( " +
            " select (precoEntrada * quantidade) valorEntrada,  " +
            " (precoAtual * quantidade) valorSaida ,  " +
            " case " +
            " when tipo='C' then 1  " +
            " else -1  " +
            " end as posicao " +
            " from " +
            " ( " +
            " select ticker, precoEntrada, quantidade, tipo,  " +
            " (select valor from CotacaoIntradayAcao " +
            " where CotacaoIntradayAcao.ticker = TradeReal.ticker  " +
            " order by dataHora desc " +
            " limit 1 " +
            " ) precoAtual " +
            " from TradeReal where  " +
            " posicaoAtual <> 0 " +
            " ) as tab  " +
            " ) as tab2 " +
            " ) as tab3";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err, result[0]);
        })
    }

    Tradereal.RiscoAtual = function(callback) {
        let sql = "select sum(lucro) as valor " +
            " from " +
            " ( " +
            " select ticker, ((precoStop - precoEntrada) * quantidade) * posicao as lucro " +
            " from " +
            " ( " +
            " select ticker, precoEntrada, quantidade, tipo, precotarget, precoStop, " +
            " case " +
            " when tipo='C' then 1 " + 
            " else -1 " +
            " end as posicao " +
            " from TradeReal " +
            " where posicaoAtual <> 0 " +
            " ) as tab1 " +
            " ) as tab2";

        let ds = Tradereal.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err, result[0]);
        }) 
    }

    Tradereal.ResultadoPorMes= function(meses, callback) {
        let sql = " select distinct ano, mes, " +
            " ( " +
            " select coalesce(sum(lucroPrejuizo),0) " +
            " from TradeReal " +
            " where year(dataSaida) = ano and month(dataSaida) = mes " +
            " ) as lucroPrejuizo " +
            " from DiaPregao " +
            " where diaNum >= 20210101 " +
            " and data < now() " +
            " order by ano desc, mes desc " +
            " limit " + meses;
        let ds = Tradereal.dataSource;
        //console.log(sql);
        ds.connector.query(sql, (err,result) => {
            callback(err, result);
        }) 
    }

    Tradereal.AtualizaLucroPrejuizo = function(callback) {
        let sql = "update TradeReal " +
            " set lucroPrejuizo = ((precoSaida - precoEntrada) * quantidade ) * posicaoOperacao " +
            " where lucroPrejuizo is null " +
            " and posicaoAtual = 0 ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,callback);
    }

    Tradereal.AtualizaHistorico = function(callback) {
        let sql1 = "update TradeReal " +
                " set menorPreco = (select min(minimo) from CotacaoDiarioAcao where TradeReal.ticker = CotacaoDiarioAcao.ticker " +
                " and CotacaoDiarioAcao.diaNum > TradeReal.dataNumEntrada and CotacaoDiarioAcao.diaNum < TradeReal.dataNumSaida " +
                " ), " +
                " maiorPreco = (select max(maximo) from CotacaoDiarioAcao where TradeReal.ticker = CotacaoDiarioAcao.ticker " +
                " and CotacaoDiarioAcao.diaNum > TradeReal.dataNumEntrada and CotacaoDiarioAcao.diaNum < TradeReal.dataNumSaida " +
                " ) " +
                " where dataNumSaida is not null ";
        let sql2 = "update TradeReal " +
                " set menorPercentual = ((menorPreco - precoEntrada) / precoEntrada) * 100, " +
                " maiorPercentual = ((maiorPreco -precoEntrada) / precoEntrada) * 100 " +
                " where dataNumSaida is not null " +
                " and tipo = 'C'"
        let sql3 = "update TradeReal " +
                " set menorPercentual = ((precoEntrada - maiorPreco) / precoEntrada) * 100, " +
                " maiorPercentual = ((precoEntrada - menorPreco) / precoEntrada) * 100 " +
                " where dataNumSaida is not null " +
                " and tipo = 'V'"
        let sql4 = "update TradeReal " +
                " set menorPreco1Mes = (select min(minimo) from CotacaoDiarioAcao where TradeReal.ticker = CotacaoDiarioAcao.ticker " +
                " and CotacaoDiarioAcao.diaNum > TradeReal.dataNumSaida and CotacaoDiarioAcao.data <= date_add(TradeReal.dataSaida,interval 1 month) " +
                " ), " +
                " maiorPreco1Mes = (select max(maximo) from CotacaoDiarioAcao where TradeReal.ticker = CotacaoDiarioAcao.ticker " +
                " and CotacaoDiarioAcao.diaNum > TradeReal.dataNumSaida and CotacaoDiarioAcao.data <= date_add(TradeReal.dataSaida,interval 1 month) " +
                " ) " +
                " where dataNumSaida is not null"
        let sql5 = "update TradeReal " +
                " set menorPercentual1Mes = ((menorPreco1Mes - precoEntrada) / precoEntrada) * 100, " +
                " maiorPercentual1Mes = ((maiorPreco1Mes -precoEntrada) / precoEntrada) * 100 " +
                " where dataNumSaida is not null " +
                " and tipo = 'C'"
        let sql6 = "update TradeReal " +
                " set menorPercentual1Mes = ((precoEntrada - maiorPreco1Mes) / precoEntrada) * 100, " +
                " maiorPercentual1Mes = ((precoEntrada - menorPreco1Mes) / precoEntrada) * 100 " +
                " where dataNumSaida is not null " +
                " and tipo = 'V'";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql1,(err1,result1) => {
            console.log('err1: ' , err1);
            ds.connector.query(sql2, (err2,result2) => {
                console.log('err2: ' , err2);
                ds.connector.query(sql3, (err3,result3) => {
                    console.log('err3: ' , err3);
                    ds.connector.query(sql4, (err4,result4) => {
                        console.log('err4: ' , err4);
                        ds.connector.query(sql5, (err5,result5) => {
                            console.log('err5: ' , err5);
                            ds.connector.query(sql6, (err6,result6) => {
                                console.log('err6: ' , err6);
                                callback(err6,result6);
                            })
                        })
                    })
                })
            })
        });
    }


    Tradereal.ResumoAtual = function(callback) {
        let sql = " select " +
            " (select sum(operacaoRisco) from TradeReal where dataSaida is null) as risco, " +
            " (select sum(operacaoAlvo) from TradeReal where dataSaida is null) as alvo, " +
            " (select sum(operacaoAlvo) from TradeReal where dataSaida is null and tipo='C') as alvoLong, " +
            " (select sum(operacaoRisco) from TradeReal where dataSaida is null and tipo='C') as riscoLong, " +
            " (select sum(operacaoAlvo) from TradeReal where dataSaida is null and tipo='V') as alvoShort, " +
            " (select sum(operacaoRisco) from TradeReal where dataSaida is null and tipo='V') as riscoShort, " +
            " (select sum(lucroPrejuizo) from TradeReal where dataSaida is not null) as resultadoTotal, " +
            " (select count(*) from TradeReal where dataSaida is null) as trades, " +
            " (select sum(operacaoRisco) from TradeReal where dataSaida is null) / " +
            " (select sum(lucroPrejuizo) from TradeReal where dataSaida is not null) as proporcaoRisco";
        
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    }



    Tradereal.ListaAbertoComPreco = function(callback) {
        let sql = " SELECT * , " +
            " (select valor from CotacaoIntradayAcao where CotacaoIntradayAcao.ticker = TradeReal.ticker order by dataHora desc limit 1) as precoAtual " +
            " FROM TradeReal " +
            " where dataSaida is null ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,callback);
    }

    Tradereal.ListaAbertoComPrecoTarget = function(callback) {
        let sql = "select *, " +
            " (precoTarget-precoAtual) as difTarget, abs(((precoTarget-precoAtual)/precoAtual)*100) as percTarget, operacaoAlvo, " +
            " ((precoAtual-precoEntrada)/precoEntrada*100*posicaoAtual) as percAtual, ((precoEntrada-precoTarget)/precoEntrada*100*posicaoAtual) as targetCalculado " +
            " from " +
            " ( " +
            " SELECT * , " +
            " (select valor from CotacaoIntradayAcao where CotacaoIntradayAcao.ticker = TradeReal.ticker order by dataHora desc limit 1) as precoAtual, " +
            " (select dataHora from CotacaoIntradayAcao where CotacaoIntradayAcao.ticker = TradeReal.ticker order by dataHora desc limit 1) as precoHora " +
            " FROM TradeReal " +
            " where dataSaida is null " +
            " ) tab1 " +
            " order by percTarget ";
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,callback);
    }
    Tradereal.ListaAbertoComPrecoStop = function(callback) {
        let sql = "select *, " +
            " (precoAtual-precoStop) as difStop, abs(((precoAtual-precoStop)/precoAtual)*100) as percStop, operacaoRisco, " +
            " ((precoAtual-precoEntrada)/precoEntrada*100*posicaoAtual) as percAtual, ((precoEntrada-precoStop)/precoEntrada*100*posicaoAtual) as stopCalculado  " +
            " from " +
            " ( " +
            " SELECT * , " +
            " (select valor from CotacaoIntradayAcao where CotacaoIntradayAcao.ticker = TradeReal.ticker order by dataHora desc limit 1) as precoAtual, " +
            " (select dataHora from CotacaoIntradayAcao where CotacaoIntradayAcao.ticker = TradeReal.ticker order by dataHora desc limit 1) as precoHora " +
            " FROM TradeReal " +
            " where dataSaida is null " +
            " ) tab1 " +
        " order by percStop " ;
        let ds = Tradereal.dataSource;
        ds.connector.query(sql,callback);
    }


    Tradereal.observe('before save', function updateInicioColeta(ctx, next) {
        let sqlPosicaoOpercao
        //console.log('entrou no before save');
        //console.log()
        if (ctx.instance) {
           //console.log('instance');
           ctx.instance.posicaoOperacao = (ctx.instance.tipo=='V'?-1:1);
           if (ctx.instance.tipo=='C' &&  ctx.instance.precoStop && ctx.instance.precoTarget) {
                ctx.instance.operacaoRisco = ctx.instance.quantidade * (ctx.instance.precoEntrada - ctx.instance.precoStop);
                ctx.instance.operacaoAlvo = ctx.instance.quantidade * (ctx.instance.precoTarget - ctx.instance.precoEntrada) 
           }
           if (ctx.instance.tipo=='V' &&  ctx.instance.precoStop && ctx.instance.precoTarget) {
                ctx.instance.operacaoRisco = ctx.instance.quantidade * (ctx.instance.precoStop - ctx.instance.precoEntrada);
                ctx.instance.operacaoAlvo = ctx.instance.quantidade * (ctx.instance.precoEntrada - ctx.instance.precoTarget) 
           }
        } else {
            ctx.data.posicaoOperacao = (ctx.data.tipo=='V'?-1:1);
        }
        next();
      })
};

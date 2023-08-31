'use strict';

module.exports = function(Cotacaodiarioacao) {

    Cotacaodiarioacao.ListaValidacaoRegraProjecao = function(ticker,diaNumPrevisao,limiteDias,callback) {
        let sql = "select CotacaoDiarioAcao.*, dataStr from DiaPregao " +
                " inner join CotacaoDiarioAcao on CotacaoDiarioAcao.diaNum = DiaPregao.diaNum " +
                " where DiaPregao.diaNum > " + diaNumPrevisao + " and ticker = '" + ticker + "' " +
                " order by DiaPregao.diaNum " +
                " limit " + limiteDias;
        let ds = Cotacaodiarioacao.dataSource;
        ds.connector.query(sql,callback);
    }


    Cotacaodiarioacao.LimitesPeriodo = function(ticker,diaInicio,diaFinal,callback) {
        let sql = "select min(minimo) as minimo, max(maximo) as maximo " +
                " from CotacaoDiarioAcao " +
                " where ticker = '" + ticker + "' " +
                " and diaNum >= " + diaInicio +
                " and diaNum < " + diaFinal;
        let ds = Cotacaodiarioacao.dataSource;
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    }

    Cotacaodiarioacao.CotacaoDia = function(ticker, diaNum, callback) {
        let filtro = {'where' : {'and' : [{'ticker':ticker},{'diaNum':diaNum}] }}
        Cotacaodiarioacao.findOne(filtro,callback);
    }

    Cotacaodiarioacao.ListaTickerAteFinal = function(ticker, diaNumInicio, callback) {
        let filtro = {
            'where' : { 'and' : [
                {'ticker' : ticker} , 
                {'diaNum' : {'gte' : diaNumInicio}}
            ]},
            'order' : 'diaNum'
        }
        Cotacaodiarioacao.find(filtro,callback);
    }


    Cotacaodiarioacao.ListaTickerDia = function(listaTicker, diaNum, callback) {
        //let filtro = {'where' : {'and' : [{'ticker':ticker},{'diaNum':diaNum}] }}
        //Cotacaodiarioacao.findOne(filtro,callback);
        console.log('lista:' , listaTicker);
        console.log('tam:', listaTicker.length);
        let itens = "(";
        for (let i=0;i<listaTicker.length;i++) {
            if (i==0) {
                itens += "'" + listaTicker[i].ticker + "'"
            } else {
                itens += " ,'" + listaTicker[i].ticker + "'"
            }
        }
        itens += ")"
        let sql = "select * from CotacaoDiarioAcao " +
            " where ticker in " + itens + " and " +
            " diaNum = " + diaNum;
        let ds = Cotacaodiarioacao.dataSource;
        ds.connector.query(sql,callback);
    }
};

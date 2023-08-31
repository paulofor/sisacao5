'use strict';

module.exports = function(Fechamentoregradiaquantidade) {


    Fechamentoregradiaquantidade.CriaParaFechamentoRegra = function (idFechamentoRegra, callback) {
        var ds = Fechamentoregradiaquantidade.dataSource;
        const sql = "insert into FechamentoRegraDiaQuantidade (diaNum, quantidadeCompra, quantidadeVenda, fechamentoRegraDiaId) " +
                " select diaNum, 0, 0, " + idFechamentoRegra + 
                " from DiaPregao " +
                " where diaNum not in (select diaNum from FechamentoRegraDiaQuantidade where fechamentoRegraDiaId = " + idFechamentoRegra + ") " + 
                " order by diaNum " ;
        console.log('sql: ', sql);
        ds.connector.query(sql,(err,result) => {
            console.log('err', err);
            Fechamentoregradiaquantidade.AtualizaParaFechamentoRegra(idFechamentoRegra,callback);
        });
    }

    Fechamentoregradiaquantidade.AtualizaParaFechamentoRegra = function(idFechamentoRegra, callback) {
        const ds = Fechamentoregradiaquantidade.dataSource;
        const sql = " update FechamentoRegraDiaQuantidade " +
            " set quantidadeCompra = (select count(*) from FechamentoPontoSaida where resultado = 1 and fechamentoRegraDiaId = " + idFechamentoRegra  +" and diaNumSaida = diaNum), " +
            " quantidadeVenda = (select count(*) from FechamentoPontoSaida where resultado = -1 and fechamentoRegraDiaId = " + idFechamentoRegra + " and diaNumSaida = diaNum) " +
            " where fechamentoRegraDiaId = "  + idFechamentoRegra;
        console.log(sql);
        ds.connector.query(sql,(err,result) => {
            console.log('err:' , err);
            callback(err,result);
        });
    }
};

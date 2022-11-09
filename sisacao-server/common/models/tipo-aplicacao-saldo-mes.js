'use strict';

module.exports = function(Tipoaplicacaosaldomes) {


    Tipoaplicacaosaldomes.InsereMes = function(dataReferencia,callback) {
        let sql1 = "update TipoAplicacaoSaldoMes " +
            " set saldoAtual = ( " +
            " select sum(valor) " +
            " from ValorMesInstituicaoTipo " +
            " where dataReferenciaNum = diaNumReferencia and " +
            " TipoAplicacaoSaldoMes.tipoAplicacaoId = ValorMesInstituicaoTipo.tipoAplicacaoId  " +
            " )";
        
        let sql2 = "update TipoAplicacaoSaldoMes " +
            " set saldoAnterior = ( " +
            " select sum(valor) " +
            " from ValorMesInstituicaoTipo " +
            " where dataReferenciaNum = DATE_FORMAT(DATE_SUB(dataReferencia,interval 1 month), '%Y%m') and " +
            " TipoAplicacaoSaldoMes.tipoAplicacaoId = ValorMesInstituicaoTipo.tipoAplicacaoId " +
            " ) ";
        
        let sql3 = " update TipoAplicacaoSaldoMes " +
            " set movimentacaoMes = ( " +
            " select coealesce(sum(valor),0) " +
            " from MovimentacaoValorAplicado " +
            " where month(data) = month(TipoAplicacaoSaldoMes.dataReferencia) " +
            " and year(data) = year(TipoAplicacaoSaldoMes.dataReferencia) " +
            " and TipoAplicacaoSaldoMes.tipoAplicacaoId = MovimentacaoValorAplicado.tipoAplicacaoId " +
            " ) ";

        let sql4 = "update TipoAplicacaoSaldoMes " +
            " set lucroPrejuizoMes = saldoAtual - saldoAnterior - movimentacaoMes ";
        
        let sql5 = " update TipoAplicacaoSaldoMes " +
            " set percentual = 100* ((lucroPrejuizoMes) / saldoAnterior) ";

        let ds = Tipoaplicacaosaldomes.dataSource;
        ds.connector.query(sql1,(err1,result1) => {
            ds.connector.query(sql2, (erro2, result2) => {
                ds.connector.query(sql3, (err3,result3) => {
                    ds.connector.query(sql4, (err4,result4) => {
                        ds.connector.query(sql5,callback);
                    })
                })
            })
        })
        
        
    }
};

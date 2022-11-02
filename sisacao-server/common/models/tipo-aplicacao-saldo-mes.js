'use strict';

module.exports = function(Tipoaplicacaosaldomes) {


    Tipoaplicacaosaldomes.InsereMes = function(dataReferencia,callback) {
        let sql = "update TipoAplicacaoSaldoMes " +
            " set saldoAtual = ( " +
            " select sum(valor) " +
            " from ValorMesInstituicaoTipo " +
            " where dataReferenciaNum = diaNumReferencia and " +
            " TipoAplicacaoSaldoMes.tipoAplicacaoId = ValorMesInstituicaoTipo.tipoAplicacaoId  " +
            " )";
        
    }
};

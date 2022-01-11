'use strict';

module.exports = function(Tipoaplicacao) {



    /**
     * 
     * @param {number} dataRefNum 
     * @param {Function(Error, array)} callback
     */
    Tipoaplicacao.ObtemComSaldoPorPeriodo = function(dataRefNum, callback) {

        let sql = " select tipoAplicacaoId, TipoAplicacao.nome, sum(valor) as total, sum(valorPercentual) as percentualTotal " +
                " from ValorMesInstituicaoTipo " +
                " inner join TipoAplicacao on TipoAplicacao.id = ValorMesInstituicaoTipo.tipoAplicacaoId " +
                " where dataReferenciaNum = " + dataRefNum +
                " group by tipoAplicacaoId " +
                " order by total desc";
        let ds = Tipoaplicacao.dataSource;
        ds.connector.query(sql,callback);
    };
  


    Tipoaplicacao.observe('after save', function updateInicioColeta(ctx, next) {
        let sql = "insert into AplicacaoInstituicao (instituicaoFinanceiraId, tipoAplicacaoId, saldoAtual)  " +
                " select tab.instituicaoFinanceiraId, tab.tipoAplicacaoId, 0 as saldoAtual from " +
                " ( " +
                " select InstituicaoFinanceira.id as instituicaoFinanceiraId, " +
                " TipoAplicacao.id as tipoAplicacaoId " +
                " from InstituicaoFinanceira, TipoAplicacao) tab " +
                " left join AplicacaoInstituicao on tab.instituicaoFinanceiraId = AplicacaoInstituicao.instituicaoFinanceiraId " +
                " and tab.tipoAplicacaoId = AplicacaoInstituicao.tipoAplicacaoId " +
                " where id is null ";
        let ds = Tipoaplicacao.dataSource;
        ds.connector.query(sql,(err,result) => {
            next();
        })
      })
};

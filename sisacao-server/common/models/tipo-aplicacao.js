'use strict';

module.exports = function(Tipoaplicacao) {



    /**
     * 
     * @param {number} dataRefNum 
     * @param {Function(Error, array)} callback
     */
    Tipoaplicacao.ObtemComSaldoPorPeriodo = function(dataRefNum, callback) {

        let sql = " select tipoAplicacaoId, TipoAplicacao.nome, sum(valor) as total, sum(percentualValor) as percentualTotal " +
                " from ValorMesInstituicaoTipo " +
                " inner join TipoAplicacao on TipoAplicacao.id = ValorMesInstituicaoTipo.tipoAplicacaoId " +
                " where dataReferenciaNum = " + dataRefNum +
                " group by tipoAplicacaoId " +
                " order by total desc";
        let ds = Tipoaplicacao.dataSource;
        ds.connector.query(sql,callback);
    };
  

};

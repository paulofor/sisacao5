'use strict';

module.exports = function(Valoraplicado) {


    /**
    * 
    * @param {object} valorAplicado 
    * @param {Function(Error, object)} callback
    */
    Valoraplicado.InsereMovimentacao = function(valorAplicado, callback) {
        Valoraplicado.create(valorAplicado, (err,result) => {
            let sqlAplicacaoInstituicao = "update AplicacaoInstituicao set saldoAtual = saldoAtual + " + valorAplicado.valor + 
                    " where instituicaoFinanceiraId = " + valorAplicado.instituicaoFinanceiraId + 
                    " and tipoAplicacaoId = " + valorAplicado.tipoAplicaoId;
            let sqlTipoAplicacao = "update TipoAplicacao set saldoAtual = saldoAtual + " + valorAplicado.valor + 
                    " where id = " + valorAplicado.tipoAplicaoId;
            console.log(sqlAplicacaoInstituicao);
            console.log(sqlTipoAplicacao);
            let ds = Valoraplicado.dataSource;
            let filtro = {'where' : {'and' : [{} , {}] }}
            ds.connector.query(sqlAplicacaoInstituicao, (err,result1) => {
                ds.connector.query(sqlTipoAplicacao, (err,result2) => {
                    callback(err,result2)
                })
            });
        })
    };
  
    
};

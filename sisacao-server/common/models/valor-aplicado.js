'use strict';

var app = require('../../server/server');

module.exports = function(Valoraplicado) {


    /**
    * 
    * @param {object} valorAplicado 
    * @param {Function(Error, object)} callback
    */
    Valoraplicado.InsereMovimentacao = function(valorAplicado, callback) {
        console.log('valorAplicado1' , valorAplicado);
        delete valorAplicado['id'];
        delete valorAplicado['aplicacaoInstituicaos'];
        Valoraplicado.create(valorAplicado, (err,result) => {
            if (err) {
                callback(err,null);
                return;
            }
            console.log('err' , err);
            console.log('result', result);
            console.log(valorAplicado['tipoAplicacaoId'])
            let sqlAplicacaoInstituicao = "update AplicacaoInstituicao set saldoAtual = saldoAtual + " + valorAplicado.valor + 
                    " where instituicaoFinanceiraId = " + valorAplicado.instituicaoFinanceiraId + 
                    " and tipoAplicacaoId = " + valorAplicado.tipoAplicacaoId;
            let sqlTipoAplicacao = "update TipoAplicacao set saldoAtual = saldoAtual + " + valorAplicado.valor + 
                    " where id = " + valorAplicado.tipoAplicacaoId;
            console.log(sqlAplicacaoInstituicao);
            console.log(sqlTipoAplicacao);
            let ds = Valoraplicado.dataSource;
            let filtro = {'where' : {'and' : [
                            {'instituicaoFinanceiraId' : valorAplicado.instituicaoFinanceiraId} , 
                            {'tipoAplicaoId' : valorAplicado.tipoAplicacaoId }] 
                        }}
            app.models.AplicacaoInstituicao.find(filtro, (err,result) => {
                console.log('result.legnth:' , result.length)
                if (result.length==0) {
                    let novo = {
                        'instituicaoFinanceiraId' : valorAplicado.instituicaoFinanceiraId,
                        'tipoAplicaoId' : valorAplicado.tipoAplicacaoId,
                        'saldoAtual' : valorAplicado.valor 
                    }
                    console.log('novo' , novo);
                    app.models.AplicacaoInstituicao.create(novo, (err,result) => {
                        console.log('erro-create:' , err);
                        console.log('result-create:' , result);
                    })
                } else {
                    ds.connector.query(sqlAplicacaoInstituicao, (err,result1) => {
                    })
                }
            })
            ds.connector.query(sqlTipoAplicacao, (err,result2) => {
                    callback(err,result2)
            })
        })
    };
  
    
};

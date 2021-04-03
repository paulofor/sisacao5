'use strict';

var app = require('../../server/server');

module.exports = function(Execucaosimulacao) {





    /**
    * 
    * @param {number} idExecucao 
    * @param {number} diaNum 
    * @param {number} preco 
    * @param {Function(Error, object)} callback
    */
    Execucaosimulacao.AtualizaMonitoria = function(idExecucao, diaNum, preco, callback) {
        let sql = "update ExecucaoSimulacao set precoEntrada = " + preco +
        ", dataNumEntrada = " + diaNum + " where id = " + idExecucao;
        let ds = Execucaosimulacao.dataSource;
        ds.connector.query(sql,callback);
    };


    /**
     * 
     * @param {array} lista 
     * @param {Function(Error)} callback
     */

    Execucaosimulacao.ListaMonitorar = function(callback) {
        let filtro = { 
                        'where' : { 'monitorar' : '1' },
                        'include' : [
                            {
                            'relation' : 'combinacaoParametro' , 
                            'scope' : {
                                'include' : [
                                    {'relation' : 'regraSimulacao'},
                                    {'relation' : 'valorParametros', 'scope' : {'include' : 'parametroRegra'}}
                                    ] 
                                }
                            },
                            { 'relation' : 'ativoAcao'}
                        ] 
                    }
        Execucaosimulacao.find(filtro,callback);
    };
  
    /**
    * 
    * @param {number} idExecucao 
    * @param {Function(Error, object)} callback
    */
    Execucaosimulacao.ObtemMonitorarPorId = function(idExecucao, callback) {
        let filtro = { 
            'where' : { 'id' : idExecucao },
            'include' : [
                {
                'relation' : 'combinacaoParametro' , 
                'scope' : {
                    'include' : [
                        {'relation' : 'regraSimulacao'},
                        {'relation' : 'valorParametros', 'scope' : {'include' : 'parametroRegra'}}
                        ] 
                    }
                }
            ] 
        }
        Execucaosimulacao.findOne(filtro,callback);
    };
/**
* 
* @param {object} execucao 
* @param {Function(Error, object)} callback
*/
Execucaosimulacao.InsereExecucaoSimulacao = function(execucao, callback) {
    //console.log('Execucao:' , execucao);
    Execucaosimulacao.create(execucao, (err,result) => {
        for (let i=0;i<execucao.trades.length;i++) {
            execucao.trades[i]['execucaoSimulacaoId'] = result.id;
            app.models.Trade.create(execucao.trades[i]);
        };
        callback(err,{'trades' : execucao.trades.length});
    })
};
  

};

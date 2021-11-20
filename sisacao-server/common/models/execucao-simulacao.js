'use strict';

var app = require('../../server/server');

module.exports = function(Execucaosimulacao) {  

    /**
    * Faz todos os procedimentos necessários para a criação de um novo item de monitoria
    * @param {number} idExecucao 
    * @param {Function(Error, object)} callback
    */
    Execucaosimulacao.LigaMonitoria = function(idExecucao, callback) {
        var saida;
        // TODO
        callback(null, saida);
    };
  
    /**
    * Retorna todas as execuções que foram marcadas recentemente para monitoria e não estão com ValorMonitoria ainda.
    * @param {Function(Error, array)} callback
    */
    Execucaosimulacao.ListaNovaMonitoria = function(callback) {
        var listaItem;
        // TODO
        callback(null, listaItem);
    };
  


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
                            { 'relation' : 'ativoAcao'},
                            { 
                                'relation' : 'tradeReals',
                                'scope' : { 'where' : {'posicaoAtual' : '1' } }
                            }
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
    * @param {number} idExecucao 
    * @param {Function(Error, object)} callback -- IGUAL DE CIMA !!!
    */
      Execucaosimulacao.ObtemComRegraParametros = function(idExecucao, callback) {
        let filtro = {
            'where' : {'id' : idExecucao},
            'include' : {'relation' : 'combinacaoParametro' , 'scope' : {
                'include' : ['regraSimulacao' , {'relation' : 'valorParametros' , 'scope' : {'include' : 'parametroRegra'}}]
            }}}
        Execucaosimulacao.findOne(filtro,callback)
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
  


    /**
     * 
     * @param {Function(Error, object)} callback
     */

    Execucaosimulacao.ObtemProximoMonitorar = function (callback) {
        let sql = "select id " +
            " from ExecucaoSimulacao " +
            " where monitorar = 1 " +
            " and id not in (select execucaoSimulacaoId from ValorMonitoria) " +
            " limit 1 ";
        let ds = Execucaosimulacao.dataSource;
        ds.connector.query(sql, (err, result) => {
            if (result.length == 0) {
                callback(err, {})
            } else {
                //callback(err,{});
                Execucaosimulacao.ObtemMonitorarPorId(result[0].id, callback);
            }
        })
    };

    /**
    * 
    * @param {Function(Error, object)} callback
    */
    Execucaosimulacao.CalculaMaximoMedioGeral = function (callback) {
        let sql = "update ExecucaoSimulacao " +
            " set maximoDiaTrade = (select max(quantidadeDia) from Trade where Trade.execucaoSimulacaoId = ExecucaoSimulacao.id), " +
            " mediaDiaTrade = (select avg(quantidadeDia) from Trade where Trade.execucaoSimulacaoId = ExecucaoSimulacao.id) " +
            " where monitorar = 1";
        let ds = Execucaosimulacao.dataSource;
        ds.connector.query(sql, callback);
    };
  

     /**
    * 
    * @param {number} idPeriodo 
    * @param {Function(Error, array)} callback
    */
      Execucaosimulacao.MelhorValidacaoPeriodo = function(idPeriodo, callback) {
        app.models.PeriodoExperimento.findById(idPeriodo, (err,result) => {
            let periodo = result;
            let filtro = {
                'where' : { 'and' : [
                    {'resultado' : { gte : periodo.minimoPontoValidacao }} , 
                    {'periodoExperimentoId' : idPeriodo} ]
                },
                'order' : 'ticker',
                'include' : ['execucaoSimulacaoValidacaos','experimentoSimulacao']
            }
            Execucaosimulacao.find(filtro,callback);
        })
    };


   
  
  
};

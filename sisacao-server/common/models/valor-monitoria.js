'use strict';

var app = require('../../server/server');

module.exports = function(Valormonitoria) {



    /**
    * 
    * @param {number} idExecucao 
    * @param {Function(Error, object)} callback
    */
    Valormonitoria.TrataSituacao = function(idExecucao, callback) {
        var resultado;
        app.models.ExecucaoSimulacao.findById(idExecucao, (err,execucao) => {
            Valormonitoria.ObtemComCotacao(idExecucao, (err,result) => {
                //console.log('Erro1:' + err);
                //console.log('result1:' , result[0].id);
                //console.log('result2:' , JSON.stringify(result[0]));
                let lista = result;
                let comprado = 0;
                let target = 0;
                let stop = 0;
                for (let i=0;i<lista.length;i++) {
                    lista[i].situacao = '';
                    if (comprado==0) {
                        if (lista[i].valorEntrada >= lista[i].minimo && lista[i].valorEntrada <= lista[i].maximo) {
                            lista[i].situacao = 'entrada em ' + lista[i].valorEntrada;
                            comprado = 1;
                            target = lista[i].valorEntrada * (1+execucao.target);
                            stop = lista[i].valorEntrada * (1-execucao.stop);
                        }
                    } else {
                        lista[i].situacao = 'comprado';
                        if (target >= lista[i].minimo && target <= lista[i].maximo) {
                            lista[i].situacao = 'saída target';
                            comprado = 0;
                            target = 0;
                            stop = 0;
                        }
                        if (stop >= lista[i].minimo && stop <= lista[i].maximo) {
                            lista[i].situacao = 'saida stop';
                            comprado = 0;
                            target = 0;
                            stop = 0;
                        }
                    }
                    atualizaDescricao(lista[i].id,lista[i].situacao);
                };
                callback(null, lista);
            })
        })
    };


    function atualizaDescricao(id, descricao) {
        let sql = " update ValorMonitoria set situacao = '" + descricao + "' " +
            "where id = " + id;
        let ds = Valormonitoria.dataSource;
        ds.connector.query(sql, (err, resultado) => {
            //console.log('Erro: ' , err);
        })
    }
  



    /**
    * 
    * @param {number} idExecucao 
    * @param {Function(Error, array)} callback
    */
    Valormonitoria.ObtemComCotacao = function(idExecucao, callback) {
       let ds = Valormonitoria.dataSource;
       let sql = "select ValorMonitoria.* , CotacaoDiarioAcao.abertura, CotacaoDiarioAcao.maximo " +
            " , CotacaoDiarioAcao.minimo, CotacaoDiarioAcao.fechamento " +
            " from ValorMonitoria " +
            " inner join CotacaoDiarioAcao on CotacaoDiarioAcao.ticker = ValorMonitoria.ticker and " +
            " CotacaoDiarioAcao.diaNum = ValorMonitoria.diaNumEntrada " +
            " where execucaoSimulacaoId = " + idExecucao +
            " order by diaNumEntrada asc";
        ds.connector.query(sql, callback);
    };
  

    /**
     * 
     * @param {object} execucao 
     * @param {number} diaNum 
     * @param {number} preco 
     * @param {Function(Error, object)} callback
     */

    Valormonitoria.InsereMonitoria = function(execucao, diaNum, preco, callback) {
        let sql = "update ExecucaoSimulacao set precoEntrada = " + preco +
            ", dataNumEntrada = " + diaNum + " where id = " + execucao.id;
        //console.log(sql);
        //console.log(execucao);
        let ds = Valormonitoria.dataSource;
        ds.connector.query(sql, (err, result) => {
            //console.log('Err: ' , err);
            //console.log('Result: ' , result);
            let novo = {
                'ticker' : execucao.ticker, 
                'valorEntrada' : preco,
                'execucaoSimulacaoId' : execucao.id,
                'diaNumEntrada' : diaNum,
                'situacao' : '' 
             }
             Valormonitoria.create(novo, callback);
        })
        
    };

};

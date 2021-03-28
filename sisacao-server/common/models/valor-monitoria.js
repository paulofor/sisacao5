'use strict';

module.exports = function(Valormonitoria) {


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

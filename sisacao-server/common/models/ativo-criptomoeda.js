'use strict';

module.exports = function(Ativocriptomoeda) {

   /**
    * 
    * @param {Function(Error, object)} callback
    */
    Ativocriptomoeda.AtualizaFoxbit = function(callback) {
        let sql1 = " update AtivoCriptomoeda set foxbit = 0";
        let sql2 = " update AtivoCriptomoeda " +
                " set foxbit = 1 " +
                " where ticker in ( " +
                " select distinct ticker " +
                " from CotacaoIntradayFoxbit " +
                " where date(dataHora) = date(now() - interval 1 day) " +
                " and ticker is not null ) ";
        let sql3 = "insert into AtivoCriptomoeda (ticker, dataInicial, foxbit) " +
                " select distinct ticker, date(now()), 1 " +
                " from CotacaoIntradayFoxbit " +
                " where ticker not in (select ticker from AtivoCriptomoeda) " +
                " and date(dataHora) = date(now() - interval 1 day) "
        let ds = Ativocriptomoeda.dataSource;
        ds.connector.query(sql1, (err,result) => {
            ds.connector.query(sql2, (err,result) => {
                ds.connector.query(sql3, callback)
            });
        })
    };

    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Ativocriptomoeda.ListaMercadoBitcoin = function(callback) {
        let filtro = {
            'where' : {'mercadoBitcoin' : 1}
        }
        Ativocriptomoeda.find(filtro, callback)
    };

    /**
    * 
    * @param {array} lista 
    * @param {Function(Error, object)} callback
    */
     Ativocriptomoeda.InsereSeNaoExisteLista = function(lista, callback) {
        for (let i=0; i<lista.length; i++) {
            console.log(lista[i]);
            Ativocriptomoeda.upsert(lista[i], (err,result) => {
                console.log(result);
            }) 
        }
        callback(null,{'total' : lista.length})
  };
  
};

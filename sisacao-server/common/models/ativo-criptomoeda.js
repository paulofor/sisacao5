'use strict';

module.exports = function(Ativocriptomoeda) {


    /**
    * 
    * @param {Function(Error, array)} callback
    */
    Ativocriptomoeda.ListaMercadoBitcoin = function(callback) {
        let sql = 'select * from AtivoCriptomoeda where posicao >= 50';
        let ds = Ativocriptomoeda.dataSource;
        ds.connector.query(sql,callback); 
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

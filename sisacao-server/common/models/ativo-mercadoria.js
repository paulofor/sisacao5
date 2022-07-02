'use strict';

module.exports = function(Ativomercadoria) {


    Ativomercadoria.ListaColetaIntradayMercadoria = function(callback) {
        let sql = "select * from AtivoMercadoria ";
        let ds = Ativomercadoria.dataSource;
        ds.connector.query(sql,callback);
    }
};

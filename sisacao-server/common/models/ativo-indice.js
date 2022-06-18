'use strict';

module.exports = function(Ativoindice) {

    Ativoindice.ListaNaoBovespa = function(callback) {
        let sql = "select * from AtivoIndice where nome <> 'IBOVESPA'";
        let ds = Ativoindice.dataSource;
        ds.connector.query(sql,callback);
    }


    Ativoindice.ListaColetaIntraday = function(callback) {
        let sql = "select * from AtivoIndice ";
        let ds = Ativoindice.dataSource;
        ds.connector.query(sql,callback);
    }
};

'use strict';

module.exports = function(Exemplotreinoacao) {

    Exemplotreinoacao.InsereExemplo = function(exemplo,callback)  {
        console.log('exemplo: ' , exemplo);
        Exemplotreinoacao.create(exemplo, (err,result) => {
            console.log('Err:' , err);
            console.log('Result:' , result);
            callback(null,exemplo);
        });
    }

    Exemplotreinoacao.ObtemParaTeste = function(callback) {
        let sql = "select campoX, campoY from ExemploTreinoAcao limit 3";
        let ds = Exemplotreinoacao.dataSource;
        ds.connector.query(sql,callback);
    }
};

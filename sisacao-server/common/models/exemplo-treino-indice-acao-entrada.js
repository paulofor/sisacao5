'use strict';

module.exports = function(Exemplotreinoindiceacaoentrada) {


    Exemplotreinoindiceacaoentrada.InsereExemploEntradaIndice = function(exemplo,callback)  {
        //console.log('exemplo-entrada: ' , exemplo);
        Exemplotreinoindiceacaoentrada.create(exemplo, (err,result) => {
            //console.log('Err:' , err);
            //console.log('Result:' , result);
            callback(null,exemplo);
        });
    }

    Exemplotreinoindiceacaoentrada.ListaParaTreinoIndice = function(diaNumInicio,diaNumFinal,idTipoExemplo,callback) {
        let sql = "select diaNumPrevisao, ticker, campoX from ExemploTreinoIndiceAcaoEntrada " +
        " where diaNumPrevisao >= " + diaNumInicio + " and  diaNumPrevisao <=" + diaNumFinal +
        " and ticker = 'ibov' and tipoExemploTreinoId = " + idTipoExemplo
        " order by diaNumPrevisao, ticker";
        let ds = Exemplotreinoindiceacaoentrada.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err,result);
        })
    }
};

'use strict';

module.exports = function(Exemplotreinoacaosaida) {


    Exemplotreinoacaosaida.InsereExemploSaida = function(exemplo,callback)  {
        console.log('exemplo-saida: ' , exemplo);
        Exemplotreinoacaosaida.create(exemplo, (err,result) => {
            console.log('Err:' , err);
            console.log('Result:' , result);
            callback(null,exemplo);
        });
    }

    Exemplotreinoacaosaida.ObtemComEntrada = function(ticker,diaNumPrevisao, regraProjecaoId, callback) {
        let ds = Exemplotreinoacaosaida.dataSource;
        let sql = " select " +
                " saida.ticker, " +
                " regraProjecaoId, " +
                " campoX, " +
                " campoY, " +
                " diaNumInicio, " +
                " saida.diaNumPrevisao, " +
                " diaNumSaida, " +
                " valorSaida, " +
                " valorReferencia, " +
                " valorEntrada, " +
                " limiteSuperior, " +
                " limiteInferior, " +
                " resultado, " +
                " campoXOriginal " +
                " from  " +
                " ExemploTreinoAcaoSaida saida " +
                " inner join  " +
                " ExemploTreinoAcaoEntrada entrada on (saida.ticker = entrada.ticker and saida.diaNumPrevisao = entrada.diaNumPrevisao)  " +
                " where  " +
                " saida.ticker = '" + ticker +"' and  " +
                " saida.regraProjecaoId = " + regraProjecaoId + " and  " +
                " saida.diaNumPrevisao = " + diaNumPrevisao;
        ds.connector.query(sql,callback);
    } 
};

'use strict';

module.exports = function(Exemplotreinoacaosaida) {



    /*
select *, (100*(qtdeSaida/qtdeEntrada)) as percentual,
(select count(*) from ExemploTreinoAcaoSaida saida 
where saida.regraProjecaoId = tab.regraProjecaoId
and saida.campoY=0) as classe0,
(select count(*) from ExemploTreinoAcaoSaida saida 
where saida.regraProjecaoId = tab.regraProjecaoId
and saida.campoY=1) as classe1  
from
(
select regraProjecaoId , codigoRegraProjecao, count(*) as qtdeSaida,
(select count(*) from ExemploTreinoAcaoEntrada) as qtdeEntrada
from ExemploTreinoAcaoSaida
inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcaoSaida.regraProjecaoId
group by regraProjecaoId, codigoRegraProjecao
) as tab
    */
    Exemplotreinoacaosaida.ResumoPorRegra = function(callback) {
        let sql = " select *, (100*(qtdeSaida/qtdeEntrada)) as percentual, " +
            " (select count(*) from ExemploTreinoAcaoSaida saida  " +
            " where saida.regraProjecaoId = tab.regraProjecaoId " +
            " and saida.campoY=0) as classe0, " +
            " (select count(*) from ExemploTreinoAcaoSaida saida " + 
            " where saida.regraProjecaoId = tab.regraProjecaoId " +
            " and saida.campoY=1) as classe1  " +
            " from " +
            " ( " +
            " select regraProjecaoId , codigoRegraProjecao, count(*) as qtdeSaida, " +
            " (select count(*) from ExemploTreinoAcaoEntrada) as qtdeEntrada " +
            " from ExemploTreinoAcaoSaida " +
            " inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcaoSaida.regraProjecaoId " +
            " group by regraProjecaoId, codigoRegraProjecao " +
            " ) as tab";
        let ds = Exemplotreinoacaosaida.dataSource;
        ds.connector.query(sql,callback);
    }



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

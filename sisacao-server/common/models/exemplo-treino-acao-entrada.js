'use strict';

module.exports = function(Exemplotreinoacaoentrada) {


    Exemplotreinoacaoentrada.InsereExemploEntrada = function(exemplo,callback)  {
        console.log('exemplo-entrada: ' , exemplo);
        Exemplotreinoacaoentrada.create(exemplo, (err,result) => {
            console.log('Err:' , err);
            console.log('Result:' , result);
            callback(null,exemplo);
        });
    }


    /*
select 
*
from
(
select 
ent.*,
sai.ticker as tickerSaida
from 
ExemploTreinoAcaoEntrada ent
left outer join ExemploTreinoAcaoSaida sai on 
(ent.ticker = sai.ticker and ent.diaNumPrevisao = sai.diaNumPrevisao)
where
ent.ticker = 'AZUL4' and
ent.qtdeDias = 120 and
ent.posicaoReferencia = 0 and
(sai.regraProjecaoId = 2 or sai.regraProjecaoId is null)
order by ent.diaNumPrevisao
) as tab
where tab.tickerSaida is null

    */



    Exemplotreinoacaoentrada.ListaSemResultado = function(ticker,regraId,qtdeDias,posicaoReferencia) {
        let sql = " select * from " +
            " ( " +
            " select " + 
            " ent.*, " +
            " sai.ticker as tickerSaida " +
            " from " +
            " ExemploTreinoAcaoEntrada ent " +
            " left outer join ExemploTreinoAcaoSaida sai on " +
            " (ent.ticker = sai.ticker and ent.diaNumPrevisao = sai.diaNumPrevisao) " +
            " where " +
            " ent.ticker = '" + ticker + "' and " +
            " ent.qtdeDias = " + qtdeDias + " and " +
            " ent.posicaoReferencia = " + posicaoReferencia + " and " +
            " (sai.regraProjecaoId = " + regraId + " or sai.regraProjecaoId is null) " +
            " order by ent.diaNumPrevisao " +
            " ) as tab " +
            " where tab.tickerSaida is null";
        let ds = Exemplotreinoacaoentrada.dataSource;
        ds.connector.query(sql,callback);
    }
};

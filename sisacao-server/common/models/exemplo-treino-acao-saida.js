'use strict';


var app = require('../../server/server');

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
            " and saida.campoY=1) as classe1,  " +
            " (select count(*) from ExemploTreinoAcaoSaida saida  " +
            " where saida.regraProjecaoId = tab.regraProjecaoId " +
            " and saida.resultado<>0) as resultado " +
            " from " +
            " ( " +
            " select regraProjecaoId , codigoRegraProjecao, percentualEntradaDataset,  count(*) as qtdeSaida, " +
            " (select count(*) from ExemploTreinoAcaoEntrada) as qtdeEntrada " +
            " from ExemploTreinoAcaoSaida " +
            " inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcaoSaida.regraProjecaoId " +
            " group by regraProjecaoId, codigoRegraProjecao, percentualEntradaDataset " +
            " ) as tab";
        let ds = Exemplotreinoacaosaida.dataSource;
        ds.connector.query(sql,callback);
    }

/*
select campoX, campoX
from ExemploTreinoAcaoSaida saida
inner join ExemploTreinoAcaoEntrada entrada 
on entrada.diaNumPrevisao = saida.diaNumPrevisao and entrada.ticker = saida.ticker
inner join RelGrupoAcao on RelGrupoAcao.ticker = saida.ticker 
where entrada.diaNumPrevisao >= 20220101 and 
entrada.diaNumPrevisao <= 20220131 and
saida.regraProjecaoId = 30 and
entrada.qtdeDias = 120 and
entrada.posicaoReferencia = 0 and
RelGrupoAcao.grupoAcaoId  = 12
*/

    Exemplotreinoacaosaida.ListaParaTreino = function(diaNumInicio,diaNumFinal,idGrupoAcao,idRegraProjecao,idTipoExemplo, callback) {
        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            console.log(tipo);
            let sql = "select campoX, campoY " +
                " from ExemploTreinoAcaoSaida saida " +
                " inner join ExemploTreinoAcaoEntrada entrada " +
                " on entrada.diaNumPrevisao = saida.diaNumPrevisao and entrada.ticker = saida.ticker " +
                " inner join RelGrupoAcao on RelGrupoAcao.ticker = saida.ticker " +
                " where entrada.diaNumPrevisao >= " + diaNumInicio + " and " + 
                " entrada.diaNumPrevisao <= " + diaNumFinal + " and " +
                " saida.regraProjecaoId = " + idRegraProjecao + " and " +
                " entrada.qtdeDias = " +  tipo.qtdeDias + " and " +
                " entrada.posicaoReferencia = " + tipo.posicaoReferencia + " and " +
                " RelGrupoAcao.grupoAcaoId  = " + idGrupoAcao
            console.log(sql)
            let ds = Exemplotreinoacaosaida.dataSource;
            ds.connector.query(sql,callback);
        })
    }

    Exemplotreinoacaosaida.ObtemPorDia = function(diaNum,idGrupoAcao,idRegraProjecao,idTipoExemplo, callback) {
        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            console.log(tipo);
            let sql = "select campoX, campoY, entrada.ticker, entrada.diaNumPrevisao, resultado, valorSaida, diaNumSaida " +
                " from ExemploTreinoAcaoSaida saida " +
                " inner join ExemploTreinoAcaoEntrada entrada " +
                " on entrada.diaNumPrevisao = saida.diaNumPrevisao and entrada.ticker = saida.ticker " +
                " inner join RelGrupoAcao on RelGrupoAcao.ticker = saida.ticker " +
                " where entrada.diaNumPrevisao = " + diaNum + " and " + 
                " saida.regraProjecaoId = " + idRegraProjecao + " and " +
                " entrada.qtdeDias = " +  tipo.qtdeDias + " and " +
                " RelGrupoAcao.grupoAcaoId  = " + idGrupoAcao
            console.log(sql)
            let ds = Exemplotreinoacaosaida.dataSource;
            ds.connector.query(sql,callback);
        })
    }

    Exemplotreinoacaosaida.ListaParaAnalise = function(diaNumInicio,diaNumFinal,idGrupoAcao,idRegraProjecao,idTipoExemplo, 
                                                    quantidade, classeSaida, callback) {
        app.models.TipoExemploTreino.findById(idTipoExemplo, (err,tipo) => {
            console.log(tipo);
            let sql = "select campoX, campoY " +
                " from ExemploTreinoAcaoSaida saida " +
                " inner join ExemploTreinoAcaoEntrada entrada " +
                " on entrada.diaNumPrevisao = saida.diaNumPrevisao and entrada.ticker = saida.ticker " +
                " inner join RelGrupoAcao on RelGrupoAcao.ticker = saida.ticker " +
                " where entrada.diaNumPrevisao >= " + diaNumInicio + " and " + 
                " entrada.diaNumPrevisao <= " + diaNumFinal + " and " +
                " saida.regraProjecaoId = " + idRegraProjecao + " and " +
                " entrada.qtdeDias = " +  tipo.qtdeDias + " and " +
                " entrada.posicaoReferencia = " + tipo.posicaoReferencia + " and " +
                " RelGrupoAcao.grupoAcaoId  = " + idGrupoAcao + " and " +
                " campoY = " + classeSaida + 
                " limit " + quantidade;
            console.log(sql)
            let ds = Exemplotreinoacaosaida.dataSource;
            ds.connector.query(sql,callback);
        })
    }

    Exemplotreinoacaosaida.ListaParaExperiencia = function(diaNumInicio,diaNumFinal,idGrupoAcao,idRegraProjecao,idTipoExemplo, callback) {
      let linha1 = {'campoX' : '1, 1.2, 1.3, 1.4' , 'campoY' : 1 }
      let linha2 = {'campoX' : '1, .9, .75, .6' , 'campoY' : 0 }
      //let linha3 = {'campoX' : '1, .98, .88, .86' , 'campoY' : 0 }
      let linha3 = {'campoX' : '1, 1.15, 1.13, 1.86' , 'campoY' : 1 }
      //let linha4 = {'campoX' : '1, 1, 0.97, .85' , 'campoY' : 0 }
      let linha4 = {'campoX' : '1, 1.2, 1.5, 1.85' , 'campoY' : 1 }
      let linha5 = {'campoX' : '1, 1.15, 1.14, 1.2' , 'campoY' : 1 }
      let linha6 = {'campoX' : '1, 0.8, 0.97, .7' , 'campoY' : 0 }
      let linha7 = {'campoX' : '1, 0.9, 0.5, .6' , 'campoY' : 0 }
      let linha8 = {'campoX' : '1, 1.1, 0.9, .85' , 'campoY' : 0 }
      //let linha9 = {'campoX' : '1, 0.6, 0.7, .5' , 'campoY' : 0 }
      let linha9 = {'campoX' : '1, 1.04, 1.7, 1.5' , 'campoY' : 1 }
      let linha10 = {'campoX' : '1, 0.89, 0.82, .85' , 'campoY' : 0 }

      /*
      linha1 = {'campoX' : '0, 0.2, 0.3, 0.4' , 'campoY' : 1 }
      linha2 = {'campoX' : ', -0.1, -0.25, -0.4' , 'campoY' : 0 }
      linha3 = {'campoX' : '0, 0.15, 0.13, 0.86' , 'campoY' : 1 }
      linha4 = {'campoX' : '0, 0.2, 0.5, 0.85' , 'campoY' : 1 }
      linha5 = {'campoX' : '0, 0.15, 0.14, 0.2' , 'campoY' : 1 }
      linha6 = {'campoX' : '0, -0.2, -0.03, -0.3' , 'campoY' : 0 }
      linha7 = {'campoX' : '0, -0.1, -0.5, -0.4' , 'campoY' : 0 }
      linha8 = {'campoX' : '0, 0.1, -0.1, -0.15' , 'campoY' : 0 }
      linha9 = {'campoX' : '0, 0.04, 0.7, 0.5' , 'campoY' : 1 }
      linha10 = {'campoX' : '0, -0.11, -0.18, -0.15' , 'campoY' : 0 }
      */


      let saida = [linha1,linha2,linha3,linha4,linha5,linha6,linha7,linha8,linha9,linha10];
      callback(null,saida);
    }

    Exemplotreinoacaosaida.ListaParaExperienciaValidacao = function(diaNumInicio,diaNumFinal,idGrupoAcao,idRegraProjecao,idTipoExemplo, callback) {
        let linha1 = {'campoX' : '1, 1.22, 1.28, 1.45' , 'campoY' : 1 }
        let linha2 = {'campoX' : '1, .8, .75, .77' , 'campoY' : 0 }
        //let linha3 = {'campoX' : '1, .98, .88, .86' , 'campoY' : 0 }
        let linha3 = {'campoX' : '1, 1.11, 1.18, 1.25' , 'campoY' : 1 }
        //let linha4 = {'campoX' : '1, 1, 0.97, .85' , 'campoY' : 0 }
        let linha4 = {'campoX' : '1, 1.3, 1.55, 1.75' , 'campoY' : 1 }
        let linha5 = {'campoX' : '1, 1.13, 1.12, 1.29' , 'campoY' : 1 }
        let linha6 = {'campoX' : '1, 0.8, 0.67, .77' , 'campoY' : 0 }
        let linha7 = {'campoX' : '1, 0.81, 0.68, .55' , 'campoY' : 0 }
        let linha8 = {'campoX' : '1, 1.2, 0.7, .65' , 'campoY' : 0 }
        //let linha9 = {'campoX' : '1, 0.6, 0.7, .5' , 'campoY' : 0 }
        let linha9 = {'campoX' : '1, 1.07, 1.22, 1.4' , 'campoY' : 1 }
        let linha10 = {'campoX' : '1, 0.83, 0.72, .45' , 'campoY' : 0 }
  
        /*
        linha1 = {'campoX' : '0, 0.2, 0.3, 0.4' , 'campoY' : 1 }
        linha2 = {'campoX' : ', -0.1, -0.25, -0.4' , 'campoY' : 0 }
        linha3 = {'campoX' : '0, 0.15, 0.13, 0.86' , 'campoY' : 1 }
        linha4 = {'campoX' : '0, 0.2, 0.5, 0.85' , 'campoY' : 1 }
        linha5 = {'campoX' : '0, 0.15, 0.14, 0.2' , 'campoY' : 1 }
        linha6 = {'campoX' : '0, -0.2, -0.03, -0.3' , 'campoY' : 0 }
        linha7 = {'campoX' : '0, -0.1, -0.5, -0.4' , 'campoY' : 0 }
        linha8 = {'campoX' : '0, 0.1, -0.1, -0.15' , 'campoY' : 0 }
        linha9 = {'campoX' : '0, 0.04, 0.7, 0.5' , 'campoY' : 1 }
        linha10 = {'campoX' : '0, -0.11, -0.18, -0.15' , 'campoY' : 0 }
        */
  
  
        let saida = [linha1,linha2,linha3,linha4,linha5,linha6,linha7,linha8,linha9,linha10];
        callback(null,saida);
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

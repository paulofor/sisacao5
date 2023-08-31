'use strict';

module.exports = function(Regraprojecao) {


  Regraprojecao.ListaPorGrupoRegra = function(codigoGrupo, callback) {
    let sql = "select RegraProjecao.* " +
        " from RegraProjecao " +
        " inner join GrupoRegraRel on GrupoRegraRel.regraProjecaoId = RegraProjecao.id " +
        " where GrupoRegraRel.grupoRegraId = "  + codigoGrupo +
        " order by RegraProjecao.codigoRegraProjecao ";
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql,callback);
  }

  Regraprojecao.ZerarPrioridadePorGrupo = function(codigoGrupo, callback) {
      let sql = " update RegraProjecao " +
        " inner join GrupoRegraRel on RegraProjecao.id = GrupoRegraRel.regraProjecaoId " +
        " set prioridade = 0 " +
        " where GrupoRegraRel.grupoRegraId = "  + codigoGrupo;
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql,callback);
  }



  Regraprojecao.ZerarPrioridades = function(callback) {
    let sql = "update RegraProjecao set prioridade = 0";
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql,callback);
  }

  Regraprojecao.ConsultaProximoParaProcessamento = function(callback) {
    let sql1 = "SELECT distinct RegraProjecao.* " +
        " FROM RegraProjecao " +
        " inner join GrupoRegraRel on RegraProjecao.id = GrupoRegraRel.regraProjecaoId " +
        " inner join TreinoGrupoRede on TreinoGrupoRede.grupoRegraId = GrupoRegraRel.grupoRegraId " +
        " inner join PeriodoTreinoRede on PeriodoTreinoRede.id = TreinoGrupoRede.periodoTreinoRedeId " +
        //" where (PeriodoTreinoRede.diaNumFinalTeste > DATE_FORMAT(DATE_SUB(ultimaInsercao,interval 2 month),'%Y%m%d') or ultimaInsercao is null) " +
        //" and PeriodoTreinoRede.diaNumFinalTeste <  DATE_FORMAT(DATE_SUB(now(),interval 2 month),'%Y%m%d') " +
        " where (dataHoraAcesso is null or date_add(dataHoraAcesso,interval 20 hour) <= now()) " +
        " order by prioridade desc, id limit 1";
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql1,callback);
  }

  Regraprojecao.ProximoParaProcessamento = function(callback) {
    Regraprojecao.ConsultaProximoParaProcessamento((err,result) => {
      //console.log('err:', err);
      if (result.length>0) {
        let saida = result[0];
        Regraprojecao.AtualizaTotais(saida.id,(err1,result1) => {
          //callback(null,saida);
        });
        callback(null,saida);
      }
    })
  }

  Regraprojecao.AtualizaTotais = function(idRegra, callback) {
    let ds = Regraprojecao.dataSource;
    let sqlHist = "insert into RegraProjecaoHist  " +
      " (regraProjecaoId, dataHoraAcesso, quantidadeTicker,diaNumMaisAntigo,ultimaInsercao, " +
      " exemploQuantidadeSaida,exemploPercentualSaida,exemploQuantidadeClasse0,exemploPercentualClasse0, " +
      " exemploQuantidadeClasse1,exemploPercentualClasse1,exemploQuantidadeResultado,exemploPercentualResultado, " +
      " maiorDataProcessamento,quantidadeValidada,percentualValidado,prioridade, dataHoraAtual) " +
      " select " +
      " id, dataHoraAcesso, quantidadeTicker,diaNumMaisAntigo,ultimaInsercao, " +
      " exemploQuantidadeSaida,exemploPercentualSaida,exemploQuantidadeClasse0,exemploPercentualClasse0, " +
      " exemploQuantidadeClasse1,exemploPercentualClasse1,exemploQuantidadeResultado,exemploPercentualResultado, " +
      " maiorDataProcessamento,quantidadeValidada,percentualValidado,prioridade, now() " +
      " from " +
      " RegraProjecao " +
      " where id = " + idRegra + 
      " order by dataHoraAcesso desc " +
      " limit 1"
    let sql2 = "update RegraProjecao set dataHoraAcesso = now(), " +
               //" maiorDataProcessamento = (select max(diaNumPrevisao) from ExemploTreinoAcaoSaida " +
              //"   where RegraProjecao.id = ExemploTreinoAcaoSaida.regraProjecaoId), " +
              " maiorDataProcessamento = (select (maximo) from " +
              " ( " +
              " select ticker, max(diaNumPrevisao) as maximo " +
              " from ExemploTreinoAcaoSaida " +
              " where regraProjecaoId = " + idRegra +
              " and ticker in (select ticker from AtivoAcao where intraday15 = 1) " +
              " group by ticker " +
              " order by maximo limit 1 " +
              " ) as tab ), " +
              " quantidadeTicker = (select count(distinct ticker) from ExemploTreinoAcaoSaida " +
              "   where RegraProjecao.id = ExemploTreinoAcaoSaida.regraProjecaoId), " +
              " quantidadeValidada = (select count(*) from ExemploTreinoAcaoSaida where validado = 1 and regraProjecaoId = RegraProjecao.id), " +
              " exemploQuantidadeClasse1 = (select count(*) from ExemploTreinoAcaoSaida where campoY = 1 and regraProjecaoId = RegraProjecao.id), " +
              " exemploQuantidadeClasse0 = (select count(*) from ExemploTreinoAcaoSaida where campoY = 0 and regraProjecaoId = RegraProjecao.id), " +
              " exemploQuantidadeResultado = (select count(*) from ExemploTreinoAcaoSaida where resultado <> 0 and regraProjecaoId = RegraProjecao.id), " +
              " exemploQuantidadeSaida = (select count(*) from ExemploTreinoAcaoSaida where regraProjecaoId = RegraProjecao.id) " +
              " where id = " + idRegra; 
    ds.connector.query(sqlHist, (errHist,resultHist) => {
      ds.connector.query(sql2, (err,result) => {
        //console.log('err', err);
        //console.log('result:' , result);
        let sql3 = " update RegraProjecao " +
                " set " + 
                " exemploPercentualClasse1 = (exemploQuantidadeClasse1 / exemploQuantidadeSaida) * 100, " +
                " exemploPercentualClasse0 = (exemploQuantidadeClasse0 / exemploQuantidadeSaida) * 100, " +
                " exemploPercentualResultado = (exemploQuantidadeResultado / exemploQuantidadeSaida) * 100, " +
                " percentualValidado = (quantidadeValidada / exemploQuantidadeSaida) * 100 " +
                " where id = " + idRegra;
            ds.connector.query(sql3,(err3,result3) => {
              callback(null,{})
            });
      })
    })
  }



  Regraprojecao.FinalizaInsercao = function(idRegraProjecao, callback) {
    let sql = " update RegraProjecao set ultimaInsercao = now() where id = " + idRegraProjecao;
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql,(err,result) => {
      Regraprojecao.AtualizaTotais(idRegraProjecao,callback);
    })
  }



  Regraprojecao.EmDataSet = function(callback) {
    let sql = "select * from RegraProjecao " +
      " where id in " +
      " ( " +
      " select distinct regraProjecaoId " +
      " from ExemploTreinoAcao " +
      " ) order by codigoRegraProjecao ";
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql,callback);
  }


/**
 * 
 * @param {number} idRegraProjecao 
 * @param {Function(Error, object)} callback
 */

 Regraprojecao.ObtemProcessando = function(callback) {
    let filtro = {
          'where' : {'processando' : 1} ,
          'include' : {'relation' : 'grupoAcao' , 'scope' : {
            'include' : {'relation' : 'relGrupoAcaos' , scope : {
              'include' : 'ativoAcao'
              }
            } 
            } 
          }
        }
    Regraprojecao.findOne(filtro,callback);
 };
  

  /**
  * 
  * @param {number} id 
  * @param {Function(Error, object)} callback
  */
  Regraprojecao.ObtemPorId = function(id, callback) {
    let filtro = { 'where' : {'id' : id } }
    Regraprojecao.findOne(filtro,callback);

  };

  Regraprojecao.TickerPerformance = function(dataNumInicio, dataNumFinal, grupoAcao, codigoRegra, callback) {
    let sql = "select CotacaoIntradayAcaoResultado.ticker, count(*) as ticks, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = 1 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as positivos, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = -1 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as negativos, " +
          " (select count(*) " +
          " from CotacaoIntradayAcaoResultadoValor " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and regraProjecaoId = 1 " +
          " and resultado = 0 " +
          " and CotacaoIntradayAcaoResultadoValor.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " ) as zero " +
          " from CotacaoIntradayAcaoResultado " +
          " inner join RelGrupoAcao on RelGrupoAcao.ticker = CotacaoIntradayAcaoResultado.ticker " +
          " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
          " where diaNum >= " + dataNumInicio + " and diaNum <= " + dataNumFinal + " " +
          " and GrupoAcao.nome = '" + grupoAcao + "' " +
          " group by CotacaoIntradayAcaoResultado.ticker" ;
     let ds = Regraprojecao.dataSource;
     ds.connector.query(sql,callback);
  }

  /**
  * 
  * @param {string} codigo 
  * @param {Function(Error, object)} callback
  */
  Regraprojecao.ObtemPorCodigoRegra = function(codigo, callback) {
    let filtro = { 'where' : {'codigoRegraProjecao' : codigo } }
    Regraprojecao.findOne(filtro,callback);
  };

  /**
 * 
 * @param {number} idRegraProjecao 
 * @param {Function(Error, object)} callback
 */

  Regraprojecao.LigaProcessando = function(idRegraProjecao, callback) {
    let sql1 = 'update RegraProjecao set processando = 0';
    let sql2 = 'update RegraProjecao set processando = 1 where id = ' + idRegraProjecao;
    let ds = Regraprojecao.dataSource;
    ds.connector.query(sql1, (err,result) => {
        if (!err) {
            ds.connector.query(sql2,callback);
        }
    })
  };

  Regraprojecao.AtualizaDadosRegraProjecao = function(callback) {
    // Atualização de RegraProjecaoTotalMes
    let ds = Regraprojecao.dataSource;
    let sqlDelete = "delete from RegraProjecaoTotalMes"; 
    let sqlInsert = " insert into RegraProjecaoTotalMes (anoMesNum, regraProjecaoId, quantidadeLucro, quantidadePrejuizo, quantidade) " +
            " select  C1.anoMesNum,C1.regraProjecaoId," +  
            " (select count(*) from CotacaoIntradayAcaoResultadoValor C2  " +
            " where C1.anoMesNum = C2.anoMesNum  and  C1.regraProjecaoId = C2.regraProjecaoId and resultado=1) as lucro, " +
            " (select count(*) from CotacaoIntradayAcaoResultadoValor C2  " +
            " where C1.anoMesNum = C2.anoMesNum  and  C1.regraProjecaoId = C2.regraProjecaoId and resultado=-1) as prejuizo, " +
            " (select count(*) from CotacaoIntradayAcaoResultadoValor C2  " +
            " where C1.anoMesNum = C2.anoMesNum  and  C1.regraProjecaoId = C2.regraProjecaoId ) as quantidade " +
            " from CotacaoIntradayAcaoResultadoValor C1 " +
            " where C1.diaNum >= 20210701 " +
            " group by C1.anoMesNum,C1.regraProjecaoId";
     
      
      let sql2 = " update RegraProjecao " +
            " set " +
            " diaNumMaisAntigo =  " +
            " ( " +
            " select max(diaNum) from CotacaoIntradayAcaoResultadoValor as C " +
            " where C.regraProjecaoId = RegraProjecao.id " +
            " ), " +
            " quantidadeTicker = " + 
            " ( " +
            " select count(distinct ticker) from CotacaoIntradayAcaoResultadoValor as C " +
            " where C.regraProjecaoId = RegraProjecao.id " +
            " ) ";
      
      ds.connector.query(sqlDelete, (err,resutl) => {
        console.log('err1' , err);
        ds.connector.query(sqlInsert, (err, result) => {
          console.log('err2' , err);
          ds.connector.query(sql2, callback);
        })
      });
  }


};

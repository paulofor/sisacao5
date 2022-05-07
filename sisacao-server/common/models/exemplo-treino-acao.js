'use strict';

var app = require('../../server/server');


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

    Exemplotreinoacao.ObtemPorDia = function(diaNum, codigoGrupoAcao, codigoRegraProjecao, callback) {
        let sql = "select campoX, campoY from ExemploTreinoAcao " +
            " inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcao.regraProjecaoId " +
            " inner join RelGrupoAcao on RelGrupoAcao.ticker = ExemploTreinoAcao.ticker " +
            " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
            " where diaNumPrevisao = " + diaNum + " and " +
            " RegraProjecao.codigoRegraProjecao = '" + codigoRegraProjecao + "' and " +
            " GrupoAcao.nome = '" + codigoGrupoAcao + "' ";
        console.log(sql);
        let ds = Exemplotreinoacao.dataSource;
        ds.connector.query(sql, callback);
    }


    Exemplotreinoacao.ObtemConjuntoTreino = function(idPeriodo, codigoGrupoAcao, codigoRegraProjecao, callback) {
        app.models.PeriodoExperimento.findById(idPeriodo, (err,periodo) => {
            let sql = "select campoX, campoY from ExemploTreinoAcao " +
                " inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcao.regraProjecaoId " +
                " inner join RelGrupoAcao on RelGrupoAcao.ticker = ExemploTreinoAcao.ticker " +
                " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
                " where diaNumPrevisao >= " + periodo.dataNumInicial + " and " +
                " diaNumPrevisao <= " + periodo.dataNumFinal + " and " +
                " RegraProjecao.codigoRegraProjecao = '" + codigoRegraProjecao + "' and " +
                " GrupoAcao.nome = '" +  codigoGrupoAcao + "' ";
            //console.log(sql);
            let ds = Exemplotreinoacao.dataSource;
            ds.connector.query(sql,callback);
        })
    }


    Exemplotreinoacao.ObtemConjuntoDesenvolvimento = function(idPeriodo, codigoGrupoAcao, codigoRegraProjecao, callback) {
        app.models.PeriodoExperimento.findById(idPeriodo, (err,periodo) => {
            let sql = "select campoX, campoY from ExemploTreinoAcao " +
                " inner join RegraProjecao on RegraProjecao.id = ExemploTreinoAcao.regraProjecaoId " +
                " inner join RelGrupoAcao on RelGrupoAcao.ticker = ExemploTreinoAcao.ticker " +
                " inner join GrupoAcao on GrupoAcao.id = RelGrupoAcao.grupoAcaoId " +
                " where diaNumPrevisao >= " + periodo.dataNumInicioValidacao + " and " +
                " diaNumPrevisao <= " + periodo.dataNumFinalValidacao + " and " +
                " RegraProjecao.codigoRegraProjecao = '" + codigoRegraProjecao + "' and " +
                " GrupoAcao.nome = '" +  codigoGrupoAcao + "' ";
            console.log(sql);
            let ds = Exemplotreinoacao.dataSource;
            ds.connector.query(sql,callback);
        })
      
    }
};

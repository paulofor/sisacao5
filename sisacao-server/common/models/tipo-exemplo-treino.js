'use strict';

module.exports = function(Tipoexemplotreino) {


    Tipoexemplotreino.AtualizaDiaNumExemplo = function(idTipoExemplo, callback) {
        let sql = "update TipoExemploTreino set diaNumExemploEntradaInicio = date_format(date_sub(now(),interval 10 day),'%Y%m%d') where id = " + idTipoExemplo;
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }

    Tipoexemplotreino.AtualizaDiaNumExemploAtivo = function(callback) {
        let sql = "update TipoExemploTreino set diaNumExemploEntradaInicio = date_format(date_sub(now(),interval 10 day),'%Y%m%d') where  geraExemplo = 1 ";
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }


    Tipoexemplotreino.ListaGeraExemplo = function(callback) {
        let sql = "select * from TipoExemploTreino where geraExemplo = 1";
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }
    Tipoexemplotreino.ListaGeraExemploIndice = function(callback) {
        let sql = "select * from TipoExemploTreino where geraExemploIndice = 1";
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }


    Tipoexemplotreino.ObtemTotaisPorData = function(idTipoExemploTreino, callback) {
        let sql = "select diaNumPrevisao, count(*) as qtdeExemplo " +
            " from ExemploTreinoAcaoEntrada, TipoExemploTreino " +
            " where TipoExemploTreino.id = " + idTipoExemploTreino +
            " and TipoExemploTreino.qtdeDias = ExemploTreinoAcaoEntrada.qtdeDias " +
            " and TipoExemploTreino.posicaoReferencia = ExemploTreinoAcaoEntrada.posicaoReferencia " +
            " group by diaNumPrevisao " +
            " order by diaNumPrevisao desc";
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }

    Tipoexemplotreino.AtualizaDatas = function(callback) {
        let sql = "update TipoExemploTreino " +
            " set diaNumInicio = ( " +
            " select min(diaNumPrevisao) from ExemploTreinoAcaoEntrada " +
            " where ExemploTreinoAcaoEntrada.qtdeDias = TipoExemploTreino.qtdeDias and " +
            " ExemploTreinoAcaoEntrada.posicaoReferencia = TipoExemploTreino.posicaoReferencia " +
            " ), " +
            " diaNumFinal = ( " +
            " select max(diaNumPrevisao) from ExemploTreinoAcaoEntrada " +
            " where ExemploTreinoAcaoEntrada.qtdeDias = TipoExemploTreino.qtdeDias and " +
            " ExemploTreinoAcaoEntrada.posicaoReferencia = TipoExemploTreino.posicaoReferencia " +
            " ), " +
            " diaNumInicioIndice = ( " +
            " select min(diaNumPrevisao) from ExemploTreinoIndiceAcaoEntrada " +
            " where ExemploTreinoIndiceAcaoEntrada.tipoExemploTreinoId = TipoExemploTreino.id ), " +
            " diaNumFinalIndice = ( " +
            " select max(diaNumPrevisao) from ExemploTreinoIndiceAcaoEntrada " +
            " where ExemploTreinoIndiceAcaoEntrada.tipoExemploTreinoId = TipoExemploTreino.id ) ";
        let ds = Tipoexemplotreino.dataSource;
        ds.connector.query(sql,callback);
    }
};

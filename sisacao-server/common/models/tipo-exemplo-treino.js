'use strict';

module.exports = function(Tipoexemplotreino) {

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
};

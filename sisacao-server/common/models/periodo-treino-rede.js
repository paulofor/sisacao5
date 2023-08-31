'use strict';

module.exports = function(Periodotreinorede) {


    Periodotreinorede.AtualizaQuantidadeDia = function(callback) {
        let sql = "update PeriodoTreinoRede " +
            " set quantidadeDiaTreino =  " +
            " (select count(*) from DiaPregao where DiaPregao.diaNum >= PeriodoTreinoRede.diaNumInicioTreino and DiaPregao.diaNum < PeriodoTreinoRede.diaNumFinalTreino), " +
            " quantidadeDiaTeste = " +
            " (select count(*) from DiaPregao where DiaPregao.diaNum >= PeriodoTreinoRede.diaNumInicioTeste and DiaPregao.diaNum < PeriodoTreinoRede.diaNumFinalTeste) ";
        let ds = Periodotreinorede.dataSource;
        ds.connector.query(sql,callback);        
    }
};

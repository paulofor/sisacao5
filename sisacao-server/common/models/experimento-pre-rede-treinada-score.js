'use strict';

module.exports = function(Experimentopreredetreinadascore) {

    Experimentopreredetreinadascore.RecebePrevisaoPreRedeTreinada = function(ticker, score,experimentoPreRedeTreinadaId, diaNum,callback) {
        let cont=0;
        for (let i=0;i<score.length;i++) {
            let novo = {'ticker' : ticker[i] , 'score' : score[i], 
                        'experimentoPreRedeTreinadaId' : experimentoPreRedeTreinadaId[i] , 'diaNum' : diaNum[i]};
            //console.log(cont, ') ' ,novo);
            Experimentopreredetreinadascore.create(novo);
            if (++cont==score.length) {
                callback(null,{'resultado' : score.length})
            }
        }
    }


    Experimentopreredetreinadascore.ObtemMelhoresPorDia = function(diaNum,experimentoId,callback) {
        const ds =  Experimentopreredetreinadascore.dataSource;
        const sql = "select * from ExperimentoPreRedeTreinadaScore where diaNum = " + diaNum + 
                " and experimentoPreRedeTreinadaId = " + experimentoId + " and score > 0.6 " +
                " order by score desc";
        ds.connector.query(sql,callback);
    }
    Experimentopreredetreinadascore.ObtemAleatoriaBaseadaEmMelhores = function(diaNum,experimentoId,callback) {
        const ds =  Experimentopreredetreinadascore.dataSource;
        const sqlContagem = "select count(*) as limite from ExperimentoPreRedeTreinadaScore where diaNum = " + diaNum + 
            " and experimentoPreRedeTreinadaId = " + experimentoId + " and score > 0.6 ";
        ds.connector.query(sqlContagem,(err,result) => {
            const sql = "select * from ExperimentoPreRedeTreinadaScore where diaNum = " + diaNum + 
                " and experimentoPreRedeTreinadaId = " + experimentoId +
                " order by RAND() limit " + result[0].limite
            console.log(sql);
            ds.connector.query(sql,callback);
        });
    }

    Experimentopreredetreinadascore.AtualizaResultadoTrade = function(resultado, callback) {
        const ds =  Experimentopreredetreinadascore.dataSource;
        const sql = "update ExperimentoPreRedeTreinadaScore set " +
            " valorSaida = " + resultado.valorSaida + ", " +
            " resultado = " + resultado.resultado + " , " +
            " diaNumSaida = " + resultado.diaNumSaida + " , " +
            " valorEntrada = " + resultado.valorEntrada + ", " +
            " resultado = " + resultado.resultado + " , " +
            " diaNumEntrada = " + resultado.diaNumEntrada + "  " +
            " where ticker = '" + resultado.ticker + "' and " +
            " diaNum = " + resultado.diaNum + " and " +
            " experimentoPreRedeTreinadaId = " + resultado.experimentoPreRedeTreinadaId;
        //console.log(sql);
        ds.connector.query(sql,callback);
    }

};

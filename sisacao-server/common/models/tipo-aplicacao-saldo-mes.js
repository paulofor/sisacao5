'use strict';

module.exports = function(Tipoaplicacaosaldomes) {



    Tipoaplicacaosaldomes.CalculaProjecao = function(tipoAplicacaoId, callback) {
        let sql1 = "SELECT * FROM TipoAplicacaoSaldoMes \n " +
            " where tipoAplicacaoId = " + tipoAplicacaoId + " \n" + 
            " and percentualProjetado is not null \n" +
            " and saldoAtual is null \n" +
            " order by diaNumReferencia";
        let ds = Tipoaplicacaosaldomes.dataSource;
        
        ds.connector.query(sql1,(err,result) => {
            for (let i=0; i<result.length; i++) {
                if (i==0) {
                    let sqlUpdate = "update TipoAplicacaoSaldoMes set saldoProjetado = (saldoAnterior*(1+(percentualProjetado/100))) + movimentacaoMes, " +
                    " lucroProjetado = (saldoAnterior*(1+(percentualProjetado/100))) - saldoAnterior " +
                    " where diaNumReferencia = " + result[i].diaNumReferencia;
                    console.log(sqlUpdate);
                    ds.connector.query(sqlUpdate,(err,result) => {
                        console.log('err1' , err);

                    })
                } else {
                    let sqlSaldoAnterior = "select * from TipoAplicacaoSaldoMes where tipoAplicacaoId = " + tipoAplicacaoId + 
                        " and diaNumReferencia = " + result[i-1].diaNumReferencia;
                    ds.connector.query(sqlSaldoAnterior, (err,resultAnt) => {
                        console.log(resultAnt);
                        let sqlUpdate = "update TipoAplicacaoSaldoMes set saldoProjetado = (" + resultAnt[0]['saldoProjetado'] + "*(1+(percentualProjetado/100))), " +
                        " lucroProjetado = (" + resultAnt[0]['saldoProjetado'] + " * (percentualProjetado/100) ) " +
                        " where diaNumReferencia = " + result[i].diaNumReferencia + " and tipoAplicacaoId = " + tipoAplicacaoId;
                        console.log(sqlUpdate);
                        ds.connector.query(sqlUpdate,(err,result) => {
                            console.log('err:' , err);
                        })
                    })
                   
                }
                
            }
        });
        callback(null,{'concluido':'ok'});
        
    }


    Tipoaplicacaosaldomes.InsereMes = function(dataReferencia,callback) {
        let sql1 = "update TipoAplicacaoSaldoMes " +
            " set saldoAtual = ( " +
            " select sum(valor) " +
            " from ValorMesInstituicaoTipo " +
            " where dataReferenciaNum = diaNumReferencia and " +
            " TipoAplicacaoSaldoMes.tipoAplicacaoId = ValorMesInstituicaoTipo.tipoAplicacaoId  " +
            " )";
        
        let sql2 = "update TipoAplicacaoSaldoMes " +
            " set saldoAnterior = ( " +
            " select sum(valor) " +
            " from ValorMesInstituicaoTipo " +
            " where dataReferenciaNum = DATE_FORMAT(DATE_SUB(dataReferencia,interval 1 month), '%Y%m') and " +
            " TipoAplicacaoSaldoMes.tipoAplicacaoId = ValorMesInstituicaoTipo.tipoAplicacaoId " +
            " ) ";
        
        let sql3 = " update TipoAplicacaoSaldoMes " +
            " set movimentacaoMes = ( " +
            " select coalesce(sum(valor),0) " +
            " from MovimentacaoValorAplicado " +
            " where month(data) = month(TipoAplicacaoSaldoMes.dataReferencia) " +
            " and year(data) = year(TipoAplicacaoSaldoMes.dataReferencia) " +
            " and TipoAplicacaoSaldoMes.tipoAplicacaoId = MovimentacaoValorAplicado.tipoAplicacaoId " +
            " ) ";

        let sql4 = "update TipoAplicacaoSaldoMes " +
            " set lucroPrejuizoMes = saldoAtual - saldoAnterior - movimentacaoMes ";
        
        let sql5 = " update TipoAplicacaoSaldoMes " +
            " set percentual = 100* ((lucroPrejuizoMes) / saldoAnterior) ";
        
        let sql6 = "update TipoAplicacao \n " +
            " set saldoAtual = (select (saldoAnterior+movimentacaoMes) from TipoAplicacaoSaldoMes \n " +
            " where TipoAplicacao.id = TipoAplicacaoSaldoMes.tipoAplicacaoId \n " +
            " and TipoAplicacaoSaldoMes.saldoAtual is null and TipoAplicacaoSaldoMes.saldoAnterior is not null) \n "
       

        let ds = Tipoaplicacaosaldomes.dataSource;
        ds.connector.query(sql1,(err1,result1) => {
            console.log('err1', err1);
            ds.connector.query(sql2, (err2, result2) => {
                console.log('err2', err2);
                ds.connector.query(sql3, (err3,result3) => {
                    console.log('err3', err3);
                    ds.connector.query(sql4, (err4,result4) => {
                        console.log('err4', err4);
                        ds.connector.query(sql5,(err5,result5) => {
                            console.log('err5', err5);
                            ds.connector.query(sql6,callback);
                        });
                    })
                })
            })
        })
        
        
    }
};

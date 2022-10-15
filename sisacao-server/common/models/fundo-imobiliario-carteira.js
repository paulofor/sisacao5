'use strict';

module.exports = function(Fundoimobiliariocarteira) {

/*

update FundoImobiliarioCarteira
set 
cotacaoDataReferencia = 
(select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1),
cotacaoAtual =  (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1),
dataCotacaoAtual = (select data from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1),
valorTotalDataReferencia = (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1) * quantidade,
valorTotalAtual = (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1) * quantidade,
valorizacaoAtual = ((select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1)) * quantidade,
percentualValorizacao = ((select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1)) / (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1) * 100,
proventoPercentual = (proventoTotal/valorTotalDataReferencia) * 100,
resultadoMes = proventoTotal + (
((select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao 
where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker
and date(data) < date(dataReferencia)
order by data desc limit 1)) * quantidade
)

*/



    Fundoimobiliariocarteira.AtualizaDiario = function(callback) {
        let ds = Fundoimobiliariocarteira.dataSource;
        let sql = "update FundoImobiliarioCarteira " +
            " set " +
            " cotacaoDataReferencia = " +
            " (select fechamento from CotacaoDiarioAcao " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1), " +
            " cotacaoAtual =  (select fechamento from CotacaoDiarioAcao " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1), " +
            " dataCotacaoAtual = (select data from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1), " +
            " valorTotalDataReferencia = (select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1) * quantidade, " +
            " valorTotalAtual = (select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1) * quantidade, " +
            " valorizacaoAtual = ((select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1)) * quantidade, " +
            " percentualValorizacao = ((select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1)) / (select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1) * 100, " +
            " proventoPercentual = (proventoTotal/valorTotalDataReferencia) * 100, " +
            " resultadoMes = proventoTotal + ( " +
            " ((select fechamento from CotacaoDiarioAcao  " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " order by data desc limit 1) - (select fechamento from CotacaoDiarioAcao " +
            " where FundoImobiliarioCarteira.ticker = CotacaoDiarioAcao.ticker " +
            " and date(data) < date(dataReferencia) " +
            " order by data desc limit 1)) * quantidade " +
            " ) " +
            " where year(dataReferencia) = year(date_sub(now(), interval 3 hour)) " +
            " and month(dataReferencia) = month(date_sub(now(), interval 3 hour)) ";
        let sql2 = "update FundoImobiliarioCarteira " +
            " set saldoMes = valorizacaoAtual + coalesce(proventoTotal,0) , " +
            " percentualSaldoMes = 100* ((valorizacaoAtual + coalesce(proventoTotal,0)) / valorTotalDataReferencia) " +
            " where year(dataReferencia) = year(date_sub(now(), interval 3 hour)) " +
            " and month(dataReferencia) = month(date_sub(now(), interval 3 hour)) ";
        let sqlTotais = "select sum(valorTotalDataReferencia) totalReferencia, sum(valorTotalAtual) totalAtual " +
                " from FundoImobiliarioCarteira " +
                " where year(dataReferencia) = year(date_sub(now(), interval 3 hour)) " +
                " and month(dataReferencia) = month(date_sub(now(), interval 3 hour)) ";
        ds.connector.query(sql,(err1,result1) => {
            console.log(result1);
            ds.connector.query(sql2, (err2, result2) => {
                console.log(result2);
                ds.connector.query(sqlTotais, (err3,resultTotais) => {
                    let sql3 = "update FundoImobiliarioCarteira " +
                        " set percentualValorTotal = 100 * (valorTotalAtual / " + resultTotais[0].totalAtual + " ), " +
                        " percentualValorDataReferencia = 100 * (valorTotalDataReferencia / " + resultTotais[0].totalReferencia + " ) " +
                        " where year(dataReferencia) = year(date_sub(now(), interval 3 hour)) " +
                        " and month(dataReferencia) = month(date_sub(now(), interval 3 hour)) ";
                    console.log(sql3);
                    ds.connector.query(sql3,callback);
                })
            })
        });
    }
};

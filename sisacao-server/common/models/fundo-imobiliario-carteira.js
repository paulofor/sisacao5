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
            " )" ;
        ds.connector.query(sql,callback);
    }
};

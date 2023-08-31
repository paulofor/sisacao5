'use strict';

module.exports = function(Financeiroacaodia) {


    Financeiroacaodia.AtualizaDia = function(callback) {
        let sql = "insert into FinanceiroAcaoDia (lucroMetaMes2, valorMetaMes2, valorFixoDia, instituicaoFinanceiraId, tipoAplicacaoId, valorVariavelDia,stopDia,targetDia,qtdeTradeAbertoCompra,qtdeTradeAbertoVenda,diaNum, " +
            " qtdeDiaFaltandoMes, qtdeDiaCorridoMes) " +
            " select  " +
            " (select lucroProjetado from TipoAplicacaoSaldoMes " +
            " where tipoAplicacaoId = 2 and " +
            " diaNumReferencia = REPLACE(DATE_FORMAT(NOW(), '%Y-%m'), '-', '')) as lucroMetaMes2, " +
            " (select saldoProjetado from TipoAplicacaoSaldoMes " +
            " where tipoAplicacaoId = 2 and " +
            " diaNumReferencia = REPLACE(DATE_FORMAT(NOW(), '%Y-%m'), '-', '')) as valorMetaMes2, " +
            " (select valorAtual from FinanceiroAcaoFixo where instituicaoFinanceiraId = 3 and tipoAplicacaoId = 2 order by dataAlteracao desc limit 1), " +
            " 3 as instituicaoFinanceiraId, " +
            " 2 as tipoAplicacaoId, " +
            " ( " +
            " select sum(lucro) as valor " +
            " from " +
            " ( " +
            " select valorEntrada, valorSaida, posicao, ((valorSaida - valorEntrada) * posicao) as lucro " +
            " from  " +
            " ( " +
            " select (precoEntrada * quantidade) valorEntrada,  " +
            " (precoAtual * quantidade) valorSaida ,  " +
            " case  " +
            " when tipo='C' then 1  " +
            " else -1  " +
            " end as posicao " +
            " from " +
            " ( " +
            " select ticker, precoEntrada, quantidade, tipo,  " +
            " (select valor from CotacaoIntradayAcao " +
            " where CotacaoIntradayAcao.ticker = TradeReal.ticker  " +
            " order by dataHora desc " +
            " limit 1 " +
            " ) precoAtual " +
            " from TradeReal where " + 
            " posicaoAtual <> 0 " +
            " ) as tab  " +
            " ) as tab2 " +
            " ) as tab3 " +
            " ) as valorVariavelDia , " +
            " (select sum(operacaoRisco) from TradeReal where dataSaida is null) as stopDia, " +
            " (select sum(operacaoAlvo) from TradeReal where dataSaida is null) as targetDia, " +
            " (select count(*) from TradeReal where dataSaida is null and tipo='C') as qtdeTradeAbertoCompra, " +
            " (select count(*) from TradeReal where dataSaida is null and tipo='V') as qtdeTradeAbertoVenda, " +
            " diaNum, " +
            " (select count(*) from DiaPregao " +
            " where mes = month(date(now())) and  ano = year(date(now())) " +
            " and data > date(now()) " +
            " ) diaRestante, " +
            " (select count(*) from DiaPregao " +
            " where mes = month(date(now())) and  ano = year(date(now())) " +
            " and data <= date(now()) " +
            " ) diaPassado " +
            " from DiaPregao " +
            " where data = date(now())" 
        //console.log(sql);    
        let sql2 = "update FinanceiroAcaoDia  set valorTotalAtual = valorFixoDia + valorVariavelDia";
        let ds =  Financeiroacaodia.dataSource;
        ds.connector.query(sql,(err,result) => {
            console.log('Resultado:' , err);
            ds.connector.query(sql2,callback);
        });
        
    }
};

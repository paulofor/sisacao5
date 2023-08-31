'use strict';

module.exports = function(Cotacaointradaycoinmarketcap) {
    
    Cotacaointradaycoinmarketcap.RecebeCoinmarketcap = function(lista,callback) {
        let ds = Cotacaointradaycoinmarketcap.dataSource;
        for (let i=0; i<lista.length;i++) {
            let item = lista[i];
            //console.log(item);
            let sql = "insert into CotacaoIntradayCoinmarketcap (ticker,dataHora,diaNum,numMarketPair,circulationSupply,totalSupply,cmcRank,price,volume24h,marketCap,marketCapDominance,fullyDilutedMarketCap) " +
                " values ('" + item.ticker + "' , now() , date_format(now(),'%Y%m%d') , " + item.numMarketPair + " , " + item.circulationSupply + " , " + item.totalSupply + " , " +
                item.cmcRank + " , " + item.price + " , " + item.volume24h + " , " + item.marketCap + " , " +  item.marketCapDominance + " , " + item.fullyDilutedMarketCap + " )";
            ds.connector.query(sql,(err,result) => {
                if (err) console.log('err:' + err);
            })            
        }
        callback(null,{});

    }
};

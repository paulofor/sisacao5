'use strict';

module.exports = function(Tradetreinorede) {

    Tradetreinorede.InsereTrade = function(trade,callback) {
        Tradetreinorede.create(trade,callback);
    }
};

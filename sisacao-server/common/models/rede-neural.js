'use strict';

module.exports = function(Redeneural) {


    Redeneural.ObtemListaTreino = function(callback) {
        Redeneural.find({},callback);
    }
};

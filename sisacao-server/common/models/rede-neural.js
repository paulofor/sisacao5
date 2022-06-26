'use strict';

var app = require('../../server/server');

module.exports = function(Redeneural) {


    Redeneural.ObtemListaTreino = function(callback) {
        Redeneural.find({},callback);
    }

    Redeneural.ListaPrevisaoDia = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let filtro = {
                'include' : 
                [
                    { 
                    'relation' : 'previsaoRedes',
                    'scope' : 
                        {'where' : { 'and' : [ {'valorPrevisao' : {'gt' : 0.25 }} , {'diaNumPrevisao' : result.diaNum }] }, "order" : "valorPrevisao desc" } 
                    },
                ], 
            }
            Redeneural.find(filtro,callback);
        });       
    }

    Redeneural.ListaExecucaoPrevisao = function(callback) {
        Redeneural.find(callback);
    }
};

'use strict';

var app = require('../../server/server');

module.exports = function(Treinorede) {


    Treinorede.ObtemListaParaTreino = function(callback) {
        let filtro = {'include' : ['redeNeural' , 'periodoTreinoRede' , 'tipoExemploTreino']}
        Treinorede.find(filtro,callback);
    } 

    Treinorede.ObtemListaParaPrevisao = function(callback) {
        let filtro = {'where' : {'ativoPrevisao':'1'}}
        Treinorede.find(filtro,callback);
    } 

    Treinorede.ListaPrevisaoDiaTreino = function(callback) {
        app.models.DiaPregao.ObtemProximo((err,result) => {
            let filtro = {
                'where' : {'ativoPrevisao' : 1},
                'include' : 
                [
                    { 
                    'relation' : 'previsaoRedes',
                    'scope' : 
                        {'where' : { 'and' : [ {'valor' : {'gt' : 0.25 }} , {'diaNumPrevisao' : result.diaNum }] }, 
                        "order" : "valorPrevisao desc" , 'limit' : 10} 
                    },
                ], 
            }
            Treinorede.find(filtro,callback);
        });       
    }
}

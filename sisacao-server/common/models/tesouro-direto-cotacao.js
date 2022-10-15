'use strict';


var app = require('../../server/server');


module.exports = function(Tesourodiretocotacao) {



    Tesourodiretocotacao.InsereLista = function(listaItem,callback) {
        listaItem.forEach(cotacao => {
            //console.log(cotacao);
            app.models.TesouroDireto.find({'where' : {'nome' : cotacao.nome} } , (err,result) => {
                console.log(result.length)
                if (result.length==0) {
                    let tesouro = {'nome' : cotacao.nome }
                    app.models.TesouroDireto.create(tesouro, (err,result) => {
                        console.log('err:' , err)
                        console.log('result' , result);
                        cotacao['tesouroDiretoId'] = result.id;
                    })
                } else {
                    cotacao['tesouroDiretoId'] = result[0].id
                }
                //console.log('insert:' + JSON.stringify(cotacao));
                Tesourodiretocotacao.create(cotacao);
            })
        });
        callback(null,{'result' : 'ok'})
    }
};

'use strict';

var app = require('../../server/server');

module.exports = function(Versaoprerede) {

    Versaoprerede.CriaRedeNeural = function(idVersao, callback) {
        let ds = Versaoprerede.dataSource;
        Versaoprerede.findById(idVersao,(err,versao) => {
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err,preRede) => {
                console.log('versao:' , versao);
                console.log('preRede:', preRede);
                let rede = {'estrutura' : versao.estrutura , 
                    'fitTreinamento' : versao.fitTreinamento, 'compilacao' : versao.compilacao ,
                    'tipoExemploTreino1Id' : preRede.tipoExemploTreino1Id, 'tipoExemploTreino2Id' : preRede.tipoExemploTreino2Id, 
                    'nome' : preRede.nome , 'versaoPreRedeId' : versao.id }
                console.log(rede);
                app.models.RedeNeural.create(rede, (err,result) => {
                    console.log('result', result);
                    const sql = "update VersaoPreRede set redeNeuralId = " + result.id + " where id = " + versao.id;
                    ds.connector.query(sql,callback);
                })
            })
        })
    }

    Versaoprerede.GerarRedeRegra = function(idVersao,callback) {
        //console.log('Entrei no gerar' );
        Versaoprerede.findById(idVersao, (err,versao) => {
            //console.log('versao:' , versao);
            app.models.PreRedeNeural.findById(versao.preRedeNeuralId, (err,preRede) => {
                let sql = "delete from VersaoPreRedeRegra where versaoPreRedeId = " + versao.id;
                let ds = Versaoprerede.dataSource;
                ds.connector.query(sql,(err,result) => {
                    //console.log('preRede:' , preRede);
                    let item1 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoVenda1Id};
                    //console.log('item1' , item1);
                    app.models.VersaoPreRedeRegra.create(item1, (err,result) => {
                        //console.log('err1' , err);
                        //console.log('result1', result);
                    });
                    let item2 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoVenda2Id};
                    app.models.VersaoPreRedeRegra.create(item2);
                    let item3 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoVenda3Id};
                    app.models.VersaoPreRedeRegra.create(item3);
                    let item4 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoCompra1Id};
                    app.models.VersaoPreRedeRegra.create(item4);
                    let item5 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoCompra2Id};
                    app.models.VersaoPreRedeRegra.create(item5);
                    let item6 = {'versaoPreRedeId' : versao.id , 'regraProjecaoId' : preRede.regraProjecaoCompra3Id};
                    app.models.VersaoPreRedeRegra.create(item6);
                    callback(null,{});
                });
            })
        })
    }

};

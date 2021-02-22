'use strict';

var app = require('../../server/server');

module.exports = function(Experimentosimulacao) {

    let posicao = 0;
    let listaComb = [];
    
    /**
    * 
    * @param {number} idExperimento 
    * @param {Function(Error, object)} callback
    */
    Experimentosimulacao.GerarCombinacoes = function(idExperimento, callback) {
        let ds = Experimentosimulacao.dataSource;
        let filtro = {
            'where' : { 'experimentoSimulacaoId' : idExperimento }
        }
        app.models.ExperimentoParametro.find(filtro, (err1, parametros) => {
            //console.log('parametros' , parametros);
            //console.log('tamanho:' , parametros.length);
            let sqlLimpeza = "delete from CombinacaoParametro where experimentoSimulacaoId = " + idExperimento;
            ds.connector.query(sqlLimpeza, (err,result) => {
                let valor = new Array();
                let ids = new Array();
                for (let i=0;i<parametros.length;i++) {
                    valor.push(parametros[i].inicial);
                    ids.push(parametros[i].parametroRegraId);
                }
                posicao = 0;
                trataItem(valor,parametros,ids, idExperimento, 0);
                //console.log(JSON.stringify(listaComb));
                let sqlQuantidade = "update ExperimentoSimulacao set quantidadeCombinacao = " + listaComb.length + 
                        " where id = " + idExperimento;
                ds.connector.query(sqlQuantidade, (err,result) => {

                })
                salvaCombinacao(listaComb);
                var saida = {'quantidade' : listaComb.length};
                callback(null, saida);
            })

        })
        
       
    };
  
    function trataItem(valor,parametros,ids,idExperimento, ind) {
        while (valor[ind] <= parametros[ind].final) {
            if ((ind+1)<valor.length) {
                trataItem(valor,parametros,ids, idExperimento, ind + 1)
            } else {
                posicao++;
                //console.log(posicao, ' - ' , valor, ' ' , ids);
                //salvaCombinacao(idExperimento, posicao, ids, valor);
                let combinacao = {'posicaoCombinacao' : posicao, 'experimentoSimulacaoId' : idExperimento, 'valorParametros' : []};
                for (let i=0; i<ids.length; i++) {
                    let valorParametro = {'parametroRegraId' : ids[i], 'valorParametro' : valor[i]}
                    combinacao.valorParametros.push(valorParametro);
                }
                listaComb.push(combinacao);
            }
            valor[ind]+= parametros[ind].passo;
            
        }
        valor[ind] = parametros[ind].inicial;
    }

    function salvaCombinacao(listaComb) {
        listaComb.forEach(combinacao => {
            app.models.CombinacaoParametro.create(combinacao , (err,result) => {
                combinacao.valorParametros.forEach(valor => {
                    valor['combinacaoParametroId'] = result.id;
                    app.models.ValorParametro.create(valor, (err,result) => {

                    })
                })
            })
        })
    }
        /*
        for (let i=0;i<combinacao.length;i++) {
        app.models.CombinacaoParametro.create(combinacao, (err,result) => {
            if (result.id) {
                for (let i=0; i<ids.length; i++) {
                    app.models.ValorParametro.create(valorParametro, (err,result) => {
                        //console.log('inseriu: ' , result );
                    })
                }
            }
        })
        */
    



    Experimentosimulacao.observe('after save', function updateTimestamp(ctx, next) {

        let ds = Experimentosimulacao.dataSource;
        let sqlCria = '';
        let sqlLimpa = '';

        if (ctx.instance) {
        //    ctx.instance.dataHora = new Date();
            //console.log('ctx.instance: ' , JSON.stringify(ctx.instance))
            sqlLimpa = " delete from ExperimentoParametro where experimentoSimulacaoId = " + ctx.instance.id
            sqlCria =   "insert into ExperimentoParametro (parametroRegraId, experimentoSimulacaoId) " +
                            "select id, " + ctx.instance.id + " from ParametroRegra where regraSimulacaoId = " + ctx.instance.regraSimulacaoId;
            //console.log('instancia');
            
        } else {
        //    ctx.data.dataHora = new Date();
            sqlLimpa = " delete from ExperimentoParametro where experimentoSimulacaoId = " + ctx.data.id
            sqlCria =   "insert into ExperimentoParametro (parametroRegraId, experimentoSimulacaoId) " +
                        "select id, " + ctx.data.id + " from ParametroRegra where regraSimulacaoId = " + ctx.data.regraSimulacaoId;
            //console.log('nao instancia');
        }
        //console.log('limpa:' , sqlLimpa);
        //console.log('cria:' , sqlCria);
        ds.connector.query(sqlLimpa, (err,result) => {
            ds.connector.query(sqlCria, (err,result) => {
                next();
            })
        });
    });


};

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
    Experimentosimulacao.ColocaEmExecucao = function(idExperimento, callback) {
        let sql1 = "update ExperimentoSimulacao set emExecucao = 0 ";
        let sql2 = "update ExperimentoSimulacao set emExecucao = 1 where id = " + idExperimento;
        let ds = Experimentosimulacao.dataSource;
        ds.connector.query(sql1, (err1,result1) => {
            ds.connector.query(sql2, callback);
        })
    };
  
  

    /**
    * 
    * @param {number} idExperimento 
    * @param {number} idPeriodo 
    * @param {Function(Error, object)} callback
    */
    Experimentosimulacao.InicioExecucao = function(idExperimento, idPeriodo, callback) {
        let sql = "update ExperimentoSimulacao set permiteEdicao = 0 " +
            " where id = " + idExperimento;
        let ds = Experimentosimulacao.dataSource;
        ds.connector.query(sql, (err,result) => {
            callback(err,result);
        })
    };
    
    /**
    * 
    * @param {number} idExperimento 
    * @param {Function(Error, object)} callback
    */
   Experimentosimulacao.FechaExperimento = function(idExperimento, callback) {
        let sql1 = "update ExperimentoSimulacao set dataExecucao = now() where id = " + idExperimento;
        let sql2 = "update CombinacaoParametro " +
            " set regraSimulacaoId = " +
            " (select regraSimulacaoId from ExperimentoSimulacao where ExperimentoSimulacao.id = CombinacaoParametro.experimentoSimulacaoId) " +
            " where experimentoSimulacaoId = " + idExperimento;

        let ds = Experimentosimulacao.dataSource;
        ds.connector.query(sql1, (err1,result1)=> {
            
        });
        
        ds.connector.query(sql2, callback);
        //callback(null,"{ 'resultado' : 'executando'}");
    };

    /**
     * 
     * @param {number} idExperimento 
     * @param {number} inicioBloco 
     * @param {string} finalBloco 
     * @param {Function(Error, object)} callback
     */

    Experimentosimulacao.GerarCombinacoesBloco =  function(idExperimento, inicioBloco, finalBloco, callback) {
        listaComb = [];
        let ds = Experimentosimulacao.dataSource;
        let filtro = {
            'where' : { 'experimentoSimulacaoId' : idExperimento },
            'order' : 'parametroRegraId'

        }
        Experimentosimulacao.findOne({'where' : {'id' : idExperimento} }, (err,experimento) => {
            app.models.ExperimentoParametro.find(filtro, (err1, parametros) => {
                console.log('Erro1: ' , err1);
                if (inicioBloco==1) {
                    let sqlLimpeza = "delete from CombinacaoParametro where experimentoSimulacaoId = " + idExperimento;
                    ds.connector.query(sqlLimpeza, (err,result) => {
                        let valor = new Array();
                        let ids = new Array();
                        for (let i=0;i<parametros.length;i++) {
                            valor.push(parametros[i].inicial);
                            ids.push(parametros[i].parametroRegraId);
                        }
                        posicao = 0;
                        trataItem(valor,parametros,ids, idExperimento, 0, experimento.regraSimulacaoId);
                        let sqlQuantidade = "update ExperimentoSimulacao set quantidadeCombinacao = " + listaComb.length + 
                                " where id = " + idExperimento;
                        ds.connector.query(sqlQuantidade, (err,result) => {
    
                        })
                        //salvaCombinacao(listaComb, inicioBloco, finalBloco);
                        for (let i=(inicioBloco-1);i<listaComb.length && i<finalBloco;i++) {
                            salvaCombinacaoUnica(listaComb[i]);
                        }
                        var saida = {'quantidade' : listaComb.length};
                        callback(null, saida);
                    })
                } else {
                    let valor = new Array();
                    let ids = new Array();
                    for (let i=0;i<parametros.length;i++) {
                        valor.push(parametros[i].inicial);
                        ids.push(parametros[i].parametroRegraId);
                    }
                    posicao = 0;
                    trataItem(valor,parametros,ids, idExperimento, 0, experimento.regraSimulacaoId);
                    salvaCombinacao(listaComb, inicioBloco, finalBloco);
                    var saida = {'quantidade' : listaComb.length};
                    callback(null, saida);
                }

            })
        })
    };


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
        Experimentosimulacao.findOne({'where' : {'id' : idExperimento} }, (err,experimento) => {
            app.models.ExperimentoParametro.find(filtro, (err1, parametros) => {
                let sqlLimpeza = "delete from CombinacaoParametro where experimentoSimulacaoId = " + idExperimento;
                ds.connector.query(sqlLimpeza, (err,result) => {
                    let valor = new Array();
                    let ids = new Array();
                    for (let i=0;i<parametros.length;i++) {
                        valor.push(parametros[i].inicial);
                        ids.push(parametros[i].parametroRegraId);
                    }
                    posicao = 0;
                    trataItem(valor,parametros,ids, idExperimento, 0, experimento.regraSimulacaoId);
                    //console.log(JSON.stringify(listaComb));
                    let sqlQuantidade = "update ExperimentoSimulacao set quantidadeCombinacao = " + listaComb.length + 
                            " where id = " + idExperimento;
                    ds.connector.query(sqlQuantidade, (err,result) => {

                    })
                    salvaCombinacao(listaComb,1, listaComb.length);
                    var saida = {'quantidade' : listaComb.length};
                    callback(null, saida);
                })
            })
        })
        
    };



  
    function trataItem(valor,parametros,ids,idExperimento, ind, idRegra) {
        while (valor[ind] <= parametros[ind].final) {
            if ((ind+1)<valor.length) {
                trataItem(valor,parametros,ids, idExperimento, ind + 1, idRegra)
            } else {
                posicao++;
                //console.log(posicao, ' - ' , valor, ' ' , ids);
                //salvaCombinacao(idExperimento, posicao, ids, valor);
                let combinacao = {'posicaoCombinacao' : posicao, 'experimentoSimulacaoId' : idExperimento, 'valorParametros' : [], 'regraSimulacaoId' : idRegra};
                for (let i=0; i<ids.length; i++) {
                    let valorParametro = {'parametroRegraId' : ids[i], 'valorParametro' : valor[i] , 'experimentoSimulacaoId' : idExperimento}
                    combinacao.valorParametros.push(valorParametro);
                }
                listaComb.push(combinacao);
            }
            valor[ind]+= parametros[ind].passo;
            
        }
        valor[ind] = parametros[ind].inicial;
    }

    function salvaCombinacao2(listaComb) {
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
    function salvaCombinacao(listaComb, inicioBloco, finalBloco) {
        let conta = 0;
        for (let i=(inicioBloco-1);i<listaComb.length && i<finalBloco;i++) {
            app.models.CombinacaoParametro.create(listaComb[i] , (err,result) => {
                for (let x=0;x<listaComb[i].valorParametros.length;x++) {
                    let valor = listaComb[i].valorParametros[x];
                    valor['combinacaoParametroId'] = result.id;
                    conta = 0;
                    app.models.ValorParametro.create(valor, (err,result) => {
                        //conta++;
                        //if (conta==listaComb[i].valorParametros.length) {
                        //    listaComb[i]=null;
                        //}
                    })
                };
            })
        }
    }


    function salvaCombinacaoUnica(combinacao) {
        app.models.CombinacaoParametro.create(combinacao , (err,result) => {
            for (let x=0;x<combinacao.valorParametros.length;x++) {
                let valor = combinacao.valorParametros[x];
                valor['combinacaoParametroId'] = result.id;
                //conta = 0;
                app.models.ValorParametro.create(valor, (err,result) => {
                    //conta++;
                    //if (conta==listaComb[i].valorParametros.length) {
                    //    listaComb[i]=null;
                    //}
                })
            };
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
        let sqlConsulta = '';

        if (ctx.instance) {
        //    ctx.instance.dataHora = new Date();
            //console.log('ctx.instance: ' , JSON.stringify(ctx.instance))
            sqlLimpa = " delete from ExperimentoParametro where experimentoSimulacaoId = " + ctx.instance.id
            sqlCria =   "insert into ExperimentoParametro (parametroRegraId, experimentoSimulacaoId) " +
                            "select id, " + ctx.instance.id + " from ParametroRegra where regraSimulacaoId = " + ctx.instance.regraSimulacaoId;
            sqlConsulta = " select * from ExperimentoParametro where experimentoSimulacaoId = " + ctx.instance.id;
            //console.log('instancia');
            
        } else {
        //    ctx.data.dataHora = new Date();
            sqlLimpa = " delete from ExperimentoParametro where experimentoSimulacaoId = " + ctx.data.id
            sqlCria =   "insert into ExperimentoParametro (parametroRegraId, experimentoSimulacaoId) " +
                        "select id, " + ctx.data.id + " from ParametroRegra where regraSimulacaoId = " + ctx.data.regraSimulacaoId;
            sqlConsulta = " select * from ExperimentoParametro where experimentoSimulacaoId = " +  ctx.data.id;
            //console.log('nao instancia');
        }
        //console.log('limpa:' , sqlLimpa);
        //console.log('cria:' , sqlCria);
        ds.connector.query(sqlConsulta, (err,result) => {
            //console.log('sql', sqlConsulta);
            //console.log('result' , result);
            //console.log('tamanho' , result.length);
            if (result.length==0) {
                ds.connector.query(sqlLimpa, (err,result) => {
                    ds.connector.query(sqlCria, (err,result) => {
                        next();
                    })
                });
            } else {
                next();
            }
        })
        
    });




    /**
    * 
    * @param {number} idExperimento 
    * @param {Function(Error, object)} callback
    */

    Experimentosimulacao.CarregaParaSimulacao = function(idExperimento, callback) {
        let filtro = { 
            'where' : {'id' : idExperimento},
            'include' : [
                { 'relation' : 'regraSimulacao' , 'scope' : {'include' : 'parametroRegras'} },
                { 'relation' : 'experimentoSimulacaoPeriodos' , 
                                'scope' : {
                                        'include':'periodoExperimento',
                                        'where' : {'concluido' : 0 }
 
                                }
                }
            ]
            
        }
        Experimentosimulacao.findOne(filtro, callback);
    };

    /**
    * 
    * @param {Function(Error, object)} callback
    */
    Experimentosimulacao.ObtemParaSimulacao = function(callback) {
        let filtro = { 
            'where' : {'emExecucao' : 1},
            'include' : [
                { 'relation' : 'regraSimulacao' , 'scope' : {'include' : 'parametroRegras'} },
                { 'relation' : 'experimentoSimulacaoPeriodos' , 
                            'scope' : {
                                    'include':'periodoExperimento',
                                    'where' : {'concluido' : 0 }

                            }
            }
        ]

        }
        Experimentosimulacao.findOne(filtro, callback);
    };


    /**
    * 
    * @param {number} id 
    * @param {Function(Error, object, array, number)} callback
    */

    Experimentosimulacao.ObtemExecucao = function (idExperimento, callback) {
        //console.log('idExperimento:' , idExperimento);
        var experimento, melhoresExecucao, combinacaoProcessada, execucaoCriada;
        let filtroExperimento = {
            'where' : {'id' : idExperimento},
            'include' : 'grupoAcao'
        }
        Experimentosimulacao.findOne(filtroExperimento, (err,result) => {
            experimento = result;
            let filtro = {
                'order' : ['resultado desc' , 'ticker asc' , 'primeiraEntrada asc'],
                'limit' : 200,
                'include' : [
                    {'relation' : 'combinacaoParametro' , 'scope' : {'include' : 'regraSimulacao'}},
                    {'relation' : 'trades' }
                ],
                'where' : {'experimentoSimulacaoId' : idExperimento}
            }
            app.models.ExecucaoSimulacao.find(filtro, (err,result) => {
                //console.log('Erro:' , err);
                melhoresExecucao = result;
                let sql = "select count(*) as qtde from CombinacaoParametro " +
                    " where experimentoSimulacaoId = " + idExperimento +
                    " and descricao is not null";
                let ds = Experimentosimulacao.dataSource;
                ds.connector.query(sql, (err,result) => {
                    combinacaoProcessada = result[0].qtde;
                    let sql2 = "select count(*) as qtdeExec from ExecucaoSimulacao " +
                    " inner join CombinacaoParametro on CombinacaoParametro.id = ExecucaoSimulacao.combinacaoParametroId " +
                    " where ExecucaoSimulacao.experimentoSimulacaoId = " + idExperimento + 
                    " and descricao is not null ";
                    ds.connector.query(sql2, (err,result2) => {
                        execucaoCriada = result2[0].qtdeExec;
                        callback(null, experimento, melhoresExecucao, combinacaoProcessada, execucaoCriada);
                    })
                })
            })

        })
    };
  
    /**
    * 
    * @param {Function(Error)} callback
    */
    Experimentosimulacao.ProcessaPermiteEdicaoExperimento = function(callback) {
        let sql1 = "update ExperimentoSimulacao " +
                " set permiteEdicao = " +
                " (select count(*) from ExecucaoSimulacao where experimentoSimulacaoId = ExperimentoSimulacao.id)";
        let sql2 = "update ExperimentoSimulacao " +
                " set permiteEdicao = 1 " +
                " where permiteEdicao = 0";
        let sql3 = "update ExperimentoSimulacao " +
                " set permiteEdicao = 0 " +
                " where permiteEdicao > 1";
        let ds = Experimentosimulacao.dataSource;
        ds.connector.query(sql1, (err,result) => {
            ds.connector.query(sql2, (err,result) => {
                ds.connector.query(sql3, callback);
            });
        })
    };
};

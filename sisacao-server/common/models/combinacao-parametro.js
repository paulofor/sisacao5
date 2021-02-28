'use strict';

module.exports = function(Combinacaoparametro) {

/**
 * 
 * @param {number} idExperimento 
 * @param {Function(Error, object)} callback
 */

Combinacaoparametro.GetProximoExecucao = function(idExperimento, callback) {
    var combinacao;
    // TODO
    let filtro = {
        'order' : 'posicaoCombinacao',
        'where' : { 'and' : [{'experimentoSimulacaoId' : idExperimento}, {'dataExecucao' : null} ]},
        'limit' : '1',
        'include' : {'relation' : 'valorParametros' , 'scope' : {'include' : 'parametroRegra'}}
    }
    Combinacaoparametro.findOne(filtro,callback);
  };
  
};

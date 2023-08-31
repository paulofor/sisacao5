'use strict';

module.exports = function(Experimentoprerederesultado) {

    Experimentoprerederesultado.RecebePrevisaoTeste = function(id, score,experimentoId, callback) {
        let cont=0;
        for (let i=0;i<score.length;i++) {
            let novo = {'score' : score[i] , 
                        'exemploDadoSinteticoTesteId' : id[i] , 'experimentoPreRedeId' : experimentoId[i]};
            console.log(cont, ') ' ,novo);
            Experimentoprerederesultado.create(novo);
            if (++cont==score.length) {
                callback(null,{'resultado' : score.length})
            }
        }
    }
};

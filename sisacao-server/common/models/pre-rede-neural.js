'use strict';

module.exports = function(Preredeneural) {

    Preredeneural.ListaParaTreino = function(callback) {
        let filtro = {
            'where' : {'geraScriptTreino' : 1},
            'include' : [
                {'relation' : 'versaoPreRedes', 'scope' : 
                    {'include' : {'relation':'versaoPreRedeRegras', 'scope' : {'include' : 'regraProjecao'}}}
                },
                'tipoExemploTreino1',
                'tipoExemploTreino2',
                'periodoTreinoRede',
                'grupoAcao',
                'regraProjecaoVenda1',
                'regraProjecaoVenda2',
                'regraProjecaoVenda3',
                'regraProjecaoCompra1',
                'regraProjecaoCompra2',
                'regraProjecaoCompra3'
            ]
        }
        Preredeneural.find(filtro,callback);
    }
};

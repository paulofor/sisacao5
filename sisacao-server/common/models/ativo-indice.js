'use strict';

module.exports = function(Ativoindice) {

    Ativoindice.ListaNaoBovespa = function(callback) {
        let sql = "select * from AtivoIndice where nome <> 'IBOVESPA'";
        let ds = Ativoindice.dataSource;
        ds.connector.query(sql,callback);
    }

    Ativoindice.ListaBovespa = function(callback) {
        let sql = "select * from AtivoIndice where nome = 'IBOVESPA'";
        let ds = Ativoindice.dataSource;
        ds.connector.query(sql,callback);
    }


    Ativoindice.ListaColetaIntradayIndice = function(callback) {
        let sql = "select * from AtivoIndice ";
        let ds = Ativoindice.dataSource;
        ds.connector.query(sql,callback);
    }

    Ativoindice.ListaIndiceResultadoMaisRecente = function(callback) {
        let filtro = {
            'where' : {'nome' : 'IBOVESPA'},
            'order' : ['intraday15 desc' , 'ticker'],
            'include' : [
                        {   'relation' : 'cotacaoIntradayIndiceResultados' , 
                            'scope' : {
                                'order' : 'dataHora desc',
                                'limit' : 1,
                                'where' : {'valor' : {'neq':null}}
                            }
                        }
                    ]
        }
        Ativoindice.find(filtro,callback);
    };
};

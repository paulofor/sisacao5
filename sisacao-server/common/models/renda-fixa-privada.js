'use strict';

module.exports = function(Rendafixaprivada) {


    Rendafixaprivada.ListaMelhoresDia = function(qtdeDias,callback) {
       let sql = " select * from RendaFixaPrivada " +
                " where dataAcesso = (select max(dataAcesso) " + 
                " from RendaFixaPrivada) " +
                " order by rentabilidadeAnualCalculada desc " +
                " limit " + qtdeDias;
        let ds = Rendafixaprivada.dataSource;
        ds.connector.query(sql,callback);
    }



    Rendafixaprivada.RecebeDado = function(rendaFixa,callback) {
        rendaFixa.dataInsercao = new Date();
        Rendafixaprivada.create(rendaFixa,callback);
    }

    Rendafixaprivada.InsereSeNaoExisteFixaPrivada = function(listaItem,callback) {
        //console.log('Tam:' , listaItem.length);
        let ds = Rendafixaprivada.dataSource;
        let yourDate = new Date()
        let dataInsercao = yourDate.toISOString().split('T')[0]
        listaItem.forEach(element => {
            //console.log('element: ' , JSON.stringify(element));
            element['dataInsercao'] = dataInsercao;
            let filtro = {'where' : { 'and' : 
                [
                    {'nome' : element.nome},
                    {'emissor':element.emissor},
                    {'distribuidor':element.distribuidor},
                    {'vencimento':element.vencimento}
                ]}
            }
            //console.log('filtro:' , JSON.stringify(filtro));
            Rendafixaprivada.findOne(filtro, (err,result)=> {
                //console.log('result:', result);
                //console.log('err:', err);
                if (result==null) {
                    element['dataAcesso'] = dataInsercao;
                    element['dataInsercao'] = dataInsercao;
                    Rendafixaprivada.create(element);
                    //console.log('Inserção');
                } else {
                    let sql = "update RendaFixaPrivada set dataAcesso = now() where id = " + result.id;
                    //console.log('sql:' , sql);
                    ds.connector.query(sql,(err,result) => {

                    });
                }
            })
        });
        callback(null,{'resultado' : 'ok'})
    }
};

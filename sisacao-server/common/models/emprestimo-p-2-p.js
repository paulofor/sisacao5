'use strict';

module.exports = function(Emprestimop2p) {


    Emprestimop2p.CriaParcelas = function(idEmprestimo, callback) {
        //console.log('CriaParcelas ' , idEmprestimo);
        let ds = Emprestimop2p.dataSource;
        Emprestimop2p.findById(idEmprestimo, (err,emprestimo) => {
            if (err) console.log('Erro1:' , err);
            let cont = 0;
            for (let mes = 0; mes<emprestimo.quantidadeParcela;mes++) {
                let sql = "insert into ParcelaEmprestimo (numeroParcela,valor,dataVencimento,emprestimoP2PId) " +
                    " select " + (mes+1) + ", valorParcela, date_add(dataPrimeiraParcela, interval " + mes + " month) , id from EmprestimoP2P where id = " + idEmprestimo;
                //console.log(sql);
                ds.connector.query(sql,(err,result) => {
                    if (err) console.log('Erro2:' , err);
                    cont++;
                    if (cont==emprestimo.quantidadeParcela) {
                        callback(null,result)
                    }
                })
            }
        })
    }

};

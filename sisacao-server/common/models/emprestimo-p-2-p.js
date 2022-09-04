'use strict';

module.exports = function(Emprestimop2p) {


    let TAXA_JUROS = 13.75
    let TAXA_INADIPLENCIA = 0.25;

/*
select 
(select sum(previsaoLucroPrejuizo)  from EmprestimoP2P) as totalLucroPrejuizo,   
(select (sum(valorPresente) * 0.75) from EmprestimoP2P) as totalValorPresente 
*/



    Emprestimop2p.ObtemResumo = function(callback) {
        let sql = " select " + 
            " (select sum(previsaoLucroPrejuizo)  from EmprestimoP2P) as totalLucroPrejuizo, " +   
            " (select (sum(valorPresente) * " + (1 - TAXA_INADIPLENCIA) + ") from EmprestimoP2P) as totalValorPresente ";
        let ds = Emprestimop2p.dataSource;
        console.log(sql);
        ds.connector.query(sql,(err,result) => {
            callback(err,result[0]);
        });
    }

/*

update ParcelaEmprestimo
set valorPrevisto = (select parcelaMinima from EmprestimoP2P where EmprestimoP2P.id = ParcelaEmprestimo.emprestimoP2PId)
where dataVencimento >= now()

update ParcelaEmprestimo
set valorPrevisto = valor
where valorPrevisto is null

update ParcelaEmprestimo
set tempoMeses =  DATEDIFF(date(dataVencimento), date(now())) div 30

update ParcelaEmprestimo
set valorPresente = 0

update ParcelaEmprestimo
set valorPresente = (valorPrevisto) / power(1+0.015,tempoMeses)
where tempoMeses >= 0

*/

    Emprestimop2p.CalculaValorPresente = function(callback) {
        let sql0 = "update ParcelaEmprestimo set valorPrevisto = null ";
        let sql1 = "update ParcelaEmprestimo " +
                " set valorPrevisto = (select parcelaMinima from EmprestimoP2P where EmprestimoP2P.id = ParcelaEmprestimo.emprestimoP2PId) " +
                " where dataVencimento >= now()"
        let sql2 = "update ParcelaEmprestimo " +
                " set valorPrevisto = valor " +
                " where valorPrevisto is null";
        let sql3 = "update ParcelaEmprestimo " +
                " set tempoMeses =  DATEDIFF(date(dataVencimento), date(now())) div 30";
        let sql4 = " update ParcelaEmprestimo " +
                   " set valorPresente = 0";
        let sql5 = " update ParcelaEmprestimo " +
                   " set valorPresente = (valorPrevisto) / power(1+ " + (TAXA_JUROS/100/12) + ",tempoMeses) " +
                   " where tempoMeses >= 0 and dataVencimento > now()";
        let sql6 = " update EmprestimoP2P set valorPresente = (select sum(valorPresente) from ParcelaEmprestimo where " +
                   " EmprestimoP2P.id = ParcelaEmprestimo.emprestimoP2PId) ";
  
        let ds = Emprestimop2p.dataSource;
        //console.log(sql0);
        ds.connector.query(sql0, (err0,result) => {
            console.log('err0' , err0);
            ds.connector.query(sql1, (err1,result) => {
                console.log('err1' , err1);
                ds.connector.query(sql2, (err2,result) => {
                    console.log('err2' , err2);
                    ds.connector.query(sql3, (err3,result) => {
                        console.log('err3' , err3);
                        ds.connector.query(sql4, (err4,result) => {
                            console.log('err4' , err4);
                            ds.connector.query(sql5, (err5,result) => {
                                console.log('err5' , err5);
                                ds.connector.query(sql6, callback)
                            }) 
                        }) 
                    }) 
                }) 
            }) 
        })        
    }



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

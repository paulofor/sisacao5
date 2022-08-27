'use strict';

module.exports = function(Parcelaemprestimo) {


    Parcelaemprestimo.observe('after save', function updateEmprestimoP2P(ctx, next) {
        console.log('entrou na funcao');
        let id = 0;
        if (ctx.instance) {
            id = ctx.instance.emprestimoP2PId;
        } else {
            id = ctx.data.emprestimoP2PId;
        }
        let sqlTotal = "update EmprestimoP2P set totalRecebido = (select sum(valorRecebido) from ParcelaEmprestimo " +
        " where ParcelaEmprestimo.emprestimoP2PId = EmprestimoP2P.id ) , " +
        " parcelaMinima = (select min(valorRecebido) from ParcelaEmprestimo " +
        " where ParcelaEmprestimo.emprestimoP2PId = EmprestimoP2P.id ) , " +
        " quantidadeFutura = (select count(*) from ParcelaEmprestimo " +
        " where ParcelaEmprestimo.emprestimoP2PId = EmprestimoP2P.id and ParcelaEmprestimo.dataVencimento >= now() and valorRecebido is null) ,  " +
        " quantidadeRecebida = (select count(*) from ParcelaEmprestimo " +
        " where ParcelaEmprestimo.emprestimoP2PId = EmprestimoP2P.id and ParcelaEmprestimo.valorRecebido is not null) , " +
        " quantidadeEmAtraso = (select count(*) from ParcelaEmprestimo " +
        " where ParcelaEmprestimo.emprestimoP2PId = EmprestimoP2P.id and ParcelaEmprestimo.dataVencimento < now() and valorRecebido is null)  " +
        " where id = " + id;

        let sql2 = "update EmprestimoP2P set previsaoRecebimento = quantidadeFutura * parcelaMinima where id = " + id;
        let sql3 = "update EmprestimoP2P set previsaoTotal = previsaoRecebimento + totalRecebido where id = " + id;
        //console.log('SQL Total: ' , sqlTotal);
        let ds = Parcelaemprestimo.dataSource;
        ds.connector.query(sqlTotal,(err,result) => {
            if (err) console.log('err1' , err);
            ds.connector.query(sql2, (err,result) => {
                if (err) console.log('err2' , err);
                ds.connector.query(sql3, (err,result) => {
                    if (err) console.log('err3' , err);
                    next();
                })
            })
                
        })
      })
};

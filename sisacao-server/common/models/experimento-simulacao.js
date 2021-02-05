'use strict';

module.exports = function(Experimentosimulacao) {


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

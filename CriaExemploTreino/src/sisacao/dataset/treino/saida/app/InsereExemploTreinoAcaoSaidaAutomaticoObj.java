package sisacao.dataset.treino.saida.app;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ProximoParaProcessamento;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.entrada.periodo.app.CriaDataSetSaidaSimples;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoEntrada_ListaSemResultadoSimples;

public class InsereExemploTreinoAcaoSaidaAutomaticoObj {

	DatasetExemplo ds = null;
	
	public void executa(String codigoGrupoAcao) {
		ds = new DatasetExemplo();
		ds.setCodigoGrupoAcao(codigoGrupoAcao);
		RegraProjecao_ProximoParaProcessamento exec = new RegraProjecao_ProximoParaProcessamento();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}
	
	public DatasetExemplo getDataset() {
		return ds;
	}

	private void trataProximo() {
		DaoBaseComum.setProximo(RegraProjecao_ProximoParaProcessamento.NOME, new AtivoAcao_ListaPorNomeGrupo());
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new ExemploTreinoAcaoEntrada_ListaSemResultadoSimples());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior.NOME, new CriaDataSetSaidaSimples());

	}
}

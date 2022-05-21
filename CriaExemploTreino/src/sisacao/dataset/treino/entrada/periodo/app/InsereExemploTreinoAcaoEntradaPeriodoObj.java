package sisacao.dataset.treino.entrada.periodo.app;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.entrada.app.CriaDataSetEntrada;
import sisacao.dataset.treino.entrada.dao.DiaPregao_ListaDataPeriodo;

public class InsereExemploTreinoAcaoEntradaPeriodoObj {

	public void executa(int posicaoEntrada, int qtdeDias,String codigo, int diaNumInicio, int diaNumFinal) {
		DatasetExemplo ds = new DatasetExemplo();
		ds.setPosicaoDia(posicaoEntrada);
		ds.setQtdeDia(qtdeDias);
		ds.setCodigoGrupoAcao(codigo);
		ds.setDiaNumInicio(diaNumInicio);
		ds.setDiaNumFinal(diaNumFinal);
		//AtivoAcao_ListaPorNomeGrupo exec = new AtivoAcao_ListaPorNomeGrupo();
		DiaPregao_ListaDataPeriodo exec = new DiaPregao_ListaDataPeriodo();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade.NOME, new CriaDataSetEntrada());
	}
}

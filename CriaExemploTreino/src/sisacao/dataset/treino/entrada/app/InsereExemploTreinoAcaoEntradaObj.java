package sisacao.dataset.treino.entrada.app;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerQuantidade;
import sisacao.dataset.treino.entrada.dao.DatasetExemploEntrada;

public class InsereExemploTreinoAcaoEntradaObj {

	public void executa(int posicaoEntrada, int qtdeDias,String codigo) {
		DatasetExemploEntrada ds = new DatasetExemploEntrada();
		ds.setPosicaoDia(posicaoEntrada);
		ds.setQtdeDia(qtdeDias);
		ds.setCodigoGrupoAcao(codigo);
		AtivoAcao_ListaPorNomeGrupo exec = new AtivoAcao_ListaPorNomeGrupo();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new DiaPregao_ObtemIntradayResultadoTickerQuantidade());
	}
}

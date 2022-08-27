package sisacao.dataset.treino.saida.app;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegra;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.entrada.periodo.app.CriaDataSetSaida;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoEntrada_ListaSemResultado;

public class InsereExemploTreinoAcaoSaidaObj {

	DatasetExemplo ds = null;
	
	public void executa(int posicaoEntrada, int qtdeDias,String codigo, String codigoRegra) {
		ds = new DatasetExemplo();
		ds.setPosicaoEntrada(posicaoEntrada);
		ds.setQtdeDia(qtdeDias);
		ds.setCodigoGrupoAcao(codigo);
		ds.setCodigoRegraProjecao(codigoRegra);
		RegraProjecao_ObtemPorCodigoRegra exec = new RegraProjecao_ObtemPorCodigoRegra();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}
	
	public DatasetExemplo getDataset() {
		return ds;
	}

	private void trataProximo() {
		DaoBaseComum.setProximo(RegraProjecao_ObtemPorCodigoRegra.NOME, new AtivoAcao_ListaPorNomeGrupo());
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new ExemploTreinoAcaoEntrada_ListaSemResultado());
		//DaoBaseComum.setProximo(ExemploTreinoAcaoEntrada_ListaSemResultado.NOME, new DiaPregao_ObtemIntradayResultadoTickerAteFinal());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new CriaDataSetSaida());
	}
}

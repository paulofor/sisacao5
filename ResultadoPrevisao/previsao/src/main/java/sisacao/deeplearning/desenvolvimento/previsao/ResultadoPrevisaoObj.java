package sisacao.deeplearning.desenvolvimento.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.PrevisaoRede_ListaComDiario;
import sisacao.deeplearning.desenvolvimento.processamento.BuscaSaidaTrade;

public class ResultadoPrevisaoObj {

	public void executa(long idTreinoRede, long diaInicio, long diaFinal, double valor) {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
		ds.setDiaNumInicial(diaInicio);
		ds.setDiaNumFinal(diaFinal);
		ds.setValorLimite(valor);
		ds.setIdTreinoRede(idTreinoRede);
		PrevisaoRede_ListaComDiario exec = new PrevisaoRede_ListaComDiario();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}

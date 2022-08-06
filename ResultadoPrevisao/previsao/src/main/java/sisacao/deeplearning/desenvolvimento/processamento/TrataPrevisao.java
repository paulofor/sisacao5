package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TrataPrevisao extends DaoBasePrevisao{

	@Override
	protected void executaImpl() {
		DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		PrevisaoTeste previsao = ds.getPrevisaoCorrente();
		System.out.println(previsao);
		List<PrevisaoTeste> listaPrevisao = ds.getListaPrevisao();
		if (previsao.getPrecoEntrada() >= previsao.getMinimoDiario() && previsao.getPrecoEntrada() <= previsao.getMaximoDiario()) {
			System.out.println("Ativou o preço");
			if (ds.podeProcessar(previsao)) {
				System.out.println("Não esta operando");
				ds.criaTrade(previsao);
				AtivoAcao acao = new AtivoAcao();
				acao.setTicker(previsao.getTicker());
				ds.setAtivoAcaoCorrente(acao);
				ds.setDiaNumInicio(previsao.getDiaNumPrevisao());
				ds.setTamanhoAmostra(200);
				executaProximo();
			} else {
				System.out.println("Ja esta operando");
				finalizar();
			}
		} else {
			System.out.println("Fora dos limites");
			finalizar();
		}
	}

	@Override
	protected DaoBase getProximo() {
		return new DiaPregao_ObtemIntradayResultadoTickerAteFinal();
	}

}

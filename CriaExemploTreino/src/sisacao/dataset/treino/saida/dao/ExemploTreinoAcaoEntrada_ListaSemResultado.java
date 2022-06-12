package sisacao.dataset.treino.saida.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetExemplo;

public class ExemploTreinoAcaoEntrada_ListaSemResultado extends DaoBaseApp {

	private ExemploTreinoAcaoEntrada dado;
	

	
	
	public ExemploTreinoAcaoEntrada_ListaSemResultado() {
		super();
	}
	
	@Override
	public void executaImpl() {
		final DatasetExemplo ds = (DatasetExemplo) getComum();
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		int regraId = ds.getRegraProjecao().getId();
		int qtdeDias = ds.getQtdeDia();
		int posicaoReferencia = ds.getPosicaoEntrada();
		this.repExemploTreinoEntrada.listaSemResultado(ticker, regraId, qtdeDias, posicaoReferencia, new ListCallback<ExemploTreinoAcaoEntrada>() {
			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			@Override
			public void onSuccess(List<ExemploTreinoAcaoEntrada> objects) {
				for (ExemploTreinoAcaoEntrada entrada : objects) {
					ds.setExemploTreinoAcaoEntrada(entrada);
					ds.setDiaNumInicio(entrada.getDiaNumPrevisao());
					executaProximoSemFinalizar();
				}
				finalizar();

			}});
	}

	public void setDado(ExemploTreinoAcaoEntrada exemplo) {
		this.dado = exemplo;
	}

	@Override
	protected DaoBase getProximo() {
		return new DiaPregao_ObtemIntradayResultadoTickerAteFinal();
	}

	

	
	
}

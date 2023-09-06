package br.inf.digicom.loopback.comum.diapregao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.loopback.comum.DaoBaseComum;


public class DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3 extends DaoBaseComum {

	
	public static String NOME = "DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioDiaPregao rep = 
			adapterItem.createRepository(RepositorioDiaPregao.class);
	
	

	@Override
	protected long getTempo() {
		return 2000;
	}
	@Override
	protected void executaImpl() {
		final DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3DS ds = (DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3DS) getComum();
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		int qtdeDia = ds.getQtdeDia();
		this.rep.obtemIntradayResultadoTickerQuantidadeB3(ticker, qtdeDia, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				ds.setListaCotacaoResultado(objects);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}

			
			
		});
	}
	
}
package br.inf.digicom.loopback.comum.diapregao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.loopback.comum.DaoBaseComum;


public class DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade extends DaoBaseComum {

	
	public static String NOME = "DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioDiaPregao rep = 
			adapterItem.createRepository(RepositorioDiaPregao.class);
	
	

	@Override
	protected long getTempo() {
		return 2000;
	}
	@Override
	protected void executaImpl() {
		final DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeDS ds = (DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeDS) getComum();
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		int qtdeDia = ds.getQtdeDia();
		int diaNumPrevisao = ds.getDiaNumPrevisao();
		this.rep.obtemIntradayResultadoTickerPeriodoQuantidade(ticker, qtdeDia, diaNumPrevisao, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Tamanho:" + objects.size());
				System.out.println("Primeiro: " + objects.get(0).getDiaNum());
				System.out.println("Ultimo: " + objects.get(objects.size()-1).getDiaNum());
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
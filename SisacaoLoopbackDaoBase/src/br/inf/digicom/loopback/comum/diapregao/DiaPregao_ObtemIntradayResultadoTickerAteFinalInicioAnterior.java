package br.inf.digicom.loopback.comum.diapregao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.DaoBaseException;


public class DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior extends DaoBaseComum {

	public static String NOME = "DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioDiaPregao rep = 
			adapterItem.createRepository(RepositorioDiaPregao.class);
	
	
	@Override
	protected String getNome() {
		return NOME;
	}
	@Override
	protected long getTempo() {
		return 2000;
	}
	@Override
	protected void executaImpl() {
		final DiaPregao_ObtemIntradayResultadoTickerAteFinalDS ds = (DiaPregao_ObtemIntradayResultadoTickerAteFinalDS) getComum();
		if (ds.getAtivoAcaoCorrente()==null) {
			throw new DaoBaseException("Não tem ds.getAtivoAcaoCorrente() em " + ds.getClass().getName());
		}
		if (ds.getDiaNumInicio()==0) {
			throw new DaoBaseException("Não tem ds.getDiaNumInicio() em " + ds.getClass().getName());
		}
		if (ds.getTamanhoAmostra()==0) {
			throw new DaoBaseException("Não tem ds.getTamanhoAmostra() em " + ds.getClass().getName());
		}
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		int dataNumInicio = ds.getDiaNumInicio();
		int tamanhoAmostra = ds.getTamanhoAmostra();
		this.rep.obtemIntradayResultadoTickerAteFinalInicioAnterior(ticker, dataNumInicio, tamanhoAmostra, new ListCallback<DiaPregao>() {

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
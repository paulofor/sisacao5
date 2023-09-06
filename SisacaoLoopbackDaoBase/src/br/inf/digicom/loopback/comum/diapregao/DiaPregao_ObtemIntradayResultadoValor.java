package br.inf.digicom.loopback.comum.diapregao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.DaoBaseException;


public class DiaPregao_ObtemIntradayResultadoValor extends DaoBaseComum {

	public static String NOME = "DiaPregao_ObtemIntradayResultadoValor";
	
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
		final DiaPregao_ObtemIntradayResultadoValorDS ds = (DiaPregao_ObtemIntradayResultadoValorDS) getComum();
		if (ds.getAtivoAcaoCorrente()==null) {
			throw new DaoBaseException("Não tem ds.getAtivoAcaoCorrente() em " + ds.getClass().getName());
		}
		if (ds.getRegraProjecao()==null) {
			throw new DaoBaseException("Não tem ds.getRegraProjecao() em " + ds.getClass().getName());
		}
		if (ds.getDiaNumInicio()==0) {
			throw new DaoBaseException("Não tem ds.getDiaNumInicio() em " + ds.getClass().getName());
		}
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		int idRegra = ds.getRegraProjecao().getId();
		int dataNumInicio = ds.getDiaNumInicio();
		this.rep.obtemIntradayResultadoValor(ticker, dataNumInicio, idRegra, new ListCallback<DiaPregao>() {

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
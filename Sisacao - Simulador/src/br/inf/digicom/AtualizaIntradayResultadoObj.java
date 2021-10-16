package br.inf.digicom;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository;

public class AtualizaIntradayResultadoObj {

	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	RepositorioAcaoBase.AtivoAcaoRepository repAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	CotacaoIntradayAcaoResultadoRepository repIntraResult = adapter.createRepository(CotacaoIntradayAcaoResultadoRepository.class);
	
	private List<AtivoAcao>  resultado = null;
	
	public List<AtivoAcao> executa(int idGrupo) {
		resultado = null;
		repAcao.listaPorGrupo(idGrupo, new ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(final List<AtivoAcao> objects) {
				resultado = objects;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
		while (resultado == null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	
	
	private CotacaoIntradayAcaoResultado retorno = null;
	private boolean concluido = false;

	public synchronized CotacaoIntradayAcaoResultado executaTicker(String ticker) {
		concluido = false;
		this.repIntraResult.gravaVaziaComAnterior(ticker, new ObjectCallback<CotacaoIntradayAcaoResultado>() {

			@Override
			public void onSuccess(CotacaoIntradayAcaoResultado object) {
				retorno = object;
				concluido = true;
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
		while (!concluido) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

}

package br.inf.digicom.simulacao.service;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository;
import br.inf.digicom.Constantes;

public class CotacaoIntradayAcaoResultadoService {

	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	CotacaoIntradayAcaoResultadoRepository rep = adapter.createRepository(CotacaoIntradayAcaoResultadoRepository.class);
	
	private boolean atualizaTargetStopDiaOk = false;
	public void atualizaTargetStopDia(List<CotacaoIntradayAcaoResultado> lista) {
		rep.atualizaTargetStopDia(lista, new VoidCallback() {
			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				atualizaTargetStopDiaOk = true;
			}
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
			}
		});
		while (!atualizaTargetStopDiaOk) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

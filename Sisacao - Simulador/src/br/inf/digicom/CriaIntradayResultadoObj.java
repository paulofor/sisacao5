package br.inf.digicom;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;

public class CriaIntradayResultadoObj {
	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	RepositorioAcaoBase.AtivoAcaoRepository repAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository repResult = adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository.class);
	
	public void executa(int idGrupo) {
		repAcao.listaPorGrupo(idGrupo, new ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				for (AtivoAcao acao : objects) {
					if (!"AZUL4".equals(acao.getTicker())) {
						try {
							
							repResult.criaTickerAno(acao.getTicker(), 2021L , new VoidCallback() {
								@Override
								public void onSuccess() {
									System.out.println("Enviou " + acao.getTicker());
								}

								@Override
								public void onError(Throwable t) {
									t.printStackTrace();
								}
								
							});
							Thread.sleep(120000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						};
					}
					
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
		
	}

}

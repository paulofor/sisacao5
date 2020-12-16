package br.inf.digicom.loopback;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioOpcaoBase;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioAcaoBase.CotacaoIntradayAcaoRepository repCotacaoAcao = adapter
			.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);

	public void obtemSerie(String ticker, int dias) {
		if (ativo instanceof AtivoAcao) {
			repCotacaoAcao.insereValorHorario(ativo.getTicker(), horario, valor, new VoidCallback() {
				@Override
				public void onSuccess() {
					System.out.println("Inseriu dado (" + ativo.getTicker() + ")");
				}
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
			});
		}
	}
}

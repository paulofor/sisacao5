package sisacao.opcaointra.cotacao;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.Ativo;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;

public class CotacaoIntradayManipuladorAtivo extends CotacaoManipulador {

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioAcaoBase.CotacaoIntradayAcaoRepository repCotacaoAcao = adapter
			.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);

	private Ativo ativo;

	public CotacaoIntradayManipuladorAtivo(Ativo ativo, String data) {
		super(ativo.getTicker(), data);
		this.ativo = ativo;
	}

	@Override
	public void gravaIntraday(String horario, Double valor) {
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

package sisacao.opcaointra.cotacao;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.Ativo;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.AtivoImobiliario;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.digicom.sisacao.modelo.AtivoOpcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioImobiliarioBase;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.com.digicom.sisacao.repositorio.RepositorioMercadoriaBase;
import br.com.digicom.sisacao.repositorio.RepositorioOpcaoBase;

public class CotacaoIntradayManipuladorAtivo extends CotacaoManipulador {

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioAcaoBase.CotacaoIntradayAcaoRepository repCotacaoAcao = adapter
			.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);
	RepositorioOpcaoBase.CotacaoIntradayOpcaoRepository repCotacaoOpcao = adapter
			.createRepository(RepositorioOpcaoBase.CotacaoIntradayOpcaoRepository.class);
	RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository repCotacaoMercadoria = adapter
			.createRepository(RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository.class);
	RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository repCotacaoImobiliario = adapter
			.createRepository(RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository.class);
	RepositorioIndiceBase.CotacaoIntradayIndiceRepository repCotacaoIndice = adapter
			.createRepository(RepositorioIndiceBase.CotacaoIntradayIndiceRepository.class);
	

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
		if (ativo instanceof AtivoOpcao) {
			repCotacaoOpcao.insereValorHorario(ativo.getTicker(), horario, valor, new VoidCallback() {
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
		if (ativo instanceof AtivoMercadoria) {
			repCotacaoMercadoria.insereValorHorario(ativo.getTicker(), horario, valor, new VoidCallback() {
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
		if (ativo instanceof AtivoIndice) {
			repCotacaoIndice.insereValorHorario(ativo.getTicker(), horario, valor, new VoidCallback() {
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
		if (ativo instanceof AtivoImobiliario) {
			repCotacaoImobiliario.insereValorHorario(ativo.getTicker(), horario, valor, new VoidCallback() {
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

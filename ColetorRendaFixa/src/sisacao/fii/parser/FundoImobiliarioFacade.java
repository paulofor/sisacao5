package sisacao.fii.parser;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.com.digicom.sisacao.repositorio.RepositorioFundoImobiliario;
import sisacao.fii.parser.callback.ListaClubeFIICallback;
import sisacao.fii.parser.callback.ListaClubeFIIDetalheCallback;
import sisacao.fii.parser.dado.FundoImobiliarioDado;

public class FundoImobiliarioFacade {

	static RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	static RepositorioFundoImobiliario repFundoImobiliario = adapter.createRepository(RepositorioFundoImobiliario.class);

	
	public static void trataLista(List<FundoImobiliario> lista) {
		try {
			for (FundoImobiliario fundo : lista) {
				Thread.sleep(5000);
				chamaDetalhe(fundo);
			}
			Thread.sleep(3 * 60000);
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private static void chamaDetalhe(FundoImobiliario fundo) {
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ListaClubeFIIDetalheCallback();
		FundoImobiliarioDado dado = new FundoImobiliarioDado();
		dado.setFundo(fundo);
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();
	}
	
	
	public void obtemListaFundo() {
		ExecutadorParse exec = new ExecutadorParse();
		ICallbackParse callback = new ListaClubeFIICallback();
		FundoImobiliarioDado dado = new FundoImobiliarioDado();
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();
		/*
		ICallbackCotacao callback = getCallbackParse();
		callback.setTicker(ticker);
		super.setCallbackParse(callback);
		super.setDadosParse(new CotacaoManipulador(ticker,data));
		*/
	}
	
	public void salvaItemBasico(final FundoImobiliario fundo) {
		this.repFundoImobiliario.insereSeNaoExiste(fundo, (new ObjectCallback<FundoImobiliario>() {
			@Override
			public void onSuccess(FundoImobiliario execucao) {
				System.out.println(fundo.getTicker());
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
		}));
	}
}

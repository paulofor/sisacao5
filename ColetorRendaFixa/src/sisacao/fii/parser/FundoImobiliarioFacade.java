package sisacao.fii.parser;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.ExecutadorParseApache3;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AluguelFundoImobiliario;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.com.digicom.sisacao.repositorio.RepositorioAluguelFundoImobiliario;
import br.com.digicom.sisacao.repositorio.RepositorioFundoImobiliario;
import sisacao.fii.app.desen.ObtemAluguelFundoImob;
import sisacao.fii.parser.callback.AluguelFIIBrasilDetalheCallback;
import sisacao.fii.parser.callback.ListaClubeFIICallback;
import sisacao.fii.parser.callback.ListaClubeFIIDetalheCallback;
import sisacao.fii.parser.dado.AluguelFIIDado;
import sisacao.fii.parser.dado.FundoImobiliarioDado;

public class FundoImobiliarioFacade {

	
	static RestAdapter adapter = new RestAdapter(Constante.LoopbackUrl);
	static RepositorioFundoImobiliario repFundoImobiliario = adapter.createRepository(RepositorioFundoImobiliario.class);
	static RepositorioAluguelFundoImobiliario repAluguelFundoImobiliario = adapter.createRepository(RepositorioAluguelFundoImobiliario.class);
	


	
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
	
	
	public void obtemListaFundo() throws DaoException {
		ExecutadorParseApache3 exec = new ExecutadorParseApache3();
		ICallbackParse callback = new ListaClubeFIICallback();
		FundoImobiliarioDado dado = new FundoImobiliarioDado();
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();

	}
	
	public void salvaItemBasico(final FundoImobiliario fundo) {
		this.repFundoImobiliario.insereSeNaoExiste(fundo, (new ObjectCallback<FundoImobiliario>() {
			@Override
			public void onSuccess(FundoImobiliario execucao) {
				System.out.println("Recebeu retorno ok");
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.out.println("Recebeu retorno erro");

			}
		}));
	}
	public void obtemListaAluguelFundo() {
		// TODO Auto-generated method stub
		this.repFundoImobiliario.listaCompleta((new ListCallback<FundoImobiliario>() {
			@Override
			public void onSuccess(List<FundoImobiliario> lista) {
				try {
					trataAluguel(lista);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();

			}
		}));
	}
	public static void trataAluguel(List<FundoImobiliario> lista) throws DaoException {
		try {
			//chamaDetalheAluguel(lista.get(0));
			FundoImobiliario fundoTeste = new FundoImobiliario();
			fundoTeste.setTicker("HABT11");
			chamaDetalheAluguel(fundoTeste);
			for (FundoImobiliario fundo : lista) {
				Thread.sleep(5000);
				chamaDetalheAluguel(fundo);
			}
			
			Thread.sleep(3 * 60000);
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private static void chamaDetalheAluguel(FundoImobiliario fundo) throws DaoException {
		ExecutadorParseApache3 exec = new ExecutadorParseApache3();
		ICallbackParse callback = new AluguelFIIBrasilDetalheCallback();
		AluguelFIIDado dado = new AluguelFIIDado();
		dado.setFundo(fundo);
		callback.setDados(dado);
		exec.setCallbackParse(callback);
		exec.setDadosParse(dado);
		exec.executa();
	}
	/*
	public static void insereListaAluguel(List<AluguelFundoImobiliario> lista) {
		repAluguelFundoImobiliario.insereSeNaoExisteAluguelFundo(lista, new ObjectCallback<AluguelFundoImobiliario>() {
			@Override
			public void onSuccess(AluguelFundoImobiliario object) {
				System.out.println("inseriu lista aluguel");
			}
			@Override
			public void onError(Throwable t) {
			}
		});
	}
	*/
	
	public static void insereListaAluguelPorItem(List<AluguelFundoImobiliario> lista) {
		final int LIMITE = 5;
		for (int ind=0;ind<LIMITE && ind<lista.size(); ind++) {
			AluguelFundoImobiliario item = lista.get(ind);
			if (item.getValor()==0) continue;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repAluguelFundoImobiliario.insereSeNaoExisteItemAluguel(item, new ObjectCallback<AluguelFundoImobiliario>() {
				@Override
				public void onSuccess(AluguelFundoImobiliario object) {
					System.out.println("inseriu item aluguel");
					
				}
				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}
			});
		}
		
		
	}
}

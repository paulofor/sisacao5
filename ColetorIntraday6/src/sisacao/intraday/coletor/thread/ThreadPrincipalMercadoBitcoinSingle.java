package sisacao.intraday.coletor.thread;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.agregador.AgregadorMercadoBitcoinDummy;
import sisacao.intraday.coletor.agregador.AgregadorThread;
import sisacao.intraday.coletor.pesquisador.PesquisadorMercadoBitcoinNoThread;

public class ThreadPrincipalMercadoBitcoinSingle extends ThreadPaiBase{

	
	private List<AtivoCriptomoeda> listaTicker = null;
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
	
	
	
	PesquisadorMercadoBitcoinNoThread pesquisador = new PesquisadorMercadoBitcoinNoThread();
	
	@Override
	protected AgregadorThread getAgregador() {
		return new AgregadorMercadoBitcoinDummy();
	}

	@Override
	protected void mudouDia(String paramString1, String paramString2, boolean paramBoolean) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		super.run();
		if (listaTicker==null) {
			carregaListaTicker();
		} else {
			obtemCotacaoLista();
		}
	}
	
	private void carregaListaTicker() {
		System.out.println("carregaListaTicker()");
		this.repCriptomoeda.listaMercadoBitcoin(new ListCallback<AtivoCriptomoeda>() {
			@Override
			public void onSuccess(List<AtivoCriptomoeda> objects) {
				listaTicker = objects;
				System.out.println("Ativos: " + listaTicker.size());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}
	
	private void obtemCotacaoLista() {
		System.out.println("obtemCotacaoLista()");
		for (AtivoCriptomoeda ativo : listaTicker) {
			
			try {
				pesquisador.obtemCotacao(ativo.getTicker());
				Thread.sleep(2000);
				System.gc();
			} catch (DaoException | InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}

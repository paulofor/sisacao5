package sisacao.intraday.coletor.agregador;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.pesquisador.PesquisadorIntradayMercadoBitcoin;

public class AgregadorThreadMercadoBitcoin implements AgregadorThread{

	private List<PesquisadorTimer> listaThreads = null;
	
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
		
	final Timer timer = new Timer();
	

	
	public AgregadorThreadMercadoBitcoin() {
		listaThreads = new ArrayList<PesquisadorTimer>();
	}

	
	
	public void limpaColetoresAtual() {
		for (PesquisadorTimer item: listaThreads) {
			item.cancel();
		}
		listaThreads.clear();
	}



	@Override
	public void disparaColetoresDia(final String novoDia) {
		// TODO Auto-generated method stub
		this.repCriptomoeda.listaMercadoBitcoin(new ListCallback<AtivoCriptomoeda>() {

			@Override
			public void onSuccess(List<AtivoCriptomoeda> objects) {
				// TODO Auto-generated method stub
				for (AtivoCriptomoeda item : objects) {
					inicializaAtivo(novoDia, item.getTicker());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}

	private final void inicializaAtivo(String diaAtual, String ticker) {
		int tempo = 15 * 60 * 1000;
		PesquisadorIntradayMercadoBitcoin timerThread = null;
		timerThread = new PesquisadorIntradayMercadoBitcoin(ticker);
		timerThread.inicializa(diaAtual);
		timer.schedule(timerThread, 0L, tempo);
		listaThreads.add(timerThread);
	}

	
}

package timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.opcaointra.cotacao.PesquisadorIntradayMercadoBitcoin;

public class AgregadorThreadColetaCripto {

	private List<PesquisadorTimer> listaThreads = null;
	
	private List<ColetorIndividualTh> listaColetor = null;
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
		
	final Timer timer = new Timer();
	

	
	public AgregadorThreadColetaCripto() {
		listaThreads = new ArrayList<PesquisadorTimer>();
		listaColetor = new ArrayList<ColetorIndividualTh>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		for (PesquisadorTimer item: listaThreads) {
			item.cancel();
		}
		listaThreads.clear();
	}


	


	

	public void disparaColetoresDia(String diaAtual) {
		this.disparaColetoresMercadoBitcoin(diaAtual);
	}
	
	
	private void disparaColetoresMercadoBitcoin(final String diaAtual) {
		//final RestricaoTempo restricao = getRestricaoTempo();
		repCriptomoeda.listaMercadoBitcoin(new ListCallback<AtivoCriptomoeda>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoCriptomoeda> objects) {
				System.out.println("Total Acao: " + objects.size());
				inicializaAtivo(objects,diaAtual);
				
			} 
        });
		
	}

	
	private final void inicializaAtivo(List<AtivoCriptomoeda> objects, String diaAtual) {
		//System.out.println("Inicializando: " + ativo.getTicker() + "(" + ativo.minutos() + ")");
		int tempo = 30 * 60 * 1000;
		PesquisadorIntradayMercadoBitcoin timerThread = null;
		timerThread = new PesquisadorIntradayMercadoBitcoin();
		timerThread.inicializa(objects, diaAtual);
		timer.schedule(timerThread, 0L, tempo);
		listaThreads.add(timerThread);
	}
	

	
	
}

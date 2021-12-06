package sisacao.intraday.coletor.agregador;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.pesquisador.PesquisadorIntradayFoxbit;

public class AgregadorThreadFoxbit {

	private List<PesquisadorTimer> listaThreads = null;
	
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
		
	final Timer timer = new Timer();
	

	
	public AgregadorThreadFoxbit() {
		listaThreads = new ArrayList<PesquisadorTimer>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		for (PesquisadorTimer item: listaThreads) {
			item.cancel();
		}
		listaThreads.clear();
	}


	


	

	public void disparaColetoresDia(String diaAtual) {
		this.inicializaAtivo(diaAtual);
	}
	
	
	

	
	private final void inicializaAtivo(String diaAtual) {
		//System.out.println("Inicializando: " + ativo.getTicker() + "(" + ativo.minutos() + ")");
		int tempo = 30 * 60 * 1000;
		PesquisadorIntradayFoxbit timerThread = null;
		timerThread = new PesquisadorIntradayFoxbit();
		timerThread.inicializa(diaAtual);
		timer.schedule(timerThread, 0L, tempo);
		listaThreads.add(timerThread);
	}
	

	
	
}

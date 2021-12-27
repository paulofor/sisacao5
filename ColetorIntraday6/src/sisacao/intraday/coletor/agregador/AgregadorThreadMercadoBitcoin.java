package sisacao.intraday.coletor.agregador;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;

public class AgregadorThreadMercadoBitcoin {

private List<PesquisadorTimer> listaThreads = null;
	
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
		
	final Timer timer = new Timer();
	

	
	public AgregadorThreadMercadoBitcoin() {
		listaThreads = new ArrayList<PesquisadorTimer>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		for (PesquisadorTimer item: listaThreads) {
			item.cancel();
		}
		listaThreads.clear();
	}
}

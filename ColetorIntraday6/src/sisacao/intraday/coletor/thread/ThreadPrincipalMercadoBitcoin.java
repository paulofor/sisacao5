package sisacao.intraday.coletor.thread;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.ArquivoLog;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.agregador.AgregadorThread;
import sisacao.intraday.coletor.agregador.AgregadorThreadMercadoBitcoin;
import sisacao.intraday.coletor.obj.AtualizaMercadoBitcoinObj;

public class ThreadPrincipalMercadoBitcoin extends ThreadPaiBase{

	private AgregadorThread agregador = new AgregadorThreadMercadoBitcoin();

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCriptomoeda = 
			adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);
	
	private boolean primeiro = true;

	@Override
	protected void mudouDia(String paramString1, String paramString2, boolean paramBoolean) throws DaoException {
		// TODO Auto-generated method stub
		AtualizaMercadoBitcoinObj obj = new AtualizaMercadoBitcoinObj();
		obj.executa();
	}

	
	public ThreadPrincipalMercadoBitcoin() {
		super();
		this.agregador.limpaColetoresAtual();
		this.agregador.disparaColetoresDia(null);
	}
	@Override
	protected AgregadorThread getAgregador() {
		return new AgregadorThreadMercadoBitcoin();
	}

	
	@Override
	public void run() {
		
	}

}

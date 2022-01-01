package sisacao.intraday.coletor.thread;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.lib.dao.DaoException;
import sisacao.intraday.coletor.agregador.AgregadorThread;
import sisacao.intraday.coletor.agregador.AgregadorThreadFoxbit;


public class ThreadPrincipalFoxbit extends ThreadPaiBase{

	
	
	
	
	@Override
	protected void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) throws DaoException {
		
		repCripto.atualizaFoxbit(new VoidCallback(){
			@Override
			public void onSuccess() {
				System.out.println("[sucesso] Exit");
			}
			@Override
			public void onError(Throwable t) {
				System.out.println("[erro] Exit");
			}
			
		});
	}

	@Override
	protected AgregadorThread getAgregador() {
		return new AgregadorThreadFoxbit();
	}


	

	

}

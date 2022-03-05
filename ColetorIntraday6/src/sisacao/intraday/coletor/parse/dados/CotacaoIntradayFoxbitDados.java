package sisacao.intraday.coletor.parse.dados;



import java.util.List;

import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CotacaoIntradayFoxbit;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.thread.ThreadPaiBase;

public class CotacaoIntradayFoxbitDados implements IDadosParse{
	
	RestAdapter adapter = new RestAdapter(ThreadPaiBase.LoopBackUrl);
	
	RepositorioCriptomoedaBase.CotacaoIntradayFoxbitRepository repCripto = adapter
			.createRepository(RepositorioCriptomoedaBase.CotacaoIntradayFoxbitRepository.class);

	List<CotacaoIntradayFoxbit> listaCotacao = null;
	
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		System.out.println("Recebeu json");
	}

	public void setLista(List<CotacaoIntradayFoxbit> listaCotacao) {
		this.listaCotacao = listaCotacao;
	}

	public void registra() {
		repCripto.insereListaFonteFoxbit(this.listaCotacao, new VoidCallback() {

			@Override
			public void onSuccess() {
				System.out.println("Enviado dados lista tam: " + listaCotacao.size());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.out.println("Erro envio dados");
			}});
	}

}

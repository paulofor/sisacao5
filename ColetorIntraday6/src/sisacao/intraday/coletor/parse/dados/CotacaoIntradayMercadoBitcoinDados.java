package sisacao.intraday.coletor.parse.dados;



import java.lang.management.ManagementFactory;

import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CotacaoIntradayMercadoBitcoin;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;

public class CotacaoIntradayMercadoBitcoinDados implements IDadosParse{
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	
	RepositorioCriptomoedaBase.CotacaoIntradayMercadoBitcoinRepository repCripto = adapter
			.createRepository(RepositorioCriptomoedaBase.CotacaoIntradayMercadoBitcoinRepository.class);

	
	private String ticker =  null;
	
			
	public CotacaoIntradayMercadoBitcoinDados(String ticker) {
		this.ticker = ticker;
	}
	
	public String getTicker() {
		return this.ticker;
	}
	
	
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		System.out.println("Recebeu json");
	}

	public void registra(final CotacaoIntradayMercadoBitcoin cotacao) {
		// TODO Auto-generated method stub
		repCripto.insereItem(cotacao, new ObjectCallback<CotacaoIntradayMercadoBitcoin>() {

			@Override
			public void onSuccess(CotacaoIntradayMercadoBitcoin object) {
				// TODO Auto-generated method stub
				System.out.println("Threads: " + ManagementFactory.getThreadMXBean().getThreadCount());
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

		});
	}

	/*
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
	*/
	

}

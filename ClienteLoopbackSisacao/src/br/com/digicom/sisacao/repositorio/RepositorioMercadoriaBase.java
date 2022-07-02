package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.digicom.sisacao.modelo.CotacaoIntradayMercadoria;

public class RepositorioMercadoriaBase {

	
	public static class AtivoMercadoriaRepository extends ModelRepository<AtivoMercadoria> {
		public AtivoMercadoriaRepository() {
			super("AtivoMercadoria", AtivoMercadoria.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoMercadoria";
		}
		
		public void listaColetaIntradayMercadoria(ListCallback<AtivoMercadoria> listCallback) {
			RestContractItem contrato = new RestContractItem("AtivoMercadoria/listaColetaIntradayMercadoria","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoMercadoria.listaColetaIntradayMercadoria");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntradayMercadoria", params,   new JsonArrayParser<AtivoMercadoria>(this, listCallback));
		}
	}
	
	public static class CotacaoIntradayMercadoriaRepository extends ModelRepository<CotacaoIntradayMercadoria> {
		public CotacaoIntradayMercadoriaRepository() {
			super("CotacaoIntradayMercadoria", CotacaoIntradayMercadoria.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayMercadorias";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayMercadoria/insereValorHorarioMercadoria","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayMercadoria.insereValorHorarioMercadoria");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorarioMercadoria", params, new EmptyResponseParser(voidCallback));
		}
	}

}

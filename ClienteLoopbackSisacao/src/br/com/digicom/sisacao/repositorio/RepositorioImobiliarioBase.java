package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoImobiliario;
import br.com.digicom.sisacao.modelo.CotacaoIntradayImobiliario;

public class RepositorioImobiliarioBase {

	public static class AtivoImobiliarioRepository extends ModelRepository<AtivoImobiliario> {
		public AtivoImobiliarioRepository() {
			super("AtivoImobiliario", AtivoImobiliario.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoImobiliarios";
		}
		public void listaColetaIntraday(final ListCallback<AtivoImobiliario> callback) {
			RestContractItem contrato = new RestContractItem("AtivoImobiliarios/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoImobiliario.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoImobiliario>(this, callback));
			
		}
	}
	
	public static class CotacaoIntradayImobiliarioRepository extends ModelRepository<CotacaoIntradayImobiliario> {
		public CotacaoIntradayImobiliarioRepository() {
			super("CotacaoIntradayImobiliario", CotacaoIntradayImobiliario.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayImobiliarios";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayImobiliarios/insereValorHorarioImobiliario","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayImobiliario.insereValorHorarioImobiliario");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorarioImobiliario", params, new EmptyResponseParser(voidCallback));
		}
	}

}

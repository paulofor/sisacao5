package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.modelo.CotacaoIntradayCriptomoeda;

public class RepositorioCriptomoedaBase {

	
	public static class AtivoCriptomoedaRepository extends ModelRepository<AtivoCriptomoeda> {
		public AtivoCriptomoedaRepository() {
			super("AtivoCriptomoeda", AtivoCriptomoeda.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoCriptomoeda";
		}
		public void listaColetaIntraday(final ListCallback<AtivoCriptomoeda> callback) {
			RestContractItem contrato = new RestContractItem("AtivoCriptomoeda/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoCriptomoeda.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoCriptomoeda>(this, callback));
			
		}
	}
	
	public static class CotacaoIntradayCriptomoedaRepository extends ModelRepository<CotacaoIntradayCriptomoeda> {
		public CotacaoIntradayCriptomoedaRepository() {
			super("CotacaoIntradayCriptomoeda", CotacaoIntradayCriptomoeda.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayCriptomoedas";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayCriptomoeda/insereValorHorarioCriptomoeda","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayCriptomoeda.insereValorHorarioCriptomoeda");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        invokeStaticMethod("insereValorHorarioCriptomoeda", params, new EmptyResponseParser(voidCallback));
		}
	}

}

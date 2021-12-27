package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import br.com.digicom.sisacao.modelo.CotacaoIntradayCriptomoeda;
import br.com.digicom.sisacao.modelo.CotacaoIntradayFoxbit;

public class RepositorioCriptomoedaBase {

	
	public static class AtivoCriptomoedaRepository extends ModelRepository<AtivoCriptomoeda> {
		public AtivoCriptomoedaRepository() {
			super("AtivoCriptomoeda", AtivoCriptomoeda.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoCriptomoedas";
		}
		public void listaMercadoBitcoin(final ListCallback<AtivoCriptomoeda> callback) {
			RestContractItem contrato = new RestContractItem("AtivoCriptomoedas/listaMercadoBitcoin","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoCriptomoeda.listaMercadoBitcoin");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaMercadoBitcoin", params,   new JsonArrayParser<AtivoCriptomoeda>(this, callback));
			
		}
		public void listaColetaIntraday(final ListCallback<AtivoCriptomoeda> callback) {
			RestContractItem contrato = new RestContractItem("AtivoCriptomoeda/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoCriptomoeda.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoCriptomoeda>(this, callback));
		}
		public void atualizaFoxbit(final VoidCallback callback) {
			RestContractItem contrato = new RestContractItem("AtivoCriptomoeda/atualizaFoxbit","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoCriptomoeda.atualizaFoxbit");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("atualizaFoxbit", params,  new EmptyResponseParser(callback));
			
		}
		public void insereSeNaoExisteLista(final List<AtivoCriptomoeda> lista, final VoidCallback callback) {
			RestContractItem contrato = new RestContractItem("AtivoCriptomoedas/insereSeNaoExisteLista","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoCriptomoeda.insereSeNaoExisteLista");
	        Map<String, Object> params = new HashMap<String, Object>();
	        JSONArray listaServico = new JSONArray();
	        for (AtivoCriptomoeda moeda : lista) {
	        	listaServico.put(moeda.jSON());
	        }
	        params.put("lista", listaServico);
	        invokeStaticMethod("insereSeNaoExisteLista", params,   new EmptyResponseParser(callback));
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
	
	
	public static class CotacaoIntradayFoxbitRepository extends ModelRepository<CotacaoIntradayFoxbit> {
		
		public CotacaoIntradayFoxbitRepository() {
			super("CotacaoIntradayFoxbit", CotacaoIntradayFoxbit.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayFoxbits";
		}

		public void insereListaFonteFoxbit(final List<CotacaoIntradayFoxbit> lista, final VoidCallback callback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayFoxbits/insereListaFonteFoxbit","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayFoxbit.insereListaFonteFoxbit");
	        Map<String, Object> params = new HashMap<String, Object>();
	        JSONArray listaServico = new JSONArray();
	        for (CotacaoIntradayFoxbit moeda : lista) {
	        	listaServico.put(moeda.getJSON());
	        }
	        params.put("listaCotacao", listaServico);
	        invokeStaticMethod("insereListaFonteFoxbit", params,   new EmptyResponseParser(callback));
		}
	}
	

}

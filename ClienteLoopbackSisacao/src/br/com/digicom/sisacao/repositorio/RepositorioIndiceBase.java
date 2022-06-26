package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.modelo.CotacaoIntradayIndice;

public class RepositorioIndiceBase {

	public static class AtivoIndiceRepository extends ModelRepository<AtivoIndice> {
		public AtivoIndiceRepository() {
			super("AtivoIndice", AtivoIndice.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoIndices";
		}
		public void ListaNaoBovespa(final ListCallback<AtivoIndice> callback) {
			RestContractItem contrato = new RestContractItem("AtivoIndices/listaNaoBovespa","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoIndice.listaNaoBovespa");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaNaoBovespa", params,   new JsonArrayParser<AtivoIndice>(this, callback));
			
		}

		public void listaColetaIntraday(final ListCallback<AtivoIndice> callback) {
			RestContractItem contrato = new RestContractItem("AtivoIndices/listaColetaIntraday","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoIndice.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoIndice>(this, callback));
		}
		
	}
	
	public static class CotacaoIntradayIndiceRepository extends ModelRepository<CotacaoIntradayIndice> {
		public CotacaoIntradayIndiceRepository() {
			super("CotacaoIntradayIndice", CotacaoIntradayIndice.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayIndices";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayIndices/insereValorHorarioIndice","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayIndice.insereValorHorarioIndice");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorarioIndice", params, new EmptyResponseParser(voidCallback));
		}
		public void insereValor(String ticker, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayIndices/insereValorIndiceDes","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayIndice.insereValorIndice");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        invokeStaticMethod("insereValorIndice", params, new EmptyResponseParser(voidCallback));
		}
	}

}

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
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;

public class RepositorioAcaoBase {

	
	public static class AtivoAcaoRepository extends ModelRepository<AtivoAcao> {
		public AtivoAcaoRepository() {
			super("AtivoAcao", AtivoAcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoAcaos";
		}
		public void listaColetaIntraday(final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoAcao>(this, callback));
			
		}
		public void insereAcaoIndice(String ticker, String nome, String tipo, Long quantidade, Double percentual, String indice,
				final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/insereAcaoIndice","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.insereAcaoIndice");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("nome", nome);
	        params.put("tipo", tipo);
	        params.put("quantidade", quantidade);
	        params.put("percentual", percentual);
	        params.put("indice", indice);
	        invokeStaticMethod("insereAcaoIndice", params,   new EmptyResponseParser(voidCallback));
			
		}
	}
	
	public static class CotacaoIntradayAcaoRepository extends ModelRepository<CotacaoIntradayAcao> {
		public CotacaoIntradayAcaoRepository() {
			super("CotacaoIntradayAcao", CotacaoIntradayAcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayAcaos";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaos/insereValorHorario","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcao.insereValorHorario");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorario", params, new EmptyResponseParser(voidCallback));
		}
	}


}

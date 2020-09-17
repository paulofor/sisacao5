package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoOpcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayOpcao;

public class RepositorioOpcaoBase {

	public static class AtivoOpcaoRepository extends ModelRepository<AtivoOpcao> {
		public AtivoOpcaoRepository() {
			super("AtivoOpcao", AtivoOpcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoOpcaos";
		}
		public void listaColetaIntraday(final ListCallback<AtivoOpcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoOpcaos/listaColetaIntraday","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoOpcao.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoOpcao>(this, callback));
			
		}
	}
	
	public static class CotacaoIntradayOpcaoRepository extends ModelRepository<CotacaoIntradayOpcao> {
		public CotacaoIntradayOpcaoRepository() {
			super("CotacaoIntradayOpcao", CotacaoIntradayOpcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayOpcaos";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayOpcaos/insereValorHorario","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayOpcao.insereValorHorario");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorario", params, new EmptyResponseParser(voidCallback));
		}
	}

}

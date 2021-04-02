package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.DiaPregao;

public class RepositorioDiaPregao extends ModelRepository<DiaPregao>{

	
		public RepositorioDiaPregao() {
			super("DiaPregao", DiaPregao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "DiaPregao";
		}
		public synchronized void obtemPorDiaTicker(String ticker, int dias, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayPorTicker","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayPorTicker");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        //params.put("dia", dias);
	        invokeStaticMethod("obtemIntradayPorTicker", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemProximo(final ObjectCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemProximo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemProximo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("obtemProximo", params,   new JsonObjectParser<DiaPregao>(this, callback));
		}
}

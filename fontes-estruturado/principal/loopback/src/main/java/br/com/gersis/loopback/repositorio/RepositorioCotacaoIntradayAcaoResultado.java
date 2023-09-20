package br.com.gersis.loopback.repositorio;


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;

public class RepositorioCotacaoIntradayAcaoResultado extends ModelRepository<CotacaoIntradayAcaoResultado> {

	public RepositorioCotacaoIntradayAcaoResultado() {
		super("CotacaoIntradayAcaoResultado", CotacaoIntradayAcaoResultado.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "CotacaoIntradayAcaoResultado";
	}


	// ***  Operações  ***

	public synchronized void pendentePorFechamentoRegra(int idFechamentoRegraDia ,final ListCallback<CotacaoIntradayAcaoResultado> callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/pendentePorFechamentoRegra","GET");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.pendentePorFechamentoRegra");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idFechamentoRegraDia", idFechamentoRegraDia);
		invokeStaticMethod("pendentePorFechamentoRegra", params,   new JsonArrayParser<CotacaoIntradayAcaoResultado>(this, callback));
	}

	public synchronized void listaPossiveisSaidas(CotacaoIntradayAcaoResultado entrada ,final ListCallback<CotacaoIntradayAcaoResultado> callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/listaPossiveisSaidas","GET");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.listaPossiveisSaidas");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("entrada", entrada.getJSON());
		invokeStaticMethod("listaPossiveisSaidas", params,   new JsonArrayParser<CotacaoIntradayAcaoResultado>(this, callback));
	}

	public synchronized void gravaVaziaComAnterior(String ticker ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/gravaVaziaComAnterior","POST");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.gravaVaziaComAnterior");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		invokeStaticMethod("gravaVaziaComAnterior", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<CotacaoIntradayAcaoResultado> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (CotacaoIntradayAcaoResultado item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

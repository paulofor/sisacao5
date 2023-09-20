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

import br.com.gersis.loopback.modelo.CotacaoIntradayIndiceResultado;

public class RepositorioCotacaoIntradayIndiceResultado extends ModelRepository<CotacaoIntradayIndiceResultado> {

	public RepositorioCotacaoIntradayIndiceResultado() {
		super("CotacaoIntradayIndiceResultado", CotacaoIntradayIndiceResultado.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "CotacaoIntradayIndiceResultado";
	}


	// ***  Operações  ***

	public synchronized void criaIndiceResultadoAno(String ticker ,int ano ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayIndiceResultados/criaIndiceResultadoAno","POST");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayIndiceResultado.criaIndiceResultadoAno");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("ano", ano);
		invokeStaticMethod("criaIndiceResultadoAno", params,   new EmptyResponseParser(callback));
	}

	public synchronized void gravaVaziaComAnteriorIndice(String ticker ,final ObjectCallback<CotacaoIntradayIndiceResultado> callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayIndiceResultados/gravaVaziaComAnteriorIndice","POST");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayIndiceResultado.gravaVaziaComAnteriorIndice");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		invokeStaticMethod("gravaVaziaComAnteriorIndice", params,   new JsonObjectParser<CotacaoIntradayIndiceResultado>(this, callback));
	}


	private JSONArray obtemLista(List<CotacaoIntradayIndiceResultado> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (CotacaoIntradayIndiceResultado item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

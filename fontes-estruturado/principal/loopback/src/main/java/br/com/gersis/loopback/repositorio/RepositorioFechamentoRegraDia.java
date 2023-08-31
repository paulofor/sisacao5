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

import br.com.gersis.loopback.modelo.FechamentoRegraDia;

public class RepositorioFechamentoRegraDia extends ModelRepository<FechamentoRegraDia> {

	public RepositorioFechamentoRegraDia() {
		super("FechamentoRegraDia", FechamentoRegraDia.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "FechamentoRegraDia";
	}


	// ***  Operações  ***

	public synchronized void listaVerificacaoDiaria(final ListCallback<FechamentoRegraDia> callback ) {
		RestContractItem contrato = new RestContractItem("FechamentoRegraDia/listaVerificacaoDiaria","GET");
		this.getRestAdapter().getContract().addItem(contrato, "FechamentoRegraDia.listaVerificacaoDiaria");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaVerificacaoDiaria", params,   new JsonArrayParser<FechamentoRegraDia>(this, callback));
	}


	private JSONArray obtemLista(List<FechamentoRegraDia> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (FechamentoRegraDia item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

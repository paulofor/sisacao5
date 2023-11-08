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

import br.com.gersis.loopback.modelo.AtivoIndice;

public class RepositorioAtivoIndice extends ModelRepository<AtivoIndice> {

	public RepositorioAtivoIndice() {
		super("AtivoIndice", AtivoIndice.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "AtivoIndice";
	}


	// ***  Operações  ***

	public synchronized void listaBovespa(final ListCallback<AtivoIndice> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoIndices/listaBovespa","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoIndice.listaBovespa");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaBovespa", params,   new JsonArrayParser<AtivoIndice>(this, callback));
	}

	public synchronized void listaIndiceResultadoMaisRecente(final ListCallback<AtivoIndice> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoIndices/listaIndiceResultadoMaisRecente","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoIndice.listaIndiceResultadoMaisRecente");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaIndiceResultadoMaisRecente", params,   new JsonArrayParser<AtivoIndice>(this, callback));
	}


	private JSONArray obtemLista(List<AtivoIndice> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (AtivoIndice item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

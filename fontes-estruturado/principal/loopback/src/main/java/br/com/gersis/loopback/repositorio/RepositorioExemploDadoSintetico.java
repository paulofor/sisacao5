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

import br.com.gersis.loopback.modelo.ExemploDadoSintetico;

public class RepositorioExemploDadoSintetico extends ModelRepository<ExemploDadoSintetico> {

	public RepositorioExemploDadoSintetico() {
		super("ExemploDadoSintetico", ExemploDadoSintetico.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploDadoSintetico";
	}


	// ***  Operações  ***

	public synchronized void listaPorAmostraParaTreino(int idAmostra ,final ListCallback<ExemploDadoSintetico> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploDadoSinteticos/listaPorAmostraParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploDadoSintetico.listaPorAmostraParaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idAmostra", idAmostra);
		invokeStaticMethod("listaPorAmostraParaTreino", params,   new JsonArrayParser<ExemploDadoSintetico>(this, callback));
	}


	private JSONArray obtemLista(List<ExemploDadoSintetico> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExemploDadoSintetico item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

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

import br.com.gersis.loopback.modelo.RedeNeural;

public class RepositorioRedeNeural extends ModelRepository<RedeNeural> {

	public RepositorioRedeNeural() {
		super("RedeNeural", RedeNeural.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RedeNeural";
	}


	// ***  Operações  ***

	public synchronized void obtemListaTreino(final ListCallback<RedeNeural> callback ) {
		RestContractItem contrato = new RestContractItem("RedeNeurals/obtemListaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RedeNeural.obtemListaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemListaTreino", params,   new JsonArrayParser<RedeNeural>(this, callback));
	}


	private JSONArray obtemLista(List<RedeNeural> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (RedeNeural item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

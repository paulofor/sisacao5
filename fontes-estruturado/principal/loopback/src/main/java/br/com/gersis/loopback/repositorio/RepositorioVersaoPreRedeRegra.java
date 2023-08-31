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

import br.com.gersis.loopback.modelo.VersaoPreRedeRegra;

public class RepositorioVersaoPreRedeRegra extends ModelRepository<VersaoPreRedeRegra> {

	public RepositorioVersaoPreRedeRegra() {
		super("VersaoPreRedeRegra", VersaoPreRedeRegra.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "VersaoPreRedeRegra";
	}


	// ***  Operações  ***

	public synchronized void listaParaTreino(final ListCallback<VersaoPreRedeRegra> callback ) {
		RestContractItem contrato = new RestContractItem("VersaoPreRedeRegras/listaParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "VersaoPreRedeRegra.listaParaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaParaTreino", params,   new JsonArrayParser<VersaoPreRedeRegra>(this, callback));
	}

	public synchronized void listaParaTreinoDadoSintetico(final ListCallback<VersaoPreRedeRegra> callback ) {
		RestContractItem contrato = new RestContractItem("VersaoPreRedeRegras/listaParaTreinoDadoSintetico","GET");
		this.getRestAdapter().getContract().addItem(contrato, "VersaoPreRedeRegra.listaParaTreinoDadoSintetico");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaParaTreinoDadoSintetico", params,   new JsonArrayParser<VersaoPreRedeRegra>(this, callback));
	}


	private JSONArray obtemLista(List<VersaoPreRedeRegra> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (VersaoPreRedeRegra item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

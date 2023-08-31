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

import br.com.gersis.loopback.modelo.TreinoGrupoRede;

public class RepositorioTreinoGrupoRede extends ModelRepository<TreinoGrupoRede> {

	public RepositorioTreinoGrupoRede() {
		super("TreinoGrupoRede", TreinoGrupoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TreinoGrupoRede";
	}


	// ***  Operações  ***


	private JSONArray obtemLista(List<TreinoGrupoRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (TreinoGrupoRede item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

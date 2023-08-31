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

import br.com.gersis.loopback.modelo.PeriodoTreinoRede;

public class RepositorioPeriodoTreinoRede extends ModelRepository<PeriodoTreinoRede> {

	public RepositorioPeriodoTreinoRede() {
		super("PeriodoTreinoRede", PeriodoTreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PeriodoTreinoRede";
	}


	// ***  Operações  ***


	private JSONArray obtemLista(List<PeriodoTreinoRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (PeriodoTreinoRede item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

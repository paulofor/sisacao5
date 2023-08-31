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

import br.com.gersis.loopback.modelo.ExperimentoPreRede;

public class RepositorioExperimentoPreRede extends ModelRepository<ExperimentoPreRede> {

	public RepositorioExperimentoPreRede() {
		super("ExperimentoPreRede", ExperimentoPreRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoPreRede";
	}


	// ***  Operações  ***

	public synchronized void listaExperimentoParaTreino(final ListCallback<ExperimentoPreRede> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedes/listaExperimentoParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRede.listaExperimentoParaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaExperimentoParaTreino", params,   new JsonArrayParser<ExperimentoPreRede>(this, callback));
	}


	private JSONArray obtemLista(List<ExperimentoPreRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExperimentoPreRede item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

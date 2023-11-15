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

import br.com.gersis.loopback.modelo.ExperimentoRedeNeural;

public class RepositorioExperimentoRedeNeural extends ModelRepository<ExperimentoRedeNeural> {

	public RepositorioExperimentoRedeNeural() {
		super("ExperimentoRedeNeural", ExperimentoRedeNeural.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoRedeNeural";
	}


	// ***  Operações  ***

	public synchronized void obtemParaCache(final ListCallback<ExperimentoRedeNeural> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoRedeNeurals/obtemParaCache","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoRedeNeural.obtemParaCache");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemParaCache", params,   new JsonArrayParser<ExperimentoRedeNeural>(this, callback));
	}

	public synchronized void geraTreinoCache(int idExperimento ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoRedeNeurals/geraTreinoCache","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoRedeNeural.geraTreinoCache");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idExperimento", idExperimento);
		invokeStaticMethod("geraTreinoCache", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<ExperimentoRedeNeural> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExperimentoRedeNeural item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

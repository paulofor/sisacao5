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

import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;

public class RepositorioExperimentoPreRedeTreinada extends ModelRepository<ExperimentoPreRedeTreinada> {

	public RepositorioExperimentoPreRedeTreinada() {
		super("ExperimentoPreRedeTreinada", ExperimentoPreRedeTreinada.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoPreRedeTreinada";
	}


	// ***  Operações  ***

	public synchronized void obtemProximoParaResultado(final ObjectCallback<ExperimentoPreRedeTreinada> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadas/obtemProximoParaResultado","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinada.obtemProximoParaResultado");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemProximoParaResultado", params,   new JsonObjectParser<ExperimentoPreRedeTreinada>(this, callback));
	}

	public synchronized void atualizaResultado(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadas/atualizaResultado","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinada.atualizaResultado");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("atualizaResultado", params,   new EmptyResponseParser(callback));
	}

	public synchronized void calculaResultado(int experimentoId ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadas/calculaResultado","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinada.calculaResultado");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("calculaResultado", params,   new EmptyResponseParser(callback));
	}

	public synchronized void calculaResultadoControle(int experimentoId ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadas/calculaResultadoControle","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinada.calculaResultadoControle");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("calculaResultadoControle", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<ExperimentoPreRedeTreinada> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExperimentoPreRedeTreinada item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

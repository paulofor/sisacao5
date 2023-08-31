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

import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaControle;

public class RepositorioExperimentoPreRedeTreinadaControle extends ModelRepository<ExperimentoPreRedeTreinadaControle> {

	public RepositorioExperimentoPreRedeTreinadaControle() {
		super("ExperimentoPreRedeTreinadaControle", ExperimentoPreRedeTreinadaControle.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoPreRedeTreinadaControle";
	}


	// ***  Operações  ***

	public synchronized void obtemEscolhaPorDia(int diaNum ,int experimentoId ,final ListCallback<ExperimentoPreRedeTreinadaControle> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaControles/obtemEscolhaPorDia","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaControle.obtemEscolhaPorDia");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("obtemEscolhaPorDia", params,   new JsonArrayParser<ExperimentoPreRedeTreinadaControle>(this, callback));
	}

	public synchronized void atualizaResultadoTrade(ExperimentoPreRedeTreinadaControle resultado ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaControles/atualizaResultadoTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaControle.atualizaResultadoTrade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resultado", resultado.getJSON());
		invokeStaticMethod("atualizaResultadoTrade", params,   new EmptyResponseParser(callback));
	}

	public synchronized void recebePrevisaoPreRedeTreinada(List<ExperimentoPreRedeTreinadaControle> ticker ,List<ExperimentoPreRedeTreinadaControle> experimentoPreRedeTreinadaId ,List<ExperimentoPreRedeTreinadaControle> diaNum ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaControles/recebePrevisaoPreRedeTreinada","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaControle.recebePrevisaoPreRedeTreinada");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker",obtemLista(ticker));
		params.put("experimentoPreRedeTreinadaId",obtemLista(experimentoPreRedeTreinadaId));
		params.put("diaNum",obtemLista(diaNum));
		invokeStaticMethod("recebePrevisaoPreRedeTreinada", params,   new EmptyResponseParser(callback));
	}

	public synchronized void insere(ExperimentoPreRedeTreinadaControle controle ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaControles/insere","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaControle.insere");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("controle", controle.getJSON());
		invokeStaticMethod("insere", params,   new EmptyResponseParser(callback));
	}

	public synchronized void reinicializaExperimento(int experimentoId ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaControles/reinicializaExperimento","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaControle.reinicializaExperimento");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("reinicializaExperimento", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<ExperimentoPreRedeTreinadaControle> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExperimentoPreRedeTreinadaControle item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

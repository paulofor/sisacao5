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

import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaScore;

public class RepositorioExperimentoPreRedeTreinadaScore extends ModelRepository<ExperimentoPreRedeTreinadaScore> {

	public RepositorioExperimentoPreRedeTreinadaScore() {
		super("ExperimentoPreRedeTreinadaScore", ExperimentoPreRedeTreinadaScore.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoPreRedeTreinadaScore";
	}


	// ***  Operações  ***

	public synchronized void recebePrevisaoPreRedeTreinada(List<ExperimentoPreRedeTreinadaScore> ticker ,List<ExperimentoPreRedeTreinadaScore> score ,List<ExperimentoPreRedeTreinadaScore> experimentoPreRedeTreinadaId ,List<ExperimentoPreRedeTreinadaScore> diaNum ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaScores/recebePrevisaoPreRedeTreinada","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaScore.recebePrevisaoPreRedeTreinada");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker",obtemLista(ticker));
		params.put("score",obtemLista(score));
		params.put("experimentoPreRedeTreinadaId",obtemLista(experimentoPreRedeTreinadaId));
		params.put("diaNum",obtemLista(diaNum));
		invokeStaticMethod("recebePrevisaoPreRedeTreinada", params,   new EmptyResponseParser(callback));
	}

	public synchronized void obtemMelhoresPorDia(int diaNum ,int experimentoId ,final ListCallback<ExperimentoPreRedeTreinadaScore> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaScores/obtemMelhoresPorDia","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaScore.obtemMelhoresPorDia");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("obtemMelhoresPorDia", params,   new JsonArrayParser<ExperimentoPreRedeTreinadaScore>(this, callback));
	}

	public synchronized void atualizaResultadoTrade(ExperimentoPreRedeTreinadaScore resultado ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaScores/atualizaResultadoTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaScore.atualizaResultadoTrade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("resultado", resultado.getJSON());
		invokeStaticMethod("atualizaResultadoTrade", params,   new EmptyResponseParser(callback));
	}

	public synchronized void obtemAleatoriaBaseadaEmMelhores(int diaNum ,int experimentoId ,final ListCallback<ExperimentoPreRedeTreinadaScore> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoPreRedeTreinadaScores/obtemAleatoriaBaseadaEmMelhores","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoPreRedeTreinadaScore.obtemAleatoriaBaseadaEmMelhores");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		params.put("experimentoId", experimentoId);
		invokeStaticMethod("obtemAleatoriaBaseadaEmMelhores", params,   new JsonArrayParser<ExperimentoPreRedeTreinadaScore>(this, callback));
	}


	private JSONArray obtemLista(List<ExperimentoPreRedeTreinadaScore> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExperimentoPreRedeTreinadaScore item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

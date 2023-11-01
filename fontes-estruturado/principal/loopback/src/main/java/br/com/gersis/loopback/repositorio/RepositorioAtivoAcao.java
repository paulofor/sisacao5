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

import br.com.gersis.loopback.modelo.AtivoAcao;

public class RepositorioAtivoAcao extends ModelRepository<AtivoAcao> {

	public RepositorioAtivoAcao() {
		super("AtivoAcao", AtivoAcao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "AtivoAcao";
	}


	// ***  Operações  ***

	public synchronized void listaPorGrupo(int idGrupo ,final ListCallback<AtivoAcao> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoAcaos/listaPorGrupo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaPorGrupo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idGrupo", idGrupo);
		invokeStaticMethod("listaPorGrupo", params,   new JsonArrayParser<AtivoAcao>(this, callback));
	}

	public synchronized void listaPorNomeGrupo(String nomeGrupo ,final ListCallback<AtivoAcao> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoAcaos/listaPorNomeGrupo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaPorNomeGrupo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nomeGrupo", nomeGrupo);
		invokeStaticMethod("listaPorNomeGrupo", params,   new JsonArrayParser<AtivoAcao>(this, callback));
	}

	public synchronized void listaParaIntradayResultado(final ListCallback<AtivoAcao> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoAcaos/listaParaIntradayResultado","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaParaIntradayResultado");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaParaIntradayResultado", params,   new JsonArrayParser<AtivoAcao>(this, callback));
	}

	public synchronized void listaParaInsereExemploSaida(int qtdeDias ,int diaNum ,final ListCallback<AtivoAcao> callback ) {
		RestContractItem contrato = new RestContractItem("AtivoAcaos/listaParaInsereExemploSaida","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaParaInsereExemploSaida");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qtdeDias", qtdeDias);
		params.put("diaNum", diaNum);
		invokeStaticMethod("listaParaInsereExemploSaida", params,   new JsonArrayParser<AtivoAcao>(this, callback));
	}


	private JSONArray obtemLista(List<AtivoAcao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (AtivoAcao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

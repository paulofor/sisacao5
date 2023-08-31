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

import br.com.gersis.loopback.modelo.AmostraDadoSintetico;

public class RepositorioAmostraDadoSintetico extends ModelRepository<AmostraDadoSintetico> {

	public RepositorioAmostraDadoSintetico() {
		super("AmostraDadoSintetico", AmostraDadoSintetico.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "AmostraDadoSintetico";
	}


	// ***  Operações  ***

	public synchronized void listaDisponivelParaPreRedeVersao1(int idVersao ,final ListCallback<AmostraDadoSintetico> callback ) {
		RestContractItem contrato = new RestContractItem("AmostraDadoSinteticos/listaDisponivelParaPreRedeVersao1","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AmostraDadoSintetico.listaDisponivelParaPreRedeVersao1");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idVersao", idVersao);
		invokeStaticMethod("listaDisponivelParaPreRedeVersao1", params,   new JsonArrayParser<AmostraDadoSintetico>(this, callback));
	}

	public synchronized void listaDisponivelParaPreRedeVersao2(int idVersao ,final ListCallback<AmostraDadoSintetico> callback ) {
		RestContractItem contrato = new RestContractItem("AmostraDadoSinteticos/listaDisponivelParaPreRedeVersao2","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AmostraDadoSintetico.listaDisponivelParaPreRedeVersao2");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idVersao", idVersao);
		invokeStaticMethod("listaDisponivelParaPreRedeVersao2", params,   new JsonArrayParser<AmostraDadoSintetico>(this, callback));
	}

	public synchronized void listaDisponivelParaPreRedeVersaoIndice1(int idVersao ,final ListCallback<AmostraDadoSintetico> callback ) {
		RestContractItem contrato = new RestContractItem("AmostraDadoSinteticos/listaDisponivelParaPreRedeVersaoIndice1","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AmostraDadoSintetico.listaDisponivelParaPreRedeVersaoIndice1");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idVersao", idVersao);
		invokeStaticMethod("listaDisponivelParaPreRedeVersaoIndice1", params,   new JsonArrayParser<AmostraDadoSintetico>(this, callback));
	}

	public synchronized void listaDisponivelParaPreRedeVersaoIndice2(int idVersao ,final ListCallback<AmostraDadoSintetico> callback ) {
		RestContractItem contrato = new RestContractItem("AmostraDadoSinteticos/listaDisponivelParaPreRedeVersaoIndice2","GET");
		this.getRestAdapter().getContract().addItem(contrato, "AmostraDadoSintetico.listaDisponivelParaPreRedeVersaoIndice2");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idVersao", idVersao);
		invokeStaticMethod("listaDisponivelParaPreRedeVersaoIndice2", params,   new JsonArrayParser<AmostraDadoSintetico>(this, callback));
	}


	private JSONArray obtemLista(List<AmostraDadoSintetico> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (AmostraDadoSintetico item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

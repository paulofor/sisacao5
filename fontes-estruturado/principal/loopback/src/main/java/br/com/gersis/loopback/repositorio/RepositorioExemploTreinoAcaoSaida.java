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

import br.com.gersis.loopback.modelo.ExemploTreinoAcaoSaida;

public class RepositorioExemploTreinoAcaoSaida extends ModelRepository<ExemploTreinoAcaoSaida> {

	public RepositorioExemploTreinoAcaoSaida() {
		super("ExemploTreinoAcaoSaida", ExemploTreinoAcaoSaida.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaoSaida";
	}


	// ***  Operações  ***

	public synchronized void listaParaTreino(final ListCallback<ExemploTreinoAcaoSaida> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoSaidas/listaParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoSaida.listaParaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaParaTreino", params,   new JsonArrayParser<ExemploTreinoAcaoSaida>(this, callback));
	}


	private JSONArray obtemLista(List<ExemploTreinoAcaoSaida> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExemploTreinoAcaoSaida item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

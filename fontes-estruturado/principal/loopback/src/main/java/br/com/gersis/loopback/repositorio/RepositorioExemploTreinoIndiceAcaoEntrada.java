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

import br.com.gersis.loopback.modelo.ExemploTreinoIndiceAcaoEntrada;

public class RepositorioExemploTreinoIndiceAcaoEntrada extends ModelRepository<ExemploTreinoIndiceAcaoEntrada> {

	public RepositorioExemploTreinoIndiceAcaoEntrada() {
		super("ExemploTreinoIndiceAcaoEntrada", ExemploTreinoIndiceAcaoEntrada.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoIndiceAcaoEntrada";
	}


	// ***  Operações  ***

	public synchronized void listaParaTreinoIndice(int diaNumInicio ,int diaNumFinal ,int idTipoExemplo ,final ListCallback<ExemploTreinoIndiceAcaoEntrada> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoIndiceAcaoEntradas/listaParaTreinoIndice","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoIndiceAcaoEntrada.listaParaTreinoIndice");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNumInicio", diaNumInicio);
		params.put("diaNumFinal", diaNumFinal);
		params.put("idTipoExemplo", idTipoExemplo);
		invokeStaticMethod("listaParaTreinoIndice", params,   new JsonArrayParser<ExemploTreinoIndiceAcaoEntrada>(this, callback));
	}


	private JSONArray obtemLista(List<ExemploTreinoIndiceAcaoEntrada> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExemploTreinoIndiceAcaoEntrada item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

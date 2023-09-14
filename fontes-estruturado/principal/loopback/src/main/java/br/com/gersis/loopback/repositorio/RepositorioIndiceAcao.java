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

import br.com.gersis.loopback.modelo.IndiceAcao;

public class RepositorioIndiceAcao extends ModelRepository<IndiceAcao> {

	public RepositorioIndiceAcao() {
		super("IndiceAcao", IndiceAcao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "IndiceAcao";
	}


	// ***  Operações  ***

	public synchronized void listaIntradayResultado(final ListCallback<IndiceAcao> callback ) {
		RestContractItem contrato = new RestContractItem("IndiceAcaos/listaIntradayResultado","GET");
		this.getRestAdapter().getContract().addItem(contrato, "IndiceAcao.listaIntradayResultado");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaIntradayResultado", params,   new JsonArrayParser<IndiceAcao>(this, callback));
	}


	private JSONArray obtemLista(List<IndiceAcao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (IndiceAcao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

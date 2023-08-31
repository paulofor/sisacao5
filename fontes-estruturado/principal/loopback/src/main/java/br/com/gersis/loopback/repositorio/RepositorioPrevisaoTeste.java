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

import br.com.gersis.loopback.modelo.PrevisaoTeste;

public class RepositorioPrevisaoTeste extends ModelRepository<PrevisaoTeste> {

	public RepositorioPrevisaoTeste() {
		super("PrevisaoTeste", PrevisaoTeste.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PrevisaoTeste";
	}


	// ***  Operações  ***

	public synchronized void atualizaResultadoTeste(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("PrevisaoTestes/atualizaResultadoTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "PrevisaoTeste.atualizaResultadoTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("atualizaResultadoTeste", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<PrevisaoTeste> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (PrevisaoTeste item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

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

import br.com.gersis.loopback.modelo.RegraProjecaoReversao;

public class RepositorioRegraProjecaoReversao extends ModelRepository<RegraProjecaoReversao> {

	public RepositorioRegraProjecaoReversao() {
		super("RegraProjecaoReversao", RegraProjecaoReversao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RegraProjecaoReversao";
	}


	// ***  Operações  ***

	public synchronized void listaExecucaoDia(final ListCallback<RegraProjecaoReversao> callback ) {
		RestContractItem contrato = new RestContractItem("RegraProjecaoReversaos/listaExecucaoDia","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecaoReversao.listaExecucaoDia");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaExecucaoDia", params,   new JsonArrayParser<RegraProjecaoReversao>(this, callback));
	}


	private JSONArray obtemLista(List<RegraProjecaoReversao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (RegraProjecaoReversao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

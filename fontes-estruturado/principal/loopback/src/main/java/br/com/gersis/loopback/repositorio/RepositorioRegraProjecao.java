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

import br.com.gersis.loopback.modelo.RegraProjecao;

public class RepositorioRegraProjecao extends ModelRepository<RegraProjecao> {

	public RepositorioRegraProjecao() {
		super("RegraProjecao", RegraProjecao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RegraProjecao";
	}


	// ***  Operações  ***

	public synchronized void proximoParaProcessamento(final ObjectCallback<RegraProjecao> callback ) {
		RestContractItem contrato = new RestContractItem("RegraProjecaos/proximoParaProcessamento","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecao.proximoParaProcessamento");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("proximoParaProcessamento", params,   new JsonObjectParser<RegraProjecao>(this, callback));
	}


	private JSONArray obtemLista(List<RegraProjecao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (RegraProjecao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

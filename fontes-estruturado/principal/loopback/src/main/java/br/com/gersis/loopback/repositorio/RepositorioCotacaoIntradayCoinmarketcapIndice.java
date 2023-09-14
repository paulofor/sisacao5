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

import br.com.gersis.loopback.modelo.CotacaoIntradayCoinmarketcapIndice;

public class RepositorioCotacaoIntradayCoinmarketcapIndice extends ModelRepository<CotacaoIntradayCoinmarketcapIndice> {

	public RepositorioCotacaoIntradayCoinmarketcapIndice() {
		super("CotacaoIntradayCoinmarketcapIndice", CotacaoIntradayCoinmarketcapIndice.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "CotacaoIntradayCoinmarketcapIndice";
	}


	// ***  Operações  ***

	public synchronized void insere(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("CotacaoIntradayCoinmarketcapIndices/insere","POST");
		this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayCoinmarketcapIndice.insere");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("insere", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<CotacaoIntradayCoinmarketcapIndice> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (CotacaoIntradayCoinmarketcapIndice item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

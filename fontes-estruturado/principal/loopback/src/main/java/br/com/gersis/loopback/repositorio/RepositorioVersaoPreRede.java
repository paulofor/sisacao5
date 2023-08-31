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

import br.com.gersis.loopback.modelo.VersaoPreRede;

public class RepositorioVersaoPreRede extends ModelRepository<VersaoPreRede> {

	public RepositorioVersaoPreRede() {
		super("VersaoPreRede", VersaoPreRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "VersaoPreRede";
	}


	// ***  Operações  ***

	public synchronized void gerarRedeRegra(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("VersaoPreRedes/gerarRedeRegra","POST");
		this.getRestAdapter().getContract().addItem(contrato, "VersaoPreRede.gerarRedeRegra");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("gerarRedeRegra", params,   new EmptyResponseParser(callback));
	}

	public synchronized void criaRedeNeural(int idVersao ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("VersaoPreRedes/criaRedeNeural","POST");
		this.getRestAdapter().getContract().addItem(contrato, "VersaoPreRede.criaRedeNeural");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idVersao", idVersao);
		invokeStaticMethod("criaRedeNeural", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<VersaoPreRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (VersaoPreRede item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

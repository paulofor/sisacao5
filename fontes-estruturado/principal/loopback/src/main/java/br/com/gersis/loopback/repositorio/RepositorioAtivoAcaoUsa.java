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

import br.com.gersis.loopback.modelo.AtivoAcaoUsa;

public class RepositorioAtivoAcaoUsa extends ModelRepository<AtivoAcaoUsa> {

	public RepositorioAtivoAcaoUsa() {
		super("AtivoAcaoUsa", AtivoAcaoUsa.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "AtivoAcaoUsa";
	}


	// ***  Operações  ***

	public synchronized void insereSeNaoExiste(AtivoAcaoUsa ativo ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("AtivoAcaoUsas/insereSeNaoExiste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "AtivoAcaoUsa.insereSeNaoExiste");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ativo", ativo.getJSON());
		invokeStaticMethod("insereSeNaoExiste", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<AtivoAcaoUsa> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (AtivoAcaoUsa item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

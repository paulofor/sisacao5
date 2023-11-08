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

import br.com.gersis.loopback.modelo.TipoExemploTreino;

public class RepositorioTipoExemploTreino extends ModelRepository<TipoExemploTreino> {

	public RepositorioTipoExemploTreino() {
		super("TipoExemploTreino", TipoExemploTreino.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TipoExemploTreino";
	}


	// ***  Operações  ***

	public synchronized void listaGeraExemplo(final ListCallback<TipoExemploTreino> callback ) {
		RestContractItem contrato = new RestContractItem("TipoExemploTreinos/listaGeraExemplo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TipoExemploTreino.listaGeraExemplo");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaGeraExemplo", params,   new JsonArrayParser<TipoExemploTreino>(this, callback));
	}

	public synchronized void atualizaDiaNumExemplo(int idTipoExemplo ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TipoExemploTreinos/atualizaDiaNumExemplo","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TipoExemploTreino.atualizaDiaNumExemplo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTipoExemplo", idTipoExemplo);
		invokeStaticMethod("atualizaDiaNumExemplo", params,   new EmptyResponseParser(callback));
	}

	public synchronized void atualizaDiaNumExemploAtivo(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TipoExemploTreinos/atualizaDiaNumExemploAtivo","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TipoExemploTreino.atualizaDiaNumExemploAtivo");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("atualizaDiaNumExemploAtivo", params,   new EmptyResponseParser(callback));
	}

	public synchronized void listaGeraExemploIndice(final ListCallback<TipoExemploTreino> callback ) {
		RestContractItem contrato = new RestContractItem("TipoExemploTreinos/listaGeraExemploIndice","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TipoExemploTreino.listaGeraExemploIndice");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("listaGeraExemploIndice", params,   new JsonArrayParser<TipoExemploTreino>(this, callback));
	}


	private JSONArray obtemLista(List<TipoExemploTreino> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (TipoExemploTreino item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

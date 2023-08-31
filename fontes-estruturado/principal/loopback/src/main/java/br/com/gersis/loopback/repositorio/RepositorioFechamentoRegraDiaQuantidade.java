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

import br.com.gersis.loopback.modelo.FechamentoRegraDiaQuantidade;

public class RepositorioFechamentoRegraDiaQuantidade extends ModelRepository<FechamentoRegraDiaQuantidade> {

	public RepositorioFechamentoRegraDiaQuantidade() {
		super("FechamentoRegraDiaQuantidade", FechamentoRegraDiaQuantidade.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "FechamentoRegraDiaQuantidade";
	}


	// ***  Operações  ***

	public synchronized void criaParaFechamentoRegra(int idFechamentoRegra ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("FechamentoRegraDiaQuantidades/criaParaFechamentoRegra","POST");
		this.getRestAdapter().getContract().addItem(contrato, "FechamentoRegraDiaQuantidade.criaParaFechamentoRegra");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idFechamentoRegra", idFechamentoRegra);
		invokeStaticMethod("criaParaFechamentoRegra", params,   new EmptyResponseParser(callback));
	}

	public synchronized void atualizaParaFechamentoRegra(int idFechamentoRegra ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("FechamentoRegraDiaQuantidades/atualizaParaFechamentoRegra","POST");
		this.getRestAdapter().getContract().addItem(contrato, "FechamentoRegraDiaQuantidade.atualizaParaFechamentoRegra");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idFechamentoRegra", idFechamentoRegra);
		invokeStaticMethod("atualizaParaFechamentoRegra", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<FechamentoRegraDiaQuantidade> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (FechamentoRegraDiaQuantidade item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

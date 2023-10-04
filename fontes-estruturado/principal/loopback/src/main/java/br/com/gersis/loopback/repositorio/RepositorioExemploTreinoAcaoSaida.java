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

import br.com.gersis.loopback.modelo.ExemploTreinoAcaoSaida;

public class RepositorioExemploTreinoAcaoSaida extends ModelRepository<ExemploTreinoAcaoSaida> {

	public RepositorioExemploTreinoAcaoSaida() {
		super("ExemploTreinoAcaoSaida", ExemploTreinoAcaoSaida.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaoSaida";
	}


	// ***  Operações  ***

	public synchronized void listaParaTreinoEntradaSaida(int diaNumInicio ,int diaNumFinal ,int idGrupoAcao ,int idRegraProjecao ,int idTipoExemplo ,final ListCallback<ExemploTreinoAcaoSaida> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoSaidas/listaParaTreinoEntradaSaida","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoSaida.listaParaTreinoEntradaSaida");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNumInicio", diaNumInicio);
		params.put("diaNumFinal", diaNumFinal);
		params.put("idGrupoAcao", idGrupoAcao);
		params.put("idRegraProjecao", idRegraProjecao);
		params.put("idTipoExemplo", idTipoExemplo);
		invokeStaticMethod("listaParaTreinoEntradaSaida", params,   new JsonArrayParser<ExemploTreinoAcaoSaida>(this, callback));
	}

	public synchronized void insereExemploSaida(ExemploTreinoAcaoSaida exemplo ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoSaidas/insereExemploSaida","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoSaida.insereExemploSaida");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("exemplo", exemplo.getJSON());
		invokeStaticMethod("insereExemploSaida", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<ExemploTreinoAcaoSaida> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExemploTreinoAcaoSaida item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

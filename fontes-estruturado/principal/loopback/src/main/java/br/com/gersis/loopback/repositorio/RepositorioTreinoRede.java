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

import br.com.gersis.loopback.modelo.TreinoRede;

public class RepositorioTreinoRede extends ModelRepository<TreinoRede> {

	public RepositorioTreinoRede() {
		super("TreinoRede", TreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TreinoRede";
	}


	// ***  Operações  ***

	public synchronized void desligaTesteGrupo(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/desligaTesteGrupo","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.desligaTesteGrupo");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("desligaTesteGrupo", params,   new EmptyResponseParser(callback));
	}

	public synchronized void alteraAtivaTeste(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/alteraAtivaTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.alteraAtivaTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("alteraAtivaTeste", params,   new EmptyResponseParser(callback));
	}

	public synchronized void executouDadoTeste(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/executouDadoTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.executouDadoTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("executouDadoTeste", params,   new EmptyResponseParser(callback));
	}

	public synchronized void obtemListaPrevisaoTeste(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaPrevisaoTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaPrevisaoTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemListaPrevisaoTeste", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}

	public synchronized void executouPrevisaoTeste(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/executouPrevisaoTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.executouPrevisaoTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("executouPrevisaoTeste", params,   new EmptyResponseParser(callback));
	}

	public synchronized void obtemListaParaTeste(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaParaTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaParaTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemListaParaTeste", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}

	public synchronized void obtemListaParaTreino(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaParaTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemListaParaTreino", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}

	public synchronized void executouTreinamento(int id ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/executouTreinamento","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.executouTreinamento");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		invokeStaticMethod("executouTreinamento", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<TreinoRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (TreinoRede item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

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

import br.com.gersis.loopback.modelo.ExemploTreinoAcaoEntrada;

public class RepositorioExemploTreinoAcaoEntrada extends ModelRepository<ExemploTreinoAcaoEntrada> {

	public RepositorioExemploTreinoAcaoEntrada() {
		super("ExemploTreinoAcaoEntrada", ExemploTreinoAcaoEntrada.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaoEntrada";
	}


	// ***  Operações  ***

	public synchronized void obtemPorDiaTicker(int diaNum ,String ticker ,final ListCallback<ExemploTreinoAcaoEntrada> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoEntradas/obtemPorDiaTicker","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoEntrada.obtemPorDiaTicker");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		params.put("ticker", ticker);
		invokeStaticMethod("obtemPorDiaTicker", params,   new JsonArrayParser<ExemploTreinoAcaoEntrada>(this, callback));
	}

	public synchronized void obtemPorDiaNum(final ListCallback<ExemploTreinoAcaoEntrada> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoEntradas/obtemPorDiaNum","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoEntrada.obtemPorDiaNum");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemPorDiaNum", params,   new JsonArrayParser<ExemploTreinoAcaoEntrada>(this, callback));
	}

	public synchronized void listaSemResultadoSimples(String ticker ,int regraId ,final ListCallback<ExemploTreinoAcaoEntrada> callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoEntradas/listaSemResultadoSimples","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoEntrada.listaSemResultadoSimples");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("regraId", regraId);
		invokeStaticMethod("listaSemResultadoSimples", params,   new JsonArrayParser<ExemploTreinoAcaoEntrada>(this, callback));
	}

	public synchronized void insereExemploEntrada(ExemploTreinoAcaoEntrada exemplo ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoEntradas/insereExemploEntrada","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoEntrada.insereExemploEntrada");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("exemplo", exemplo.getJSON());
		invokeStaticMethod("insereExemploEntrada", params,   new EmptyResponseParser(callback));
	}


	private JSONArray obtemLista(List<ExemploTreinoAcaoEntrada> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (ExemploTreinoAcaoEntrada item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

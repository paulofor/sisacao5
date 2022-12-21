package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.RendaFixaPrivada;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;

public class RepositorioTradeTreinoRede extends ModelRepository<TradeTreinoRede>{

	public RepositorioTradeTreinoRede() {
		super("TradeTreinoRede", TradeTreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TradeTreinoRedes";
	}
	
	public void atualizaTreino(final List<TradeTreinoRede> trades, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("TradeTreinoRedes/atualizaTreino","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TradeTreinoRede.atualizaTreino");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("listaTrade", obtemLista(trades));
        invokeStaticMethod("atualizaTreino", params,    new EmptyResponseParser(callback));
	}
	private JSONArray obtemLista(List<TradeTreinoRede> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (TradeTreinoRede item : listaEntrada) {
			lista.put(item.getJson());
		}
		return lista;
	}
	
	public void insereTrade(final TradeTreinoRede trade, final ObjectCallback<TradeTreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TradeTreinoRedes/insereTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TradeTreinoRede.insereTrade");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("item", trade.getJsonEstrada());
        invokeStaticMethod("insereTrade", params,   new JsonObjectParser<TradeTreinoRede>(this, callback));
	}
	

	public void finalizaTrade(final TradeTreinoRede trade, final ObjectCallback<TradeTreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TradeTreinoRedes/finalizaTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TradeTreinoRede.finalizaTrade");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("item", trade.getJsonSaida());
        invokeStaticMethod("finalizaTrade", params,   new JsonObjectParser<TradeTreinoRede>(this, callback));
	}
	
	public void atualizaTrade(final ObjectCallback<TradeTreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TradeTreinoRedes/atualizaTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TradeTreinoRede.atualizaTrade");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("atualizaTrade", params,   new JsonObjectParser<TradeTreinoRede>(this, callback));
	}
}

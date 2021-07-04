package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.RendaFixa;

public class RepositorioRendaFixa extends ModelRepository<RendaFixa>{

	
	public RepositorioRendaFixa() {
		super("RendaFixa", RendaFixa.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RendaFixas";
	}
	
	public void insereSeNaoExisteFixa(List<RendaFixa> listaItem, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("RendaFixa/insereSeNaoExisteFixa","POST");
		this.getRestAdapter().getContract().addItem(contrato, "RendaFixa.insereSeNaoExisteFixa");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("listaItem", obtemLista(listaItem))
        invokeStaticMethod("insereSeNaoExisteFixa", params,   new EmptyResponseParser(voidCallback));
	}
	
	private JSONArray obtemLista(List<RendaFixa> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (RendaFixa item : listaEntrada) {
			lista.put(item.getJSON());
		}
	}
}

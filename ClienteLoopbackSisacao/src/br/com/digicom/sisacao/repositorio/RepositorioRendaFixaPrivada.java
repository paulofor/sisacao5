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
import br.com.digicom.sisacao.modelo.RendaFixaPrivada;

public class RepositorioRendaFixaPrivada extends ModelRepository<RendaFixaPrivada>{

	
	public RepositorioRendaFixaPrivada() {
		super("RendaFixaPrivada", RendaFixaPrivada.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RendaFixaPrivadas";
	}
	
	public void insereSeNaoExisteFixaPrivada(List<RendaFixaPrivada> listaItem, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("RendaFixaPrivadas/insereSeNaoExisteFixaPrivada","POST");
		this.getRestAdapter().getContract().addItem(contrato, "RendaFixaPrivada.insereSeNaoExisteFixaPrivada");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("listaItem", obtemLista(listaItem));
        invokeStaticMethod("insereSeNaoExisteFixaPrivada", params,   new EmptyResponseParser(voidCallback));
	}
	
	private JSONArray obtemLista(List<RendaFixaPrivada> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (RendaFixaPrivada item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

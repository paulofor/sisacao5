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
import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;

public class RepositorioTesouroDiretoCotacao extends ModelRepository<TesouroDiretoCotacao>{

	
	public RepositorioTesouroDiretoCotacao() {
		super("TesouroDiretoCotacao", TesouroDiretoCotacao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TesouroDiretoCotacaos";
	}
	
	public void insereLista(List<TesouroDiretoCotacao> listaItem, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("TesouroDiretoCotacaos/insereLista","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TesouroDiretoCotacao.insereLista");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("listaItem", obtemLista(listaItem));
        invokeStaticMethod("insereLista", params,   new EmptyResponseParser(voidCallback));
	}
	
	private JSONArray obtemLista(List<TesouroDiretoCotacao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (TesouroDiretoCotacao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

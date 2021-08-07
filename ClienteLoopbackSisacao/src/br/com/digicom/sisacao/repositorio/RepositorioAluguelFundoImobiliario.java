package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AluguelFundoImobiliario;

public class RepositorioAluguelFundoImobiliario  extends ModelRepository<AluguelFundoImobiliario>{

	public RepositorioAluguelFundoImobiliario() {
		super("AluguelFundoImobiliario", AluguelFundoImobiliario.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "AluguelFundoImobiliarios";
	}
	
	public void insereSeNaoExisteAluguelFundo(final List<AluguelFundoImobiliario> listaAluguel, final ObjectCallback<AluguelFundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("AluguelFundoImobiliarios/insereSeNaoExisteAluguelFundo","POST");
		this.getRestAdapter().getContract().addItem(contrato, "AluguelFundoImobiliario.insereSeNaoExisteAluguelFundo");
        Map<String, Object> params = new HashMap<String, Object>();
        JSONArray listaItem = new JSONArray();
        //for (AluguelFundoImobiliario aluguel : listaAluguel) {
        //	listaItem.put(aluguel.getJSON());
        //}
        //params.put("listaItem", listaItem);
        params.put("listaItem", listaItem);
        invokeStaticMethod("insereSeNaoExisteAluguelFundo", params,   new JsonObjectParser<AluguelFundoImobiliario>(this, callback));
	}
	public void insereSeNaoExisteItemAluguel(final AluguelFundoImobiliario itemAluguel, final ObjectCallback<AluguelFundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("AluguelFundoImobiliarios/insereSeNaoExisteItemAluguel","POST");
		this.getRestAdapter().getContract().addItem(contrato, "AluguelFundoImobiliario.insereSeNaoExisteItemAluguel");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("itemAluguel", itemAluguel.getJSON());
        invokeStaticMethod("insereSeNaoExisteItemAluguel", params,   new JsonObjectParser<AluguelFundoImobiliario>(this, callback));
	}

}

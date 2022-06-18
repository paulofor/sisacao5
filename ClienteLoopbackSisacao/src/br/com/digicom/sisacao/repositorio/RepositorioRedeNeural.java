package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.RedeNeural;

public class RepositorioRedeNeural extends ModelRepository<RedeNeural>{

	public RepositorioRedeNeural() {
		super("RedeNeural", RedeNeural.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RedeNeurals";
	}
	
	
	public void obtemListaTreino(final ListCallback<RedeNeural> callback ) {
		RestContractItem contrato = new RestContractItem("RedeNeurals/obtemListaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RedeNeural.obtemListaTreino");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaTreino", params,   new JsonArrayParser<RedeNeural>(this, callback));
	}
	
}

package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.com.digicom.sisacao.modelo.TreinoRede;

public class RepositorioTreinoRede extends ModelRepository<TreinoRede>{

	public RepositorioTreinoRede() {
		super("TreinoRede", TreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TreinoRedes";
	}
	
	
	
	public void obtemListaParaTreino(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaParaTreino");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaParaTreino", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}
	
	public void obtemListaPrevisaoTeste(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaPrevisaoTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaPrevisaoTeste");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaPrevisaoTeste", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}

}

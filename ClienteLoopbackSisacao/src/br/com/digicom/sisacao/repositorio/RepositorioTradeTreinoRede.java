package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AluguelFundoImobiliario;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;

public class RepositorioTradeTreinoRede extends ModelRepository<TradeTreinoRede>{

	public RepositorioTradeTreinoRede() {
		super("TradeTreinoRede", TradeTreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TradeTreinoRedes";
	}
	
	public void insereTrade(final TradeTreinoRede trade, final ObjectCallback<TradeTreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("AluguelFundoImobiliarios/insereTrade","POST");
		this.getRestAdapter().getContract().addItem(contrato, "AluguelFundoImobiliario.insereTrade");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("item", trade.getJsonEstrada());
        invokeStaticMethod("insereTrade", params,   new JsonObjectParser<TradeTreinoRede>(this, callback));
	}
}

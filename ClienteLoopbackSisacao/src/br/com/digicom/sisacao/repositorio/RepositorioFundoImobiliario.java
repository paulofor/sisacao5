package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.FundoImobiliario;

public class RepositorioFundoImobiliario  extends ModelRepository<FundoImobiliario>{

	public RepositorioFundoImobiliario() {
		super("FundoImobiliario", FundoImobiliario.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "FundoImobiliarios";
	}
	
	public void insereSeNaoExiste(final FundoImobiliario fundo, final ObjectCallback<FundoImobiliario> callback ) {
		RestContractItem contrato = new RestContractItem("FundoImobiliarios/insereSeNaoExiste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "FundoImobiliario.insereSeNaoExiste");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("fundo", fundo.jSON());
        invokeStaticMethod("insereSeNaoExiste", params,   new JsonObjectParser<FundoImobiliario>(this, callback));
	}

}

package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.PontoEntradaSimulacao;

public class RepositorioPontoEntradaSimulacao extends ModelRepository<PontoEntradaSimulacao>{

	public RepositorioPontoEntradaSimulacao() {
		super("PontoEntradaSimulacao", PontoEntradaSimulacao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PontoEntradaSimulacaos";
	}
	
	
	public void preparaProximoDia(final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("PontoEntradaSimulacaos/preparaProximoDia","POST");
		this.getRestAdapter().getContract().addItem(contrato, "PontoEntradaSimulacao.preparaProximoDia");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("preparaProximoDia", params,   new EmptyResponseParser(callback));
	}
	
}

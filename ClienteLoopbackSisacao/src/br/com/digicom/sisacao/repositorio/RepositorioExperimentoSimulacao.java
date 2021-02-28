package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;

public class RepositorioExperimentoSimulacao extends ModelRepository<ExperimentoSimulacao>{

	public RepositorioExperimentoSimulacao() {
		super("ExperimentoSimulacao", ExperimentoSimulacao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExperimentoSimulacaos";
	}
	
	public void carregaParaSimulacao(long idExperimento, final ObjectCallback<ExperimentoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoSimulacaos/carregaParaSimulacao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoSimulacao.carregaParaSimulacao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("carregaParaSimulacao", params,   new JsonObjectParser<ExperimentoSimulacao>(this, callback));
	}
}

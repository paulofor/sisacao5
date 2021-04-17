package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
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
	
	public void carregaParaSimulacao(final long idExperimento, final ObjectCallback<ExperimentoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoSimulacaos/carregaParaSimulacao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoSimulacao.carregaParaSimulacao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("carregaParaSimulacao", params,   new JsonObjectParser<ExperimentoSimulacao>(this, callback));
	}
	public void obtemParaSimulacao(final ObjectCallback<ExperimentoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoSimulacaos/obtemParaSimulacao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoSimulacao.obtemParaSimulacao");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemParaSimulacao", params,   new JsonObjectParser<ExperimentoSimulacao>(this, callback));
	}
	
	public void fechaExperimento(final long idExperimento,  final VoidCallback voidCallback) {
		RestContractItem contrato = new RestContractItem("ExperimentoSimulacaos/fechaExperimento","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoSimulacao.fechaExperimento");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("fechaExperimento", params,   new EmptyResponseParser(voidCallback));
	}
}

package br.com.digicom.sisacao.repositorio;

import com.strongloop.android.loopback.ModelRepository;

import br.com.digicom.sisacao.modelo.ExemploTreino;

public class RepositorioExemploTreino extends ModelRepository<ExemploTreino>{

	public RepositorioExemploTreino() {
		super("ExemploTreino", ExemploTreino.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinos";
	}
	
	/*
	public void carregaParaSimulacao(final long idExperimento, final ObjectCallback<ExemploTreino> callback ) {
		RestContractItem contrato = new RestContractItem("ExperimentoSimulacaos/carregaParaSimulacao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExperimentoSimulacao.carregaParaSimulacao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("carregaParaSimulacao", params,   new JsonObjectParser<ExemploTreino>(this, callback));
	}
	*/

}

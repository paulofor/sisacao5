package br.com.digicom.sisacao.repositorio;

import com.strongloop.android.loopback.ModelRepository;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;

public class RepositorioExemploTreinoAcao extends ModelRepository<ExemploTreinoAcao>{

	public RepositorioExemploTreinoAcao() {
		super("ExemploTreinoAcao", ExemploTreinoAcao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaos";
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

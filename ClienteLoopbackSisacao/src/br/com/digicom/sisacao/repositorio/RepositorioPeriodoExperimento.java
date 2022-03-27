package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.PeriodoExperimento;

public class RepositorioPeriodoExperimento  extends ModelRepository<PeriodoExperimento>{

	public RepositorioPeriodoExperimento() {
		super("PeriodoExperimento", PeriodoExperimento.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PeriodoExperimentos";
	}
	
	public void obtemPeriodoParaExecucao(final int id, final ObjectCallback<PeriodoExperimento> callback ) {
		RestContractItem contrato = new RestContractItem("PeriodoExperimentos/obtemPeriodoParaExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "PeriodoExperimento.obtemPeriodoParaExecucao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento",id);
        invokeStaticMethod("obtemPeriodoParaExecucao", params,   new JsonObjectParser<PeriodoExperimento>(this, callback));
	}
	
	
	
}

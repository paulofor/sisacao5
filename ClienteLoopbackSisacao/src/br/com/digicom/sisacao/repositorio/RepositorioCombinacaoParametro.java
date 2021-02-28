package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.DiaPregao;

public class RepositorioCombinacaoParametro extends ModelRepository<CombinacaoParametro>{

	public RepositorioCombinacaoParametro() {
		super("CombinacaoParametro", CombinacaoParametro.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "CombinacaoParametros";
	}
	
	public void getProximoExecucao(long idExperimento, final ObjectCallback<CombinacaoParametro> callback ) {
		RestContractItem contrato = new RestContractItem("CombinacaoParametros/getProximoExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "CombinacaoParametro.getProximoExecucao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("getProximoExecucao", params,   new JsonObjectParser<CombinacaoParametro>(this, callback));
	}

}

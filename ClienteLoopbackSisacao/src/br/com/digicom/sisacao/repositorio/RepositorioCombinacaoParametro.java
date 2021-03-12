package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.CombinacaoParametro;

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

	public void getListaExecucao(long idExperimento, final ListCallback<CombinacaoParametro> callback ) {
		RestContractItem contrato = new RestContractItem("CombinacaoParametros/getListaExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "CombinacaoParametro.getListaExecucao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExperimento", idExperimento);
        invokeStaticMethod("getListaExecucao", params,   new JsonArrayParser<CombinacaoParametro>(this, callback));
	}
	
	public void alteraDescricao(long idCombinacao, String descricao, final VoidCallback voidCallback) {
		RestContractItem contrato = new RestContractItem("CombinacaoParametros/alteraDescricao","POST");
		this.getRestAdapter().getContract().addItem(contrato, "CombinacaoParametro.alteraDescricao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", idCombinacao);
        params.put("descricao", descricao);
        invokeStaticMethod("alteraDescricao", params,   new EmptyResponseParser(voidCallback));
	}
}

package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacaoValidacao;

public class RepositorioExecucaoSimulacaoValidacao extends ModelRepository<ExecucaoSimulacao>{

	public RepositorioExecucaoSimulacaoValidacao() {
		super("ExecucaoSimulacaoValidacao", ExecucaoSimulacao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExecucaoSimulacaoValidacaos";
	}
	
	public void insereExecucaoSimulacaoValidacao(ExecucaoSimulacaoValidacao execucao, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("ExecucaoSimulacaoValidacaos/insereExecucaoSimulacaoValidacao","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExecucaoSimulacaoValidacao.insereExecucaoSimulacaoValidacao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("execucao", execucao.jSON());
        invokeStaticMethod("insereExecucaoSimulacaoValidacao", params,   new EmptyResponseParser(voidCallback));
        execucao = null;
	}
	
	/*
	public void obtemMonitorarPorId(final int id, final ObjectCallback<ExecucaoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExecucaoSimulacaos/obtemMonitorarPorId","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExecucaoSimulacao.obtemMonitorarPorId");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idExecucao",id);
        invokeStaticMethod("obtemMonitorarPorId", params,   new JsonObjectParser<ExecucaoSimulacao>(this, callback));
	}
	
	public void listaMonitorar(final ListCallback<ExecucaoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExecucaoSimulacaos/listaMonitorar","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExecucaoSimulacao.listaMonitorar");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("listaMonitorar", params,   new JsonArrayParser<ExecucaoSimulacao>(this, callback));
	}
	
	public void obtemProximoMonitorar(final ObjectCallback<ExecucaoSimulacao> callback ) {
		RestContractItem contrato = new RestContractItem("ExecucaoSimulacaos/obtemProximoMonitorar","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExecucaoSimulacao.obtemProximoMonitorar");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemProximoMonitorar", params,   new JsonObjectParser<ExecucaoSimulacao>(this, callback));
	}
	*/
	
}

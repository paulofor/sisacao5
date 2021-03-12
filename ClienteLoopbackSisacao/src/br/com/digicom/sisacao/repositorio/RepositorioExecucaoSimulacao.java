package br.com.digicom.sisacao.repositorio;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestAdapter;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;

public class RepositorioExecucaoSimulacao extends ModelRepository<ExecucaoSimulacao>{

	public RepositorioExecucaoSimulacao() {
		super("ExecucaoSimulacao", ExecucaoSimulacao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExecucaoSimulacaos";
	}
	
	public void insereExecucaoSimulacao(ExecucaoSimulacao execucao, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("ExecucaoSimulacaos/insereExecucaoSimulacao","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExecucaoSimulacao.insereExecucaoSimulacao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("execucao", execucao.getJSON());
        invokeStaticMethod("insereExecucaoSimulacao", params,   new EmptyResponseParser(voidCallback));
        execucao = null;
	}
	
}

package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ValorMonitoria;

public class RepositorioValorMonitoria extends ModelRepository<ValorMonitoria>{

	public RepositorioValorMonitoria() {
		super("ValorMonitoria", ValorMonitoria.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ValorMonitorias";
	}
	
	public void insereMonitoria(ExecucaoSimulacao execucao, final int diaNum, final Double preco, String tipo, Integer periodoExperimentoId, final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("ValorMonitoria/insereMonitoria","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ValorMonitoria.insereMonitoria");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("execucao", execucao.jSON());
        params.put("diaNum", diaNum);
        params.put("preco", preco);
        params.put("tipo", tipo);
        params.put("periodoExperimentoId" , periodoExperimentoId);
        invokeStaticMethod("insereMonitoria", params,   new EmptyResponseParser(voidCallback));
        execucao = null;
	}
}

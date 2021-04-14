package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.OrdemCompra;

public class RepositorioOrdemCompra extends ModelRepository<OrdemCompra>{

	public RepositorioOrdemCompra() {
		super("OrdemCompra", OrdemCompra.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "OrdemCompras";
	}
	
	public void limpaGeral(final VoidCallback voidCallback ) {
		RestContractItem contrato = new RestContractItem("OrdemCompra/limpaGeral","POST");
		this.getRestAdapter().getContract().addItem(contrato, "OrdemCompra.limpaGeral");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("limpaGeral", params,   new EmptyResponseParser(voidCallback));
	}

}

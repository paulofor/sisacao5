package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;

public class RepositorioExemploTreinoAcao extends ModelRepository<ExemploTreinoAcao>{

	public RepositorioExemploTreinoAcao() {
		super("ExemploTreinoAcao", ExemploTreinoAcao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaos";
	}
	
	
	
	
	public void insereExemplo(final ExemploTreinoAcao exemplo, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaos/insereExemplo","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcao.insereExemplo");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("exemplo", exemplo.getJSON());
        invokeStaticMethod("insereExemplo", params,   new EmptyResponseParser(callback));
	}
	

}

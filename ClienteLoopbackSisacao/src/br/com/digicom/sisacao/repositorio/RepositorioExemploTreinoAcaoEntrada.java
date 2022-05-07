package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;

public class RepositorioExemploTreinoAcaoEntrada extends ModelRepository<ExemploTreinoAcaoEntrada>{

	public RepositorioExemploTreinoAcaoEntrada() {
		super("ExemploTreinoAcaoEntrada", ExemploTreinoAcaoEntrada.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaoEntradas";
	}
	
	
	
	
	public void insereExemploEntrada(final ExemploTreinoAcaoEntrada exemplo, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoEntradas/insereExemploEntrada","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoEntrada.insereExemploEntrada");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("exemplo", exemplo.getJSON());
        invokeStaticMethod("insereExemploEntrada", params,   new EmptyResponseParser(callback));
	}
	

}

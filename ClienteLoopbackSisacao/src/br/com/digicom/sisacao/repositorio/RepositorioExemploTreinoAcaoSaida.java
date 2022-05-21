package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoSaida;

public class RepositorioExemploTreinoAcaoSaida extends ModelRepository<ExemploTreinoAcaoSaida>{

	public RepositorioExemploTreinoAcaoSaida() {
		super("ExemploTreinoAcaoSaida", ExemploTreinoAcaoSaida.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "ExemploTreinoAcaoSaidas";
	}
	
	
	
	
	public void insereExemploSaida(final ExemploTreinoAcaoSaida exemplo, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoSaidas/insereExemploSaida","POST");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoSaida.insereExemploSaida");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("exemplo", exemplo.getJSON());
        invokeStaticMethod("insereExemploSaida", params,   new EmptyResponseParser(callback));
	}
	public void listaSemResultado(final String ticker, final int regraId, final int qtdeDias, final int posicaoReferencia,  ListCallback<ExemploTreinoAcaoSaida> callback  ) {
		RestContractItem contrato = new RestContractItem("ExemploTreinoAcaoSaidas/listaSemResultado","GET");
		this.getRestAdapter().getContract().addItem(contrato, "ExemploTreinoAcaoSaida.listaSemResultado");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ticker",ticker);
        params.put("regraId",regraId);
        params.put("qtdeDias",qtdeDias);
        params.put("posicaoReferencia",posicaoReferencia);
        invokeStaticMethod("listaSemResultado", params,   new JsonArrayParser<ExemploTreinoAcaoSaida>(this, callback));
	}

}

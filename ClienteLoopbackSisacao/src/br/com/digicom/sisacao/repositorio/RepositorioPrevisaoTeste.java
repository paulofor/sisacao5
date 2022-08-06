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
import br.com.digicom.sisacao.modelo.PrevisaoTeste;

public class RepositorioPrevisaoTeste extends ModelRepository<PrevisaoTeste>{

	public RepositorioPrevisaoTeste() {
		super("PrevisaoTeste", PrevisaoTeste.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PrevisaoTestes";
	}
	
	
	public void listaComDiarioTargetStopTeste(long idTreinoRede, long diaNumInicial, long diaNumFinal, double limiteValor, final ListCallback<PrevisaoTeste> callback ) {
		RestContractItem contrato = new RestContractItem("PrevisaoTestes/listaComDiarioTargetStopTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "PrevisaoTeste.listaComDiarioTargetStopTeste");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("treinoRedeId", idTreinoRede);
        params.put("diaNumInicial", diaNumInicial);
        params.put("diaNumFinal", diaNumFinal);
        params.put("limiteValor", limiteValor);
        invokeStaticMethod("listaComDiarioTargetStopTeste", params,   new JsonArrayParser<PrevisaoTeste>(this, callback));
	}
	
	public void atualizaResultadoTeste(final PrevisaoTeste exemplo, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("PrevisaoTestes/atualizaResultadoTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "PrevisaoTeste.atualizaResultadoTeste");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("previsao", exemplo.jSON());
        invokeStaticMethod("atualizaResultadoTeste", params,   new EmptyResponseParser(callback));
	}
	
}

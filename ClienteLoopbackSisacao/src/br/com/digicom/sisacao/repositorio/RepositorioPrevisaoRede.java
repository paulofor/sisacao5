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
import br.com.digicom.sisacao.modelo.PrevisaoRede;

public class RepositorioPrevisaoRede extends ModelRepository<PrevisaoRede>{

	public RepositorioPrevisaoRede() {
		super("PrevisaoRede", PrevisaoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "PrevisaoRedes";
	}
	
	
	public void listaComDiarioTargetStop(long idTreinoRede, long diaNumInicial, long diaNumFinal, double limiteValor, final ListCallback<PrevisaoRede> callback ) {
		RestContractItem contrato = new RestContractItem("PrevisaoRedes/listaComDiarioTargetStop","GET");
		this.getRestAdapter().getContract().addItem(contrato, "PrevisaoRede.listaComDiarioTargetStop");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("treinoRedeId", idTreinoRede);
        params.put("diaNumInicial", diaNumInicial);
        params.put("diaNumFinal", diaNumFinal);
        params.put("limiteValor", limiteValor);
        invokeStaticMethod("listaComDiarioTargetStop", params,   new JsonArrayParser<PrevisaoRede>(this, callback));
	}
	
	public void atualizaResultado(final PrevisaoRede exemplo, final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("PrevisaoRedes/atualizaResultado","POST");
		this.getRestAdapter().getContract().addItem(contrato, "PrevisaoRede.atualizaResultado");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("previsao", exemplo.jSON());
        invokeStaticMethod("atualizaResultado", params,   new EmptyResponseParser(callback));
	}
	
}

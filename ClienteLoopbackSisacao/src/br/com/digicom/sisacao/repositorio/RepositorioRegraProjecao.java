package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoOpcao;
import br.com.digicom.sisacao.modelo.PeriodoExperimento;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public class RepositorioRegraProjecao extends ModelRepository<RegraProjecao>{

	
	public RepositorioRegraProjecao() {
		super("RegraProjecao", RegraProjecao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "RegraProjecaos";
	}
	
	public void obtemProcessando(final ObjectCallback<RegraProjecao> callback) {
		RestContractItem contrato = new RestContractItem("RegraProjecaos/obtemProcessando","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecao.obtemProcessando");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemProcessando", params,   new JsonObjectParser<RegraProjecao>(this, callback));
	}

	public void obtemPorId(final int id, final ObjectCallback<RegraProjecao> callback) {
		RestContractItem contrato = new RestContractItem("RegraProjecaos/obtemPorId","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecao.obtemPorId");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id",id);
        invokeStaticMethod("obtemPorId", params,   new JsonObjectParser<RegraProjecao>(this, callback));
	}
	
}

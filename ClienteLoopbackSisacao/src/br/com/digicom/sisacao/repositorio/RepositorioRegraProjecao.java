package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

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
	
	public void finalizaInsercao(final int id, final VoidCallback callback) {
		RestContractItem contrato = new RestContractItem("RegraProjecaos/finalizaInsercao","POST");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecao.finalizaInsercao");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idRegraProjecao",id);
        invokeStaticMethod("finalizaInsercao", params,   new EmptyResponseParser(callback));
	}
	
	public void obtemPorCodigoRegra(String codigoRegra, ObjectCallback<RegraProjecao> callback) {
		RestContractItem contrato = new RestContractItem("RegraProjecaos/obtemPorCodigoRegra","GET");
		this.getRestAdapter().getContract().addItem(contrato, "RegraProjecao.obtemPorCodigoRegra");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("codigo",codigoRegra);
        invokeStaticMethod("obtemPorCodigoRegra", params,   new JsonObjectParser<RegraProjecao>(this, callback));
	}
	
}

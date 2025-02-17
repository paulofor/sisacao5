package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.com.digicom.sisacao.modelo.TreinoRede;

public class RepositorioTreinoRede extends ModelRepository<TreinoRede>{

	public RepositorioTreinoRede() {
		super("TreinoRede", TreinoRede.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "TreinoRedes";
	}
	
	public void executouPrevisaoTeste(long id, final VoidCallback voidCallback) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/executouPrevisaoTeste","POST");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.executouPrevisaoTeste");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        invokeStaticMethod("executouPrevisaoTeste", params,   new EmptyResponseParser(voidCallback));
	}
	
	public void obtemListaParaTreino(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaParaTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaParaTreino");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaParaTreino", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}
	
	public void obtemListaPrevisaoTeste(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaPrevisaoTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaPrevisaoTeste");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaPrevisaoTeste", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}
	public void obtemListaPrevisaoExecucao(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaPrevisaoExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaPrevisaoExecucao");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaPrevisaoExecucao", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}
	public void obtemListaParaPrevisao(final ListCallback<TreinoRede> callback ) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaParaPrevisao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaParaPrevisao");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaParaPrevisao", params,   new JsonArrayParser<TreinoRede>(this, callback));
	}
	public void obtemListaPrevisaoExecucaoComTradeAberto(ListCallback<TreinoRede> listCallback) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemListaPrevisaoExecucaoComTradeAberto","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemListaPrevisaoExecucaoComTradeAberto");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemListaPrevisaoExecucaoComTradeAberto", params,   new JsonArrayParser<TreinoRede>(this, listCallback));
	}
	public void obtemSelecionadoComPeriodoExecucao(ListCallback<TreinoRede> listCallback) {
		RestContractItem contrato = new RestContractItem("TreinoRedes/obtemSelecionadoComPeriodoExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "TreinoRede.obtemSelecionadoComPeriodoExecucao");
        Map<String, Object> params = new HashMap<String, Object>();
        invokeStaticMethod("obtemSelecionadoComPeriodoExecucao", params,   new JsonArrayParser<TreinoRede>(this, listCallback));
		
	}

}

package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.DiaPregao;

public class RepositorioDiaPregao extends ModelRepository<DiaPregao>{

	
		public RepositorioDiaPregao() {
			super("DiaPregao", DiaPregao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "DiaPregao";
		}
		
		public synchronized void listaDataPeriodo(int diaNumInicio, int diaNumFinal, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/listaDataPeriodo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.listaDataPeriodo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("diaNumInicio", diaNumInicio);
	        params.put("diaNumFinal", diaNumFinal);
	        invokeStaticMethod("listaDataPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		
		public synchronized void obtemPorDiaTicker(String ticker, int dias, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayPorTicker","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayPorTicker");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        //params.put("dia", dias);
	        invokeStaticMethod("obtemIntradayPorTicker", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemIntradayTickerPeriodo(String ticker, int inicioPeriodo, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayTickerPeriodo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayTickerPeriodo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("dataNumInicio", inicioPeriodo);
	        invokeStaticMethod("obtemIntradayTickerPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemIntradayResultadoTickerPeriodo(String ticker, int inicioPeriodo, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerPeriodo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerPeriodo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("dataNumInicio", inicioPeriodo);
	        invokeStaticMethod("obtemIntradayResultadoTickerPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemProximoB3(final ObjectCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemProximoB3","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemProximoB3");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("obtemProximoB3", params,   new JsonObjectParser<DiaPregao>(this, callback));
		}
		public synchronized void periodoAtualizacaoMonitoria(int idExecucao, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/periodoAtualizacaoMonitoria","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.periodoAtualizacaoMonitoria");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("idExecucao", idExecucao);
	        invokeStaticMethod("periodoAtualizacaoMonitoria", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemIntradayResultadoValor(String ticker, int inicioPeriodo, int idRegraProjecao, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoValor","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoValor");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("dataNumInicio", inicioPeriodo);
	        params.put("idRegraProjecao", idRegraProjecao);
	        invokeStaticMethod("obtemIntradayResultadoValor", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void proximoParaValidador(String ticker, long idPeriodo, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/proximoParaValidador","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.proximoParaValidador");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("idPeriodo", idPeriodo);
	        invokeStaticMethod("proximoParaValidador", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		
		
		
		public synchronized void obtemIntradayResultadoTickerQuantidadeB3(String ticker, int qtdeDia, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerQuantidadeB3","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerQuantidadeB3");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("qtdeDia", qtdeDia);
	        invokeStaticMethod("obtemIntradayResultadoTickerQuantidadeB3", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		public synchronized void obtemIntradayResultadoTickerPeriodoQuantidade(String ticker, int qtdeDia, int dataNumFinal, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerPeriodoQuantidade","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerPeriodoQuantidade");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("qtdeDia", qtdeDia);
	        params.put("dataNumFinal", dataNumFinal);
	        invokeStaticMethod("obtemIntradayResultadoTickerPeriodoQuantidade", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
		
		public synchronized void obtemIntradayResultadoTickerAteFinal(String ticker, int dataNumInicio, final ListCallback<DiaPregao> callback ) {
			RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerAteFinal","GET");
			this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerAteFinal");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("dataNumInicio", dataNumInicio);
	        invokeStaticMethod("obtemIntradayResultadoTickerAteFinal", params,   new JsonArrayParser<DiaPregao>(this, callback));
		}
}

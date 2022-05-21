package br.com.digicom.sisacao.repositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;

public class RepositorioAcaoBase {

	
	public static class AtivoAcaoRepository extends ModelRepository<AtivoAcao> {
		public AtivoAcaoRepository() {
			super("AtivoAcao", AtivoAcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "AtivoAcaos";
		}
		public void listaColetaIntraday(final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/listaColetaIntraday","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaColetaIntraday");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("listaColetaIntraday", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		
		public void listaPorGrupo(final Integer idGrupo, final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/listaPorGrupo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaPorGrupo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("idGrupo", idGrupo);
	        invokeStaticMethod("listaPorGrupo", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		public void simulacaoComMonitor(final Integer idPeriodo, final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/simulacaoComMonitor","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.simulacaoComMonitor");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("idPeriodo", idPeriodo);
	        invokeStaticMethod("simulacaoComMonitor", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		public void melhorSimulacaoPorExperimento(final Integer idExperimento, final Integer cortePontos, final Integer qtdeExecucao, final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/melhorSimulacaoPorExperimento","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.melhorSimulacaoPorExperimento");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("idExperimento", idExperimento);
	        params.put("cortePontos", cortePontos);
	        params.put("qtdeExecucao", qtdeExecucao);
	        invokeStaticMethod("melhorSimulacaoPorExperimento", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		public void melhorParaValidacao(final Integer idExperimento, final ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/melhorParaValidacao","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.melhorParaValidacao");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("idExperimento", idExperimento);
	        invokeStaticMethod("melhorParaValidacao", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		public void atualizaPosDiario(final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/atualizaPosDiario","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.atualizaPosDiario");
	        Map<String, Object> params = new HashMap<String, Object>();
	        invokeStaticMethod("atualizaPosDiario", params,   new EmptyResponseParser(voidCallback));
			
		}
		
		public void insereAcaoIndice(String ticker, String nome, String tipo, Long quantidade, Double percentual, String indice,
				final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/insereAcaoIndice","POST");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.insereAcaoIndice");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("nome", nome);
	        params.put("tipo", tipo);
	        params.put("quantidade", quantidade);
	        params.put("percentual", percentual);
	        params.put("indice", indice);
	        invokeStaticMethod("insereAcaoIndice", params,   new EmptyResponseParser(voidCallback));
			
		}
		public void listaPorNomeGrupo(String codigoGrupo, ListCallback<AtivoAcao> callback) {
			RestContractItem contrato = new RestContractItem("AtivoAcaos/listaPorNomeGrupo","GET");
			this.getRestAdapter().getContract().addItem(contrato, "AtivoAcao.listaPorNomeGrupo");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("nomeGrupo", codigoGrupo);
	        invokeStaticMethod("listaPorNomeGrupo", params,   new JsonArrayParser<AtivoAcao>(this, callback));
		}
		
	}
	
	public static class CotacaoIntradayAcaoRepository extends ModelRepository<CotacaoIntradayAcao> {
		public CotacaoIntradayAcaoRepository() {
			super("CotacaoIntradayAcao", CotacaoIntradayAcao.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayAcaos";
		}
		public void insereValorHorario(String ticker, String horaNegocio, Double valor, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaos/insereValorHorarioAcao","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcao.insereValorHorarioAcao");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("valor", valor);
	        params.put("horario", horaNegocio);
	        invokeStaticMethod("insereValorHorarioAcao", params, new EmptyResponseParser(voidCallback));
		}
	}
	public static class CotacaoIntradayAcaoResultadoRepository extends ModelRepository<CotacaoIntradayAcaoResultado> {
		public CotacaoIntradayAcaoResultadoRepository() {
			super("CotacaoIntradayAcaoResultado", CotacaoIntradayAcaoResultado.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayAcaoResutlados";
		}
		public void gravaVaziaComAnterior(String ticker, final ObjectCallback<CotacaoIntradayAcaoResultado> callback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/gravaVaziaComAnterior","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.gravaVaziaComAnterior");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        invokeStaticMethod("gravaVaziaComAnterior", params, new JsonObjectParser<CotacaoIntradayAcaoResultado>(this,callback));
		}
		public void criaTickerAno(String ticker, Long ano, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/criaTickerAno","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.criaTickerAno");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("ano", ano);
	        invokeStaticMethod("criaTickerAno", params, new EmptyResponseParser(voidCallback));
		}
		public void atualizaTargetStopDia(List<CotacaoIntradayAcaoResultado> lista, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/atualizaTargetStopDia","PUT");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.atualizaTargetStopDia");
	        Map<String, Object> params = new HashMap<String, Object>();
	        JSONArray listaJson = new JSONArray();
	        for (CotacaoIntradayAcaoResultado cotacao : lista) {
	        	listaJson.put(cotacao.getJSON());
	        }
	        params.put("listaCotacao", listaJson);
	        invokeStaticMethod("atualizaTargetStopDia", params, new EmptyResponseParser(voidCallback));
		}
		public void dataInicialTickerRegra(String ticker, long idRegra, final ObjectCallback<CotacaoIntradayAcaoResultado> callback ) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultados/dataInicialTickerRegra","GET");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultado.dataInicialTickerRegra");
	        Map<String, Object> params = new HashMap<String, Object>();
	        params.put("ticker", ticker);
	        params.put("idRegra", idRegra);
	        invokeStaticMethod("dataInicialTickerRegra", params,   new JsonObjectParser<CotacaoIntradayAcaoResultado>(this, callback));
		}
	}
	public static class CotacaoIntradayAcaoResultadoValorRepository extends ModelRepository<CotacaoIntradayAcaoResultadoValor> {
		public CotacaoIntradayAcaoResultadoValorRepository() {
			super("CotacaoIntradayAcaoResultadoValor", CotacaoIntradayAcaoResultadoValor.class);
		}
		@Override
		protected String verificaNomeUrl(String nome) {
			return "CotacaoIntradayAcaoResultadoValors";
		}

		public void insereLista(List<CotacaoIntradayAcaoResultadoValor> lista, final VoidCallback voidCallback) {
			RestContractItem contrato = new RestContractItem("CotacaoIntradayAcaoResultadoValors/insereLista","POST");
			this.getRestAdapter().getContract().addItem(contrato, "CotacaoIntradayAcaoResultadoValor.insereLista");
	        Map<String, Object> params = new HashMap<String, Object>();
	        JSONArray listaJson = new JSONArray();
	        for (CotacaoIntradayAcaoResultadoValor cotacao : lista) {
	        	listaJson.put(cotacao.getJSON());
	        }
	        params.put("lista", listaJson);
	        invokeStaticMethod("insereLista", params, new EmptyResponseParser(voidCallback));
		}
	}

}

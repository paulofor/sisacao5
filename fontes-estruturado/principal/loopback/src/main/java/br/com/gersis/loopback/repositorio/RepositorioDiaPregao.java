package br.com.gersis.loopback.repositorio;


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.json.JSONArray;

import com.strongloop.android.loopback.ModelRepository;
import com.strongloop.android.loopback.callbacks.JsonArrayParser;
import com.strongloop.android.loopback.callbacks.JsonObjectParser;
import com.strongloop.android.loopback.callbacks.EmptyResponseParser;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
import com.strongloop.android.remoting.adapters.RestContractItem;

import br.com.gersis.loopback.modelo.DiaPregao;

public class RepositorioDiaPregao extends ModelRepository<DiaPregao> {

	public RepositorioDiaPregao() {
		super("DiaPregao", DiaPregao.class);
	}
	@Override
	protected String verificaNomeUrl(String nome) {
		return "DiaPregao";
	}


	// ***  Operações  ***

	public synchronized void obtemIntradayResultadoTickerAteFinal(String ticker ,int dataNumInicio ,int tamanhoAmostra ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerAteFinal","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerAteFinal");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		params.put("tamanhoAmostra", tamanhoAmostra);
		invokeStaticMethod("obtemIntradayResultadoTickerAteFinal", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemComPrevisaoRedePorIdTreino(int idTreino ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemComPrevisaoRedePorIdTreino","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemComPrevisaoRedePorIdTreino");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTreino", idTreino);
		invokeStaticMethod("obtemComPrevisaoRedePorIdTreino", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayPorTicker(String ticker ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayPorTicker","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayPorTicker");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		invokeStaticMethod("obtemIntradayPorTicker", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemDiaTicker(int diaNum ,String ticker ,int quantidadeDia ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemDiaTicker","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemDiaTicker");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		params.put("ticker", ticker);
		params.put("quantidadeDia", quantidadeDia);
		invokeStaticMethod("obtemDiaTicker", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void criaDatasAno(int ano ,final VoidCallback callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/criaDatasAno","POST");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.criaDatasAno");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ano", ano);
		invokeStaticMethod("criaDatasAno", params,   new EmptyResponseParser(callback));
	}

	public synchronized void obtemProximo(final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemProximo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemProximo");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemProximo", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemProximoB3(final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemProximoB3","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemProximoB3");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemProximoB3", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemAnteriorQuantidade(DiaPregao quantidade ,final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemAnteriorQuantidade","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemAnteriorQuantidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("quantidade", quantidade.getJSON());
		invokeStaticMethod("obtemAnteriorQuantidade", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemAtualB3(final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemAtualB3","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemAtualB3");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("obtemAtualB3", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemAnteriorPorDia(int diaNum ,final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemAnteriorPorDia","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemAnteriorPorDia");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNum", diaNum);
		invokeStaticMethod("obtemAnteriorPorDia", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemPeriodoPrevisaoTeste(int idPeriodoTreinoRede ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemPeriodoPrevisaoTeste","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemPeriodoPrevisaoTeste");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idPeriodoTreinoRede", idPeriodoTreinoRede);
		invokeStaticMethod("obtemPeriodoPrevisaoTeste", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemPeriodoPrevisaoExecucao(int idPeriodoTreinoRede ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemPeriodoPrevisaoExecucao","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemPeriodoPrevisaoExecucao");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idPeriodoTreinoRede", idPeriodoTreinoRede);
		invokeStaticMethod("obtemPeriodoPrevisaoExecucao", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemPeriodoPrevisaoExecucaoPendente(int idTreinoRede ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemPeriodoPrevisaoExecucaoPendente","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemPeriodoPrevisaoExecucaoPendente");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idTreinoRede", idTreinoRede);
		invokeStaticMethod("obtemPeriodoPrevisaoExecucaoPendente", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemProximoAntesMeiaNoite(int horas ,final ObjectCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemProximoAntesMeiaNoite","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemProximoAntesMeiaNoite");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("horas", horas);
		invokeStaticMethod("obtemProximoAntesMeiaNoite", params,   new JsonObjectParser<DiaPregao>(this, callback));
	}

	public synchronized void periodoAtualizacaoMonitoria(int idExecucao ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/periodoAtualizacaoMonitoria","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.periodoAtualizacaoMonitoria");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idExecucao", idExecucao);
		invokeStaticMethod("periodoAtualizacaoMonitoria", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayTickerPeriodoQuantidade(String ticker ,int qtdeDia ,int dataNumInicio ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayTickerPeriodoQuantidade","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayTickerPeriodoQuantidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("qtdeDia", qtdeDia);
		params.put("dataNumInicio", dataNumInicio);
		invokeStaticMethod("obtemIntradayTickerPeriodoQuantidade", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoTickerAteFinalInicioAnterior(String ticker ,int dataNumInicio ,int tamanhoAmostra ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerAteFinalInicioAnterior","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerAteFinalInicioAnterior");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		params.put("tamanhoAmostra", tamanhoAmostra);
		invokeStaticMethod("obtemIntradayResultadoTickerAteFinalInicioAnterior", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayTickerPeriodo(String ticker ,int dataNumInicio ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayTickerPeriodo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayTickerPeriodo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		invokeStaticMethod("obtemIntradayTickerPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoTickerPeriodoQuantidade(String ticker ,int qtdeDia ,int diaNumPrevisao ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerPeriodoQuantidade","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerPeriodoQuantidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("qtdeDia", qtdeDia);
		params.put("diaNumPrevisao", diaNumPrevisao);
		invokeStaticMethod("obtemIntradayResultadoTickerPeriodoQuantidade", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoTickerPeriodo(String ticker ,int dataNumInicio ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerPeriodo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerPeriodo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		invokeStaticMethod("obtemIntradayResultadoTickerPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoTickerQuantidadeB3(String ticker ,int qtdeDia ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerQuantidadeB3","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerQuantidadeB3");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("qtdeDia", qtdeDia);
		invokeStaticMethod("obtemIntradayResultadoTickerQuantidadeB3", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoTickerQuantidade(String ticker ,int qtdeDia ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoTickerQuantidade","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoTickerQuantidade");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("qtdeDia", qtdeDia);
		invokeStaticMethod("obtemIntradayResultadoTickerQuantidade", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void comFalhaDiario(final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/comFalhaDiario","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.comFalhaDiario");
		Map<String, Object> params = new HashMap<String, Object>();
		invokeStaticMethod("comFalhaDiario", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoValor(String ticker ,int dataNumInicio ,int idRegraProjecao ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoValor","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoValor");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		params.put("idRegraProjecao", idRegraProjecao);
		invokeStaticMethod("obtemIntradayResultadoValor", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void exemploTreinoEntradaMaisRecente(int qtde ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/exemploTreinoEntradaMaisRecente","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.exemploTreinoEntradaMaisRecente");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qtde", qtde);
		invokeStaticMethod("exemploTreinoEntradaMaisRecente", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void obtemIntradayResultadoDataset(String ticker ,int dataNumInicio ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/obtemIntradayResultadoDataset","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.obtemIntradayResultadoDataset");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("dataNumInicio", dataNumInicio);
		invokeStaticMethod("obtemIntradayResultadoDataset", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void proximoParaValidador(String ticker ,int idPeriodo ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/proximoParaValidador","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.proximoParaValidador");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticker", ticker);
		params.put("idPeriodo", idPeriodo);
		invokeStaticMethod("proximoParaValidador", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}

	public synchronized void listaDataPeriodo(int diaNumInicio ,int diaNumFinal ,final ListCallback<DiaPregao> callback ) {
		RestContractItem contrato = new RestContractItem("DiaPregaos/listaDataPeriodo","GET");
		this.getRestAdapter().getContract().addItem(contrato, "DiaPregao.listaDataPeriodo");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diaNumInicio", diaNumInicio);
		params.put("diaNumFinal", diaNumFinal);
		invokeStaticMethod("listaDataPeriodo", params,   new JsonArrayParser<DiaPregao>(this, callback));
	}


	private JSONArray obtemLista(List<DiaPregao> listaEntrada) {
		JSONArray lista = new JSONArray();
		for (DiaPregao item : listaEntrada) {
			lista.put(item.getJSON());
		}
		return lista;
	}
}

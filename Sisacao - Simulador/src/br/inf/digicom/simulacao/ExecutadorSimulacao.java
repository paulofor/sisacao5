package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.ParametroRegra;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;
import br.inf.digicom.simulacao.regra.FabricaRegra;
import br.inf.digicom.simulacao.regra.IRegraVenda;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExecutadorSimulacao {
	
	
	protected SerieCotacaoIntradayFacade serie = new SerieCotacaoIntradayFacade();

	public void executa(List<AtivoAcao> listaAtivo, CombinacaoParametro combinacao, ExperimentoSimulacao experimentoSimulacao) {
		IRegraPontoEntrada regra = FabricaRegra.criaRegra(experimentoSimulacao.getRegraSimulacao());
		combinacao = trataCombinacao(combinacao,experimentoSimulacao.getRegraSimulacao().getParametroRegras());
		for (AtivoAcao ativo : listaAtivo) {
			executaTicker(ativo.getTicker(), regra, combinacao, experimentoSimulacao);
		}
	}

	protected CombinacaoParametro trataCombinacao(CombinacaoParametro combinacao, List<ParametroRegra> parametroRegras) {
		HashMap<Integer,ParametroRegra> listaParametro = new HashMap<Integer,ParametroRegra>();
		for (ParametroRegra param : parametroRegras) {
			listaParametro.put((Integer) param.getId(),param);
		}
		for (ValorParametro valor : combinacao.getValorParametros()) {
			valor.setParametroRegra(listaParametro.get(valor.getParametroRegraId()));
		}
		return combinacao;
	}
	
	protected void executaTicker(String ticker, IRegraPontoEntrada regra, CombinacaoParametro combinacao,ExperimentoSimulacao experimento) {
		Map parametros = new HashMap();
		for (ValorParametro param : combinacao.getValorParametros()) {
			parametros.put(param.getParametroRegra().getAtributoClasse(),param.getValorParametro());
		}
		SimuladorPontoEntradaDia simulacao = null;
		if (regra instanceof IRegraVenda) {
			simulacao = new SimuladorPontoEntradaDiaVenda();
		} else {
			simulacao = new SimuladorPontoEntradaDia();
		}
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExecucaoPontoEntrada execucao = simulacao.executa(RepositorioCotacao.getCotacao(ticker),parametros, regra, experimento.diaInicio(), experimento.diaFinal());
		salvaExecucao(execucao,ticker,combinacao, regra, experimento);
		parametros = null;
	}
	
	protected void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao, IRegraPontoEntrada regra, ExperimentoSimulacao experimento)  {
		serie.salvaExecucao(execucao,ticker,combinacao, regra, experimento);
	}

}

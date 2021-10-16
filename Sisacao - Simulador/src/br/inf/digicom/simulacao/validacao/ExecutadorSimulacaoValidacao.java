package br.inf.digicom.simulacao.validacao;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.regra.FabricaRegra;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExecutadorSimulacaoValidacao extends ExecutadorSimulacao{
	
	private ExecucaoSimulacao execucaoCorrente = null;
	
	
	protected void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao, IRegraPontoEntrada regra, ExperimentoSimulacao experimento)  {
		System.out.println("Execucao: " + execucaoCorrente.getId());
		System.out.println("Ticker: " + ticker);
		serie.salvaExecucaoValidacao(execucao,ticker,combinacao, regra, experimento,execucaoCorrente);
	}

	public void executa(AtivoAcao ativo, ExecucaoSimulacao execucao, ExperimentoSimulacao experimentoValidacao) {
		this.execucaoCorrente = execucao;
		IRegraPontoEntrada regra = FabricaRegra.criaRegra(execucao.getCombinacaoParametro().getRegraSimulacao());
		//combinacao = trataCombinacao(combinacao,experimentoSimulacao.getRegraSimulacao().getParametroRegras());
		experimentoValidacao.setValidacao();
		executaTicker(ativo.getTicker(), regra, execucao.getCombinacaoParametro(), experimentoValidacao);
	}

}

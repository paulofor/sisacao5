package br.inf.digicom.simulacao.validacao;

import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExecutadorSimulacaoValidacao extends ExecutadorSimulacao{
	
	
	
	
	protected void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao, IRegraPontoEntrada regra, ExperimentoSimulacao experimento)  {
		serie.salvaExecucaoValidacao(execucao,ticker,combinacao, regra, experimento);
	}

}

package br.inf.digicom.simulacao.validacao;

import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.PeriodoExperimento;
import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.regra.FabricaRegra;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExecutaValidadorSelecionado extends ExecutadorSimulacao{

	private DatasetComum comum = null;

	public DatasetComum getComum() {
		return comum;
	}

	public void setComum(DatasetComum comum) {
		this.comum = comum;
	}

	public void executa() {
		String ticker = this.comum.getAtivoAcao().getTicker();
		RepositorioCotacao.limpa();
		RepositorioCotacao.setCarga(ticker, this.comum.getListaDiaPregao());
		for (ExecucaoSimulacao execucao : comum.getAtivoAcao().getExecucaoSimulacaos()) {
			IRegraPontoEntrada regra = FabricaRegra.criaRegra(execucao.getRegraSimulacao());
			CombinacaoParametro combinacao = execucao.getCombinacaoParametro();
			ExperimentoSimulacao experimento = execucao.getExperimentoSimulacao();
			PeriodoExperimento periodo = this.comum.getPeriodo();
			experimento.setPeriodoExperimentoObj(periodo);
			experimento.setValidacao();
			super.executaTicker(ticker, regra, combinacao, experimento);
		}
		
	}
	
	
	@Override
	protected void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao,
			IRegraPontoEntrada regra, ExperimentoSimulacao experimento) {
		super.salvaExecucao(execucao, ticker, combinacao, regra, experimento);
	}
	
	
}

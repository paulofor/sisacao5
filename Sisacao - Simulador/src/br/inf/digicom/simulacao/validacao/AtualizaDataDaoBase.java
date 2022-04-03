package br.inf.digicom.simulacao.validacao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.monitor.ExperimentoMonitoradoFacade;

public class AtualizaDataDaoBase extends DaoBaseApp {

	ExperimentoMonitoradoFacade facade = new ExperimentoMonitoradoFacade();
	private DummyDaoBase dummy = null;
	
	
	public AtualizaDataDaoBase() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		AtivoAcao acao = ds.getAtivoAcao();
		List<DiaPregao> dias = ds.getDiaValidacao();
		for (ExecucaoSimulacao execucao : acao.getExecucaoSimulacaos()) {
			for (DiaPregao dia : dias) {
				System.out.println("Executando: " + dia.getDiaNum() + " ExecucaoID:" + execucao.getId());
				facade.atualizaPrecoEntrada(dia.getDiaNum(), execucao);
				//System.out.println("Meu dummy2" + this.dummy);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		this.dummy.setConcluido();
		this.executaProximo();
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}

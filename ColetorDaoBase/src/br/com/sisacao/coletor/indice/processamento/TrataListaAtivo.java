package br.com.sisacao.coletor.indice.processamento;

import java.util.Timer;
import java.util.TimerTask;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.DaoBaseRestricaoTempo;

public class TrataListaAtivo extends ColetorIndiceDaoBase {

	Timer timer;
	DaoBaseRestricaoTempo restricaoTempo;
	
	public TrataListaAtivo() {
		this.restricaoTempo = new DaoBaseRestricaoTempo();
		this.restricaoTempo.setHorarioInicial(9,50);
		this.restricaoTempo.setHorarioFinal(18,30);
		this.restricaoTempo.setHorarioDesliga(19,0);
	}
	
	
	@Override
	protected long getTempo() {
		return 5000;
	}

	@Override
	protected void executaImpl() {
		timer = new Timer();
		System.out.println("Criando o timer");
        timer.schedule(new RemindTask(), 0, 30*1000);
	}
	
	@Override
	protected DaoBase getProximo() {
		return new ExecutaAtivoIndice();
	}

	
    class RemindTask extends TimerTask {
        public void run() {
        	System.out.println("Entrou no run");
        	if (restricaoTempo.podeExecutar()) {
        		final DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
        		for (AtivoIndice corrente : ds.getListaAtivoIndice()) {
        			ds.setAtivoIndiceCorrente(corrente);
        			executaProximoSemFinalizar();
        		}
        	} else {
        		if (restricaoTempo.podeFinalizar()) {
        			finalizar();
        		}
        	}
        }
    }
}

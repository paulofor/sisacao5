package br.inf.digicom.loopback;

import java.util.Timer;
import java.util.TimerTask;

import br.inf.digicom.loopback.comum.DaoBaseRestricaoTempo;

public abstract class DaoBaseRecorrenteTempoPadrao extends DaoBaseRecorrente {

	@Override
	protected void inicializaTempos(DaoBaseRestricaoTempo restricaoTempo2) {
		restricaoTempo2.setHorarioInicial(9,50);
		restricaoTempo2.setHorarioFinal(19,20);
		restricaoTempo2.setHorarioDesliga(19,30);
		//restricaoTempo2.setHorarioFinal(23,55);
		//restricaoTempo2.setHorarioDesliga(23,58);
	}

	/**
	 *
	 */
	@Override
	protected int getIntervaloMinuto() {
		return 10;
	}

	
	
}

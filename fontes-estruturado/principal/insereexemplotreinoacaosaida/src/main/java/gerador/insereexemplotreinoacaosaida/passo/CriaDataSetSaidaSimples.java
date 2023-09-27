package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CriaDataSetSaidaSimples extends DaoAplicacao { 

	private int NUM_PASSO = 5;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getRegraSaida(), ds.getExemploCorrente(), ds.getListaDia())) {
			executaProximo();
		} else {
			finalizar()
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new ExemploTreinoAcaoSaida_InsereExemploSaidaImpl();
	}


	protected boolean executaCustom( RegraProjecao regraSaida , ExemploTreinoAcaoEntrada exemploCorrente , List<DiaPregao> listaDia ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}


package gerador.insereexemplotreinoacaoentradaperiodo.passo;


import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CriaDataSetEntrada extends DaoAplicacao { 

	private int NUM_PASSO = 5;


	// campos saida
	protected ExemploTreinoAcaoEntrada  saidaExemploEntrada;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getDiaCorrente(), ds.getAtivoCorrente(), ds.getListaDiaCotacao(), ds.getTipoCorrente())) {
			ds.setExemploEntrada(saidaExemploEntrada);
			executaProximo();
		} else {
			finalizar();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new ExemploTreinoAcaoEntrada_InsereExemploEntradaImpl();
	}


	protected boolean executaCustom( DiaPregao diaCorrente , AtivoAcao ativoCorrente , List<DiaPregao> listaDiaCotacao , TipoExemploTreino tipoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}


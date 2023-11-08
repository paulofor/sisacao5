package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CriaDataSetEntradaIndice extends DaoAplicacao { 

	private int NUM_PASSO = 5;


	// campos saida
	protected ExemploTreinoIndiceAcaoEntrada  saidaExemploEntradaIndice;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getTipoCorrente(), ds.getDiaCorrente(), ds.getIndiceCorrente(), ds.getListaDiaCotacao())) {
			ds.setExemploEntradaIndice(saidaExemploEntradaIndice);
			executaProximo();
		} else {
			finalizar();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndiceImpl();
	}


	protected boolean executaCustom( TipoExemploTreino tipoCorrente , DiaPregao diaCorrente , AtivoIndice indiceCorrente , List<DiaPregao> listaDiaCotacao ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}


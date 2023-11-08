package gerador.insereexemplotreinoindiceentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.*;



public class DiaPregao_ListaDataPeriodoAteOntemImpl extends DiaPregao_ListaDataPeriodoAteOntem { 

	@Override
	protected boolean executaCustom(TipoExemploTreino tipoCorrente) {
		if (tipoCorrente.getDiaNumExemploEntradaInicio()!=0) {
			this.diaNumInicio = tipoCorrente.getDiaNumInicioEntradaIndice();
			return true;
		} else {
			return false;
		}
	}
}


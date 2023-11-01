package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.DiaPregao_ListaDataPeriodoAteOntem;



public class DiaPregao_ListaDataPeriodoAteOntemImpl extends DiaPregao_ListaDataPeriodoAteOntem {

	@Override
	protected boolean executaCustom(TipoExemploTreino tipoCorrente) {
		if (tipoCorrente.getDiaNumExemploEntradaInicio()!=0) {
			this.diaNumInicio = tipoCorrente.getDiaNumExemploEntradaInicio();
			return true;
		} else {
			return false;
		}
	}

	

}


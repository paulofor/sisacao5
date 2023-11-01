package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.*;



public class AtivoAcao_ListaParaInsereExemploSaidaImpl extends AtivoAcao_ListaParaInsereExemploSaida {

	@Override
	protected boolean executaCustom(DiaPregao diaCorrente, TipoExemploTreino tipoCorrente) {
		this.qtdeDias = tipoCorrente.getQtdeDias();
		this.diaNum = diaCorrente.getDiaNum();
		return true;
				
	} 


}


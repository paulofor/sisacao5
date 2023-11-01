package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.ExemploTreinoAcaoEntrada;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.*;



public class ExemploTreinoAcaoEntrada_InsereExemploEntradaImpl extends ExemploTreinoAcaoEntrada_InsereExemploEntrada {

	@Override
	protected boolean executaCustom(ExemploTreinoAcaoEntrada exemploEntrada) {
		this.exemplo = exemploEntrada;
		return true;
	} 

	

}


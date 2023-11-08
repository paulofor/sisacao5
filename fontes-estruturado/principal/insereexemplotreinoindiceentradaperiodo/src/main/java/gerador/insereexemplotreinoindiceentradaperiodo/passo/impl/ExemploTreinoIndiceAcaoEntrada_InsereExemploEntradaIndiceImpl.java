package gerador.insereexemplotreinoindiceentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.ExemploTreinoIndiceAcaoEntrada;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.*;



public class ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndiceImpl extends ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndice {

	@Override
	protected boolean executaCustom(ExemploTreinoIndiceAcaoEntrada exemploEntradaIndice) {
		this.exemplo = exemploEntradaIndice;
		return true;
	} 


	
}


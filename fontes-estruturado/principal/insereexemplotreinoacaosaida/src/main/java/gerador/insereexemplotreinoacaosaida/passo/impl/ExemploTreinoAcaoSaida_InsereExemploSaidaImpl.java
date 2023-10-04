package gerador.insereexemplotreinoacaosaida.passo.impl;


import br.com.gersis.loopback.modelo.ExemploTreinoAcaoSaida;
import gerador.insereexemplotreinoacaosaida.passo.*;



public class ExemploTreinoAcaoSaida_InsereExemploSaidaImpl extends ExemploTreinoAcaoSaida_InsereExemploSaida {

	@Override
	protected boolean executaCustom(ExemploTreinoAcaoSaida saida) {
		this.exemplo = saida;
		return true;
	} 


}


package gerador.insereexemplotreinoacaosaida.passo.impl;


import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.RegraProjecao;
import gerador.insereexemplotreinoacaosaida.passo.*;



public class ExemploTreinoAcaoEntrada_ListaSemResultadoSimplesImpl extends ExemploTreinoAcaoEntrada_ListaSemResultadoSimples {

	@Override
	protected boolean executaCustom(RegraProjecao regraSaida, AtivoAcao ativoCorrente) {
		this.ticker = ativoCorrente.getTicker();
		this.regraId = (Integer) regraSaida.getId();
		return true;
	} 


	
}


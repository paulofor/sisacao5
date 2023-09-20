package gerador.cotacaoresultadoindice.passo.impl;


import br.com.gersis.loopback.modelo.IndiceAcao;
import gerador.cotacaoresultadoindice.passo.CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndice;



public class CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndiceImpl extends CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndice {

	@Override
	protected boolean executaCustom(IndiceAcao indiceCorrente) {
		this.ticker = indiceCorrente.getTicker();
		return true;
	}

	

}


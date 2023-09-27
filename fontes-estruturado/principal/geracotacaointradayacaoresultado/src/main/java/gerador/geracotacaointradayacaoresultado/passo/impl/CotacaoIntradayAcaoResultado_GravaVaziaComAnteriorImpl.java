package gerador.geracotacaointradayacaoresultado.passo.impl;


import br.com.gersis.loopback.modelo.AtivoAcao;
import gerador.geracotacaointradayacaoresultado.passo.*;



public class CotacaoIntradayAcaoResultado_GravaVaziaComAnteriorImpl extends CotacaoIntradayAcaoResultado_GravaVaziaComAnterior {

	@Override
	protected boolean executaCustom(AtivoAcao acaoCorrente) {
		this.ticker = acaoCorrente.getTicker();
		return true;
	} 


}


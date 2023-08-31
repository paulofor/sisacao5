package gerador.targetstoptrend.passo.impl;


import br.com.gersis.loopback.modelo.FechamentoRegraDia;
import gerador.targetstoptrend.passo.*;



public class CotacaoIntradayAcaoResultado_PendentePorFechamentoRegraImpl extends CotacaoIntradayAcaoResultado_PendentePorFechamentoRegra {

	@Override
	protected boolean executaCustom(FechamentoRegraDia FechamentoRegraDiaCorrente) {
		this.idFechamentoRegraDia = (int) FechamentoRegraDiaCorrente.getId();
		return true;
	} 

	

}


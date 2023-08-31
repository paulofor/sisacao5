package gerador.targetstoptrend.passo.impl;


import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import gerador.targetstoptrend.passo.*;



public class CotacaoIntradayAcaoResultado_ListaPossiveisSaidasImpl extends CotacaoIntradayAcaoResultado_ListaPossiveisSaidas {

	@Override
	protected boolean executaCustom(CotacaoIntradayAcaoResultado entrada) {
		this.entrada = entrada;
		return true;
	} 


	
	
}


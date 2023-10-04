package gerador.geracotacaointradayacaoresultado.passo.impl;


import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import gerador.geracotacaointradayacaoresultado.loopback.DatasetAplicacao;
import gerador.geracotacaointradayacaoresultado.passo.*;



public class VerificaFechamentoImpl extends VerificaFechamento { 


	
	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		while (executaCustom(ds.getCotacaoResultado())) {
			executaProximoSemFinalizar();
		} 
		finalizar();
	}

	@Override
	protected boolean executaCustom(CotacaoIntradayAcaoResultado cotacaoResultado) {
		if (cotacaoResultado == null ) return true;
		if (cotacaoResultado.getDiaNum() == 0) return false;
		return true;
	}
	
	
}


package gerador.targetstoptrend.passo.impl;


import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.FechamentoPontoSaida;
import br.com.gersis.loopback.modelo.FechamentoRegraDia;
import gerador.targetstoptrend.passo.FechamentoPontoSaida_RegistraSaida;



public class FechamentoPontoSaida_RegistraSaidaImpl extends FechamentoPontoSaida_RegistraSaida {

	



	@Override
	protected boolean executaCustom(FechamentoRegraDia fechamentoRegraDiaCorrente, CotacaoIntradayAcaoResultado entrada,
			CotacaoIntradayAcaoResultado pontoSaida, int resultado, int passo) {
		if (pontoSaida==null) {
			return false;
		} else {
			this.saida = new FechamentoPontoSaida();
			this.saida.setDiaNumSaida(pontoSaida.getDiaNum());
			this.saida.setDiaHoraNumTickerEntrada(entrada.getDiaHoraNumTicker());
			this.saida.setTicker(entrada.getTicker());
			this.saida.setResultado(resultado);
			this.saida.setPasso(passo);
			this.saida.setFechamentoRegraDiaId((int)fechamentoRegraDiaCorrente.getId());
			
			saida.setDataHoraEntrada(entrada.getDataHora());
			saida.setDataHoraSaida(pontoSaida.getDataHora());
			saida.setValorEntrada(entrada.getValor());
			saida.setValorSaida(pontoSaida.getValor());
			
			return true;
		}
	}



	
	
}


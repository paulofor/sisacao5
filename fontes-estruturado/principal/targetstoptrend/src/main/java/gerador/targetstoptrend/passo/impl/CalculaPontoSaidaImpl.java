package gerador.targetstoptrend.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.FechamentoRegraDia;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.*;



public class CalculaPontoSaidaImpl extends CalculaPontoSaida {

	@Override
	protected boolean executaCustom(FechamentoRegraDia fechamentoRegraDiaCorrente, CotacaoIntradayAcaoResultado entrada,
			List<CotacaoIntradayAcaoResultado> possivelSaida) {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ds.setPontoSaida(null);
		double valorBull = entrada.getValor() * (1 + (fechamentoRegraDiaCorrente.getPercentualTargetStop()));
		double valorBear = entrada.getValor() * (1 - (fechamentoRegraDiaCorrente.getPercentualTargetStop()));
		int passo = 0;
		for (CotacaoIntradayAcaoResultado cotacao : possivelSaida) {
			ds.setPasso(passo);
			if (cotacao.getValor() <= valorBear) {
				ds.setPontoSaida(cotacao);
				ds.setResultado(-1);
				return true;
			}
			if (cotacao.getValor() >= valorBull) {
				ds.setPontoSaida(cotacao);
				ds.setResultado(1);
				return true;
			}
			passo++;
		}
		ds.setResultado(0);
		return true;
	}




}


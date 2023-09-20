package gerador.insereexemplotreinoacaosaida.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.ExemploTreinoAcaoEntrada;
import br.com.gersis.loopback.modelo.RegraProjecao;
import gerador.insereexemplotreinoacaosaida.passo.*;



public class DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl extends DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior {

	@Override
	protected boolean executaCustom(RegraProjecao regraSaida, AtivoAcao ativoCorrente, ExemploTreinoAcaoEntrada exemploCorrente) {
		this.ticker = ativoCorrente.getTicker();
		this.dataNumInicio = exemploCorrente.getDiaNumPrevisao();
		this.tamanhoAmostra = regraSaida.getDiaLimite();
		return true;

	}

	


}


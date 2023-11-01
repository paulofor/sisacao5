package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.*;



public class DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeImpl extends DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade {

	@Override
	protected boolean executaCustom(DiaPregao diaCorrente, AtivoAcao ativoCorrente, TipoExemploTreino tipoCorrente) {
		this.diaNumPrevisao = diaCorrente.getDiaNum();
		this.qtdeDia = tipoCorrente.getQtdeDias();
		this.ticker = ativoCorrente.getTicker();
		return true;
	} 


}


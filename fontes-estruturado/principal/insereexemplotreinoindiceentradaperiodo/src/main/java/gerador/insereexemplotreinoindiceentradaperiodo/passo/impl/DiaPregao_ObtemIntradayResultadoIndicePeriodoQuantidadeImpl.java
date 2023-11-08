package gerador.insereexemplotreinoindiceentradaperiodo.passo.impl;


import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.AtivoIndice;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.*;



public class DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidadeImpl extends DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidade { 
	
	
	
	@Override
	protected boolean executaCustom(TipoExemploTreino tipoCorrente, DiaPregao diaCorrente, AtivoIndice indiceCorrente) {
		this.diaNumPrevisao = diaCorrente.getDiaNum();
		this.qtdeDia = tipoCorrente.getQtdeDias();
		this.ticker = indiceCorrente.getTicker();
		return true;
	}

	

}


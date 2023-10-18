package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.CriaDataSetEntrada;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.suporte.DadosTreinoX;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.suporte.EnviaDadosX;



public class CriaDataSetEntradaImpl extends CriaDataSetEntrada {


	
	private DadosTreinoX dadosTreino = new DadosTreinoX();;
	private EnviaDadosX enviaDados = new EnviaDadosX();;
	
	
	@Override
	protected boolean executaCustom(DiaPregao diaCorrente, AtivoAcao ativoCorrente, List<DiaPregao> listaDiaCotacao,
			TipoExemploTreino tipoCorrente) {
		processaDias(ativoCorrente.getTicker(), listaDiaCotacao,tipoCorrente);
		return true;
	}

	

	private void processaDias(String ticker, List<DiaPregao> dias, TipoExemploTreino tipoCorrente) {
	
		CotacaoIntradayAcaoResultado cotacaoDiaReferencia = null;
		DiaPregao diaReferencia = null; 
		int indiceDia = 0;
		try {
			diaReferencia = dias.get(dias.size()-2);
			indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + tipoCorrente.getPosicaoReferencia() - 1;
			cotacaoDiaReferencia = diaReferencia.getCotacaoIntradayAcaoResultados().get(indiceDia);
			
			dadosTreino.calcula(dias, cotacaoDiaReferencia.getValor());
			enviaDados.enviaDia(ticker, dadosTreino, cotacaoDiaReferencia.getValor(), tipoCorrente.getQtdeDias(), tipoCorrente.getPosicaoReferencia());

				
		} catch (Exception e) {
			System.out.println("Ticker: " + ticker);
			System.out.println("Indice Referencia: " + indiceDia);
			//System.out.println("Data Previsao:" + comum.);
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaReferencia);
			System.out.println("Data Referencia:" + diaReferencia.getDiaNum());
			int i = 0;
			for (CotacaoIntradayAcaoResultado cot: diaReferencia.getCotacaoIntradayAcaoResultados()) {
				System.out.println((i++) + " " +cot);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

}


package gerador.insereexemplotreinoacaoentradaperiodo.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.AtivoAcao;
import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExemploTreinoAcaoEntrada;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.CriaDataSetEntrada;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.suporte.DadosTreinoX;



public class CriaDataSetEntradaImpl extends CriaDataSetEntrada {


	
	private DadosTreinoX dadosTreino = new DadosTreinoX();;
	//private EnviaDadosX enviaDados = new EnviaDadosX();;
	private ExemploTreinoAcaoEntrada exemplo = null;
	
	@Override
	protected boolean executaCustom(DiaPregao diaCorrente, AtivoAcao ativoCorrente, List<DiaPregao> listaDiaCotacao,
			TipoExemploTreino tipoCorrente) {
		processaDias(ativoCorrente.getTicker(), listaDiaCotacao,tipoCorrente);
		this.saidaExemploEntrada = exemplo;
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
			enviaDia(ticker, dadosTreino, cotacaoDiaReferencia.getValor(), tipoCorrente.getQtdeDias(), tipoCorrente.getPosicaoReferencia());

				
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
	
	public void enviaDia(String ticker, DadosTreinoX dadoTreino, double valorReferencia, int qtdeDias, int posicaoReferencia) {
		exemplo = new ExemploTreinoAcaoEntrada();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoXOriginal(dadoTreino.getSaidaXOriginal());
		exemplo.setTicker(ticker);
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
		exemplo.setValorReferencia(valorReferencia);
		exemplo.setPosicaoReferencia(posicaoReferencia);
		exemplo.setQtdeDias(qtdeDias);
	}

}


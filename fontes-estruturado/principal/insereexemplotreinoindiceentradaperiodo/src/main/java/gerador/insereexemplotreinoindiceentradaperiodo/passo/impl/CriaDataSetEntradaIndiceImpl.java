package gerador.insereexemplotreinoindiceentradaperiodo.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.AtivoIndice;
import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.CotacaoIntradayIndiceResultado;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExemploTreinoIndiceAcaoEntrada;
import br.com.gersis.loopback.modelo.TipoExemploTreino;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.CriaDataSetEntradaIndice;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.suporte.DadosTreinoX;



public class CriaDataSetEntradaIndiceImpl extends CriaDataSetEntradaIndice { 


	private DadosTreinoX dadosTreino = new DadosTreinoX();;
	//private EnviaDadosX enviaDados = new EnviaDadosX();;
	private ExemploTreinoIndiceAcaoEntrada exemplo = null;
	
	
	
	@Override
	protected boolean executaCustom(TipoExemploTreino tipoCorrente, DiaPregao diaCorrente, AtivoIndice indiceCorrente,
			List<DiaPregao> listaDiaCotacao) {
		processaDias(indiceCorrente.getTicker(), listaDiaCotacao,tipoCorrente);
		this.saidaExemploEntradaIndice = exemplo;
		return true;
	}



	

	private void processaDias(String ticker, List<DiaPregao> dias, TipoExemploTreino tipoCorrente) {
	
		CotacaoIntradayIndiceResultado cotacaoDiaReferencia = null;
		DiaPregao diaReferencia = null; 
		int indiceDia = 0;
		try {
			diaReferencia = dias.get(dias.size()-2);
			indiceDia = dias.get(0).getCotacaoIntradayIndiceResultados().size() + tipoCorrente.getPosicaoReferencia() - 1;
			cotacaoDiaReferencia = diaReferencia.getCotacaoIntradayIndiceResultados().get(indiceDia);
			
			dadosTreino.calcula(dias, cotacaoDiaReferencia.getValor());
			enviaDia(ticker, dadosTreino, cotacaoDiaReferencia.getValor(), new Integer(tipoCorrente.getId().toString()));

				
		} catch (Exception e) {
			System.out.println("Ticker: " + ticker);
			System.out.println("Indice Referencia: " + indiceDia);
			//System.out.println("Data Previsao:" + comum.);
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaReferencia);
			System.out.println("Data Referencia:" + diaReferencia.getDiaNum());
			int i = 0;
			for (CotacaoIntradayIndiceResultado cot: diaReferencia.getCotacaoIntradayIndiceResultados()) {
				System.out.println((i++) + " " +cot);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
	}
	
	public void enviaDia(String ticker, DadosTreinoX dadoTreino, double valorReferencia, int idTipoExemplo) {
		exemplo = new ExemploTreinoIndiceAcaoEntrada();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoXOriginal(dadoTreino.getSaidaXOriginal());
		exemplo.setTicker(ticker);
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
		exemplo.setValorReferencia(valorReferencia);
		exemplo.setTipoExemploTreinoId(idTipoExemplo);
	}

}


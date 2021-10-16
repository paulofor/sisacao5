package br.inf.digicom;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.RepositorioCotacao;

public class PesquisaTrendCompraObj {

	private double PERCENTUAL_ALTO = 0.15;
	private double PERCENTUAL_BAIXO = 0.15;
	
	public void executa(String ticker) {
		RepositorioCotacao.carregaAtivoResultado(ticker, 20210101);
		processaItem(ticker);
	}

	private void processaItem(String ticker) {

		List<DiaPregao> dias = RepositorioCotacao.getCotacao(ticker);

		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			for (int indHora=0;indHora<dia.getCotacaoIntradayAcaoResultados().size();indHora++) {
				CotacaoIntradayAcaoResultado cotacao = dia.getCotacaoIntradayAcaoResultados().get(indHora);
				double valorBaixo = cotacao.getValor() * (1-PERCENTUAL_ALTO);
				double valorAlto = cotacao.getValor() * (1+PERCENTUAL_BAIXO);
				int resultado = procuraValor(dias, indDia, indHora, valorBaixo, valorAlto); 
			}
			
		}
	}

	private int procuraValor(List<DiaPregao> dias, int indDia, int indHora, double valorBaixo, double valorAlto) {
		boolean finalizou = false;
		int saida = 0;
		int posDia = indDia;
		int posHora = indHora;
		while (true) {
			CotacaoDiarioAcao diario = dias.get(indDia).getCotacaoDiarioAcaos().get(0);
			if (diario==null) {
				break;
			}
			if (diario.getMinimo() <= valorBaixo) {
				saida = -1;
				break;
			} 
			if (diario.getMaximo() >= valorAlto) {
				saida = 1;
				break;
			} 
		}
		return saida;
	}
}

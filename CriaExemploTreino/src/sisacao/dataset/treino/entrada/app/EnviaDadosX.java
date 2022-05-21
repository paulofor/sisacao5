package sisacao.dataset.treino.entrada.app;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import sisacao.dataset.treino.entrada.dao.ExemploTreinoAcaoEntrada_InsereExemploEntrada;
import sisacao.dataset.treino.proc.DadosTreino;

public class EnviaDadosX {

	private ExemploTreinoAcaoEntrada_InsereExemploEntrada dao = new ExemploTreinoAcaoEntrada_InsereExemploEntrada();
	
	
	public void enviaDia(String ticker, DadosTreinoX dadoTreino, double valorReferencia, int qtdeDias, int posicaoReferencia) {
		ExemploTreinoAcaoEntrada exemplo = new ExemploTreinoAcaoEntrada();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoXOriginal(dadoTreino.getSaidaXOriginal());
		exemplo.setTicker(ticker);
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
		exemplo.setValorReferencia(valorReferencia);
		exemplo.setPosicaoReferencia(posicaoReferencia);
		exemplo.setQtdeDias(qtdeDias);
		dao.setDado(exemplo);
		dao.executaImpl();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finalizou enviadadox");
	}
}

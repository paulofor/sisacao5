package sisacao.dataset.treino.entrada.periodo.app;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoSaida;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.proc.ProcuraPontoSaida;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoSaida_InsereExemploSaida;

public class EnviaDadosY {

	private ExemploTreinoAcaoSaida_InsereExemploSaida dao = new ExemploTreinoAcaoSaida_InsereExemploSaida();
	
	

	public void enviaDia(String ticker, RegraProjecao regra, DadosTreinoY dadosTreino,
			ProcuraPontoSaida procSaida, double valorEntrada, double valorReferencia) {
		ExemploTreinoAcaoSaida exemplo = new ExemploTreinoAcaoSaida();
		exemplo.setTicker(ticker);
		exemplo.setCampoY(dadosTreino.getSaidaY());
		exemplo.setDiaNumPrevisao(dadosTreino.getDiaPrevisao().getDiaNum());
		exemplo.setDiaNumSaida(dadosTreino.getDiaNumSaida());
		if (procSaida !=null) {
			exemplo.setLimiteSuperior(procSaida.getLimiteAlto());
			exemplo.setLimiteInferior(procSaida.getLimiteBaixo());
			exemplo.setDiaNumSaida(procSaida.getDiaNumSaida());
			exemplo.setValorSaida(procSaida.getValorSaida());
			
		}
		exemplo.setRegraProjecaoId(regra.getId());
		exemplo.setResultado(dadosTreino.getResultado());
		exemplo.setValorEntrada(valorEntrada);
		dao.setDado(exemplo);
		dao.executaImpl();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Finalizou enviadadoy");
		
	}
}

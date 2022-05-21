package sisacao.dataset.treino.proc;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.dao.ExemploTreinoAcao_InsereExemplo;

public class EnviaDados {

	private ExemploTreinoAcao_InsereExemplo dao = new ExemploTreinoAcao_InsereExemplo();
	
	
	public void enviaDia(String ticker, RegraProjecao regraProjecao, DadosTreino dadoTreino, ProcuraPontoSaida procSaida, double valorEntrada, double valorReferencia) {
		ExemploTreinoAcao exemplo = new ExemploTreinoAcao();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoXOriginal(dadoTreino.getSaidaXOriginal());
		exemplo.setCampoY(dadoTreino.getSaidaY());
		exemplo.setResultado(dadoTreino.getResultado());
		exemplo.setTicker(ticker);
		exemplo.setRegraProjecaoId(regraProjecao.getId());
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
		exemplo.setValorEntrada(valorEntrada);
		exemplo.setValorReferencia(valorReferencia);
		if (procSaida !=null) {
			exemplo.setLimiteSuperior(procSaida.getLimiteAlto());
			exemplo.setLimiteInferior(procSaida.getLimiteBaixo());
			exemplo.setDiaNumSaida(procSaida.getDiaNumSaida());
			exemplo.setValorSaida(procSaida.getValorSaida());
			
		}
		
		//exemplo.setLimiteSuperior(dadoTreino.)
		dao.setDado(exemplo);
		dao.executaImpl();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizou EnviaDados");
	}
}

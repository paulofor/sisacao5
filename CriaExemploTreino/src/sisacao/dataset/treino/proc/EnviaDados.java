package sisacao.dataset.treino.proc;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.dao.ExemploTreinoAcao_InsereExemplo;

public class EnviaDados {

	private ExemploTreinoAcao_InsereExemplo dao = new ExemploTreinoAcao_InsereExemplo();
	
	
	public void enviaDia(String ticker, RegraProjecao regraProjecao, DadosTreino dadoTreino, double valorEntrada, double valorReferencia) {
		ExemploTreinoAcao exemplo = new ExemploTreinoAcao();
		exemplo.setCampoX(dadoTreino.getSaidaX());
		exemplo.setCampoY(dadoTreino.getSaidaY());
		exemplo.setTicker(ticker);
		exemplo.setRegraProjecaoId(regraProjecao.getId());
		exemplo.setDiaNumInicio(dadoTreino.getDiaNumInicio());
		exemplo.setDiaNumPrevisao(dadoTreino.getDiaNumPrevisao());
		exemplo.setValorEntrada(valorEntrada);
		exemplo.setValorReferencia(valorReferencia);
		dao.setDado(exemplo);
		dao.executa();
	}
}

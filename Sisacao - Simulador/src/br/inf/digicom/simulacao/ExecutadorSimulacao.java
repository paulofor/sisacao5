package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.Map;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;

public class ExecutadorSimulacao {
	
	private final String PACOTE_REGRA = "br.inf.digicom.simulacao.regra";

	public void executa(AtivoAcao ativoAcao, CombinacaoParametro combinacao, ExperimentoSimulacao experimentoSimulacao) {
		
		String nomeRegra = PACOTE_REGRA + "." +experimentoSimulacao.getRegraSimulacao().getNomeClasse();
		IRegraPontoEntrada regra = null;
		try {
			regra = (IRegraPontoEntrada) Class.forName(nomeRegra).newInstance();
			SerieCotacaoIntradayFacade serie = new SerieCotacaoIntradayFacade();
			
			serie.obtemSerie(ativoAcao.getTicker(), regra, combinacao,0);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

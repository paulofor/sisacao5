package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.ParametroRegra;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;

public class ExecutadorSimulacao {
	
	private final String PACOTE_REGRA = "br.inf.digicom.simulacao.regra";
	SerieCotacaoIntradayFacade serie = new SerieCotacaoIntradayFacade();

	public void executa(List<AtivoAcao> listaAtivo, CombinacaoParametro combinacao, ExperimentoSimulacao experimentoSimulacao) {
		
		String nomeRegra = PACOTE_REGRA + "." +experimentoSimulacao.getRegraSimulacao().getNomeClasse();
		IRegraPontoEntrada regra = null;
		try {
			regra = (IRegraPontoEntrada) Class.forName(nomeRegra).newInstance();
			
			combinacao = trataCombinacao(combinacao,experimentoSimulacao.getRegraSimulacao().getParametroRegras());
			
			for (AtivoAcao ativo : listaAtivo) {
				//serie.obtemSerie(ativo.getTicker(), regra, combinacao,0);
				serie.executaTicker(ativo.getTicker(), regra, combinacao, 0);
			}
			//do {
			//	try {
			//		Thread.sleep(30000);
			//		System.out.println("wait:" + serie.getConcluidos());
			//	} catch (InterruptedException e) {
			//		e.printStackTrace();
			//	}
			//} while (serie.getConcluidos() < listaAtivo.size());
			//System.exit(0);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private CombinacaoParametro trataCombinacao(CombinacaoParametro combinacao, List<ParametroRegra> parametroRegras) {
		HashMap<Integer,ParametroRegra> listaParametro = new HashMap<Integer,ParametroRegra>();
		for (ParametroRegra param : parametroRegras) {
			listaParametro.put((Integer) param.getId(),param);
		}
		for (ValorParametro valor : combinacao.getValorParametros()) {
			valor.setParametroRegra(listaParametro.get(valor.getParametroRegraId()));
		}
		return combinacao;
	}

}

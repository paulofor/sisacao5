package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.ParametroRegra;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;
import br.inf.digicom.simulacao.regra.FabricaRegra;

public class ExecutadorSimulacao {
	
	
	SerieCotacaoIntradayFacade serie = new SerieCotacaoIntradayFacade();

	public void executa(List<AtivoAcao> listaAtivo, CombinacaoParametro combinacao, ExperimentoSimulacao experimentoSimulacao) {
		IRegraPontoEntrada regra = FabricaRegra.criaRegra(experimentoSimulacao.getRegraSimulacao());
		combinacao = trataCombinacao(combinacao,experimentoSimulacao.getRegraSimulacao().getParametroRegras());
		for (AtivoAcao ativo : listaAtivo) {
			serie.executaTicker(ativo.getTicker(), regra, combinacao, experimentoSimulacao.diaInicio(), experimentoSimulacao.diaFinal());
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

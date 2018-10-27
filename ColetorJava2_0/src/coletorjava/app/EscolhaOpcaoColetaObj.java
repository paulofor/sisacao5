package coletorjava.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;

public class EscolhaOpcaoColetaObj {

	// Esse método apenas mostra as opçoes em condiçoes de coleta
	public void principal() {
		OpcaoSisacaoGeralRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		try {
			List<OpcaoSisacaoGeral> lista = servico.MelhoresParaColeta();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	
	public void processaOpcoes() {
		OpcaoSisacaoRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		try {
			servico.CriaParaColetaPorVolumeNegocioDiaAnterior();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
}

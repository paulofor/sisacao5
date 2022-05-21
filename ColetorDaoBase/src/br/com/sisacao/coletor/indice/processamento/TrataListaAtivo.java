package br.com.sisacao.coletor.indice.processamento;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaAtivo extends DaoBaseRecorrenteTempoPadrao {


	
	
	
	@Override
	protected long getTempo() {
		return 5000;
	}

	
	
	@Override
	protected DaoBase getProximo() {
		return new ExecutaAtivoIndice();
	}


	@Override
	protected void executaPrincipal() {
		final DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		for (AtivoIndice corrente : ds.getListaAtivoIndice()) {
			ds.setAtivoIndiceCorrente(corrente);
			executaProximoSemFinalizar();
		}
	}


	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	
   
}

package br.com.sisacao.coletor.ativo.processamento;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaAtivoAcao extends DaoBaseRecorrenteTempoPadrao {


	
	
	
	@Override
	protected long getTempo() {
		return 5000;
	}

	
	
	@Override
	protected DaoBase getProximo() {
		return new ExecutaAtivoAcao();
	}


	@Override
	protected void executaPrincipal() {
		final DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		for (AtivoAcao corrente : ds.getListaAtivoAcao()) {
			ds.setAtivoAcaoCorrente(corrente);
			executaProximoSemFinalizar();
		}
	}


	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	
   
}

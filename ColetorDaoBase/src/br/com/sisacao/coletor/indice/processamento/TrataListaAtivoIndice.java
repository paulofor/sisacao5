package br.com.sisacao.coletor.indice.processamento;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaAtivoIndice extends DaoBaseRecorrenteTempoPadrao {


	private final int TAMANHO_CLUSTER = 5;
	private DummyDaoBase dummy = null;
	
	
	public TrataListaAtivoIndice() {
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	protected long getTempo() {
		return 1000;
	}

	
	
	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}


	@Override
	protected void executaPrincipal() {
		//System.out.println(this + " precisa ser único");
		final DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		int ind = 0;
		Runtime.getRuntime().gc(); 
		List<DaoBase> lista = null;
		while (ind<ds.getListaAtivoIndice().size()) {
			lista = montaLista(ind);
			ind = ind + TAMANHO_CLUSTER;
			executaEmThread(lista);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//break;
		}
		for (Object item : lista) {
			item = null;
		}
		//for (AtivoAcao corrente : ds.getListaAtivoAcao()) {
		//	ds.setAtivoAcaoCorrente(corrente);
		//	executaProximoSemFinalizar();
		//}
		//this.finalizar();
	}

	private List<DaoBase> montaLista(int indice) {
		List<DaoBase> saida = new LinkedList<DaoBase>();
		for (int i=indice;i<indice+TAMANHO_CLUSTER; i++) {
			AtivoIndice ativo = getAtivo(i);
			if (ativo!=null) {
				DaoBase dao = new ExecutaAtivoIndiceCompleto(ativo);
				saida.add(dao);
			}
		}
		return saida;
	}
	
	
	
	
	private AtivoIndice getAtivo(int indice) {
		DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		if (indice < ds.getListaAtivoIndice().size()) {
			return ds.getListaAtivoIndice().get(indice);
		} else {
			return null;
		}
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	
   
}

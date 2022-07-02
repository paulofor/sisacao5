package br.com.sisacao.coletor.mercadoria.processamento;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaAtivoMercadoria extends DaoBaseRecorrenteTempoPadrao {


	private final int TAMANHO_CLUSTER = 5;
	private DummyDaoBase dummy = null;
	
	
	public TrataListaAtivoMercadoria() {
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
		final DatasetColetorMercadoria ds = (DatasetColetorMercadoria) getComum();
		int ind = 0;
		Runtime.getRuntime().gc(); 
		List<DaoBase> lista = null;
		while (ind<ds.getListaAtivoMercadoria().size()) {
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
		//for (AtivoMercadoria corrente : ds.getListaAtivoMercadoria()) {
		//	ds.setAtivoMercadoriaCorrente(corrente);
		//	executaProximoSemFinalizar();
		//}
		//this.finalizar();
	}

	private List<DaoBase> montaLista(int indice) {
		List<DaoBase> saida = new LinkedList<DaoBase>();
		for (int i=indice;i<indice+TAMANHO_CLUSTER; i++) {
			AtivoMercadoria ativo = getAtivo(i);
			if (ativo!=null) {
				DaoBase dao = new ExecutaAtivoMercadoria(ativo);
				saida.add(dao);
			}
		}
		return saida;
	}
	
	
	
	
	private AtivoMercadoria getAtivo(int indice) {
		DatasetColetorMercadoria ds = (DatasetColetorMercadoria) getComum();
		if (indice < ds.getListaAtivoMercadoria().size()) {
			return ds.getListaAtivoMercadoria().get(indice);
		} else {
			return null;
		}
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	
   
}

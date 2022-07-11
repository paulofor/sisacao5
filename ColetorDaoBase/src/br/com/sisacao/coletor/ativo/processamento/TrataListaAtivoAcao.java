package br.com.sisacao.coletor.ativo.processamento;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaAtivoAcao extends DaoBaseRecorrenteTempoPadrao {


	private final int TAMANHO_CLUSTER = 4;
	private final int SLEEP_DAO_BASE = 2000;
	private final int SLEEP_ENTRE_CLUSTER = 5000;
	private final int SLEEP_INTRA_CLUSTER = 2000;
	private final int INTERVALO_MINUTO = 15;
	
	
	private DummyDaoBase dummy = null;
	
	
	
	
	@Override
	protected int getIntervaloMinuto() {
		return INTERVALO_MINUTO;
	}

	public TrataListaAtivoAcao() {
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	protected long getTempo() {
		return SLEEP_DAO_BASE;
	}

	
	
	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}


	@Override
	protected void executaPrincipal() {
		//System.out.println(this + " precisa ser único");
		final DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		int ind = 0;
		Runtime.getRuntime().gc(); 
		List<DaoBase> lista = null;
		while (ind<ds.getListaAtivoAcao().size()) {
			lista = montaLista(ind);
			ind = ind + TAMANHO_CLUSTER;
			executaEmThread(lista);
			try {
				Thread.sleep(SLEEP_ENTRE_CLUSTER);
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
			AtivoAcao ativo = getAtivo(i);
			try {
				Thread.sleep(SLEEP_INTRA_CLUSTER);
				if (ativo!=null) {
					DaoBase dao = new ExecutaAtivoAcao(ativo);
					saida.add(dao);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return saida;
	}
	
	
	
	
	private AtivoAcao getAtivo(int indice) {
		DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		if (indice < ds.getListaAtivoAcao().size()) {
			return ds.getListaAtivoAcao().get(indice);
		} else {
			return null;
		}
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	
   
}

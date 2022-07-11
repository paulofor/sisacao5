package br.com.sisacao.coletor.imobiliario.processamento;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrenteTempoPadrao;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.IDatasetComum;

public class TrataListaFundoImobiliario extends DaoBaseRecorrenteTempoPadrao {


	private final int TAMANHO_CLUSTER = 3;
	private DummyDaoBase dummy = null;
	
	
	public TrataListaFundoImobiliario() {
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
		final DatasetColetorImobiliario ds = (DatasetColetorImobiliario) getComum();
		int ind = 0;
		Runtime.getRuntime().gc(); 
		List<DaoBase> lista = null;
		while (ind<ds.getListaFundoImobiliario().size()) {
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
			FundoImobiliario ativo = getAtivo(i);
			try {
				Thread.sleep(2000);
				if (ativo!=null) {
					DaoBase dao = new ExecutaFundoImobiliario(ativo);
					saida.add(dao);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return saida;
	}
	
	
	
	
	private FundoImobiliario getAtivo(int indice) {
		DatasetColetorImobiliario ds = (DatasetColetorImobiliario) getComum();
		if (indice < ds.getListaFundoImobiliario().size()) {
			return ds.getListaFundoImobiliario().get(indice);
		} else {
			return null;
		}
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	@Override
	protected int getIntervaloMinuto() {
		return 20;
	}

	
   
}

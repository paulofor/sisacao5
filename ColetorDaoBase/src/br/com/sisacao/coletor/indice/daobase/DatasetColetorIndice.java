package br.com.sisacao.coletor.indice.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorIndice implements IDatasetComum{
	
	private List<AtivoIndice> listaAtivoIndice;
	
	private AtivoIndice ativoIndiceCorrente;
	
	

	public AtivoIndice getAtivoIndiceCorrente() {
		return ativoIndiceCorrente;
	}




	public void setAtivoIndiceCorrente(AtivoIndice ativoIndiceCorrente) {
		this.ativoIndiceCorrente = ativoIndiceCorrente;
	}




	public List<AtivoIndice> getListaAtivoIndice() {
		return listaAtivoIndice;
	}




	public void setListaAtivoIndice(List<AtivoIndice> objects) {
		this.listaAtivoIndice = objects;
	}

}

package br.com.sisacao.coletor.diario.daobase;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.modelo.CotacaoIntradayIndice;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetColetorDiario implements IDatasetComum{
	
	private DiaPregao diaPregao;

	public DiaPregao getDiaPregao() {
		return diaPregao;
	}

	public void setDiaPregao(DiaPregao diaPregao) {
		this.diaPregao = diaPregao;
	}

	
	


}

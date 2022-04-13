package br.inf.digicom.simulacao.regraProjecao;

import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetRegraProjecao implements IDatasetComum {
	
	private String codigoRegra;
	private String codigoGrupo;
	private RegraProjecao regraProjecao;
	
	
	
	
	

	public RegraProjecao getRegraProjecao() {
		return regraProjecao;
	}




	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}




	public String getCodigoGrupo() {
		return codigoGrupo;
	}




	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}




	public String getCodigoRegra() {
		return codigoRegra;
	}




	public void setCodigoRegra(String codigoRegra) {
		// TODO Auto-generated method stub
		
	}

}

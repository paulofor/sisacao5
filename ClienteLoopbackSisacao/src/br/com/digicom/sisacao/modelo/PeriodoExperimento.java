package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class PeriodoExperimento extends Model{

	private int dataNumInicial;
	private int dataNumFinal;
	
	
	public int getDataNumInicial() {
		return dataNumInicial;
	}
	public void setDataNumInicial(int dataNumInicial) {
		this.dataNumInicial = dataNumInicial;
	}
	public int getDataNumFinal() {
		return dataNumFinal;
	}
	public void setDataNumFinal(int dataNumFinal) {
		this.dataNumFinal = dataNumFinal;
	}
	
	
}

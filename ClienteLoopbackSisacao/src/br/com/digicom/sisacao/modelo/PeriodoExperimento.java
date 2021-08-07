package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class PeriodoExperimento extends Model{

	private int dataNumInicial;
	private int dataNumFinal;
	private Integer id;
	private int dataNumInicioColeta;
	
	
	
	
	public int getDataNumInicioColeta() {
		return dataNumInicioColeta;
	}
	public void setDataNumInicioColeta(int dataNumInicioColeta) {
		this.dataNumInicioColeta = dataNumInicioColeta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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

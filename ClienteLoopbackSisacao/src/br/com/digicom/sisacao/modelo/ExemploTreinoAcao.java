package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class ExemploTreinoAcao extends Model{
	
	private String ticker;
	//private Integer datasetAcaoId;
	private String campoX;
	private String campoY;
	private Integer diaNumInicio;
	private Integer diaNumPrevisao;
	private Integer regraProjecaoId;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	/*
	public Integer getDatasetAcaoId() {
		return datasetAcaoId;
	}
	public void setDatasetAcaoId(Integer datasetAcaoId) {
		this.datasetAcaoId = datasetAcaoId;
	}
	*/
	public String getCampoX() {
		return campoX;
	}
	public void setCampoX(String campoX) {
		this.campoX = campoX;
	}
	public String getCampoY() {
		return campoY;
	}
	public void setCampoY(String campoY) {
		this.campoY = campoY;
	}
	public Integer getDiaNumInicio() {
		return diaNumInicio;
	}
	public void setDiaNumInicio(Integer diaNumInicio) {
		this.diaNumInicio = diaNumInicio;
	}
	public Integer getDiaNumPrevisao() {
		return diaNumPrevisao;
	}
	public void setDiaNumPrevisao(Integer diaNumPrevisao) {
		this.diaNumPrevisao = diaNumPrevisao;
	}
	public void setRegraProjecaoId(Integer id) {
		this.regraProjecaoId = id;
	}
	public Integer getRegraProjecaoId() {
		return this.regraProjecaoId;
	}
	
	
	

}

package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class PeriodoTreinoRede extends Model{
	
	private Integer diaNumInicioTreino;
	private Integer diaNumFinalTreino;
	private Integer diaNumInicioValidacao;
	private Integer diaNumFinalValidacao;
	
	private Integer maximoTradeTeste;
	private Integer minimoTradeTeste;
	private Integer simultaneoTradeTeste;
	
	
	
	
	public Integer getMaximoTradeTeste() {
		return maximoTradeTeste;
	}
	public void setMaximoTradeTeste(Integer maximoTradeTeste) {
		this.maximoTradeTeste = maximoTradeTeste;
	}
	public Integer getMinimoTradeTeste() {
		return minimoTradeTeste;
	}
	public void setMinimoTradeTeste(Integer minimoTradeTeste) {
		this.minimoTradeTeste = minimoTradeTeste;
	}
	public Integer getSimultaneoTradeTeste() {
		return simultaneoTradeTeste;
	}
	public void setSimultaneoTradeTeste(Integer simultaneoTradeTeste) {
		this.simultaneoTradeTeste = simultaneoTradeTeste;
	}
	public Integer getDiaNumInicioTreino() {
		return diaNumInicioTreino;
	}
	public void setDiaNumInicioTreino(Integer diaNumInicioTreino) {
		this.diaNumInicioTreino = diaNumInicioTreino;
	}
	public Integer getDiaNumFinalTreino() {
		return diaNumFinalTreino;
	}
	public void setDiaNumFinalTreino(Integer diaNumFinalTreino) {
		this.diaNumFinalTreino = diaNumFinalTreino;
	}
	public Integer getDiaNumInicioValidacao() {
		return diaNumInicioValidacao;
	}
	public void setDiaNumInicioValidacao(Integer diaNumInicioValidacao) {
		this.diaNumInicioValidacao = diaNumInicioValidacao;
	}
	public Integer getDiaNumFinalValidacao() {
		return diaNumFinalValidacao;
	}
	public void setDiaNumFinalValidacao(Integer diaNumFinalValidacao) {
		this.diaNumFinalValidacao = diaNumFinalValidacao;
	}
	
	

}

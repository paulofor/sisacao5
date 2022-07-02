package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class TipoExemploTreino extends Model{
	
	private Integer qtdeDias;
	private Integer posicaoReferencia;
	
	
	public Integer getQtdeDias() {
		return qtdeDias;
	}
	public void setQtdeDias(Integer qtdeDias) {
		this.qtdeDias = qtdeDias;
	}
	public Integer getPosicaoReferencia() {
		return posicaoReferencia;
	}
	public void setPosicaoReferencia(Integer posicaoReferencia) {
		this.posicaoReferencia = posicaoReferencia;
	}
	
	

}

package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class RelGrupoAcao extends Model{
	
	private String ticker;
	private Integer grupoAcaoId;
	
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Integer getGrupoAcaoId() {
		return grupoAcaoId;
	}
	public void setGrupoAcaoId(Integer grupoAcaoId) {
		this.grupoAcaoId = grupoAcaoId;
	}
	
	

}

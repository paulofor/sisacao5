package br.com.digicom.cotacao.vo;

import br.com.digicom.lib.DCIObjetoDominio;

public class Cotacao implements DCIObjetoDominio {
	private String ult = null;
	private String horaNegocio = null;
	private String neg = null;
	private String horaReal = null;
	private String ticker = null;
	private String data = null;
	private long idCotacao = 0L;
	private Double valor;
	
	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setIdCotacao(long idCotacao) {
		this.idCotacao = idCotacao;
	}

	public long getIdCotacao() {
		return this.idCotacao;
	}

	public String toString() {
		return this.ticker + ":" + this.ult + "   ( " + this.horaNegocio + " neg:" + this.neg + " )";
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraNegocio() {
		return this.horaNegocio;
	}

	public void setHoraNegocio(String horaNegocio) {
		this.horaNegocio = horaNegocio;
	}

	public String getHoraReal() {
		return this.horaReal;
	}

	public void setHoraReal(String horaReal) {
		this.horaReal = horaReal;
	}

	public String getNeg() {
		return this.neg;
	}

	public void setNeg(String neg) {
		this.neg = neg;
	}

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getUlt() {
		return this.ult;
	}

	public void setUlt(String ult) {
		int posicVirgula = ult.indexOf(',');
		if (posicVirgula == -1) {
			this.ult = ult;
		} else {
			int posic = ult.indexOf('.');
			if (posic != -1) {
				this.ult = ult.substring(0, posic);
				this.ult += ult.substring(posic + 1);
			} else {
				this.ult = ult;
			}
		}
	}

	@Override
	public long getIdObj() {
		// TODO Auto-generated method stub
		return this.idCotacao;
	}
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.vo.Cotacao JD-Core Version: 0.6.0
 */
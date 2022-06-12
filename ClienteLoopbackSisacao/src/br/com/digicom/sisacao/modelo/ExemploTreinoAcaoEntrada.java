package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class ExemploTreinoAcaoEntrada extends Model{

	
	private String ticker;
	private String campoX;
	private String campoXOriginal;
	private Integer diaNumInicio;
	private Integer diaNumPrevisao;
	private Double valorReferencia;
	private Integer qtdeDias;
	private Integer posicaoReferencia;
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("ticker", ticker);
			obj.put("campoX", campoX);
			obj.put("campoXOriginal", campoXOriginal);
			obj.put("diaNumInicio", diaNumInicio);
			obj.put("diaNumPrevisao", diaNumPrevisao);
			obj.put("qtdeDias", qtdeDias);
			obj.put("posicaoReferencia", posicaoReferencia);
			obj.put("valorReferencia", valorReferencia);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getCampoX() {
		return campoX;
	}

	public void setCampoX(String campoX) {
		this.campoX = campoX;
	}

	public String getCampoXOriginal() {
		return campoXOriginal;
	}

	public void setCampoXOriginal(String campoXOriginal) {
		this.campoXOriginal = campoXOriginal;
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

	public Double getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(Double valorReferencia) {
		this.valorReferencia = valorReferencia;
	}
	public void setValorReferencia(Integer valorReferencia) {
		this.valorReferencia = new Double(valorReferencia);
	}
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

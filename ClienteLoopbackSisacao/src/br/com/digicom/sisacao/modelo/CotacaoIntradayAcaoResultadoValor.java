package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayAcaoResultadoValor extends Model{

	private String ticker;
	private Integer diaNum;
	private String hora;
	
	private Integer resultado;
	private Integer dias;
	
	private Integer idRegraProjecao;
	private String diaHoraNumTicker;
	
	
	public JSONObject getJSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("diaNum", this.diaNum);
			saida.put("hora", this.hora);
			saida.put("ticker", this.ticker);
			saida.put("resultado", this.resultado);
			saida.put("dias", this.dias);
			saida.put("idRegraProjecao", this.idRegraProjecao);
			saida.put("diaHoraNumTicker", this.diaHoraNumTicker);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public Integer getIdRegraProjecao() {
		return idRegraProjecao;
	}
	public void setIdRegraProjecao(Integer idRegraProjecao) {
		this.idRegraProjecao = idRegraProjecao;
	}
	public String getDiaHoraNumTicker() {
		return diaHoraNumTicker;
	}
	public void setDiaHoraNumTicker(String diaHoraNumTicker) {
		this.diaHoraNumTicker = diaHoraNumTicker;
	}
	
	
	
	
}

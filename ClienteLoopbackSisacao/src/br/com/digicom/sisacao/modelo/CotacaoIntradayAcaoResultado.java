package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class CotacaoIntradayAcaoResultado extends Model {

	
	
	private String ticker;
	private Double valor;

	private String hora;
	private String dataHora;
	private Integer diaNum;
	
	private String dataExtraida;
	private String horaExtraida;
	private List<CotacaoIntradayAcaoResultadoValor> cotacaoIntradayAcaoResultadoValors;

	
	
	
	
	public List<CotacaoIntradayAcaoResultadoValor> getCotacaoIntradayAcaoResultadoValors() {
		return cotacaoIntradayAcaoResultadoValors;
	}
	public void setCotacaoIntradayAcaoResultadoValors(List<HashMap> cotacaoIntradayAcaoResultadoValors) {
		this.cotacaoIntradayAcaoResultadoValors = new ArrayList<CotacaoIntradayAcaoResultadoValor>();
		for (int i = 0; i < cotacaoIntradayAcaoResultadoValors.size(); i++) {
			Object objeto = new RelGrupoAcao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) cotacaoIntradayAcaoResultadoValors.get(i), true);
			this.cotacaoIntradayAcaoResultadoValors.add((CotacaoIntradayAcaoResultadoValor) objeto);
		}
	}
	
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	public String getDataExtraida() {
		return dataExtraida;
	}
	public void setDataExtraida(String dataExtraida) {
		this.dataExtraida = dataExtraida;
	}
	public String getHoraExtraida() {
		return horaExtraida;
	}
	public void setHoraExtraida(String horaExtraida) {
		this.horaExtraida = horaExtraida;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public void setValor(Long valor) {
		this.valor = valor.doubleValue();
	}
	public void setValor(Integer valor) {
		this.valor = valor.doubleValue();
	}

	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
		this.dataExtraida = dataHora.substring(0, 10);
		this.horaExtraida = dataHora.substring(11, 19);
	}
	

	public String toString() {
		return "[" + this.dataHora + "] : " + this.valor;
	}
	public JSONObject getJSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("diaNum", this.diaNum);
			saida.put("hora", this.hora);
			saida.put("ticker", this.ticker);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	
	
}

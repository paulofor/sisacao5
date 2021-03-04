package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class Trade extends Model{

	Double precoEntrada = 0D;
	Double precoSaida = 0D;
	String dataHoraEntrada = "";
	String dataHoraSaida = "";
	String dataSaida = "";
	String dataEntrada = "";
	String lucroPrejuizo = "";
	Double percentual = 0D;
	Integer quantidadeDia = 0;
	
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("precoEntrada", precoEntrada);
			obj.put("precoSaida", precoSaida);
			obj.put("dataHoraEntrada", dataHoraEntrada);
			obj.put("dataHoraSaida", dataHoraSaida);
			obj.put("dataSaida", dataSaida);
			obj.put("dataEntrada", dataEntrada);
			obj.put("lucroPrejuizo", lucroPrejuizo);
			obj.put("percentual", percentual);
			obj.put("quantidadeDia", quantidadeDia);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	public Integer getQuantidadeDia() {
		return quantidadeDia;
	}



	public void setQuantidadeDia(Integer quantidadeDia) {
		this.quantidadeDia = quantidadeDia;
	}



	public Double getPrecoEntrada() {
		return precoEntrada;
	}
	public void setPrecoEntrada(Double precoEntrada) {
		this.precoEntrada = precoEntrada;
	}
	public void setPrecoEntrada(Integer precoEntrada) {
		this.precoEntrada = precoEntrada.doubleValue();
	}
	public Double getPrecoSaida() {
		return precoSaida;
	}
	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}
	public void setPrecoSaida(Integer precoSaida) {
		this.precoSaida = precoSaida.doubleValue();
	}
	public String getDataHoraEntrada() {
		return dataHoraEntrada;
	}
	public void setDataHoraEntrada(String dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}
	public String getDataHoraSaida() {
		return dataHoraSaida;
	}
	public void setDataHoraSaida(String dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}
	public String getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}
	public String getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getLucroPrejuizo() {
		return lucroPrejuizo;
	}
	public void setLucroPrejuizo(String lucroPrejuizo) {
		this.lucroPrejuizo = lucroPrejuizo;
	}
	public Double getPercentual() {
		return percentual;
	}
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
	
	
	
}

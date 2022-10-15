package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class TesouroDiretoCotacao  extends Model{

	private String nome;
	private String codigoTesouro;
	private int diaNum;
	private String dataHoraStr;
	private Double taxaMercado;
	
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("nome", nome);
			obj.put("codigoTesouro", codigoTesouro);
			obj.put("taxaMercado", taxaMercado);
			obj.put("dataHoraStr", dataHoraStr);
			obj.put("diaNum", diaNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public String toString() {
		return nome + " -> " + taxaMercado + "(cód:" + codigoTesouro + ")";
	}
	
	public boolean ativo() {
		return (this.taxaMercado>0);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoTesouro() {
		return codigoTesouro;
	}
	public void setCodigoTesouro(String codigoTesouro) {
		this.codigoTesouro = codigoTesouro;
	}
	public int getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(int diaNum) {
		this.diaNum = diaNum;
	}
	
	public String getDataHoraStr() {
		return dataHoraStr;
	}


	public void setDataHoraStr(String dataHora) {
		this.dataHoraStr = dataHora;
	}


	public Double getTaxaMercado() {
		return taxaMercado;
	}
	public void setTaxaMercado(Double taxaMercado) {
		this.taxaMercado = taxaMercado;
	}

	
	
	
}

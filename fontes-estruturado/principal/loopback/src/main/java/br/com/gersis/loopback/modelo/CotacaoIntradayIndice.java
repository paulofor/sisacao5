package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class CotacaoIntradayIndice extends Model {


	private String ticker;
	private String dataHora;
	private double valor;
	private String dataHoraNegStr;
	private String dia;
	// Relacionamentos 1
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("dataHora", dataHora);
			obj.put("valor", valor);
			obj.put("dataHoraNegStr", dataHoraNegStr);
			obj.put("dia", dia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setDataHora(String valor) { 
		this.dataHora = valor;
	}
	public String getDataHora() { 
		return this.dataHora;
	}
	public void setValor(double valor) { 
		this.valor = valor;
	}
	public double getValor() { 
		return this.valor;
	}
	public void setDataHoraNegStr(String valor) { 
		this.dataHoraNegStr = valor;
	}
	public String getDataHoraNegStr() { 
		return this.dataHoraNegStr;
	}
	public void setDia(String valor) { 
		this.dia = valor;
	}
	public String getDia() { 
		return this.dia;
	}

}

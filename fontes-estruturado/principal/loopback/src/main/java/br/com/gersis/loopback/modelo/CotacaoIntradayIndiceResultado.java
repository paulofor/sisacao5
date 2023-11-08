package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class CotacaoIntradayIndiceResultado extends Model {


	private String ticker;
	private String hora;
	private double valor;
	private String dia;
	private int diaNum;
	private String dataHora;
	private String diaHoraNumTicker;
	private int posicaoDia;
	// Relacionamentos 1
	private DiaPregao DiaPregao;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("hora", hora);
			obj.put("valor", valor);
			obj.put("dia", dia);
			obj.put("diaNum", diaNum);
			obj.put("dataHora", dataHora);
			obj.put("diaHoraNumTicker", diaHoraNumTicker);
			obj.put("posicaoDia", posicaoDia);
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
	public void setHora(String valor) { 
		this.hora = valor;
	}
	public String getHora() { 
		return this.hora;
	}
	public void setValor(double valor) { 
		this.valor = valor;
	}
	public double getValor() { 
		return this.valor;
	}
	public void setDia(String valor) { 
		this.dia = valor;
	}
	public String getDia() { 
		return this.dia;
	}
	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setDataHora(String valor) { 
		this.dataHora = valor;
	}
	public String getDataHora() { 
		return this.dataHora;
	}
	public void setDiaHoraNumTicker(String valor) { 
		this.diaHoraNumTicker = valor;
	}
	public String getDiaHoraNumTicker() { 
		return this.diaHoraNumTicker;
	}
	public void setPosicaoDia(int valor) { 
		this.posicaoDia = valor;
	}
	public int getPosicaoDia() { 
		return this.posicaoDia;
	}

	public DiaPregao getDiaPregao() {
		return DiaPregao;
	}
	public void setDiaPregao(HashMap valor) {
		this.DiaPregao = new DiaPregao();
		BeanUtil.setProperties(this.DiaPregao, (Map<String, ? extends Object>) valor, true);
	}
}

package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class CotacaoIntradayAcaoResultadoValor extends Model {


	private String ticker;
	private int diaNum;
	private String hora;
	private int resultado;
	private int dias;
	private String diaHoraNumTicker;
	private String dataHoraInsercao;
	private double valorEntrada;
	private double valorSaida;
	private int diaNumSaida;
	private String dataHora;
	private double valorSuperior;
	private double valorInferior;
	private int anoMesNum;
	private int lucro;
	private int prejuizo;
	// Relacionamentos 1
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("diaNum", diaNum);
			obj.put("hora", hora);
			obj.put("resultado", resultado);
			obj.put("dias", dias);
			obj.put("diaHoraNumTicker", diaHoraNumTicker);
			obj.put("dataHoraInsercao", dataHoraInsercao);
			obj.put("valorEntrada", valorEntrada);
			obj.put("valorSaida", valorSaida);
			obj.put("diaNumSaida", diaNumSaida);
			obj.put("dataHora", dataHora);
			obj.put("valorSuperior", valorSuperior);
			obj.put("valorInferior", valorInferior);
			obj.put("anoMesNum", anoMesNum);
			obj.put("lucro", lucro);
			obj.put("prejuizo", prejuizo);
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
	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setHora(String valor) { 
		this.hora = valor;
	}
	public String getHora() { 
		return this.hora;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setDias(int valor) { 
		this.dias = valor;
	}
	public int getDias() { 
		return this.dias;
	}
	public void setDiaHoraNumTicker(String valor) { 
		this.diaHoraNumTicker = valor;
	}
	public String getDiaHoraNumTicker() { 
		return this.diaHoraNumTicker;
	}
	public void setDataHoraInsercao(String valor) { 
		this.dataHoraInsercao = valor;
	}
	public String getDataHoraInsercao() { 
		return this.dataHoraInsercao;
	}
	public void setValorEntrada(double valor) { 
		this.valorEntrada = valor;
	}
	public double getValorEntrada() { 
		return this.valorEntrada;
	}
	public void setValorSaida(double valor) { 
		this.valorSaida = valor;
	}
	public double getValorSaida() { 
		return this.valorSaida;
	}
	public void setDiaNumSaida(int valor) { 
		this.diaNumSaida = valor;
	}
	public int getDiaNumSaida() { 
		return this.diaNumSaida;
	}
	public void setDataHora(String valor) { 
		this.dataHora = valor;
	}
	public String getDataHora() { 
		return this.dataHora;
	}
	public void setValorSuperior(double valor) { 
		this.valorSuperior = valor;
	}
	public double getValorSuperior() { 
		return this.valorSuperior;
	}
	public void setValorInferior(double valor) { 
		this.valorInferior = valor;
	}
	public double getValorInferior() { 
		return this.valorInferior;
	}
	public void setAnoMesNum(int valor) { 
		this.anoMesNum = valor;
	}
	public int getAnoMesNum() { 
		return this.anoMesNum;
	}
	public void setLucro(int valor) { 
		this.lucro = valor;
	}
	public int getLucro() { 
		return this.lucro;
	}
	public void setPrejuizo(int valor) { 
		this.prejuizo = valor;
	}
	public int getPrejuizo() { 
		return this.prejuizo;
	}

}

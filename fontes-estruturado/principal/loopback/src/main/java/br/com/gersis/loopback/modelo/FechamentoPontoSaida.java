package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class FechamentoPontoSaida extends Model {


	private int diaNumSaida;
	private String diaHoraNumTickerEntrada;
	private int resultado;
	private int fechamentoRegraDiaId;
	private String ticker;
	private int passo;
	private double valorEntrada;
	private double valorSaida;
	private String dataHoraEntrada;
	private String dataHoraSaida;
	// Relacionamentos 1
	private FechamentoRegraDia FechamentoRegraDia;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("diaNumSaida", diaNumSaida);
			obj.put("diaHoraNumTickerEntrada", diaHoraNumTickerEntrada);
			obj.put("resultado", resultado);
			obj.put("fechamentoRegraDiaId", fechamentoRegraDiaId);
			obj.put("ticker", ticker);
			obj.put("passo", passo);
			obj.put("valorEntrada", valorEntrada);
			obj.put("valorSaida", valorSaida);
			obj.put("dataHoraEntrada", dataHoraEntrada);
			obj.put("dataHoraSaida", dataHoraSaida);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setDiaNumSaida(int valor) { 
		this.diaNumSaida = valor;
	}
	public int getDiaNumSaida() { 
		return this.diaNumSaida;
	}
	public void setDiaHoraNumTickerEntrada(String valor) { 
		this.diaHoraNumTickerEntrada = valor;
	}
	public String getDiaHoraNumTickerEntrada() { 
		return this.diaHoraNumTickerEntrada;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setFechamentoRegraDiaId(int valor) { 
		this.fechamentoRegraDiaId = valor;
	}
	public int getFechamentoRegraDiaId() { 
		return this.fechamentoRegraDiaId;
	}
	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setPasso(int valor) { 
		this.passo = valor;
	}
	public int getPasso() { 
		return this.passo;
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
	public void setDataHoraEntrada(String valor) { 
		this.dataHoraEntrada = valor;
	}
	public String getDataHoraEntrada() { 
		return this.dataHoraEntrada;
	}
	public void setDataHoraSaida(String valor) { 
		this.dataHoraSaida = valor;
	}
	public String getDataHoraSaida() { 
		return this.dataHoraSaida;
	}

	public FechamentoRegraDia getFechamentoRegraDia() {
		return FechamentoRegraDia;
	}
	public void setFechamentoRegraDia(HashMap valor) {
		this.FechamentoRegraDia = new FechamentoRegraDia();
		BeanUtil.setProperties(this.FechamentoRegraDia, (Map<String, ? extends Object>) valor, true);
	}
}

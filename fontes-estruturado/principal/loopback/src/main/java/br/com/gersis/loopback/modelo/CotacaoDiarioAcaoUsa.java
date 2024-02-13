package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class CotacaoDiarioAcaoUsa extends Model {


	private String ticker;
	private String data;
	private double abertura;
	private double maximo;
	private double minimo;
	private double fechamento;
	private int negocios;
	private double volume;
	private double percentual;
	private int diaNum;
	// Relacionamentos 1
	private DiaPregao DiaPregao;
	// Relacionamentos N

	public void setId(Long id) {
		this.setIdObjeto(id);
	}
	public void setId(Integer id) {
		this.setIdObjeto(id);
	}

	public int getIdInteger() {
		return new Integer(getId().toString());
	}
	public long getIdLong() {
		return new Long(getId().toString());
	}

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("data", data);
			obj.put("abertura", abertura);
			obj.put("maximo", maximo);
			obj.put("minimo", minimo);
			obj.put("fechamento", fechamento);
			obj.put("negocios", negocios);
			obj.put("volume", volume);
			obj.put("percentual", percentual);
			obj.put("diaNum", diaNum);
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
	public void setData(String valor) { 
		this.data = valor;
	}
	public String getData() { 
		return this.data;
	}
	public void setAbertura(double valor) { 
		this.abertura = valor;
	}
	public double getAbertura() { 
		return this.abertura;
	}
	public void setMaximo(double valor) { 
		this.maximo = valor;
	}
	public double getMaximo() { 
		return this.maximo;
	}
	public void setMinimo(double valor) { 
		this.minimo = valor;
	}
	public double getMinimo() { 
		return this.minimo;
	}
	public void setFechamento(double valor) { 
		this.fechamento = valor;
	}
	public double getFechamento() { 
		return this.fechamento;
	}
	public void setNegocios(int valor) { 
		this.negocios = valor;
	}
	public int getNegocios() { 
		return this.negocios;
	}
	public void setVolume(double valor) { 
		this.volume = valor;
	}
	public double getVolume() { 
		return this.volume;
	}
	public void setPercentual(double valor) { 
		this.percentual = valor;
	}
	public double getPercentual() { 
		return this.percentual;
	}
	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}

	public DiaPregao getDiaPregao() {
		return DiaPregao;
	}
	public void setDiaPregao(HashMap valor) {
		this.DiaPregao = new DiaPregao();
		BeanUtil.setProperties(this.DiaPregao, (Map<String, ? extends Object>) valor, true);
	}
}

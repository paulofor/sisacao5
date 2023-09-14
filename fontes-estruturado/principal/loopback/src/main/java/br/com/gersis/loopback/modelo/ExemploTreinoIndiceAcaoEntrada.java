package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExemploTreinoIndiceAcaoEntrada extends Model {


	private String ticker;
	private String campoX;
	private int diaNumPrevisao;
	private String campoXOriginal;
	private double valorReferencia;
	private int diaNumInicio;
	private int tipoExemploTreinoId;
	// Relacionamentos 1
	private TipoExemploTreino TipoExemploTreino;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("campoX", campoX);
			obj.put("diaNumPrevisao", diaNumPrevisao);
			obj.put("campoXOriginal", campoXOriginal);
			obj.put("valorReferencia", valorReferencia);
			obj.put("diaNumInicio", diaNumInicio);
			obj.put("tipoExemploTreinoId", tipoExemploTreinoId);
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
	public void setCampoX(String valor) { 
		this.campoX = valor;
	}
	public String getCampoX() { 
		return this.campoX;
	}
	public void setDiaNumPrevisao(int valor) { 
		this.diaNumPrevisao = valor;
	}
	public int getDiaNumPrevisao() { 
		return this.diaNumPrevisao;
	}
	public void setCampoXOriginal(String valor) { 
		this.campoXOriginal = valor;
	}
	public String getCampoXOriginal() { 
		return this.campoXOriginal;
	}
	public void setValorReferencia(double valor) { 
		this.valorReferencia = valor;
	}
	public double getValorReferencia() { 
		return this.valorReferencia;
	}
	public void setDiaNumInicio(int valor) { 
		this.diaNumInicio = valor;
	}
	public int getDiaNumInicio() { 
		return this.diaNumInicio;
	}
	public void setTipoExemploTreinoId(int valor) { 
		this.tipoExemploTreinoId = valor;
	}
	public int getTipoExemploTreinoId() { 
		return this.tipoExemploTreinoId;
	}

	public TipoExemploTreino getTipoExemploTreino() {
		return TipoExemploTreino;
	}
	public void setTipoExemploTreino(HashMap valor) {
		this.TipoExemploTreino = new TipoExemploTreino();
		BeanUtil.setProperties(this.TipoExemploTreino, (Map<String, ? extends Object>) valor, true);
	}
}

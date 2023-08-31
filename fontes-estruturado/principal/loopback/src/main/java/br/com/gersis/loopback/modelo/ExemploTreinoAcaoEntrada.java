package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExemploTreinoAcaoEntrada extends Model {


	private String ticker;
	private String campoX;
	private int diaNumPrevisao;
	private String campoXOriginal;
	private double valorReferencia;
	private int qtdeDias;
	private int posicaoReferencia;
	private int diaNumInicio;
	// Relacionamentos 1
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
			obj.put("qtdeDias", qtdeDias);
			obj.put("posicaoReferencia", posicaoReferencia);
			obj.put("diaNumInicio", diaNumInicio);
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
	public void setQtdeDias(int valor) { 
		this.qtdeDias = valor;
	}
	public int getQtdeDias() { 
		return this.qtdeDias;
	}
	public void setPosicaoReferencia(int valor) { 
		this.posicaoReferencia = valor;
	}
	public int getPosicaoReferencia() { 
		return this.posicaoReferencia;
	}
	public void setDiaNumInicio(int valor) { 
		this.diaNumInicio = valor;
	}
	public int getDiaNumInicio() { 
		return this.diaNumInicio;
	}

}

package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class AtivoIndice extends Model {


	private String ticker;
	private String nome;
	private int intraday5;
	private int intraday15;
	private int intraday30;
	private int intraday10;
	// Relacionamentos 1
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
			obj.put("nome", nome);
			obj.put("intraday5", intraday5);
			obj.put("intraday15", intraday15);
			obj.put("intraday30", intraday30);
			obj.put("intraday10", intraday10);
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
	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setIntraday5(int valor) { 
		this.intraday5 = valor;
	}
	public int getIntraday5() { 
		return this.intraday5;
	}
	public void setIntraday15(int valor) { 
		this.intraday15 = valor;
	}
	public int getIntraday15() { 
		return this.intraday15;
	}
	public void setIntraday30(int valor) { 
		this.intraday30 = valor;
	}
	public int getIntraday30() { 
		return this.intraday30;
	}
	public void setIntraday10(int valor) { 
		this.intraday10 = valor;
	}
	public int getIntraday10() { 
		return this.intraday10;
	}

}

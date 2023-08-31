package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class AluguelFundoImobiliario extends Model {


	private String ticker;
	private String dataPagamento;
	private double valor;
	private String dataCom;
	private double percentual;
	private double cotacao;
	private String tipo;
	private String dataInsercao;
	// Relacionamentos 1
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("dataPagamento", dataPagamento);
			obj.put("valor", valor);
			obj.put("dataCom", dataCom);
			obj.put("percentual", percentual);
			obj.put("cotacao", cotacao);
			obj.put("tipo", tipo);
			obj.put("dataInsercao", dataInsercao);
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
	public void setDataPagamento(String valor) { 
		this.dataPagamento = valor;
	}
	public String getDataPagamento() { 
		return this.dataPagamento;
	}
	public void setValor(double valor) { 
		this.valor = valor;
	}
	public double getValor() { 
		return this.valor;
	}
	public void setDataCom(String valor) { 
		this.dataCom = valor;
	}
	public String getDataCom() { 
		return this.dataCom;
	}
	public void setPercentual(double valor) { 
		this.percentual = valor;
	}
	public double getPercentual() { 
		return this.percentual;
	}
	public void setCotacao(double valor) { 
		this.cotacao = valor;
	}
	public double getCotacao() { 
		return this.cotacao;
	}
	public void setTipo(String valor) { 
		this.tipo = valor;
	}
	public String getTipo() { 
		return this.tipo;
	}
	public void setDataInsercao(String valor) { 
		this.dataInsercao = valor;
	}
	public String getDataInsercao() { 
		return this.dataInsercao;
	}

}

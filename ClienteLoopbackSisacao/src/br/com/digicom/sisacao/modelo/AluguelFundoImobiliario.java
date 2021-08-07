package br.com.digicom.sisacao.modelo;

import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class AluguelFundoImobiliario extends Model{

	private Double valor;
	private String ticker;
	private String dataCom;
	private String dataPagamento;
	private Double percentual;
	private Double cotacao;
	private String tipo;
	
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("valor", valor);
			obj.put("ticker", ticker);
			obj.put("dataCom", dataCom);
			obj.put("dataPagamento", dataPagamento);
			obj.put("percentual", percentual);
			obj.put("cotacao", cotacao);
			obj.put("tipo", tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public String getDataCom() {
		return dataCom;
	}
	public void setDataCom(String dataCom) {
		this.dataCom = dataCom;
	}
	public String getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Double getPercentual() {
		return percentual;
	}
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
	public Double getCotacao() {
		return cotacao;
	}
	public void setCotacao(Double cotacao) {
		this.cotacao = cotacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}

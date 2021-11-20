package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class AtivoCriptomoeda  extends Model{

	private String ticker;
	private String nome;
	private Double valorMercado;
	private Integer posicao;
	//private Integer intraday5;
	//private Integer intraday15;
	//private Integer intraday30;
	//private Integer intraday10;
	
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public JSONObject jSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("nome", this.nome);
			saida.put("valorMercado", this.valorMercado);
			saida.put("posicao", this.posicao);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	public Double getValorMercado() {
		return valorMercado;
	}
	public void setValorMercado(Double valorMercado) {
		this.valorMercado = valorMercado;
	}
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	
	
}

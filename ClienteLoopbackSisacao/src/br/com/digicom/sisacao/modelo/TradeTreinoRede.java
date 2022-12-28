package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class TradeTreinoRede extends Model{

	private String ticker;
	private Double precoEntrada;
	private int diaNumEntrada;
	private Double precoSaida;
	private int diaNumSaida;
	private int treinoRedeId;
	
	private double precoStop;
	private double precoTarget;
	private String tipoCompraVenda;
	private int resultado;
	
	private int pontuacao;
	
	private double percentualMinimo;
	private double percentualMaximo;
	private int dias;
	private double target;
	private double stop;
	
	private int diaNumAtual;
	private double percentualAtual;
	
	
	
	
	public int getDiaNumAtual() {
		return diaNumAtual;
	}

	public void setDiaNumAtual(int diaNumAtual) {
		this.diaNumAtual = diaNumAtual;
	}

	public double getPercentualAtual() {
		return percentualAtual;
	}

	public void setPercentualAtual(double percentualAtual) {
		this.percentualAtual = percentualAtual;
	}

	public double getTarget() {
		return target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	public double getStop() {
		return stop;
	}

	public void setStop(double stop) {
		this.stop = stop;
	}

	public Object getJson() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("diaNumEntrada", this.diaNumEntrada);
			saida.put("precoEntrada", this.precoEntrada);
			saida.put("tipoCompraVenda", this.tipoCompraVenda);
			saida.put("qtdeDias", this.dias);
			saida.put("precoStop", this.precoStop);
			saida.put("precoTarget", this.precoTarget);
			saida.put("percentualMaximo", this.percentualMaximo);
			saida.put("percentualMinimo", this.percentualMinimo);
			saida.put("target", this.target);
			saida.put("stop", this.stop);
			saida.put("pontuacao", this.pontuacao);
			saida.put("treinoRedeId", this.treinoRedeId);
			
			saida.put("resultado", this.resultado);
			saida.put("precoSaida", this.precoSaida);
			saida.put("diaNumSaida", this.diaNumSaida);

			saida.put("diaNumAtual", this.diaNumAtual);
			saida.put("percentualAtual", this.percentualAtual);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	public Object getJsonEstrada() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("precoEntrada", this.precoEntrada);
			saida.put("diaNumEntrada", this.diaNumEntrada);
			saida.put("treinoRedeId", this.treinoRedeId);
			saida.put("precoStop", this.precoStop);
			saida.put("precoTarget", this.precoTarget);
			saida.put("tipoCompraVenda", this.tipoCompraVenda);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	public Object getJsonSaida() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("diaNumEntrada", this.diaNumEntrada);
			saida.put("treinoRedeId", this.treinoRedeId);
			saida.put("resultado", this.resultado);
			saida.put("precoSaida", this.precoSaida);
			saida.put("diaNumSaida", this.diaNumSaida);
			saida.put("pontuacao", this.pontuacao);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	public double getPercentualMinimo() {
		return percentualMinimo;
	}

	public void setPercentualMinimo(double percentualMinimo) {
		this.percentualMinimo = percentualMinimo;
	}

	public double getPercentualMaximo() {
		return percentualMaximo;
	}

	public void setPercentualMaximo(double percentualMaximo) {
		this.percentualMaximo = percentualMaximo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getTipoCompraVenda() {
		return tipoCompraVenda;
	}
	public void setTipoCompraVenda(String tipoCompraVenda) {
		this.tipoCompraVenda = tipoCompraVenda;
	}


	public double getPrecoStop() {
		return precoStop;
	}
	public void setPrecoStop(double precoStop) {
		this.precoStop = precoStop;
	}
	public void setPrecoStop(Integer precoStop) {
		this.precoStop = precoStop;
	}

	public double getPrecoTarget() {
		return precoTarget;
	}
	public void setPrecoTarget(double precoTarget) {
		this.precoTarget = precoTarget;
	}
	public void setPrecoTarget(Integer precoTarget) {
		this.precoTarget = precoTarget;
	}






	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getPrecoEntrada() {
		return precoEntrada;
	}
	public void setPrecoEntrada(Double precoEntrada) {
		this.precoEntrada = precoEntrada;
	}
	public int getDiaNumEntrada() {
		return diaNumEntrada;
	}
	public void setDiaNumEntrada(int diaNumEntrada) {
		this.diaNumEntrada = diaNumEntrada;
	}
	public Double getPrecoSaida() {
		return precoSaida;
	}
	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}
	public int getDiaNumSaida() {
		return diaNumSaida;
	}
	public void setDiaNumSaida(int diaNumSaida) {
		this.diaNumSaida = diaNumSaida;
	}
	public int getTreinoRedeId() {
		return treinoRedeId;
	}
	public void setTreinoRedeId(int treinoRedeId) {
		this.treinoRedeId = treinoRedeId;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public void calculaFinalizacao() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

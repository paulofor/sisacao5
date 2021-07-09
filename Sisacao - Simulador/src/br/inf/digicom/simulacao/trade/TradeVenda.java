package br.inf.digicom.simulacao.trade;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;

public class TradeVenda extends Trade {




	
	public boolean lucro() {
		return this.precoSaida < this.precoEntrada;
	}
	public boolean prejuizo() {
		return this.precoEntrada < this.precoSaida;
	}
	public double percentual() {
		return ((this.precoEntrada - this.precoSaida) / this.precoEntrada) * 100;
	}
	
	public TradeVenda(double precoEntrada, CotacaoIntradayAcao cotacao, int indDiaEntrada) {
		super(precoEntrada,cotacao,indDiaEntrada);
	}


	public String getTipo() {
		return "V";
	}


}

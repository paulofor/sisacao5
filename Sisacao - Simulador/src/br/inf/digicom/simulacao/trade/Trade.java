package br.inf.digicom.simulacao.trade;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;

public class Trade {

	private CotacaoIntradayAcao entrada = null;
	private CotacaoIntradayAcao saida = null;
	private int indDiaEntrada = 0;
	private int indDiaSaida = 0;
	private int difDias = 0;
	
	private double precoEntrada;
	private double precoSaida;

	public CotacaoIntradayAcao getCotacaoEntrada() {
		return this.entrada;
	}
	public CotacaoIntradayAcao getCotacaoSaida() {
		return this.saida;
	}
	
	public boolean lucro() {
		return this.precoSaida > this.precoEntrada;
	}
	public boolean prejuizo() {
		return this.precoEntrada > this.precoSaida;
	}
	public double percentual() {
		return ((this.precoSaida - this.precoEntrada) / this.precoEntrada) * 100;
	}
	
	public Trade(double precoEntrada, CotacaoIntradayAcao cotacao, int indDiaEntrada) {
		this.entrada = cotacao;
		this.indDiaEntrada = indDiaEntrada;
		this.precoEntrada = precoEntrada;
	}

	public double getValorEntrada() {
		return this.precoEntrada;
	}
	public double getValorSaida() {
		return this.precoSaida;
	}

	public void setSaida(double precoSaida, CotacaoIntradayAcao cotacao, int indDiaSaida) {
		this.saida = cotacao;
		this.indDiaSaida = indDiaSaida;
		this.difDias = this.indDiaSaida - this.indDiaEntrada;
		this.precoSaida = precoSaida;
	}
	
	public String entradaDataPrecoDisplay() {
		return "" + entrada.getDataExtraida() + " (" + entrada.getValor() + ")";
	}
	
	public String entradaDisplay() {
		return "" + entrada.getValor();
	}
	public String saidaDisplay() {
		return "" + saida.getValor();
	}

	public void printTrade() {
		
		System.out.println("Ent: " + this.precoEntrada + " (" + entrada.getValor() + ")");
		System.out.println("Sai: " + saida.getValor() + " (" + this.difDias + " dias)");
	}
	public Integer getQuantidadeDia() {
		return this.difDias;
	}

}

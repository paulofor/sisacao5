package br.inf.digicom.simulacao.trade;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;

public class Trade {

	private CotacaoIntradayAcao entrada = null;
	private CotacaoIntradayAcao saida = null;
	private int indDiaEntrada = 0;
	private int indDiaSaida = 0;
	private int difDias = 0;
	
	private double precoEntrada;

	public Trade(double precoEntrada, CotacaoIntradayAcao cotacao, int indDiaEntrada) {
		this.entrada = cotacao;
		this.indDiaEntrada = indDiaEntrada;
		this.precoEntrada = precoEntrada;
	}

	public double getValorEntrada() {
		return this.precoEntrada;
	}

	public void setSaida(CotacaoIntradayAcao cotacao, int indDiaSaida) {
		this.saida = cotacao;
		this.indDiaSaida = indDiaSaida;
		this.difDias = this.indDiaSaida - this.indDiaEntrada;
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

}

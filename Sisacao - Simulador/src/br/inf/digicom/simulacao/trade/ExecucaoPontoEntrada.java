package br.inf.digicom.simulacao.trade;

import java.util.ArrayList;
import java.util.List;

public class ExecucaoPontoEntrada {
	
	
	private List<Trade> trades = new ArrayList<Trade>();
	private int somaLucro = 0;
	private int somaPrejuizo = 0;
	
	public int getSomaLucro() {
		return this.somaLucro;
	}
	public int getSomaPrejuizo() {
		return this.somaPrejuizo;
	}
	
	public List<Trade> listaTrades() {
		return this.trades;
	}
	
	public void addTrade(Trade trade) {
		if (trade.lucro()) somaLucro++;
		if (trade.prejuizo()) somaPrejuizo++;
		this.trades.add(trade);
	}
	
	public void exibeResultado() {
		for (Trade trade : trades) {
			trade.printTrade();
		}
	}
	
	
	
}

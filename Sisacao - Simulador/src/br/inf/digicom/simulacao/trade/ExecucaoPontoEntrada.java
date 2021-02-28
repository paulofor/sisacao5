package br.inf.digicom.simulacao.trade;

import java.util.ArrayList;
import java.util.List;

public class ExecucaoPontoEntrada {
	
	private List<Trade> trades = new ArrayList<Trade>();
	
	public void addTrade(Trade trade) {
		this.trades.add(trade);
	}
	
	public void exibeResultado() {
		for (Trade trade : trades) {
			trade.printTrade();
		}
	}
	
	
	
}

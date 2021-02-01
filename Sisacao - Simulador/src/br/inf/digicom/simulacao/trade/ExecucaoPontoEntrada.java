package br.inf.digicom.simulacao.trade;

import java.util.ArrayList;
import java.util.List;

public class ExecucaoPontoEntrada {
	
	private int diasAtual = 5;
	private int posicaoSaidaAtual = 20;
	private double targetAtual = .07;
	private double stopAtual = .1;
	
	private List<Trade> trades = new ArrayList<Trade>();

	
	public int getDias() {
		return diasAtual;
	}

	public int getPosicaoSaida() {
		return posicaoSaidaAtual;
	}

	public double getTarget() {
		return this.targetAtual;
	}

	public double getStop() {
		return this.stopAtual;
	}
	
	public void addTrade(Trade trade) {
		this.trades.add(trade);
	}
	
	
	public void exibeResultado() {
		for (Trade trade : trades) {
			trade.printTrade();
		}
	}

	public int getLimiteMinimo() {
		return this.diasAtual * 30;
	}
}

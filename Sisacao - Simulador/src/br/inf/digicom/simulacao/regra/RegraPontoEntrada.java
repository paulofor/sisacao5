package br.inf.digicom.simulacao.regra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class RegraPontoEntrada implements IRegraPontoEntrada {
	
	private int diaInicial;
	
	private List<Double> valores;
	
	private int diasAtual;
	private int posicaoSaidaAtual;
	private double targetAtual;
	private double stopAtual;
	
	@Override
	public void setParametros(Map parametros) {
		// TODO Auto-generated method stub
		this.diasAtual = ((Double) parametros.get("dias")).intValue();
		this.posicaoSaidaAtual = ((Double) parametros.get("posicaoSaida")).intValue();
		this.targetAtual = (double) parametros.get("target");
		this.stopAtual = (double) parametros.get("stop");
	}

	
	public int getLimiteMinimo() {
		return this.diasAtual * 30;
	}
	
	
	
	private ExecucaoPontoEntrada execucao = null;
	
	public void setExecucaoPontoEntrada(ExecucaoPontoEntrada execucao) {
		this.execucao = execucao;
	}

	public double getPontoEntrada(int indDia, List<DiaPregao> dias) {
		if (indDia - diaInicial <= diasAtual) {
			return 0;
		} else {
			valores = new ArrayList<Double>();
			for (int i=indDia; i>(indDia-diasAtual); i--) {
				List<CotacaoIntradayAcao> cotacoes = dias.get(i).getCotacaoIntradayAcaos();
				for (CotacaoIntradayAcao cot : cotacoes) {
					valores.add(cot.getValor());
				}
			}
			Collections.sort(valores);
			if (valores.size() > getLimiteMinimo()) {
				System.out.println("(" + valores.get(0) + " - " + valores.get(valores.size()-1) + ")");
				return valores.get(posicaoSaidaAtual);
			} else {
				return 0;
			}
		}
	}

	public void setDiaInicial(int indDia) {
		this.diaInicial = indDia;
	}

	@Override
	public double getTarget() {
		return this.targetAtual;
	}

	@Override
	public double getStop() {
		return this.stopAtual;
	}

	
}

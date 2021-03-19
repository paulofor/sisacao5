package br.inf.digicom.simulacao.regra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class RegraEntradaDistanteAlvo implements IRegraPontoEntrada {
	
	private int diaInicial;
	
	private List<Double> valores;
	
	private int dias;
	private int posicao;
	private double target;
	private double stop;
	private double percSeguranca;
	
	@Override
	public void setParametros(Map parametros) {
		this.dias = ((Double) parametros.get("dias")).intValue();
		this.posicao = ((Double) parametros.get("posicao")).intValue();
		this.target = (double) parametros.get("target");
		this.stop = (double) parametros.get("stop");
		this.percSeguranca = (double) parametros.get("precentAdd");
	}

	
	public int getLimiteMinimo() {
		return this.dias * 30;
	}
	
	
	
	private ExecucaoPontoEntrada execucao = null;
	
	public void setExecucaoPontoEntrada(ExecucaoPontoEntrada execucao) {
		this.execucao = execucao;
	}

	public double getPontoEntrada(int indDia, List<DiaPregao> pregao) {
		if (indDia - diaInicial <= dias) {
			return 0;
		} else {
			valores = new ArrayList<Double>();
			for (int i=indDia; i>(indDia-dias); i--) {
				List<CotacaoIntradayAcao> cotacoes = pregao.get(i).getCotacaoIntradayAcaos();
				for (CotacaoIntradayAcao cot : cotacoes) {
					valores.add(cot.getValor());
				}
			}
			Collections.sort(valores);
			if (valores.size() > getLimiteMinimo()) {
				System.out.println("(" + valores.get(0) + " - " + valores.get(valores.size()-1) + ")");
				double valorReferencia = valores.get(valores.size() - posicao);
				double percentual = target + percSeguranca;
				double entrada = valorReferencia / (percentual + 1);
				return entrada;
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
		return this.target;
	}

	@Override
	public double getStop() {
		return this.stop;
	}

	
}

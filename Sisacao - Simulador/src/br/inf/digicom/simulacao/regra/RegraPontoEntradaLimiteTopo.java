package br.inf.digicom.simulacao.regra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class RegraPontoEntradaLimiteTopo implements IRegraPontoEntrada, IRegraCompra {
	
	private int diaInicial;
	
	private List<Double> valores;
	private List<Double> valoresTopo;
 	
	private int diasMin;
	private int posicaoMin;
	private double target;
	private double stop;
	private int diasTopo;
	private int posicaoTopo;
	private double percentualSeguranca;
	
	@Override
	public void setParametros(Map parametros) {
		this.diasMin = ((Double) parametros.get("diasMin")).intValue();
		this.posicaoMin = ((Double) parametros.get("posicaoMin")).intValue();
		this.target = (double) parametros.get("target");
		this.stop = (double) parametros.get("stop");
		this.diasTopo = ((Double) parametros.get("diasTopo")).intValue();
		this.posicaoTopo = ((Double) parametros.get("posicaoTopo")).intValue();
		this.percentualSeguranca = (double) parametros.get("percentualSeguranca");
	}

	
	public int getLimiteMinimo() {
		return this.diasMin * FabricaRegra.TICKER_DIA;
	}
	public int getLimiteMinimoTopo() {
		return this.diasTopo * FabricaRegra.TICKER_DIA;
	}
	
	
	
	private ExecucaoPontoEntrada execucao = null;
	
	public void setExecucaoPontoEntrada(ExecucaoPontoEntrada execucao) {
		this.execucao = execucao;
	}

	public double getPontoEntrada(int indDia, List<DiaPregao> dias) {
		if (indDia - diaInicial <= diasMin ) {
			return 0;
		} else {
			valores = new ArrayList<Double>();
			for (int i=indDia; i>(indDia-diasMin); i--) {
				List<CotacaoIntradayAcao> cotacoes = dias.get(i).getCotacaoIntradayAcaos();
				for (CotacaoIntradayAcao cot : cotacoes) {
					valores.add(cot.getValor());
				}
			}
			Collections.sort(valores);
			//System.out.println("(" + valores.get(0) + " - " + valores.get(valores.size()-1) + ")");
			
			valoresTopo = new ArrayList<Double>();
			for (int i=indDia; i>(indDia-diasTopo); i--) {
				List<CotacaoIntradayAcao> cotacoes = dias.get(i).getCotacaoIntradayAcaos();
				for (CotacaoIntradayAcao cot : cotacoes) {
					valoresTopo.add(cot.getValor());
				}
			}
			Collections.sort(valoresTopo);
			//System.out.println("(" + valoresTopo.get(0) + " - " + valoresTopo.get(valoresTopo.size()-1) + ")");
			
			if (valores.size() > getLimiteMinimo() && valoresTopo.size() > this.getLimiteMinimoTopo()) {
				double valorEntrada = valores.get(posicaoMin);
				double saidaLucro = valorEntrada * (1 + this.target + this.percentualSeguranca);
				double limiteTopo = valoresTopo.get(valoresTopo.size() - this.posicaoTopo - 1);
				if (limiteTopo>=saidaLucro) {
					return valorEntrada;
				} else {
					return 0;
				}
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

	@Override
	public String getTipo() {
		return "C";
	}
	
}

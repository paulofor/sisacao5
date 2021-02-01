package br.inf.digicom.simulacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class RegraPontoEntrada {
	
	private int diaInicial;
	
	private List<Double> valores;
	
	//private final int DIAS = 10;
	//private final int POSICAO_SAIDA = 15;
	
	private ExecucaoPontoEntrada execucao = null;
	
	public void setExecucaoPontoEntrada(ExecucaoPontoEntrada execucao) {
		this.execucao = execucao;
	}

	public double getPontoEntrada(int indDia, List<DiaPregao> dias) {
		if (indDia - diaInicial <= execucao.getDias()) {
			return 0;
		} else {
			valores = new ArrayList<Double>();
			for (int i=indDia; i>(indDia-execucao.getDias()); i--) {
				List<CotacaoIntradayAcao> cotacoes = dias.get(i).getCotacaoIntradayAcaos();
				for (CotacaoIntradayAcao cot : cotacoes) {
					valores.add(cot.getValor());
				}
			}
			Collections.sort(valores);
			if (valores.size() > execucao.getLimiteMinimo()) {
				System.out.println("(" + valores.get(0) + " - " + valores.get(valores.size()-1) + ")");
				return valores.get(execucao.getPosicaoSaida());
			} else {
				return 0;
			}
		}
	}

	public void setDiaInicial(int indDia) {
		this.diaInicial = indDia;
	}

}

package br.inf.digicom.simulacao;

import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;

public class SimuladorPontoEntradaDia {
	
	//RegraPontoEntrada regra = new RegraPontoEntrada();
	int somaLucro = 0;
	int somaPrejuizo = 0;
	
	double pontoEntrada;
	
	
	public ExecucaoPontoEntrada executa(List<DiaPregao> dias, Map parametros, IRegraPontoEntrada regra) {

		ExecucaoPontoEntrada execucao = new ExecucaoPontoEntrada();
		regra.setExecucaoPontoEntrada(execucao);
		regra.setParametros(parametros);
		Trade trade = null;
		
		int indDia = 0;
		int indHora = 0;
		while (dias.get(indDia).getCotacaoIntradayAcaos().size() == 0) {
			indDia++;
		}
		regra.setDiaInicial(indDia);
		indHora = 0;
		while (dias.get(indDia).getDiaNum() < 20210226) {
			indHora = 0;
			pontoEntrada = regra.getPontoEntrada(indDia, dias);
			while (dias.get(indDia).getCotacaoIntradayAcaos().size()>indHora) {
				CotacaoIntradayAcao cotacao = getCotacao(indDia,indHora,dias);
				if (cotacao!=null) {
					if (trade==null) {
						//System.out.println("Valor: " + cotacao.getValor() + " Entrada: " + pontoEntrada);
						if (pontoEntrada>=cotacao.getValor()) {
							trade = new Trade((indHora==0?cotacao.getValor():pontoEntrada),cotacao, indDia);
						}
					} else {
						double saidaAlta = trade.getValorEntrada() * (1+regra.getTarget());;
						double saidaBaixa = trade.getValorEntrada() * (1-regra.getStop());
						//System.out.println("Valor: " + cotacao.getValor() + " Target: " + saidaAlta + "Stop: " + saidaBaixa);
						if (cotacao.getValor()>=saidaAlta) {
							this.somaLucro++;
							trade.setSaida((indHora==0?cotacao.getValor():saidaAlta), cotacao, indDia);
							indDia++;
							indHora=0;
							execucao.addTrade(trade);
							trade = null;
							//break;
						}
						if (cotacao.getValor()<=saidaBaixa) {
							this.somaPrejuizo++;
							trade.setSaida((indHora==0?cotacao.getValor():saidaBaixa),cotacao, indDia);
							indDia++;
							indHora=0;
							execucao.addTrade(trade);
							trade = null;
							//break;
						}
					}
				}
				indHora++;
			}
			indDia++;
			indHora=0;
		}
		System.out.println("Lucro:" + this.somaLucro);
		System.out.println("Prejuizo:" + this.somaPrejuizo);
		execucao.exibeResultado();
		return execucao;
	}
	
	

	private CotacaoIntradayAcao getCotacao(int indDia, int indHora, List<DiaPregao> dias) {
		if (dias.get(indDia).getCotacaoIntradayAcaos().size() > indHora) {
			return dias.get(indDia).getCotacaoIntradayAcaos().get(indHora);
		} else {
			return null;
		}
	}

}

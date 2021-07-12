package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;
import br.inf.digicom.simulacao.trade.TradeVenda;

public class SimuladorPontoEntradaDiaVenda extends SimuladorPontoEntradaDia {
	
	//RegraPontoEntrada regra = new RegraPontoEntrada();
	
	
	public ExecucaoPontoEntrada executa(List<DiaPregao> dias, Map parametros, IRegraPontoEntrada regra, int diaInicio, int diaFim) {

		ExecucaoPontoEntrada execucao = new ExecucaoPontoEntrada();
		regra.setExecucaoPontoEntrada(execucao);
		regra.setParametros(parametros);
		Trade trade = null;
		
		int indDia = 0;
		int indHora = 0;
		//while (dias.get(indDia).getCotacaoIntradayAcaos().size() == 0) {
		//	indDia++;
		//}
		while (dias.get(indDia).getDiaNum() < diaInicio) {
			indDia++;
		}
		regra.setDiaInicial(indDia);
		indHora = 0;
		while (dias.get(indDia).getDiaNum() <= diaFim) {
			indHora = 0;
			pontoEntrada = regra.getPontoEntrada(indDia -1, dias);
			while (dias.get(indDia).getCotacaoIntradayAcaos().size()>indHora   && pontoEntrada>0) {
				CotacaoIntradayAcao cotacao = getCotacao(indDia,indHora,dias);
				if (cotacao!=null) {
					if (trade==null) {
						//System.out.println("Valor: " + cotacao.getValor() + " Entrada: " + pontoEntrada);
						if (pontoEntrada<=cotacao.getValor()) {
							trade = new TradeVenda((indHora==0?cotacao.getValor():pontoEntrada),cotacao, indDia);
						}
					} else {
						double saidaAlta = trade.getValorEntrada() * (1+regra.getStop());;
						double saidaBaixa = trade.getValorEntrada() * (1-regra.getTarget());
						//System.out.println("Valor: " + cotacao.getValor() + " Target: " + saidaAlta + "Stop: " + saidaBaixa);
						if (cotacao.getValor()>=saidaAlta) {
							this.somaPrejuizo++;
							trade.setSaida((indHora==0?cotacao.getValor():saidaAlta), cotacao, indDia);
							indDia++;
							indHora=0;
							execucao.addTrade(trade);
							trade = null;
							//break;
						}
						if (cotacao.getValor()<=saidaBaixa) {
							this.somaLucro++;
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
	
	

	

}

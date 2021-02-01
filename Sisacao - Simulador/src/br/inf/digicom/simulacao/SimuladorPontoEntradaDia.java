package br.inf.digicom.simulacao;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;

public class SimuladorPontoEntradaDia {
	
	RegraPontoEntrada regra = new RegraPontoEntrada();
	int somaLucro = 0;
	int somaPrejuizo = 0;
	
	double pontoEntrada;
	
	
	public void executa(List<DiaPregao> dias, ExecucaoPontoEntrada execucao) {

		regra.setExecucaoPontoEntrada(execucao);
		Trade trade = null;
		
		int indDia = 0;
		int indHora = 0;
		while (dias.get(indDia).getCotacaoIntradayAcaos().size() == 0) {
			indDia++;
		}
		regra.setDiaInicial(indDia);
		indHora = 0;
		while (dias.get(indDia).getDiaNum() < 20210129) {
			indHora = 0;
			pontoEntrada = regra.getPontoEntrada(indDia, dias);
			while (dias.get(indDia).getCotacaoIntradayAcaos().size()>indHora) {
				CotacaoIntradayAcao cotacao = getCotacao(indDia,indHora,dias);
				if (cotacao!=null) {
					if (trade==null) {
						
						System.out.println("Valor: " + cotacao.getValor() + " Entrada: " + pontoEntrada);
						if (pontoEntrada>=cotacao.getValor()) {
							trade = new Trade(cotacao, indDia);
						}
					} else {
						double saidaAlta = trade.getValorEntrada() * (1+execucao.getTarget());;
						double saidaBaixa = trade.getValorEntrada() * (1-execucao.getStop());
						//System.out.println("Valor: " + cotacao.getValor() + " Target: " + saidaAlta + "Stop: " + saidaBaixa);
						if (cotacao.getValor()>=saidaAlta) {
							this.somaLucro++;
							trade.setSaida(cotacao, indDia);
							indDia++;
							indHora=0;
							execucao.addTrade(trade);
							trade = null;
							//break;
						}
						if (cotacao.getValor()<=saidaBaixa) {
							this.somaPrejuizo++;
							trade.setSaida(cotacao, indDia);
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
	}
	
	

	private CotacaoIntradayAcao getCotacao(int indDia, int indHora, List<DiaPregao> dias) {
		if (dias.get(indDia).getCotacaoIntradayAcaos().size() > indHora) {
			return dias.get(indDia).getCotacaoIntradayAcaos().get(indHora);
		} else {
			return null;
		}
	}

}

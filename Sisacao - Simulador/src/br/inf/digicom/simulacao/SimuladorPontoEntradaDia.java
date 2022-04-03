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

public class SimuladorPontoEntradaDia {
	
	//RegraPontoEntrada regra = new RegraPontoEntrada();
	int somaLucro = 0;
	int somaPrejuizo = 0;
	
	double pontoEntrada;
	
	
	public Double precoEntrada(List<DiaPregao> dias, CombinacaoParametro combinacao, IRegraPontoEntrada regra, int dia) {
		Map parametros = new HashMap();
		for (ValorParametro param : combinacao.getValorParametros()) {
			parametros.put(param.getParametroRegra().getAtributoClasse(),param.getValorParametro());
		}
		regra.setParametros(parametros);
		int indDia = 0;
		int indHora = 0;
		try {
			while (dias.get(indDia).getDiaNum() < dia) {
				indDia++;
			}
		} catch (Exception e ) {
			System.out.println("indDia:" + indDia);
			System.out.println("dia:" + dia);
			System.out.println("dias.size()" + dias.size());
			System.out.println("dias.get(indDia):" + dias.get(indDia));
			System.exit(-1);
		}
		
		regra.setDiaInicial(0);
		Double pontoEntrada = regra.getPontoEntrada(indDia - 1, dias);
		return pontoEntrada;
	}
	
	
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
		while (indDia<dias.size() && dias.get(indDia).getDiaNum() <= diaFim) {
			indHora = 0;
			pontoEntrada = regra.getPontoEntrada(indDia -1, dias);
			while (dias.get(indDia).getCotacaoIntradayAcaos().size()>indHora && pontoEntrada>0) {
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
	
	

	protected CotacaoIntradayAcao getCotacao(int indDia, int indHora, List<DiaPregao> dias) {
		if (dias.get(indDia).getCotacaoIntradayAcaos().size() > indHora) {
			return dias.get(indDia).getCotacaoIntradayAcaos().get(indHora);
		} else {
			return null;
		}
	}

}

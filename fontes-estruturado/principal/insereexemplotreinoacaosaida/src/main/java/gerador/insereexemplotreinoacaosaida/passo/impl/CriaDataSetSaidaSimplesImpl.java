package gerador.insereexemplotreinoacaosaida.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExemploTreinoAcaoEntrada;
import br.com.gersis.loopback.modelo.ExemploTreinoAcaoSaida;
import br.com.gersis.loopback.modelo.RegraProjecao;
import gerador.insereexemplotreinoacaosaida.passo.CriaDataSetSaidaSimples;
import gerador.insereexemplotreinoacaosaida.passo.suporte.DadosTreinoY;
import gerador.insereexemplotreinoacaosaida.passo.suporte.ProcuraPontoSaida;



public class CriaDataSetSaidaSimplesImpl extends CriaDataSetSaidaSimples {

	
	private List<DiaPregao> dias = null;
	private DadosTreinoY dadosTreino = new DadosTreinoY();;

	private ProcuraPontoSaida procuraPontoSaida = new ProcuraPontoSaida();
	
	private double valorEntrada;
	private ExemploTreinoAcaoSaida exemploSaida = new ExemploTreinoAcaoSaida();
	
	
	@Override
	protected boolean executaCustom(RegraProjecao regraSaida, ExemploTreinoAcaoEntrada exemploCorrente,
			List<DiaPregao> listaDia) {
		System.out.println("*******");
		System.out.println("Amostra com " + listaDia.size() + " dias, preciso de " + regraSaida.getDiaLimite());
		System.out.println("Analisando " + exemploCorrente.getTicker() + ", dia " + exemploCorrente.getDiaNumPrevisao() + ", regra:" + regraSaida.getCodigoRegraProjecao());
		System.out.println("*******");
		this.dias = listaDia;
		int tamAmostra = listaDia.size();
		int tamRegraProjeco = regraSaida.getDiaLimite();

		if (tamAmostra<tamRegraProjeco) {
			if (tamAmostra==0) {
				this.finalizar();
				return false;
			} else {
				return false;
			}
		} else {
			processaDias(regraSaida, exemploCorrente);
			this.saidaSaida = exemploSaida;
			return true;
		}
		
	}

	
	
	private void processaDias(RegraProjecao regraSaida, ExemploTreinoAcaoEntrada entrada) {
		int diaReferencia = 0;

		this.procuraPontoSaida.setRegra(regraSaida);
		DiaPregao ontem = dias.get(0);
		DiaPregao diaOperacao = dias.get(1);
		int posicao = 15 - regraSaida.getIndiceHoraReferenciaDataset() - 1;
		double valorReferencia = ontem.getCotacaoIntradayAcaoResultados().get(posicao).getValor();
		dias.remove(0);
		if ("V".equals(regraSaida.getTipoCompraVenda())) {
			this.valorEntrada = valorReferencia * (1 + regraSaida.getPercentualEntradaDataset()); // Venda
			double minimo = obtemMinimo(diaOperacao);
			double maximo = obtemMaximo(diaOperacao);
			if (valorEntrada >= minimo && valorEntrada <= maximo) {
				// Entrou
				Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
				if (result!=null) {
					dadosTreino.calcula(dias, result, this.procuraPontoSaida, valorReferencia);
					enviaDia(entrada.getTicker(), regraSaida, dadosTreino, procuraPontoSaida,valorEntrada, valorReferencia );
				} else {
					DiaPregao atual = dias.get(diaReferencia);
					System.out.println("Dia sem saída:" + atual);
					System.out.println("");
				}
			} else {
				dadosTreino.calcula(dias, this.procuraPontoSaida, valorReferencia);
				enviaDia(entrada.getTicker(), regraSaida, dadosTreino, null,valorEntrada, valorReferencia);

			}
		} else {
			this.valorEntrada = valorReferencia * (1 - regraSaida.getPercentualEntradaDataset()); // Compra
			double minimo = obtemMinimo(diaOperacao);
			double maximo = obtemMaximo(diaOperacao);
			if (valorEntrada >= minimo && valorEntrada <= maximo) {

				Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
				if (result!=null) {
					dadosTreino.calcula(dias, result, this.procuraPontoSaida, valorReferencia);
					enviaDia(entrada.getTicker(), regraSaida, dadosTreino, procuraPontoSaida,valorEntrada, valorReferencia );
				} else {
					DiaPregao atual = dias.get(diaReferencia);
					System.out.println("Dia sem saída:" + atual);
					System.out.println("");
				}
			} else {
				dadosTreino.calcula(dias, this.procuraPontoSaida, valorReferencia);
				enviaDia(entrada.getTicker(), regraSaida, dadosTreino, null,valorEntrada, valorReferencia );
			}
		}

		
	}

	private Double obtemMinimo(DiaPregao dia) {
		Double min = (dia.getCotacaoDiarioAcaos().size()>0?dia.getCotacaoDiarioAcaos().get(0).getMinimo():null);
		if (min!=null) return min;
		min = 99999d;
		for (CotacaoIntradayAcaoResultado cotacao :dia.getCotacaoIntradayAcaoResultados()) {
			if (cotacao.getValor() < min) min = cotacao.getValor();
		}
		return min;
	}
	private Double obtemMaximo(DiaPregao dia) {
		Double max = (dia.getCotacaoDiarioAcaos().size()>0?dia.getCotacaoDiarioAcaos().get(0).getMaximo():null);
		if (max!=null) return max;
		max = 0d;
		for (CotacaoIntradayAcaoResultado cotacao :dia.getCotacaoIntradayAcaoResultados()) {
			if (cotacao.getValor() > max) max = cotacao.getValor();
		}
		return max;
		
		
	}
	
	private DiaPregao getDiaSeguinte(int ind) {
		if (ind+1 < dias.size()) {
			return dias.get(ind+1);
		} else {
			return null;
		}
	}


	
	
	public void enviaDia(String ticker, RegraProjecao regra, DadosTreinoY dadosTreino,
			ProcuraPontoSaida procSaida, double valorEntrada, double valorReferencia) {
		exemploSaida = new ExemploTreinoAcaoSaida();
		exemploSaida.setTicker(ticker);
		exemploSaida.setCampoY(dadosTreino.getSaidaY());
		exemploSaida.setDiaNumPrevisao(dadosTreino.getDiaPrevisao().getDiaNum());
		exemploSaida.setDiaNumSaida(dadosTreino.getDiaNumSaida());
		if (procSaida !=null) {
			exemploSaida.setLimiteSuperior(procSaida.getLimiteAlto());
			exemploSaida.setLimiteInferior(procSaida.getLimiteBaixo());
			exemploSaida.setDiaNumSaida(procSaida.getDiaNumSaida());
			exemploSaida.setValorSaida(procSaida.getValorSaida());
			
		}
		exemploSaida.setRegraProjecaoId(Integer.parseInt(regra.getId().toString()));
		exemploSaida.setResultado(dadosTreino.getResultado());
		exemploSaida.setValorEntrada(valorEntrada);
		
	}
}


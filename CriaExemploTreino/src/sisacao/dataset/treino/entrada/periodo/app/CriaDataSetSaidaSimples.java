package sisacao.dataset.treino.entrada.periodo.app;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.proc.ProcuraPontoSaida;

public class CriaDataSetSaidaSimples extends DaoBaseApp{

	private List<DiaPregao> dias = null;
	private DadosTreinoY dadosTreino = new DadosTreinoY();;
	private EnviaDadosY enviaDados = new EnviaDadosY();;
	private DummyDaoBase dummy = null;
	private ProcuraPontoSaida procuraPontoSaida = new ProcuraPontoSaida();
	
	private double valorEntrada;

	public CriaDataSetSaidaSimples() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected void executaImpl() {
		DatasetExemplo ds = (DatasetExemplo) getComum();
		this.dias = ds.getListaCotacaoResultado();
		System.out.println("Amostra dia: " + this.dias.size());
		int tamAmostra = dias.size();
		int tamRegraProjeco = ds.getRegraProjecao().getDiaLimite();
		if (dias.size()<ds.getRegraProjecao().getDiaLimite()) {
			if (dias.size()==0) {
				this.finalizar();
			} else {
				this.executaProximo();
			}
			
		} else {
			processaDias();
			this.executaProximo();
		}
		
	}

	private void processaDias() {
		int diaReferencia = 0;
		DatasetExemplo comum = (DatasetExemplo) getComum();
		ExemploTreinoAcaoEntrada entrada = comum.getExemploTreinoAcaoEntrada();
		RegraProjecao regra = comum.getRegraProjecao();
		this.procuraPontoSaida.setRegra(regra);
		DiaPregao ontem = dias.get(0);
		DiaPregao diaOperacao = dias.get(1);
		int posicao = 15 - regra.getIndiceHoraReferenciaDataset() - 1;
		double valorReferencia = ontem.getCotacaoIntradayAcaoResultados().get(posicao).getValor();
		dias.remove(0);
		if ("V".equals(regra.getTipoCompraVenda())) {
			this.valorEntrada = valorReferencia * (1 + regra.getPercentualEntradaDataset()); // Venda
			double minimo = obtemMinimo(diaOperacao);
			double maximo = obtemMaximo(diaOperacao);
			if (valorEntrada >= minimo && valorEntrada <= maximo) {
				// Entrou
				Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
				if (result!=null) {
					dadosTreino.calcula(dias, result, this.procuraPontoSaida, valorReferencia);
					this.enviaDados.enviaDia(entrada.getTicker(), regra, dadosTreino, procuraPontoSaida,valorEntrada, valorReferencia );
				} else {
					DiaPregao atual = dias.get(diaReferencia);
					System.out.println("Dia sem saída:" + atual);
					System.out.println("");
				}
			} else {
				dadosTreino.calcula(dias, this.procuraPontoSaida, valorReferencia);
				this.enviaDados.enviaDia(entrada.getTicker(), regra, dadosTreino, null,valorEntrada, valorReferencia);

			}
		} else {
			this.valorEntrada = valorReferencia * (1 - regra.getPercentualEntradaDataset()); // Compra
			double minimo = obtemMinimo(diaOperacao);
			double maximo = obtemMaximo(diaOperacao);
			if (valorEntrada >= minimo && valorEntrada <= maximo) {

				Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
				if (result!=null) {
					dadosTreino.calcula(dias, result, this.procuraPontoSaida, valorReferencia);
					this.enviaDados.enviaDia(entrada.getTicker(), regra, dadosTreino, procuraPontoSaida,valorEntrada, valorReferencia );
				} else {
					DiaPregao atual = dias.get(diaReferencia);
					System.out.println("Dia sem saída:" + atual);
					System.out.println("");
				}
			} else {
				dadosTreino.calcula(dias, this.procuraPontoSaida, valorReferencia);
				this.enviaDados.enviaDia(entrada.getTicker(), regra, dadosTreino, null,valorEntrada, valorReferencia );

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

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}
	
	

}

package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetComum;

public class GeraDataset extends DaoBaseApp {
	
	private DummyDaoBase dummy = null;
	

	private List<DiaPregao> dias = null;
	private double valorEntrada = 0;
	private RegraProjecao regraProjecao;
	private ProcuraPontoSaida procuraPontoSaida = null;
	private DadosTreino dadosTreino = null;
	private EnviaDados enviaDados = null;
	private String ticker = null;
	
	private long diaEntradaNum;
	
	public GeraDataset() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	public long getDiaEntradaNum() {
		return diaEntradaNum;
	}

	public void setDiaEntradaNum(long diaEntradaNum) {
		this.diaEntradaNum = diaEntradaNum;
	}

	

	private void executaItem() {
		DatasetComum comum = (DatasetComum) getComum();
		this.dias = comum.getListaPregao();
		this.ticker = comum.getAtivoAcaoCorrente().getTicker();
		this.regraProjecao = comum.getRegraProjecao();
		procuraPontoSaida = new ProcuraPontoSaida(this.regraProjecao);
		this.dadosTreino = new DadosTreino();
		this.dadosTreino.setQuantidadeDia(comum.getQuantidadeDiasX());
		this.enviaDados = new EnviaDados();
		processaDias();
		System.out.println(" !!!!  final de execução !!!!");
	}
	
	private void processaDias() {
		DatasetComum comum = (DatasetComum) getComum();
		int diaReferencia = 0;
		CotacaoIntradayAcaoResultado cotacaoDiaAnterior = null;
		DiaPregao diaOperacao = null;
		try {
			
			int indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + this.regraProjecao.getIndiceHoraReferenciaDataset() - 1;
			for (int indDia=comum.getQuantidadeDiasX();indDia<(dias.size()-10);indDia++) {
				diaOperacao = dias.get(indDia);
				DiaPregao diaAnterior = dias.get(indDia-1);
				cotacaoDiaAnterior = diaAnterior.getCotacaoIntradayAcaoResultados().get(indiceDia);
				if ("V".equals(this.regraProjecao.getTipoCompraVenda())) {
					this.valorEntrada = cotacaoDiaAnterior.getValor() * (1 + this.regraProjecao.getPercentualEntradaDataset()); // Venda
					if (valorEntrada >= obtemMinimo(diaOperacao) && valorEntrada <= obtemMaximo(diaOperacao)) {
						diaReferencia = indDia+1;
						Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
						if (result!=null) {
							dadosTreino.calcula(dias, indDia, result, this.procuraPontoSaida, cotacaoDiaAnterior.getValor());
							this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, procuraPontoSaida,valorEntrada, cotacaoDiaAnterior.getValor() );
						} else {
							DiaPregao atual = dias.get(diaReferencia);
							System.out.println("Dia sem saída:" + atual);
							System.out.println("");
						}
					} else {
						dadosTreino.calcula(dias, indDia,  this.procuraPontoSaida, cotacaoDiaAnterior.getValor());
						this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, null,valorEntrada, cotacaoDiaAnterior.getValor() );

					}
				} else {
					this.valorEntrada = cotacaoDiaAnterior.getValor() * (1 - this.regraProjecao.getPercentualEntradaDataset()); // Compra
					if (valorEntrada >= obtemMinimo(diaOperacao) && valorEntrada <= obtemMaximo(diaOperacao)) {
						diaReferencia = indDia+1;
						Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
						if (result!=null) {
							dadosTreino.calcula(dias, indDia, result, this.procuraPontoSaida, cotacaoDiaAnterior.getValor());
							this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, procuraPontoSaida,valorEntrada, cotacaoDiaAnterior.getValor() );
						} else {
							DiaPregao atual = dias.get(diaReferencia);
							System.out.println("Dia sem saída:" + atual);
							System.out.println("");
						}
					} else {
						dadosTreino.calcula(dias, indDia,  this.procuraPontoSaida, cotacaoDiaAnterior.getValor());
						this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, null,valorEntrada, cotacaoDiaAnterior.getValor() );

					}
				}
				
				
			}
		} catch (Exception e) {
			System.out.println("Ticker: " + this.ticker);
			System.out.println("this.procuraPontoSaida:" + this.procuraPontoSaida);
			System.out.println("diaReferencia:" + diaReferencia);
			System.out.println("valorEntrada:" + valorEntrada);
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaAnterior);
			System.out.println("Dia Operação:" + diaOperacao.getDiaNum());
			for (CotacaoIntradayAcaoResultado cot: diaOperacao.getCotacaoIntradayAcaoResultados()) {
				System.out.println(cot);
			}
			e.printStackTrace();
			System.exit(-1);
		}
		
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
	private Double obtemMinimo(DiaPregao dia) {
		Double min = (dia.getCotacaoDiarioAcaos().size()>0?dia.getCotacaoDiarioAcaos().get(0).getMinimo():null);
		if (min!=null) return min;
		min = 99999d;
		for (CotacaoIntradayAcaoResultado cotacao :dia.getCotacaoIntradayAcaoResultados()) {
			if (cotacao.getValor() < min) min = cotacao.getValor();
		}
		return min;
	}
	
	private DiaPregao getDiaSeguinte(int ind) {
		if (ind+1 < dias.size()) {
			return dias.get(ind+1);
		} else {
			return null;
		}
	}

	@Override
	protected void executaImpl() {
		// TODO Auto-generated method stub
		executaItem();
		executaProximo();
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}
	
	
	

}

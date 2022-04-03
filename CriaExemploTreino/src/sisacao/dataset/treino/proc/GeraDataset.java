package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.dao.DatasetComum;

public class GeraDataset {
	
	private DatasetComum comum;
	
	private List<DiaPregao> dias = null;
	private double valorEntrada = 0;
	private RegraProjecao regraProjecao;
	private ProcuraPontoSaida procuraPontoSaida = null;
	private DadosTreino dadosTreino = null;
	private EnviaDados enviaDados = null;
	private String ticker = null;
	
	private long diaEntradaNum;
	
	
	
	public long getDiaEntradaNum() {
		return diaEntradaNum;
	}

	public void setDiaEntradaNum(long diaEntradaNum) {
		this.diaEntradaNum = diaEntradaNum;
	}

	public void setDatasetComum(DatasetComum valor) {
		this.comum = valor;
	}

	public void executa() {
		this.dias = this.comum.getListaPregao();
		this.ticker = this.comum.getTicker();
		this.regraProjecao = this.comum.getRegraProjecao();
		procuraPontoSaida = new ProcuraPontoSaida(this.regraProjecao);
		this.dadosTreino = new DadosTreino();
		this.dadosTreino.setQuantidadeDia(this.comum.getQuantidadeDiasX());
		this.enviaDados = new EnviaDados();
		processaDias();
	}
	
	private void processaDias() {
		int diaReferencia = 0;
		CotacaoIntradayAcaoResultado cotacaoDiaAnterior = null;
		try {
			
			int indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + this.regraProjecao.getIndiceHoraReferenciaDataset() - 1;
			for (int indDia=this.comum.getQuantidadeDiasX();indDia<dias.size();indDia++) {
				DiaPregao diaOperacao = dias.get(indDia);
				DiaPregao diaAnterior = dias.get(indDia-1);
				cotacaoDiaAnterior = diaAnterior.getCotacaoIntradayAcaoResultados().get(indiceDia);
				this.valorEntrada = cotacaoDiaAnterior.getValor() * (1 + this.regraProjecao.getPercentualEntradaDataset()); // Venda

				//CotacaoDiarioAcao cotacaoOperacao = diaOperacao.getCotacaoDiarioAcaos().get(0);
				//System.out.println("cotacaoOperacao:" + cotacaoOperacao);
				if (valorEntrada >= obtemMinimo(diaOperacao) && valorEntrada <= obtemMaximo(diaOperacao)) {
					diaReferencia = indDia+1;
					Integer result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
					if (result!=null) {
						dadosTreino.calcula(dias, indDia, result, this.procuraPontoSaida);
						this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, procuraPontoSaida,valorEntrada, cotacaoDiaAnterior.getValor() );
					} else {
						DiaPregao atual = dias.get(diaReferencia);
						System.out.println("Dia sem saída:" + atual);
						System.out.println("");
					}
				} else {
					dadosTreino.calcula(dias, indDia,  this.procuraPontoSaida);
					this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, null,valorEntrada, cotacaoDiaAnterior.getValor() );

				}
				
			}
		} catch (Exception e) {
			System.out.println("this.procuraPontoSaida:" + this.procuraPontoSaida);
			System.out.println("diaReferencia:" + diaReferencia);
			System.out.println("valorEntrada:" + valorEntrada);
			System.out.println("cotacaoDiaAnterior:" + cotacaoDiaAnterior);
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
	
	
	

}

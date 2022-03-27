package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.singleton.DatasetComum;

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
		this.dadosTreino.setQuantidadeDia(this.comum.getQuantidadeDias());
		this.enviaDados = new EnviaDados();
		processaDias();
	}
	
	private void processaDias() {
		int indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + this.regraProjecao.getIndiceHoraReferenciaDataset() - 1;
		for (int indDia=this.comum.getQuantidadeDias();indDia<dias.size();indDia++) {
			DiaPregao diaOperacao = dias.get(indDia);
			DiaPregao diaAnterior = dias.get(indDia-1);
			CotacaoIntradayAcaoResultado cotacaoDiaAnterior = diaAnterior.getCotacaoIntradayAcaoResultados().get(indiceDia);
			this.valorEntrada = cotacaoDiaAnterior.getValor() * (1 + this.regraProjecao.getPercentualEntradaDataset()); // Venda
			CotacaoDiarioAcao cotacaoOperacao = diaOperacao.getCotacaoDiarioAcaos().get(0);
			if (valorEntrada >= cotacaoOperacao.getMinimo() && valorEntrada <= cotacaoOperacao.getMaximo()) {
				int diaReferencia = indDia+1;
				int result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
				dadosTreino.calcula(dias, indDia, result, this.procuraPontoSaida);
				this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, procuraPontoSaida,valorEntrada, cotacaoDiaAnterior.getValor() );
			} else {
				dadosTreino.calcula(dias, indDia,  this.procuraPontoSaida);
				this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino, null,valorEntrada, cotacaoDiaAnterior.getValor() );

			}
			
		}
	}
	
	private DiaPregao getDiaSeguinte(int ind) {
		if (ind+1 < dias.size()) {
			return dias.get(ind+1);
		} else {
			return null;
		}
	}
	
	
	

}

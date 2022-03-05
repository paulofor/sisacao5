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
		int indiceDia = dias.get(0).getCotacaoIntradayAcaoResultados().size() + this.regraProjecao.getIndiceHoraReferenciaDataset();
		for (int indDia=this.comum.getQuantidadeDias();indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			CotacaoIntradayAcaoResultado cotacaoDia = 
					dia.getCotacaoIntradayAcaoResultados().get(indiceDia);
			this.valorEntrada = cotacaoDia.getValor() * (1 - this.regraProjecao.getPercentualEntradaDataset());
			DiaPregao diaSeguinte = getDiaSeguinte(indDia);
			if (diaSeguinte!=null) {
				CotacaoDiarioAcao cotacaoSeguinte = diaSeguinte.getCotacaoDiarioAcaos().get(0);
				if (valorEntrada >= cotacaoSeguinte.getMinimo() && valorEntrada <= cotacaoSeguinte.getMaximo()) {
					int diaReferencia = indDia+2;
					int result = this.procuraPontoSaida.procuraValor(dias,diaReferencia,0,valorEntrada);
					dadosTreino.calcula(dias, indDia, result, this.procuraPontoSaida);
				} else {
					dadosTreino.calcula(dias, indDia,  this.procuraPontoSaida);
				}
			} 
			this.enviaDados.enviaDia(ticker, regraProjecao, dadosTreino);
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

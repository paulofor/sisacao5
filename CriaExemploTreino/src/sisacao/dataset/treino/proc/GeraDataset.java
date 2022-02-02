package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import sisacao.dataset.treino.singleton.DatasetComum;

public class GeraDataset {
	
	private DatasetComum comum;
	
	private int contaDia = 0;
	private List<DiaPregao> dias = null;
	private int indiceHoraDia = 0;
	private double valorEntradaVenda = 0;
	private double valorEntradaCompra = 0;
	private double valorEntrada = 0;
	private double percentualEntrada = 0;
	private boolean tipoCompra;
	
	public void setDatasetComum(DatasetComum valor) {
		this.comum = valor;
	}

	public void executa() {
		this.dias = this.comum.getListaPregao();
		this.indiceHoraDia = this.comum.getRegraProjecao().getIndiceHoraReferenciaDataset();
		this.percentualEntrada = this.comum.getRegraProjecao().getPercentualEntradaDataset();
		this.tipoCompra = "C".equals(this.comum.getRegraProjecao().getTipoCompraVenda());
		processaDias();
		
	}
	
	private void processaDias() {
		this.contaDia = 0;
		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			CotacaoIntradayAcaoResultado cotacaoDia = dia.getCotacaoIntradayAcaoResultados().get(this.indiceHoraDia);
			if (this.tipoCompra) {
				this.valorEntrada = cotacaoDia.getValor() * (1 - this.percentualEntrada);
				DiaPregao diaSeguinte = getDiaSeguinte(indDia);
				if (diaSeguinte!=null) {
					CotacaoDiarioAcao cotacaoSeguinte = diaSeguinte.getCotacaoDiarioAcaos().get(0);
					if (valorEntrada >= cotacaoSeguinte.getMinimo() && valorEntrada <= cotacaoSeguinte.getMaximo()) {
						  Entrou - pesquisar resultado do trade.
					}
				}
			} else {
				this.valorEntrada = cotacaoDia.getValor() * (1 + this.percentualEntrada);
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

package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.singleton.DatasetComum;

public class GeraDataset {
	
	private DatasetComum comum;
	
	private int contaDia = 0;
	private List<DiaPregao> dias = null;
	private int indiceHoraDia = 0;
	private double valorEntrada = 0;
	//private double percentualEntrada = 0;
	private boolean tipoCompra;
	
	private RegraProjecao regraProjecao;
	private int diaNumSaida;
	private double valorSaida;
	private int sinalBaixo;
	private int sinalAlto;
	
	public void setDatasetComum(DatasetComum valor) {
		this.comum = valor;
	}

	public void executa() {
		this.dias = this.comum.getListaPregao();
		this.regraProjecao = this.comum.getRegraProjecao();
		this.tipoCompra = "C".equals(this.comum.getRegraProjecao().getTipoCompraVenda());
		processaDias();
		
	}
	
	private void processaDias() {
		this.contaDia = 0;
		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			CotacaoIntradayAcaoResultado cotacaoDia = 
					dia.getCotacaoIntradayAcaoResultados().get(this.regraProjecao.getIndiceHoraReferenciaDataset());
			if (this.tipoCompra) {
				// Operacao de Compra
				this.valorEntrada = cotacaoDia.getValor() * (1 - this.regraProjecao.getPercentualEntradaDataset());
				DiaPregao diaSeguinte = getDiaSeguinte(indDia);
				if (diaSeguinte!=null) {
					CotacaoDiarioAcao cotacaoSeguinte = diaSeguinte.getCotacaoDiarioAcaos().get(0);
					if (valorEntrada >= cotacaoSeguinte.getMinimo() && valorEntrada <= cotacaoSeguinte.getMaximo()) {
						// Entrou em trade de compra - pesquisar resultado
						double limiteBaixoStop = valorEntrada * (1-this.regraProjecao.getStop()); 
						double limiteAltoTarget = valorEntrada * (1+this.regraProjecao.getTarget());
						int diaReferencia = indDia+2;
						this.sinalBaixo = -1; // Trade com prejuizo
						this.sinalAlto = 1; // Trade com lucro
						int result = procuraValor(dias,diaReferencia,0,limiteBaixoStop,limiteAltoTarget);
						  
					}
				}
			} else {
				// Operacao de Venda
				this.valorEntrada = cotacaoDia.getValor() * (1 + this.regraProjecao.getPercentualEntradaDataset());
				DiaPregao diaSeguinte = getDiaSeguinte(indDia);
				if (diaSeguinte!=null) {
					CotacaoDiarioAcao cotacaoSeguinte = diaSeguinte.getCotacaoDiarioAcaos().get(0);
					if (valorEntrada >= cotacaoSeguinte.getMinimo() && valorEntrada <= cotacaoSeguinte.getMaximo()) {
						// Entrou em trade de venda - pesquisar resultado
						double limiteBaixoTarget = valorEntrada * (1-this.regraProjecao.getTarget()); 
						double limiteAltoStop = valorEntrada * (1+this.regraProjecao.getStop());
						int diaReferencia = indDia+2;
						this.sinalBaixo = 1; // Trade com lucro
						this.sinalAlto = -1; // Trade com prejuizo
						int result = procuraValor(dias,diaReferencia,0,limiteBaixoTarget,limiteAltoStop);
						
						  
					}
				}
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
	
	
	private Integer procuraValor(List<DiaPregao> dias, int indDia, int indHora, double valorBaixo, double valorAlto) {
		
		boolean finalizou = false;
		Integer saida = 0;
		int posDia = indDia;
		int posHora = indHora;
		CotacaoDiarioAcao diario = null;
		while (indDia<dias.size() && this.contaDia < this.regraProjecao.getDiaLimite()) {
			this.contaDia++;
			DiaPregao dia = dias.get(indDia);
			if (dia.getCotacaoDiarioAcaos().size()>0) {
				diario = dias.get(indDia).getCotacaoDiarioAcaos().get(0);
				//System.out.println(diario + " - " + this.contaDia + " dias.");
				if (diario==null) {
					saida = null;
					//System.out.println("Saiu, sem diario");
					break;
				} else {
					this.diaNumSaida = diario.getDiaNum();
					this.valorSaida = (diario.getFechamento()!=null?diario.getFechamento():0);
				}
				if (diario.getMinimo()!=null && diario.getMinimo() <= valorBaixo) {
					saida = this.sinalBaixo;
					this.valorSaida = valorBaixo;
					//System.out.println("Saiu, mínimo");
					break;
				} 
				if (diario.getMaximo()!=null && diario.getMaximo() >= valorAlto) {
					saida = this.sinalAlto;
					this.valorSaida = valorAlto;
					//System.out.println("Saiu, máximo");
					break;
				} 
			} else {
				saida = null;
				//System.out.println("Saiu, acabou diario");
				break;
			}
			indDia++;
		}
		//System.out.println("resultado:" + saida);
		return saida;
	}

}

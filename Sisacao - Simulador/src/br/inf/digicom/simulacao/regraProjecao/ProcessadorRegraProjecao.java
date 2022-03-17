package br.inf.digicom.simulacao.regraProjecao;

import java.util.ArrayList;
import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public class ProcessadorRegraProjecao {
	
	private int contaDia = 0;
	private RegraProjecao regraProjecao = null;
	private double percentualBaixo = 0;
	private double percentualAlto = 0;
	CotacaoIntradayResultadoValor_InsereLista insere = new CotacaoIntradayResultadoValor_InsereLista();
	
	private double valorEntrada;
	private double valorSaida;
	private int diaNumSaida;
	
	private int sinalAlto  =0;
	private int sinalBaixo = 0;
	
	private int contaDiaAlteracao = 0;
	//private double valorSuperior;
	//private double valorInferior;
	//private String dataHora;
	
	public void executa(String ticker, RegraProjecao regraProjecao, List<DiaPregao> dias) {
		System.out.println(ticker + " 3.I");
		// TODO Auto-generated method stub
		this.regraProjecao = regraProjecao;
		if ("CV".equals(regraProjecao.getTipoCompraVenda()) || "C".equals(regraProjecao.getTipoCompraVenda())) {
			this.percentualAlto = regraProjecao.getTarget();
			this.percentualBaixo = regraProjecao.getStop();
			this.sinalAlto = 1;
			this.sinalBaixo = -1;
		}
		if ("V".equals(regraProjecao.getTipoCompraVenda())) {
			this.percentualBaixo = regraProjecao.getTarget();
			this.percentualAlto = regraProjecao.getStop();
			this.sinalAlto = -1;
			this.sinalBaixo = 1;
		}
		processaItem(ticker, dias);
		System.out.println(ticker + " 3.F");
	}

		
		
	private void processaItem(String ticker, List<DiaPregao> dias) {
		System.out.println(ticker + " com " + dias.size() + " dias.");
		this.contaDia = 0;
		List<CotacaoIntradayAcaoResultadoValor> listaValor = new ArrayList();
		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			//System.out.println("Dia:" + dia.getDiaNum());
			//if (dia.getDiaNum()==20210514) {
			//	System.out.println("Chegou");
			//}
			for (int indHora=0;indHora<dia.getCotacaoIntradayAcaoResultados().size();indHora++) {
				CotacaoIntradayAcaoResultado cotacao = dia.getCotacaoIntradayAcaoResultados().get(indHora);
				//System.out.println("Hora:" + cotacao.getDataHora());
				//System.out.println("Valor: " + cotacao.getCotacaoIntradayAcaoResultadoValors().size());
				if (cotacao.getCotacaoIntradayAcaoResultadoValors().size()>0) {
					//System.out.println("Pulou " + cotacao);
					continue;
				}
				CotacaoIntradayAcaoResultadoValor valor = new CotacaoIntradayAcaoResultadoValor();
				valor.setDiaNum(cotacao.getDiaNum());
				valor.setHora(cotacao.getHora());
				valor.setTicker(cotacao.getTicker());
				valor.setRegraProjecaoId(this.regraProjecao.getId());
				valor.setDiaHoraNumTicker(cotacao.getDiaNum() + cotacao.getHora() + cotacao.getTicker());
				// AAAAMM
				// 012345
				String anoMes = cotacao.getDiaNum().toString().substring(0,6);
				valor.setAnoMesNum(Integer.parseInt(anoMes));
				if (cotacao.getValor()==null) break;
				double valorBaixo = cotacao.getValor() * (1-percentualBaixo);
				double valorAlto = cotacao.getValor() * (1+percentualAlto);
				this.valorEntrada = cotacao.getValor();
				
				//System.out.println("Tratando..." + cotacao + " Alto: " + valorAlto + " Baixo: " + valorBaixo);
				this.contaDia = 0;
				Integer resultado = procuraValor(dias, indDia, indHora, valorBaixo, valorAlto); 
				if (resultado != null) {
					valor.setResultado(resultado);
					valor.setDias(contaDia);
					valor.setDiaNumSaida(this.diaNumSaida);
					valor.setValorEntrada(this.valorEntrada);
					valor.setValorSaida(this.valorSaida);
					valor.setValorInferior(valorBaixo);
					valor.setValorSuperior(valorAlto);
					valor.setDataHora(cotacao.getDataHora());
					listaValor.add(valor);
				}
				this.diaNumSaida = 0;
				this.valorEntrada = 0;
				this.valorSaida = 0;
			}
			enviaDia(listaValor);
			listaValor.clear();
		}
		System.out.println("Terminou loop principal (" + ticker + ") - " + this.contaDiaAlteracao + " dias alterados");
	}
		
	private void enviaDia(List<CotacaoIntradayAcaoResultadoValor> listaValor) {
		if (listaValor.size()==0) return;
		this.contaDiaAlteracao ++;
		this.insere.setLista(listaValor);
		this.insere.executa();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
				if (dia.getDiaNum()==20210610) {
					System.out.println("*** Pulou 20210610");
					indDia++;
					continue;
				}
				System.out.println("Dia sem cotacao diario: " + dia.getDiaNum());
				saida = null;
				//System.out.println("Saiu, acabou diario");
				break;
			}
			indDia++;
		}
		if ((saida!=null) && (saida==0) && (this.contaDia < this.regraProjecao.getDiaLimite())) {
			saida = null;
		}
			
		
		//System.out.println("resultado:" + saida);
		return saida;
	}
}

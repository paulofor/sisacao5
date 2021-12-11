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
	
	//private double valorSuperior;
	//private double valorInferior;
	//private String dataHora;
	
	public void executa(String ticker, RegraProjecao regraProjecao, List<DiaPregao> dias) {
		// TODO Auto-generated method stub
		this.regraProjecao = regraProjecao;
		if ("CV".equals(regraProjecao.getTipoCompraVenda()) || "C".equals(regraProjecao.getTipoCompraVenda())) {
			this.percentualAlto = regraProjecao.getTarget();
			this.percentualBaixo = regraProjecao.getStop();
		}
		if ("V".equals(regraProjecao.getTipoCompraVenda())) {
			this.percentualBaixo = regraProjecao.getTarget();
			this.percentualAlto = regraProjecao.getStop();
		}
		processaItem(ticker, dias);
	}

		
		
	private void processaItem(String ticker, List<DiaPregao> dias) {
		this.contaDia = 0;
		List<CotacaoIntradayAcaoResultadoValor> listaValor = new ArrayList();
		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);

			for (int indHora=0;indHora<dia.getCotacaoIntradayAcaoResultados().size();indHora++) {
				CotacaoIntradayAcaoResultado cotacao = dia.getCotacaoIntradayAcaoResultados().get(indHora);
				if (cotacao.getCotacaoIntradayAcaoResultadoValors().size()>0) {
					System.out.println("Pulou " + cotacao);
					continue;
				}
				CotacaoIntradayAcaoResultadoValor valor = new CotacaoIntradayAcaoResultadoValor();
				valor.setDiaNum(cotacao.getDiaNum());
				valor.setHora(cotacao.getHora());
				valor.setTicker(cotacao.getTicker());
				valor.setRegraProjecaoId(this.regraProjecao.getId());
				valor.setDiaHoraNumTicker(cotacao.getDiaNum() + cotacao.getHora() + cotacao.getTicker());
				if (cotacao.getValor()==null) break;
				double valorBaixo = cotacao.getValor() * (1-percentualBaixo);
				double valorAlto = cotacao.getValor() * (1+percentualAlto);
				this.valorEntrada = cotacao.getValor();
				
				System.out.println("Tratando..." + cotacao + " Alto: " + valorAlto + " Baixo: " + valorBaixo);
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
		System.out.println("Terminou loop principal");
	}
		
	private void enviaDia(List<CotacaoIntradayAcaoResultadoValor> listaValor) {
		this.insere.setLista(listaValor);
		this.insere.executa();
		try {
			Thread.sleep(2000);
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
				System.out.println(diario + " - " + this.contaDia + " dias.");
				if (diario==null) {
					saida = null;
					System.out.println("Saiu, sem diario");
					break;
				} else {
					this.diaNumSaida = diario.getDiaNum();
					this.valorSaida = (diario.getFechamento()!=null?diario.getFechamento():0);
				}
				if (diario.getMinimo()!=null && diario.getMinimo() <= valorBaixo) {
					saida = -1;
					this.valorSaida = valorBaixo;
					System.out.println("Saiu, mínimo");
					break;
				} 
				if (diario.getMaximo()!=null && diario.getMaximo() >= valorAlto) {
					saida = 1;
					this.valorSaida = valorAlto;
					System.out.println("Saiu, máximo");
					break;
				} 
			} else {
				saida = null;
				System.out.println("Saiu, acabou diario");
				break;
			}
			indDia++;
		}
		System.out.println("resultado:" + saida);
		return saida;
	}
}

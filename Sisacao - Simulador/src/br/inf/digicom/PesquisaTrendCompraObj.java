package br.inf.digicom;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.service.CotacaoIntradayAcaoResultadoService;

public class PesquisaTrendCompraObj {

	private double PERCENTUAL_ALTO = 0.15;
	private double PERCENTUAL_BAIXO = 0.15;
	private int contaDia = 0;
	
	private CotacaoIntradayAcaoResultadoService service = null;
	
	public PesquisaTrendCompraObj() {
		service = new CotacaoIntradayAcaoResultadoService();
	}
	
	public void executa(String ticker) {
		RepositorioCotacao.carregaAtivoResultado(ticker, 20210101);
		processaItem(ticker);
	}

	private void processaItem(String ticker) {

		List<DiaPregao> dias = RepositorioCotacao.getCotacao(ticker);
		this.contaDia = 0;
		for (int indDia=0;indDia<dias.size();indDia++) {
			DiaPregao dia = dias.get(indDia);
			CotacaoIntradayAcaoResultado ultimoDia = dia.getCotacaoIntradayAcaoResultados().get(dia.getCotacaoIntradayAcaoResultados().size() - 1);
			if (ultimoDia.getTg15St15()!=null) {
				System.out.println("Pulou " + ultimoDia + " - " + ultimoDia.getTg15St15());
				continue;
			}
			for (int indHora=0;indHora<dia.getCotacaoIntradayAcaoResultados().size();indHora++) {
				CotacaoIntradayAcaoResultado cotacao = dia.getCotacaoIntradayAcaoResultados().get(indHora);
				if (cotacao.getValor()==null) break;
				double valorBaixo = cotacao.getValor() * (1-PERCENTUAL_ALTO);
				double valorAlto = cotacao.getValor() * (1+PERCENTUAL_BAIXO);
				System.out.println("Tratando..." + cotacao + " Alto: " + valorAlto + " Baixo: " + valorBaixo);
				this.contaDia = 0;
				Integer resultado = procuraValor(dias, indDia, indHora, valorBaixo, valorAlto); 
				if (resultado!=null) {
					cotacao.setTg15St15(resultado);
					cotacao.setDiasTg15St15(this.contaDia);
					cotacao.atualizaTg15St15();
				}

			}
			enviaDia(dia);
		}
		System.out.println("Terminou loop principal");
	}
	
	private void enviaDia(DiaPregao dia) {
		service.atualizaTargetStopDia(dia.getCotacaoIntradayAcaoResultados());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(dia);
	}

	private Integer procuraValor(List<DiaPregao> dias, int indDia, int indHora, double valorBaixo, double valorAlto) {
		int LIMITE_DIAS_PROCURA = 200;
		boolean finalizou = false;
		Integer saida = null;
		int posDia = indDia;
		int posHora = indHora;
		CotacaoDiarioAcao diario = null;
		while (indDia<dias.size() && this.contaDia < LIMITE_DIAS_PROCURA) {
			this.contaDia++;
			DiaPregao dia = dias.get(indDia);
			if (dia.getCotacaoDiarioAcaos().size()>0) {
				diario = dias.get(indDia).getCotacaoDiarioAcaos().get(0);
				System.out.println(diario + " - " + this.contaDia + " dias.");
				if (diario==null) {
					saida = 0;
					System.out.println("Saiu, sem diario");
					break;
				}
				if (diario.getMinimo()!=null && diario.getMinimo() <= valorBaixo) {
					saida = -1;
					System.out.println("Saiu, mínimo");
					break;
				} 
				if (diario.getMaximo()!=null && diario.getMaximo() >= valorAlto) {
					saida = 1;
					System.out.println("Saiu, máximo");
					break;
				} 
			}
			indDia++;
		}
		return saida;
	}
}

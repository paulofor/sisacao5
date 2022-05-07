package sisacao.dataset.treino.entrada.app;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import sisacao.dataset.treino.entrada.dao.ExemploTreinoAcaoEntrada_InsereExemploEntrada;
import sisacao.dataset.treino.proc.DadosTreino;
import sisacao.dataset.treino.proc.ProcuraPontoSaida;

public class DadosTreinoX {

	private String saidaX;
	private String saidaXOriginal;
	private int qtdeDia;
	
	private DiaPregao diaPrevisao;
	private DiaPregao diaInicio;
	
	public String getSaidaX() {
		return saidaX;
	}

	public void setQtdeDia(int qtdeDia) {
		this.qtdeDia = qtdeDia;
		
	}

	public String getSaidaXOriginal() {
		return this.saidaXOriginal;
	}

	public Integer getDiaNumPrevisao() {
		return this.diaPrevisao.getDiaNum();
	}
	public Integer getDiaNumInicio() {
		return this.diaInicio.getDiaNum();
	}

	private void calcula(List<DiaPregao> dias, int indDiaPrevisao, double valorReferencia) {
		this.diaPrevisao = dias.get(indDiaPrevisao+1);
		int inicio = indDiaPrevisao - qtdeDia;
		this.diaInicio = dias.get(inicio);
		this.saidaXOriginal = "";
		this.saidaX = "";
		int contaX = 0;
		for (int i=inicio;i<indDiaPrevisao;i++) {
			DiaPregao diaCorrente = dias.get(i);
			for (int x=0; x<diaCorrente.getCotacaoIntradayAcaoResultados().size();x++) {
				CotacaoIntradayAcaoResultado cotacao = diaCorrente.getCotacaoIntradayAcaoResultados().get(x);
				this.saidaXOriginal += ", " + cotacao.getValor();
				this.saidaX += ", " + String.format("%.6f", (cotacao.getValor()) / valorReferencia).replace(',', '.');
				contaX++;
			}
		}
		this.saidaXOriginal = this.saidaXOriginal.substring(1);
		this.saidaX = this.saidaX.substring(1);
		System.out.println("Calculou aqui");
	}
	
}

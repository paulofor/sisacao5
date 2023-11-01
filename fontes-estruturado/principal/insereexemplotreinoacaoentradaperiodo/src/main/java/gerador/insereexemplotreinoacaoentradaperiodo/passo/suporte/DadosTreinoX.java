package gerador.insereexemplotreinoacaoentradaperiodo.passo.suporte;

import java.util.List;

import br.com.gersis.loopback.modelo.CotacaoIntradayAcaoResultado;
import br.com.gersis.loopback.modelo.DiaPregao;

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

	public void calcula(List<DiaPregao> dias, double valorReferencia) {
		int indDiaPrevisao = dias.size() - 1;
		this.diaPrevisao = dias.get(indDiaPrevisao);
		int inicio = 0;
		this.diaInicio = dias.get(inicio);
		this.saidaXOriginal = "";
		this.saidaX = "";
		int contaX = 0;
		int somaQtde = 0;
		for (int i=inicio;i<indDiaPrevisao;i++) {
			DiaPregao diaCorrente = dias.get(i);
			//System.out.print("Dia Atual: " + diaCorrente.getDiaNum() + " Qtde:" + diaCorrente.getCotacaoIntradayAcaoResultados().size());
			for (int x=0; x<diaCorrente.getCotacaoIntradayAcaoResultados().size();x++) {
				CotacaoIntradayAcaoResultado cotacao = diaCorrente.getCotacaoIntradayAcaoResultados().get(x);
				this.saidaXOriginal += ", " + cotacao.getValor();
				this.saidaX += ", " + String.format("%.6f", (cotacao.getValor()) / valorReferencia).replace(',', '.');
				somaQtde++;
				contaX++;
			}
			//System.out.println("Total:" + somaQtde);
		}
		this.saidaXOriginal = this.saidaXOriginal.substring(1);
		this.saidaX = this.saidaX.substring(1);

	}
	
}

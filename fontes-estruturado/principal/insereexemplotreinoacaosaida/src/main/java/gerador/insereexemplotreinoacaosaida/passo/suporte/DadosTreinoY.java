package gerador.insereexemplotreinoacaosaida.passo.suporte;

import java.util.List;

import br.com.gersis.loopback.modelo.DiaPregao;

public class DadosTreinoY {

	
	private int diaNumSaida;
	private double valorSaida;
	private String saidaY;
	private int resultado;
	private DiaPregao diaPrevisao;
	
	public void calcula(List<DiaPregao> dias, Integer result, ProcuraPontoSaida procuraPontoSaida,	double valorReferencia) {
		this.resultado = result;
		this.diaNumSaida = procuraPontoSaida.getDiaNumSaida();
		this.valorSaida = procuraPontoSaida.getValorSaida();
		this.diaPrevisao = dias.get(0);

	}

	public void calcula(List<DiaPregao> dias, ProcuraPontoSaida procuraPontoSaida, double valorReferencia) {
		this.diaNumSaida = 0;
		this.valorSaida = 0;
		this.diaPrevisao = dias.get(0);
		this.resultado = 0;
	}

	public int getDiaNumSaida() {
		return diaNumSaida;
	}

	public double getValorSaida() {
		return valorSaida;
	}

	public int getSaidaY() {
		if (resultado==1) return 1;
		else return 0;
	}

	public int getResultado() {
		return resultado;
	}

	public DiaPregao getDiaPrevisao() {
		return diaPrevisao;
	}



}

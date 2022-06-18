package sisacao.dataset.treino.entrada.periodo.app;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import sisacao.dataset.treino.proc.ProcuraPontoSaida;

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

	public String getSaidaY() {
		if (resultado==1) return "1";
		else return "0";
	}

	public int getResultado() {
		return resultado;
	}

	public DiaPregao getDiaPrevisao() {
		return diaPrevisao;
	}



}

package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;

public class DadosTreino {

	
	private String saidaX;
	private String saidaY;
	
	private int quantidadeDia;
	
	private DiaPregao diaPrevisao;
	private DiaPregao diaInicio;
	private int diaNumSaida;
	private double valorSaida;
	private int resultado;

	
	public String getSaidaX() {
		return saidaX;
	}
	public String getSaidaY() {
		if (resultado==1) return "1";
		else return "0";
	}
	public Integer getResultado() {
		return resultado;
	}
	private void calcula(List<DiaPregao> dias, int indDia, int result) {
		// TODO Auto-generated method stub
		
		this.diaPrevisao = dias.get(indDia);
		int inicio = indDia - quantidadeDia;
		this.diaInicio = dias.get(inicio);
		this.saidaX = "";
		int contaX = 0;
		for (int i=inicio;i<indDia;i++) {
			DiaPregao diaCorrente = dias.get(i);
			for (int x=0; x<diaCorrente.getCotacaoIntradayAcaoResultados().size();x++) {
				CotacaoIntradayAcaoResultado cotacao = diaCorrente.getCotacaoIntradayAcaoResultados().get(x);
				this.saidaX += ", " + cotacao.getValor();
				contaX++;
			}
		}
		this.saidaX = this.saidaX.substring(1);
		this.resultado = result;
		System.out.println("Calculou aqui");
	}
	public void setQuantidadeDia(int quantidadeDias) {
		this.quantidadeDia = quantidadeDias;
	}
	
	public Integer getDiaNumPrevisao() {
		return this.diaPrevisao.getDiaNum();
	}
	public Integer getDiaNumInicio() {
		return this.diaInicio.getDiaNum();
	}
	public void calcula(List<DiaPregao> dias, int indDia, int result, ProcuraPontoSaida procuraPontoSaida) {
		this.diaNumSaida = procuraPontoSaida.getDiaNumSaida();
		this.valorSaida = procuraPontoSaida.getValorSaida();
		this.calcula(dias, indDia, result);
	}
	public void calcula(List<DiaPregao> dias, int indDia, ProcuraPontoSaida procuraPontoSaida) {
		this.diaNumSaida = 0;
		this.valorSaida = 0;
		this.calcula(dias, indDia, 0);
	}
	
	
}

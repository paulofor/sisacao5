package sisacao.dataset.treino.proc;

import java.util.List;

import br.com.digicom.sisacao.modelo.DiaPregao;

public class DadosTreino {

	
	private String saidaX;
	private String saidaY;
	
	private int quantidadeDia;
	
	private DiaPregao diaPrevisao;
	private DiaPregao diaInicio;
	
	public String getSaidaX() {
		return saidaX;
	}
	public String getSaidaY() {
		return saidaY;
	}
	public void calcula(List<DiaPregao> dias, int indDia, int result) {
		// TODO Auto-generated method stub
		
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
	
}

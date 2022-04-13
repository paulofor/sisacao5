package br.inf.digicom.loopback;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.PeriodoExperimento;

public class DatasetComum implements IDatasetComum {
	
	private PeriodoExperimento periodo;
	private AtivoAcao ativoAcao;
	private List<DiaPregao> listaDiaPregao;
	private List<DiaPregao> diaValidacao;
	private int idPeriodo;
	
	

	public List<DiaPregao> getDiaValidacao() {
		return diaValidacao;
	}

	public void setDiaValidacao(List<DiaPregao> diaValidacao) {
		this.diaValidacao = diaValidacao;
	}

	public PeriodoExperimento getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoExperimento periodo) {
		this.periodo = periodo;
	}

	public AtivoAcao getAtivoAcao() {
		return ativoAcao;
	}

	public void setAtivoAcao(AtivoAcao ativoAcao) {
		this.ativoAcao = ativoAcao;
	}

	public List<DiaPregao> getListaDiaPregao() {
		return listaDiaPregao;
	}

	public void setListaDiaPregao(List<DiaPregao> listaDiaPregao) {
		this.listaDiaPregao = listaDiaPregao;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	

	

	

	
}

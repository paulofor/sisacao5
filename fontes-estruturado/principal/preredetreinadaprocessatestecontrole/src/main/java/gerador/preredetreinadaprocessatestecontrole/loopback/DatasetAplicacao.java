package gerador.preredetreinadaprocessatestecontrole.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private ExperimentoPreRedeTreinada experimento;
	private DiaPregao diaCorrente;
	private RegraProjecao regra;
	private List<DiaPregao> listaDiaComCotacao;
	private ExperimentoPreRedeTreinadaScore escolhidoDia;
	private ExperimentoPreRedeTreinadaControle controle;


	public void setExperimento(ExperimentoPreRedeTreinada valor) { 
		this.experimento = valor;
	}
	public ExperimentoPreRedeTreinada getExperimento() { 
		return this.experimento;
	}
	public void setDiaCorrente(DiaPregao valor) { 
		this.diaCorrente = valor;
	}
	public DiaPregao getDiaCorrente() { 
		return this.diaCorrente;
	}
	public void setRegra(RegraProjecao valor) { 
		this.regra = valor;
	}
	public RegraProjecao getRegra() { 
		return this.regra;
	}
	public void setListaDiaComCotacao(List<DiaPregao> valor) { 
		this.listaDiaComCotacao = valor;
	}
	public List<DiaPregao> getListaDiaComCotacao() { 
		return this.listaDiaComCotacao;
	}
	public void setEscolhidoDia(ExperimentoPreRedeTreinadaScore valor) { 
		this.escolhidoDia = valor;
	}
	public ExperimentoPreRedeTreinadaScore getEscolhidoDia() { 
		return this.escolhidoDia;
	}
	public void setControle(ExperimentoPreRedeTreinadaControle valor) { 
		this.controle = valor;
	}
	public ExperimentoPreRedeTreinadaControle getControle() { 
		return this.controle;
	}
}

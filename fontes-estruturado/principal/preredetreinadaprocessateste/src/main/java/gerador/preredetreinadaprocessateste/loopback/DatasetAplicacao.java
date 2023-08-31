package gerador.preredetreinadaprocessateste.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private ExperimentoPreRedeTreinada experimento;
	private DiaPregao diaCorrente;
	private ExperimentoPreRedeTreinadaScore ativoMelhorDia;
	private RegraProjecao regra;
	private List<DiaPregao> listaDiaComCotacao;


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
	public void setAtivoMelhorDia(ExperimentoPreRedeTreinadaScore valor) { 
		this.ativoMelhorDia = valor;
	}
	public ExperimentoPreRedeTreinadaScore getAtivoMelhorDia() { 
		return this.ativoMelhorDia;
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
}

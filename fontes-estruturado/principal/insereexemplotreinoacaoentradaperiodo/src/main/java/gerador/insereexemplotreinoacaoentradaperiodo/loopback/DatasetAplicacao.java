package gerador.insereexemplotreinoacaoentradaperiodo.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private DiaPregao diaCorrente;
	private AtivoAcao ativoCorrente;
	private List<DiaPregao> listaDiaCotacao;
	private ExemploTreinoAcaoEntrada exemploEntrada;
	private TipoExemploTreino tipoCorrente;


	public void setDiaCorrente(DiaPregao valor) { 
		this.diaCorrente = valor;
	}
	public DiaPregao getDiaCorrente() { 
		return this.diaCorrente;
	}
	public void setAtivoCorrente(AtivoAcao valor) { 
		this.ativoCorrente = valor;
	}
	public AtivoAcao getAtivoCorrente() { 
		return this.ativoCorrente;
	}
	public void setListaDiaCotacao(List<DiaPregao> valor) { 
		this.listaDiaCotacao = valor;
	}
	public List<DiaPregao> getListaDiaCotacao() { 
		return this.listaDiaCotacao;
	}
	public void setExemploEntrada(ExemploTreinoAcaoEntrada valor) { 
		this.exemploEntrada = valor;
	}
	public ExemploTreinoAcaoEntrada getExemploEntrada() { 
		return this.exemploEntrada;
	}
	public void setTipoCorrente(TipoExemploTreino valor) { 
		this.tipoCorrente = valor;
	}
	public TipoExemploTreino getTipoCorrente() { 
		return this.tipoCorrente;
	}
}

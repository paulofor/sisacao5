package gerador.insereexemplotreinoindiceentradaperiodo.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private TipoExemploTreino tipoCorrente;
	private DiaPregao diaCorrente;
	private AtivoIndice indiceCorrente;
	private List<DiaPregao> listaDiaCotacao;
	private ExemploTreinoIndiceAcaoEntrada exemploEntradaIndice;


	public void setTipoCorrente(TipoExemploTreino valor) { 
		this.tipoCorrente = valor;
	}
	public TipoExemploTreino getTipoCorrente() { 
		return this.tipoCorrente;
	}
	public void setDiaCorrente(DiaPregao valor) { 
		this.diaCorrente = valor;
	}
	public DiaPregao getDiaCorrente() { 
		return this.diaCorrente;
	}
	public void setIndiceCorrente(AtivoIndice valor) { 
		this.indiceCorrente = valor;
	}
	public AtivoIndice getIndiceCorrente() { 
		return this.indiceCorrente;
	}
	public void setListaDiaCotacao(List<DiaPregao> valor) { 
		this.listaDiaCotacao = valor;
	}
	public List<DiaPregao> getListaDiaCotacao() { 
		return this.listaDiaCotacao;
	}
	public void setExemploEntradaIndice(ExemploTreinoIndiceAcaoEntrada valor) { 
		this.exemploEntradaIndice = valor;
	}
	public ExemploTreinoIndiceAcaoEntrada getExemploEntradaIndice() { 
		return this.exemploEntradaIndice;
	}
}

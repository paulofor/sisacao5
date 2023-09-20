package gerador.insereexemplotreinoacaosaida.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private RegraProjecao regraSaida;
	private AtivoAcao ativoCorrente;
	private String nomeGrupoAcao;
	private ExemploTreinoAcaoEntrada exemploCorrente;
	private List<DiaPregao> listaDia;


	public void setRegraSaida(RegraProjecao valor) { 
		this.regraSaida = valor;
	}
	public RegraProjecao getRegraSaida() { 
		return this.regraSaida;
	}
	public void setAtivoCorrente(AtivoAcao valor) { 
		this.ativoCorrente = valor;
	}
	public AtivoAcao getAtivoCorrente() { 
		return this.ativoCorrente;
	}
	public void setNomeGrupoAcao(String valor) { 
		this.nomeGrupoAcao = valor;
	}
	public String getNomeGrupoAcao() { 
		return this.nomeGrupoAcao;
	}
	public void setExemploCorrente(ExemploTreinoAcaoEntrada valor) { 
		this.exemploCorrente = valor;
	}
	public ExemploTreinoAcaoEntrada getExemploCorrente() { 
		return this.exemploCorrente;
	}
	public void setListaDia(List<DiaPregao> valor) { 
		this.listaDia = valor;
	}
	public List<DiaPregao> getListaDia() { 
		return this.listaDia;
	}
}

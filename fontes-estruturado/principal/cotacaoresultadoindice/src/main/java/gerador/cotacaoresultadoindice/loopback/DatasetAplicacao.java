package gerador.cotacaoresultadoindice.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private AtivoIndice indiceCorrente;
	private CotacaoIntradayIndiceResultado resultado;


	public void setIndiceCorrente(AtivoIndice valor) { 
		this.indiceCorrente = valor;
	}
	public AtivoIndice getIndiceCorrente() { 
		return this.indiceCorrente;
	}
	public void setResultado(CotacaoIntradayIndiceResultado valor) { 
		this.resultado = valor;
	}
	public CotacaoIntradayIndiceResultado getResultado() { 
		return this.resultado;
	}
}

package gerador.geracotacaointradayacaoresultado.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private AtivoAcao acaoCorrente;
	private CotacaoIntradayAcaoResultado cotacaoResultado;


	public void setAcaoCorrente(AtivoAcao valor) { 
		this.acaoCorrente = valor;
	}
	public AtivoAcao getAcaoCorrente() { 
		return this.acaoCorrente;
	}
	public void setCotacaoResultado(CotacaoIntradayAcaoResultado valor) { 
		this.cotacaoResultado = valor;
	}
	public CotacaoIntradayAcaoResultado getCotacaoResultado() { 
		return this.cotacaoResultado;
	}
}

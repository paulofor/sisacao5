package gerador.geracotacaointradayacaoresultado.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private AtivoAcao acaoCorrente;


	public void setAcaoCorrente(AtivoAcao valor) { 
		this.acaoCorrente = valor;
	}
	public AtivoAcao getAcaoCorrente() { 
		return this.acaoCorrente;
	}
}

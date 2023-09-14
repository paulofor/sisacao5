package gerador.cotacaoresultadoindice.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private IndiceAcao indiceCorrente;


	public void setIndiceCorrente(IndiceAcao valor) { 
		this.indiceCorrente = valor;
	}
	public IndiceAcao getIndiceCorrente() { 
		return this.indiceCorrente;
	}
}

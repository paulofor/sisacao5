package gerador.criapythontreinorede.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private TreinoRede treinoCorrente;


	public void setTreinoCorrente(TreinoRede valor) { 
		this.treinoCorrente = valor;
	}
	public TreinoRede getTreinoCorrente() { 
		return this.treinoCorrente;
	}
}

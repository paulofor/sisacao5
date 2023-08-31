package gerador.criapythonprerededadosintetico.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private ExperimentoPreRede experimentoCorrente;


	public void setExperimentoCorrente(ExperimentoPreRede valor) { 
		this.experimentoCorrente = valor;
	}
	public ExperimentoPreRede getExperimentoCorrente() { 
		return this.experimentoCorrente;
	}
}

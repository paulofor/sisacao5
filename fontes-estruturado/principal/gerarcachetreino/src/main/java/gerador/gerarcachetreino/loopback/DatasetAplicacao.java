package gerador.gerarcachetreino.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private ExperimentoRedeNeural experimento;


	public void setExperimento(ExperimentoRedeNeural valor) { 
		this.experimento = valor;
	}
	public ExperimentoRedeNeural getExperimento() { 
		return this.experimento;
	}
}

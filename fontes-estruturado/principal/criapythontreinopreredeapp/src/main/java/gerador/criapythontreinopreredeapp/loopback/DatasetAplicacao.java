package gerador.criapythontreinopreredeapp.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private PreRedeNeural preRedeNeuralCorrente;


	public void setPreRedeNeuralCorrente(PreRedeNeural valor) { 
		this.preRedeNeuralCorrente = valor;
	}
	public PreRedeNeural getPreRedeNeuralCorrente() { 
		return this.preRedeNeuralCorrente;
	}
}

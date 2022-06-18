package sisacao.deeplearning.tensorflow.loopback;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetTreinoRede implements IDatasetComum{

	private RedeNeural redeCorrente;

	public RedeNeural getRedeCorrente() {
		return redeCorrente;
	}

	public void setRedeCorrente(RedeNeural redeCorrente) {
		this.redeCorrente = redeCorrente;
	}
	
	
}

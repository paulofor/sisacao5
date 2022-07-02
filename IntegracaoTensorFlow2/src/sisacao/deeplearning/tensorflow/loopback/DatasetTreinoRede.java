package sisacao.deeplearning.tensorflow.loopback;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetTreinoRede implements IDatasetComum{

	private RedeNeural redeCorrente;
	private TreinoRede treinoRedeCorrente;

	@Deprecated
	public RedeNeural getRedeCorrente() {
		return redeCorrente;
	}
	@Deprecated
	public void setRedeCorrente(RedeNeural redeCorrente) {
		this.redeCorrente = redeCorrente;
	}

	public TreinoRede getTreinoRedeCorrente() {
		return treinoRedeCorrente;
	}

	public void setTreinoRedeCorrente(TreinoRede treinoRedeCorrente) {
		this.treinoRedeCorrente = treinoRedeCorrente;
	}

	
	
}

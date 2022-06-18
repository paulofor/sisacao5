package sisacao.deeplearning.tensorflow;

import sisacao.deeplearning.tensorflow.loopback.DatasetTreinoRede;
import sisacao.deeplearning.tensorflow.loopback.RedeNeural_ObtemListaTreino;

public class CriaPythonTreinoRedeObj {

	public void executa() {
		DatasetTreinoRede ds = new DatasetTreinoRede();
		RedeNeural_ObtemListaTreino exec = new RedeNeural_ObtemListaTreino();
		exec.setComum(ds);
		exec.executa();
	}

	
}

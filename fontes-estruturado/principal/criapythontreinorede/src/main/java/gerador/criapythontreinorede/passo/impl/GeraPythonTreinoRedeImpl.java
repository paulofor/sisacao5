package gerador.criapythontreinorede.passo.impl;


import br.com.gersis.loopback.modelo.TreinoRede;
import gerador.criapythontreinorede.jupyter.NotebookTreinoTensorFlow;
import gerador.criapythontreinorede.passo.GeraPythonTreinoRede;



public class GeraPythonTreinoRedeImpl extends GeraPythonTreinoRede {

	@Override
	protected boolean executaCustom(TreinoRede treinoCorrente) {
		NotebookTreinoTensorFlow obj = new NotebookTreinoTensorFlow();
		obj.setTreinoRede(treinoCorrente);
		obj.geraNotebook("redes/treino_rede_" + String.format("%010d", treinoCorrente.getId()));
		return true;
	}

	
	

}


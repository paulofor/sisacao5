package sisacao.cdb.app;


import sisacao.cdb.daobase.DatasetColetorCDB;
import sisacao.cdb.processamento.ExecutaColetaDiarioCDB;

public class ColetorDiarioCDBObj {

	public void executa() {
		DatasetColetorCDB ds = new DatasetColetorCDB();
		ExecutaColetaDiarioCDB servico = new ExecutaColetaDiarioCDB();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}

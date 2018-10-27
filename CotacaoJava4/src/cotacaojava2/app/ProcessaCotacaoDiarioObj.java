package cotacaojava2.app;

import cotacaojava2.coletordiario.ImportadorDiarioHistoricoObj;
import cotacaojava2.coletordiario.ImportadorDiarioHistoricoOpcaoObj;
import cotacaojava2.coletordiario.TransferidorObj;

public class ProcessaCotacaoDiarioObj {
	
	public void executa(String dataAnterior) {
		String data = dataAnterior.substring(3, 5)
				+ dataAnterior.substring(0, 2);
		String ano = dataAnterior.substring(6);
		TransferidorObj transferidor = new TransferidorObj();
		if (transferidor.main(data,ano)) {
			ImportadorDiarioHistoricoObj obj2 = new ImportadorDiarioHistoricoObj();
			obj2.main(dataAnterior);
			ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
			obj3.main(dataAnterior);
		} else {
			transferidor.obtemDeArquivo(dataAnterior);
			ImportadorDiarioHistoricoObj obj2 = new ImportadorDiarioHistoricoObj();
			obj2.main(dataAnterior);
			ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
			obj3.main(dataAnterior);
		}
	}
}

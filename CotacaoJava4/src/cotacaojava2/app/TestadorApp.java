package cotacaojava2.app;

import cotacaojava2.coletordiario.ImportadorDiarioHistoricoOpcaoObj;
import cotacaojava2.timer.CotacaoOpcao2ThreadPai;

public class TestadorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CotacaoOpcao2ThreadPai obj = new CotacaoOpcao2ThreadPai();
		//obj.mudouDia("15-03-2016", "14-03-2016", true);
		
		ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
	    obj3.main("12-01-2017");
	}

}

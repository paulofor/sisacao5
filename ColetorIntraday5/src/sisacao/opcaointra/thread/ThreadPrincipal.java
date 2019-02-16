package sisacao.opcaointra.thread;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.OpcaoSisacao;
import sisacao.opcaointra.app.FuncoesObj;
import sisacao.opcaointra.importador.TransferidorObj;
import timer.AgregadorThreadColeta;


public class ThreadPrincipal extends ThreadPaiBase{

	private AgregadorThreadColeta agregador = new AgregadorThreadColeta();
	
	@Override
	protected void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) throws DaoException {
		System.out.println("Data anterior: " + dataAnterior);
		// DD-MM-AAAA
		// 0123456789
		if (existePregaoDiaAnterior) {
			String mesDia = dataAnterior.substring(3, 5) + dataAnterior.substring(0, 2);
			String ano = dataAnterior.substring(6);
			TransferidorObj obj = new TransferidorObj();
	   		obj.main(mesDia,ano);
			//TransferidorObj transferidor = new TransferidorObj();
			//transferidor.main(data, ano);
			//ImportadorDiarioHistoricoObj obj2 = new ImportadorDiarioHistoricoObj();
			//obj2.main(dataAnterior);
			//ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
			//obj3.main(dataAnterior);
			// Escolhedor de op��es autom�tico
			//EscolhaOpcaoColetaObj obj = new EscolhaOpcaoColetaObj();
			//obj.processaOpcoes();
	   		
	   		FuncoesObj funcObj = new FuncoesObj();
	   		funcObj.pesquisOpcoesComVolume();
	   		
	   		//agregador.limpaColetoresAtual();
	   		//agregador.disparaColetoresDia(mesDia);
	   		
		}
		//EscolhedorOpcaoSextaObj obj2 = new EscolhedorOpcaoSextaObj();
		//obj2.processaDia(dataAnterior);
	}

	

}

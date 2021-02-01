package sisacao.opcaointra.thread;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.log.ArquivoLog;
import coletorjava.modelo.OpcaoSisacao;
import sisacao.opcaointra.app.FuncoesObj;
import sisacao.opcaointra.importador.TransferidorObj;
import sisacao.opcaointra.parser.ParserDiarioObj;
import timer.AgregadorThreadColeta;


public class ThreadPrincipal extends ThreadPaiBase{

	private AgregadorThreadColeta agregador = new AgregadorThreadColeta();
	
	
	
	
	@Override
	protected void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) throws DaoException {
		
		try {
		
			System.out.println("[debug] ThreadPrincipal.mudouDia: diaAtual:" + diaAtual + ", dataAnterior:" + dataAnterior + ", existePregaoDiaAnterior:" + existePregaoDiaAnterior);
			// DD-MM-AAAA
			// 0123456789
			if (existePregaoDiaAnterior) {
				ArquivoLog.getInstancia().salvaLog("mudouDia" + "dataAtual:" + diaAtual + ", dataAnterior:" + dataAnterior + "existePregao: " + existePregaoDiaAnterior);
				String mesDia = dataAnterior.substring(3, 5) + dataAnterior.substring(0, 2);
				String ano = dataAnterior.substring(8);
				TransferidorObj obj = new TransferidorObj();
		   		obj.main(mesDia,ano);
		   		
		   		//Sem memoria pra isso
		   		ParserDiarioObj objParse = new ParserDiarioObj();
		   		objParse.inicio("20" + ano + mesDia);
		   		
		   		
		   		
				//TransferidorObj transferidor = new TransferidorObj();
				//transferidor.main(data, ano);
				//ImportadorDiarioHistoricoObj obj2 = new ImportadorDiarioHistoricoObj();
				//obj2.main(dataAnterior);
				//ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
				//obj3.main(dataAnterior);
				// Escolhedor de op��es autom�tico
				//EscolhaOpcaoColetaObj obj = new EscolhaOpcaoColetaObj();
				//obj.processaOpcoes();
		   		
		   		//FuncoesObj funcObj = new FuncoesObj();
		   		//funcObj.pesquisOpcoesComVolume();
		   		
		   		//agregador.limpaColetoresAtual();
		   		//agregador.disparaColetoresDia(mesDia);
		   		
			}
			//EscolhedorOpcaoSextaObj obj2 = new EscolhedorOpcaoSextaObj();
			//obj2.processaDia(dataAnterior);
		
		} catch (RuntimeException e ) {
			ArquivoLog.getInstancia().salvaErro(e);
		}
	}


	@Override
	protected void mudouDiaColetores(String novoDia) throws DaoException {
		agregador.limpaColetoresAtual();
   		agregador.disparaColetoresDia(novoDia);
	}

	

}

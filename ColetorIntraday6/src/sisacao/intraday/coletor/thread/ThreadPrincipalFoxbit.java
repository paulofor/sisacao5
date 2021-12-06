package sisacao.intraday.coletor.thread;

import br.com.digicom.lib.dao.DaoException;
import sisacao.intraday.coletor.agregador.AgregadorThreadFoxbit;


public class ThreadPrincipalFoxbit extends ThreadPaiBase{

	private AgregadorThreadFoxbit agregador = new AgregadorThreadFoxbit();
	
	
	
	
	@Override
	protected void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) throws DaoException {
		
		try {
		
			System.out.println("[debug] ThreadPrincipal.mudouDia: diaAtual:" + diaAtual + ", dataAnterior:" + dataAnterior + ", existePregaoDiaAnterior:" + existePregaoDiaAnterior);
			// DD-MM-AAAA
			// 0123456789
			if (existePregaoDiaAnterior) {
				//ArquivoLog.getInstancia().salvaLog("mudouDia" + "dataAtual:" + diaAtual + ", dataAnterior:" + dataAnterior + "existePregao: " + existePregaoDiaAnterior);
				String mesDia = dataAnterior.substring(3, 5) + dataAnterior.substring(0, 2);
				String ano = dataAnterior.substring(8);
				//TransferidorObj obj = new TransferidorObj();
		   		//obj.main(mesDia,ano);
		   		
		   		//Sem memoria pra isso
		   		//ParserDiarioObj objParse = new ParserDiarioObj();
		   		//objParse.inicio("20" + ano + mesDia);
		   		
			}
		} catch (RuntimeException e ) {
			//ArquivoLog.getInstancia().salvaErro(e);
		}
	}


	@Override
	protected void mudouDiaColetores(String novoDia) throws DaoException {
		agregador.limpaColetoresAtual();
   		agregador.disparaColetoresDia(novoDia);
	}

	

}

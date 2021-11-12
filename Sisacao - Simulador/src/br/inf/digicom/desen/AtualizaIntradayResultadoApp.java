package br.inf.digicom.desen;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.AtualizaIntradayResultadoObj;

public class AtualizaIntradayResultadoApp {

	private static final int ID_GRUPO01_100 = 8;
	private static final int ID_GRUPO02_100 = 9;
	private static final int ID_GRUPO03_100 = 10;
	private static final int ID_GRUPO04_100 = 11;
	
	
	public static void main(String[] args) {
		
		try {
			int idGrupo = Integer.parseInt(args[0]);
			AtualizaIntradayResultadoObj obj = new AtualizaIntradayResultadoObj();
					
			List<AtivoAcao> lista = obj.executa(idGrupo);
			System.out.println("Temos " + lista.size() + " ativos");
			for (AtivoAcao ativo : lista) {
				while (obj.executaTicker(ativo.getTicker())!=null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
		

	}

}

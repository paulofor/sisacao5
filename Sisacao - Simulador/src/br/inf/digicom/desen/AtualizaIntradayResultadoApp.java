package br.inf.digicom.desen;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.AtualizaIntradayResultadoObj;

public class AtualizaIntradayResultadoApp {

	
	
	public static void main(String[] args) {
		
		AtualizaIntradayResultadoObj obj = new AtualizaIntradayResultadoObj();
				
		List<AtivoAcao> lista = obj.executa(8);
		System.out.println("Temos " + lista.size() + " ativos");
		for (AtivoAcao ativo : lista) {
			//if (!"AZUL4".equals(ativo.getTicker()))
				while (obj.executaTicker(ativo.getTicker())!=null);
		}
		System.exit(0);
	}

}

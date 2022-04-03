package sisacao.dataset.treino.obj;

import br.inf.digicom.loopback.IDatasetComum;
import sisacao.dataset.treino.dao.DatasetComum;
import sisacao.dataset.treino.dao.RegraProjecao_ObtemPorCodigoRegra;

public class CriaExemploTreinoAcaoObj {

	private String ticker = "AZUL4";
	private Integer diaNumInicio = 20210101;
	//private Integer meses = 6; 
	
	//private Integer tamanhoX;
	//private final Integer OBSERVACAO_DIA = 15;	
	
	
	public void executa(String codigoRegra, int qtdeDias) {
		DatasetComum comum = new DatasetComum();
		RegraProjecao_ObtemPorCodigoRegra exec = new RegraProjecao_ObtemPorCodigoRegra();
		comum.setTicker(ticker);
		comum.setInicioPeriodo(diaNumInicio);
		comum.setCodigoRegra(codigoRegra);
		comum.setQuantidadeDiasX(3);
		exec.setComum(comum);
		exec.executa();
	
	}
	
	/*
	private void calculaParametros() {
		this.tamanhoX = 30 * OBSERVACAO_DIA * meses; 
	}
	*/

}

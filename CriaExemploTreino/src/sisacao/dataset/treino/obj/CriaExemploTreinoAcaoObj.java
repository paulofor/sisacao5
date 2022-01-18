package sisacao.dataset.treino.obj;

import sisacao.dataset.treino.dao.DiaPregao_ObtemIntradayResultadoDataset;

public class CriaExemploTreinoAcaoObj {

	private String ticker = "AZUL4";
	private Integer diaNumInicio = 20210101;
	private Integer meses = 6; 
	
	private Integer tamanhoX;
	private final Integer OBSERVACAO_DIA = 15;	
	
	
	public void executa() {
		this.calculaParametros();
		System.out.println(ticker + " Xn=" + this.tamanhoX + " Inicio: " + diaNumInicio);
		DiaPregao_ObtemIntradayResultadoDataset exec = new DiaPregao_ObtemIntradayResultadoDataset();
		exec.setTicker(ticker);
		exec.setInicioPeriodo(20210101);
		exec.executa();
	}
	
	private void calculaParametros() {
		this.tamanhoX = 30 * OBSERVACAO_DIA * meses; 
	}

}

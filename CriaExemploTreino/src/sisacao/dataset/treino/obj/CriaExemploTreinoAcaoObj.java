package sisacao.dataset.treino.obj;

public class CriaExemploTreinoAcaoObj {

	private String ticker = "AZUL4";
	private Integer diaNumInicio = 20210101;
	private Integer meses = 6; 
	
	private Integer tamanhoX;
	private final Integer OBSERVACAO_DIA = 15;	
	
	
	public void executa() {
		this.calculaParametros();
		System.out.println(ticker + "Xn = " + this.tamanhoX + " Inicio: " + diaNumInicio);
	}
	
	private void calculaParametros() {
		this.tamanhoX = 30 * OBSERVACAO_DIA * meses; 
	}

}

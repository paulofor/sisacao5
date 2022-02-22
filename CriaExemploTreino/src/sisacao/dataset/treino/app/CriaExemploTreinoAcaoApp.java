package sisacao.dataset.treino.app;

import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class CriaExemploTreinoAcaoApp {
	
	public static void main(String[] args) {
		System.out.print("CriaExemploTreinoAcaoApp");
		System.out.println(" (30-12-2021)");
		String codigoRegra = "t15s10v";
		int qtdeDias = 60;
		CriaExemploTreinoAcaoObj obj = new CriaExemploTreinoAcaoObj();
		obj.executa(codigoRegra, qtdeDias);
	}

}

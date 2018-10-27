package coletorjava.app;

public class ColetorJava2App {

	public static void main(String[] args) {
		System.out.println("Ola Mundão !");
		//tratando2014();
		ColetorJava2Obj obj = new ColetorJava2Obj();
		obj.verificarIntraday("ITUB4","2013");
		
		//obj.verificador15MinutosOpcoes();
		//obj.criaHistoricoOpcao15("BBDC4", "20-08-2014", "31-12-2014");
		//verificaSeAconteceuColetaIntraday_BBDC4();
		//criaOpcoes15_BBDC4();
				
		//obj.corrigeTodasOpcoesDiarioAno("2008");
		//obj.corrigeTodasOpcoesDiarioAno("2009");
		//obj.corrigeTodasOpcoesDiarioAno("2010");
		//obj.corrigeTodasOpcoesDiarioAno("2011");
		//obj.corrigeTodasOpcoesDiarioAno("2012");
		//obj.corrigeTodasOpcoesDiarioAno("2013");
		
		//obj.verificaSplits();
		//obj.executa();
		//obj.obtemNovas();
		//obj.exibeDiasSemCotacaoDiario("BBDC4","2013");
		//corrigeAnos();
		//obj.verificarIntraday("ITUB4","2008");
		//obj.verificarIntraday("ITUB4","2009");
		//obj.verificarIntraday("ITUB4","2010");
		//obj.verificarIntraday("ITUB4","2011");
		//obj.verificarIntraday("ITUB4","2012");
		//obj.verificarIntraday("ITUB4","2013");
	}
	
	private static void tratando2014() {
		ColetorJava2Obj obj = new ColetorJava2Obj();
		//obj.corrigeDiasSemCotacaoDiario("BBDC4", "2014");
		//obj.corrigeDiasSemCotacaoDiario("ITUB4", "2014");
		//obj.corrigeDiasSemCotacaoDiario("VALE5", "2014");	
		//obj.exibeDiasSemCotacaoDiario("BBDC4", "2014");
		obj.verificarIntraday("ITUB4","2013");
		//obj.corrigeTodasOpcoesDiarioAno("2014");
		/*
		obj.criarOpcoesParaColeta("20-01-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2014","BBDC4");
		
		obj.verificarSeAconteceuColetaIntraday("01-02-2014", "01-01-2014", "01-02-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-03-2014", "01-02-2014", "01-03-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-04-2014", "01-03-2014", "01-04-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-05-2014", "01-04-2014", "01-05-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-06-2014", "01-05-2014", "01-06-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-07-2014", "01-06-2014", "01-07-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-08-2014", "01-07-2014", "01-08-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-09-2014", "01-08-2014", "01-09-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-10-2014", "01-09-2014", "01-10-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-11-2014", "01-10-2014", "01-11-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-12-2014", "01-11-2014", "01-12-2014", "BBDC4");
		*/
		//obj.criaHistoricoOpcao15("BBDC4", "20-08-2014", "31-12-2014");
		//obj.verificador15MinutosOpcoes();
	}
	
	private static void verificaSeAconteceuColetaIntraday_BBDC4() {
		ColetorJava2Obj obj = new ColetorJava2Obj();
		/*
		obj.verificarSeAconteceuColetaIntraday("01-11-2012", "01-10-2012", "01-11-2012", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-12-2012", "01-11-2012", "01-11-2012", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-01-2013", "01-12-2012", "01-01-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-02-2013", "01-01-2013", "01-02-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-03-2013", "01-02-2013", "01-03-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-04-2013", "01-03-2013", "01-04-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-05-2013", "01-04-2013", "01-05-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-06-2013", "01-05-2013", "01-06-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-07-2013", "01-06-2013", "01-07-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-08-2013", "01-07-2013", "01-08-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-09-2013", "01-08-2013", "01-09-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-10-2013", "01-09-2013", "01-10-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-11-2013", "01-10-2013", "01-11-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-12-2013", "01-11-2013", "01-12-2013", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-01-2014", "01-12-2013", "01-01-2014", "BBDC4");
		*/
		obj.verificarSeAconteceuColetaIntraday("01-02-2014", "01-01-2014", "01-02-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-03-2014", "01-02-2014", "01-03-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-04-2014", "01-03-2014", "01-04-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-05-2014", "01-04-2014", "01-05-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-06-2014", "01-05-2014", "01-06-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-07-2014", "01-06-2014", "01-07-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-08-2014", "01-07-2014", "01-08-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-09-2014", "01-08-2014", "01-09-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-10-2014", "01-09-2014", "01-10-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-11-2014", "01-10-2014", "01-11-2014", "BBDC4");
		obj.verificarSeAconteceuColetaIntraday("01-12-2014", "01-11-2014", "01-12-2014", "BBDC4");
	
		
	}
	
	
	private static void criaOpcoes15_BBDC4() {
		ColetorJava2Obj obj = new ColetorJava2Obj();

		obj.criarOpcoesParaColeta("20-09-2009","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2009","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2009","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2009","BBDC4");
		
		obj.criarOpcoesParaColeta("20-01-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2010","BBDC4");
		obj.criarOpcoesParaColeta("20-01-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2011","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2011","BBDC4");
		
		obj.criarOpcoesParaColeta("20-01-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2012","BBDC4");
		obj.criarOpcoesParaColeta("20-01-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2013","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2013","BBDC4");
		
		obj.criarOpcoesParaColeta("20-01-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-02-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-03-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-04-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-05-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-06-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-07-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-08-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-09-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-10-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-11-2014","BBDC4");
		obj.criarOpcoesParaColeta("20-12-2014","BBDC4");
		
	}
	
	
	private static void corrigeAnos() {
		ColetorJava2Obj obj = new ColetorJava2Obj();
		obj.corrigeDiasSemCotacaoDiario("BBDC4", "2007");
		obj.corrigeDiasSemCotacaoDiario("ITUB4", "2013");
		
	}
}

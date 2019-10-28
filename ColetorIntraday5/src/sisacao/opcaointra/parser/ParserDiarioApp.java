package sisacao.opcaointra.parser;

import sisacao.opcaointra.importador.TransferidorObj;

public class ParserDiarioApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Parser");
		executaJan18();
		//ParserDiarioObj obj = new ParserDiarioObj();
		//obj.inicio("20190808");
	}
	
	
	private static void executaJan18() {
		ParserDiarioObj obj = new ParserDiarioObj();
		TransferidorObj transf = new TransferidorObj();
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180101.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180101");
		
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180102.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180102");
		/*
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180103.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180103");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180104.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180104");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180105.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180105");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180106.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180106");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180107.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180107");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180108.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180108");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180109.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180109");
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR180110.zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio("20180110");
		*/
	}

}

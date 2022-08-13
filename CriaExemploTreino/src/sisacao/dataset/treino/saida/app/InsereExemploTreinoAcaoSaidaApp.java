package sisacao.dataset.treino.saida.app;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;


import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class InsereExemploTreinoAcaoSaidaApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoSaidaApp");
		System.out.println(" (06-08-2022)");
		try {
			
			//carregaProp();
			//int posicaoEntrada = 0;
			//int qtdeDias = 120;
			//String codigoGrupoAcao = "Neg-100";
			//String codigoRegra = "t11s17v";
			int posicaoEntrada = Integer.parseInt(args[0]);
			int qtdeDias = Integer.parseInt(args[1]);
			String codigoGrupoAcao = args[2];
			String codigoRegra = args[3];
			String porta = args[4];
			
	        UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:" + porta + "/api";
	        DaoBaseComum.setUrl(UrlLoopback);
			
			PrintStream printStream = new PrintStream("Error_" + codigoRegra + "_InsereExemploTreinoAcaoSaidaApp.txt");
		    System.setErr(printStream);
			
			InsereExemploTreinoAcaoSaidaObj obj = new InsereExemploTreinoAcaoSaidaObj();
			obj.executa(posicaoEntrada, qtdeDias, codigoGrupoAcao, codigoRegra);
			gravaFinalExecucao("Finalizou_" + codigoRegra + ".log");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void gravaFinalExecucao(String nomeArquivo) throws IOException {
		FileWriter arq = new FileWriter(nomeArquivo, true);
		arq.write("acabou");
		arq.close();
	}

	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CriaExemploTreinoAcao.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
        DaoBaseComum.setUrl(UrlLoopback);
	}

}

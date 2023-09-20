package sisacao.dataset.treino.saida.app;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.saida.dao.RegraProjecao_FinalizaInsercao;

public class InsereExemploTreinoAcaoSaidaAutomaticoApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoSaidaAutomaticoApp");
		System.out.println(" (06-01-2023)");
		try {
			
			String codigoGrupoAcao = args[0];
			String porta = args[1];
			
	        UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:" + porta + "/api";
	        DaoBaseComum.setUrl(UrlLoopback);
			
			InsereExemploTreinoAcaoSaidaAutomaticoObj obj = new InsereExemploTreinoAcaoSaidaAutomaticoObj();
			obj.executa(codigoGrupoAcao);

			RegraProjecao_FinalizaInsercao finaliza = new RegraProjecao_FinalizaInsercao();
			finaliza.setComum(obj.getDataset());
			finaliza.executa();
			
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

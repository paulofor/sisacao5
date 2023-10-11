package gerador.preredetreinadaprocessatestecontrole.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.preredetreinadaprocessatestecontrole.passo.*;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class PreRedeTreinadaProcessaTesteControle {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("PreRedeTreinadaProcessaTesteControle");
		System.out.println("(10/10/2023 11:40:47)");
		try {
			carregaProp();
			PreRedeTreinadaProcessaTesteControleObj obj = new PreRedeTreinadaProcessaTesteControleObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("PreRedeTreinadaProcessaTesteControle.err", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			e.printStackTrace(printWriter);
			printWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void carregaProp() throws IOException {
		//System.out.println("Dir:" + System.getProperty("user.dir"));
		//InputStream input = new FileInputStream("CriaPythonTreinoRede.config");
		//Properties prop = new Properties();
		//prop.load(input);
		//UrlLoopback = prop.getProperty("loopback.url");
		UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:23004/api";
		DaoBaseComum.setUrl(UrlLoopback);
	}

	private static void preparaComum() {
		DaoBaseComum.setUrl(UrlLoopback);
		DaoBaseComum.setProximo("PreRedeTreinadaProcessaTesteControleObj", new ExperimentoPreRedeTreinada_ObtemProximoParaResultadoImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinada_ObtemProximoParaResultado", new ExperimentoPreRedeTreinadaControle_ReinicializaExperimentoImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinadaControle_ReinicializaExperimento", new DiaPregao_ObtemPeriodoPrevisaoTesteImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemPeriodoPrevisaoTeste", new ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhoresImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhores", new DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior", new VerificaTradeImpl());
		DaoBaseComum.setProximo("VerificaTrade", new ExperimentoPreRedeTreinadaControle_InsereImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinadaControle_Insere", new ExperimentoPreRedeTreinada_CalculaResultadoControleImpl());
	}
}

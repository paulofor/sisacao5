package gerador.preredetreinadaprocessateste.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.preredetreinadaprocessateste.passo.*;
import gerador.preredetreinadaprocessateste.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class PreRedeTreinadaProcessaTeste {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("PreRedeTreinadaProcessaTeste");
		System.out.println("(26/09/2023 16:27:59)");
		try {
			carregaProp();
			PreRedeTreinadaProcessaTesteObj obj = new PreRedeTreinadaProcessaTesteObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("PreRedeTreinadaProcessaTeste.err", true);
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
		DaoBaseComum.setProximo("PreRedeTreinadaProcessaTesteObj", new ExperimentoPreRedeTreinada_ObtemProximoParaResultadoImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinada_ObtemProximoParaResultado", new DiaPregao_ObtemPeriodoPrevisaoTesteImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemPeriodoPrevisaoTeste", new ExperimentoPreRedeTreinadaScore_ObtemMelhoresPorDiaImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinadaScore_ObtemMelhoresPorDia", new DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior", new VerificaTradeImpl());
		DaoBaseComum.setProximo("VerificaTrade", new ExperimentoPreRedeTreinadaScore_AtualizaResultadoTradeImpl());
		DaoBaseComum.setProximo("ExperimentoPreRedeTreinadaScore_AtualizaResultadoTrade", new ExperimentoPreRedeTreinada_CalculaResultadoImpl());
	}
}

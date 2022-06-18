package sisacao.dataset.treino.saida.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegra;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.entrada.periodo.app.CriaDataSetSaida;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoEntrada_ListaSemResultado;

public class TestaTreinoAcaoSaidaApp {
	
	public static String UrlLoopback = "";

	public static void main(String[] args) {
		
		try {
			carregaProp();
			trataProximo();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		AtivoAcao ativo = new AtivoAcao();
		ativo.setTicker("ABEV3");
		RegraProjecao regraProjecao = new RegraProjecao();
		regraProjecao.setDiaLimite(40);
		regraProjecao.setId(30);
		regraProjecao.setTipoCompraVenda("V");
		regraProjecao.setPercentualEntradaDataset(0.02);
		
		
		ExemploTreinoAcaoEntrada_ListaSemResultado exec = new ExemploTreinoAcaoEntrada_ListaSemResultado();
		DatasetExemplo ds = new DatasetExemplo();
		ds.setAtivoAcaoCorrente(ativo);
		ds.setRegraProjecao(regraProjecao);
		ds.setDiaNumInicio(20210908);
		ds.setPosicaoEntrada(0);
		ds.setQtdeDia(120);
		
		exec.setComum(ds);
		exec.executa();
		
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CriaExemploTreinoAcao.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
        DaoBaseComum.setUrl(UrlLoopback);
	}
	
	private static void trataProximo() {
		DaoBaseComum.setProximo(RegraProjecao_ObtemPorCodigoRegra.NOME, new AtivoAcao_ListaPorNomeGrupo());
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new ExemploTreinoAcaoEntrada_ListaSemResultado());
		//DaoBaseComum.setProximo(ExemploTreinoAcaoEntrada_ListaSemResultado.NOME, new DiaPregao_ObtemIntradayResultadoTickerAteFinal());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new CriaDataSetSaida());
	}

}

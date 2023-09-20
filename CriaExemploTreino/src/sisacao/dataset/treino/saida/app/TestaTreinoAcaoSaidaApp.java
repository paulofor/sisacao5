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
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegra;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ProximoParaProcessamento;
import sisacao.dataset.treino.dao.DatasetExemplo;
import sisacao.dataset.treino.entrada.app.CriaDataSetEntrada;
import sisacao.dataset.treino.entrada.periodo.app.CriaDataSetSaida;
import sisacao.dataset.treino.entrada.periodo.app.CriaDataSetSaidaSimples;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoEntrada_ListaSemResultado;
import sisacao.dataset.treino.saida.dao.ExemploTreinoAcaoEntrada_ListaSemResultadoSimples;

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
		ativo.setTicker("AZUL4");
		
		RegraProjecao regraProjecao = new RegraProjecao();
		regraProjecao.setDiaLimite(50);
		regraProjecao.setId(48);
		regraProjecao.setTipoCompraVenda("V");
		regraProjecao.setPercentualEntradaDataset(0.02);
		regraProjecao.setIndiceHoraReferenciaDataset(0);
		regraProjecao.setTarget(0.13);
		regraProjecao.setStop(0.17);
		
		
		DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior exec = new DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior();
		DatasetExemplo ds = new DatasetExemplo();
		ds.setAtivoAcaoCorrente(ativo);
		ds.setRegraProjecao(regraProjecao);
		ds.setDiaNumInicio(20210604);
		ds.setPosicaoEntrada(0);
		ds.setQtdeDia(50);
		
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
		DaoBaseComum.setProximo(RegraProjecao_ProximoParaProcessamento.NOME, new AtivoAcao_ListaPorNomeGrupo());
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new ExemploTreinoAcaoEntrada_ListaSemResultadoSimples());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior.NOME, new CriaDataSetSaidaSimples());

	}


}

package br.com.digicom.cotacao.handle;

import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecao;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.util.ArquivoLog;

public class DaoThread extends Thread {
	private Cotacao cotacao;
	private static DaoConexao conexao;
	private static FabricaRegraI fabricaRegra;

	public static void setConexao(DaoConexao conexaoEntrada) {
		conexao = conexaoEntrada;
	}

	public static void setFabricaRegra(FabricaRegraI fabrica) {
		fabricaRegra = fabrica;
	}

	public void setCotacao(Cotacao cotacao) {
		this.cotacao = cotacao;
	}

	public void run() {
		try {
			CotacaoRegraColecao cotacaoRC = fabricaRegra.getCotacaoRegraColecao();
			cotacaoRC.getFiltro().setCotacao(this.cotacao);
			cotacaoRC.getFiltro().setNomeTicker(this.cotacao.getTicker());
			cotacaoRC.InsereCotacao(conexao);
		} catch (DaoException e) {
			System.out.println("Nao consegui inserir cotação");
			ArquivoLog.getInstancia().salvaLog("Erro DaoThread:[" + this.cotacao.getTicker() + "]" + e);
			e.printStackTrace();
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.handle.DaoThread JD-Core Version: 0.6.0
 */
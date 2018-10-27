package sisacao.app.thread;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.CotacaoProcessadaDao;
import coletorjava.dao.DBB;
import coletorjava.log.ArquivoLog;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.FabricaRegra;

public class CotacaoProcessadaDaoThread extends Thread {
	private CotacaoProcessada cotacaoProcessada;
	private String nomeTicker;

	private static DaoConexao conexao;

	public static void criaConexaoUnica() {
		/*CotacaoProcessadaDao dao = DBB.getInstancia().getCotacaoProcessadaDao();
		try {
			conexao = dao.criaConexao();
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("Nao consegui criar conexao cotacaoo");
		}*/
	}

	public void setCotacao(CotacaoProcessada cotacao, String nomeTicker) {
		this.cotacaoProcessada = cotacao;
		this.nomeTicker = nomeTicker;
	}

	public void run() {
		CotacaoProcessadaRegraColecao cotacaoProcRC = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		cotacaoProcRC.getFiltro().setCotacaoInsercao(this.cotacaoProcessada);
		cotacaoProcRC.getFiltro().setNomeTicker(this.nomeTicker);
		try {
			cotacaoProcRC.InsereItemOnline();
		} catch (DaoException e) {
			System.out.println("Nao consegui inserir cotacao");
			ArquivoLog.getInstancia().salvaLog("Erro criacao de DaoException" + e);
			e.printStackTrace();
		}
	}
}

/*
 * Location: C:\Fontes\ProjetosJava2\Recuperacao-CotacaoJava15\Cotacao15\
 * Qualified Name: sisacaoweb2.dao.CotacaoProcessadaDaoThread JD-Core Version:
 * 0.6.0
 */
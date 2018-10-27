package cotacaojava2.coletordiario;

import br.com.digicom.cotacao.dao.CotacaoDiarioDao;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.util.ArquivoLog;
import cotacaojava2.dao.DBB;
import cotacaojava2.regracolecao.CotacaoDiarioRegraColecaoImpl;
import cotacaojava2.webservice.TickerFiltro;
import cotacaojava2.webservice.TickerObjetoWs;
import cotacaojava2.webservice.TickerWSLocator;
import cotacaojava2.webservice.TickerWSSoap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImportadorDiarioHistoricoObj {
	public void main(String dataDD_MM_AAAA) {
		ArquivoLog.getInstancia().setArquivo("ImportadorDiario.log");
		CotacaoDiarioRegraColecaoImpl servico = new CotacaoDiarioRegraColecaoImpl();
		try {
			TickerWSLocator locator = new TickerWSLocator();
			TickerWSSoap ws = locator.getTickerWSSoap();
			TickerFiltro filtro = new TickerFiltro();
			filtro.setDataAtivo(dataDD_MM_AAAA);
			TickerObjetoWs[] ativos = ws.listaAtivo(filtro);
			Set listaAtivos = new HashSet();
			for (int i = 0; i < ativos.length; i++) {
				listaAtivos.add(ativos[i].getNome());
			}
			listaAtivos.add("IBOVESPA");
			Set listaOnline = new HashSet();
			TickerObjetoWs[] online = ws.listaDiarioOnline(filtro);
			for (int i = 0; i < online.length; i++) {
				listaOnline.add(online[i].getNome());
			}
			verificaTabelas(listaAtivos);
			servico.leArquivoDiario("download/BDIN", listaAtivos, listaOnline, dataDD_MM_AAAA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void verificaTabelas(Set listaAtivos) {
		CotacaoDiarioDao dao = DBB.getInstancia().getCotacaoDiarioDao();
		try {
			DaoConexao conexao = dao.criaConexao();
			dao.setConexao(conexao);
			Iterator it = listaAtivos.iterator();
			while (it.hasNext()) {
				dao.CriaTabelaSeNecessario(it.next().toString());
			}
			dao.liberaConexao(conexao);
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em verificaTabelas:" + e.getMessage());
			e.printStackTrace();
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.coletordiario.ImportadorDiarioHistoricoObj JD-Core Version:
 * 0.6.0
 */
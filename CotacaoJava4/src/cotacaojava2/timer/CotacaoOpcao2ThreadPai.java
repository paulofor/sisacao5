package cotacaojava2.timer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.digicom.cotacao.dao.CotacaoDao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;
import br.com.digicom.cotacao.threads.ThreadPaiBase;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import coletorjava.app.EscolhaOpcaoColetaObj;
import coletorjava.app.EscolhedorOpcaoSextaObj;
import cotacaojava2.coletordiario.ImportadorDiarioHistoricoObj;
import cotacaojava2.coletordiario.ImportadorDiarioHistoricoOpcaoObj;
import cotacaojava2.coletordiario.TransferidorObj;
import cotacaojava2.dao.DBB;
import cotacaojava2.webservice.TickerFiltro;
import cotacaojava2.webservice.TickerObjetoWs;
import cotacaojava2.webservice.TickerWSLocator;
import cotacaojava2.webservice.TickerWSSoap;

public class CotacaoOpcao2ThreadPai extends ThreadPaiBase {
	TickerWSLocator locatorTicker = null;

	public CotacaoOpcao2ThreadPai() {
		this.locatorTicker = new TickerWSLocator();
	}

	protected List obtemListaTicker() {
		List listaSaida = null;

		int tentativas = 48;
		while ((listaSaida == null) && (tentativas-- > 0)) {
			listaSaida = obtemListaAtivo();
		}
		ArquivoLog.getInstancia().setArquivo("ImportadorDiario.log");
		if (listaSaida == null)
			ArquivoLog.getInstancia().salvaLog("Recuperação de lista de ativos = null, Tentativas=" + tentativas);
		else {
			ArquivoLog.getInstancia().salvaLog("Recuperação de lista de ativos, tamanho:" + listaSaida.size());
		}
		verificaTabelas(listaSaida);
		return listaSaida;
	}

	private void verificaTabelas(List listaAtivos) {
		CotacaoDao dao = DBB.getInstancia().getCotacaoDao();
		try {
			DaoConexao conexao = dao.criaConexao();
			dao.setConexao(conexao);
			Iterator it = listaAtivos.iterator();
			while (it.hasNext()) {
				String ativo = it.next().toString();
				dao.CriaTabelaSeNecessario(ativo);
			}
			dao.liberaConexao(conexao);
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em verificaTabelas:" + e.getMessage());
			e.printStackTrace();
		}
	}

	protected List obtemListaAtivo() {
		List listaSaida = null;
		String dataAtual = DatasUtils.getDataDD_MM_AAAA();
		TickerFiltro filtro = new TickerFiltro();
		filtro.setDataAtivo(dataAtual);
		try {
			TickerWSSoap servico = this.locatorTicker.getTickerWSSoap();
			TickerObjetoWs[] lista = servico.listaAtivo(filtro);
			listaSaida = new ArrayList();
			for (int i = 0; i < lista.length; i++) {
				TickerObjetoWs item = lista[i];
				listaSaida.add(item.getNome());
			}
			return listaSaida;
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em obtemListAtivo:" + e.getMessage());
		}
		return listaSaida;
	}

	protected int minutos() {
		return 5;
	}

	protected void mudouAno(String anoAtual, String anoAnterior) {
		System.out.println("Novo Ano");
	}

	public void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) {
		System.out.println("Novo Dia:" + diaAtual);
		if (existePregaoDiaAnterior) {
			String data = dataAnterior.substring(3, 5) + dataAnterior.substring(0, 2);
			String ano = dataAnterior.substring(6);
			TransferidorObj transferidor = new TransferidorObj();
			transferidor.main(data, ano);
			ImportadorDiarioHistoricoObj obj2 = new ImportadorDiarioHistoricoObj();
			obj2.main(dataAnterior);
			ImportadorDiarioHistoricoOpcaoObj obj3 = new ImportadorDiarioHistoricoOpcaoObj();
			obj3.main(dataAnterior);
			// Escolhedor de opções automático
			EscolhaOpcaoColetaObj obj = new EscolhaOpcaoColetaObj();
			obj.processaOpcoes();
		}
		EscolhedorOpcaoSextaObj obj2 = new EscolhedorOpcaoSextaObj();
		obj2.processaDia(dataAnterior);
	}

	protected void mudouMes(String mesAtual, String mesAnterior) {
		/* 121 */System.out.println("Novo Mes");
	}

	protected PesquisadorTicker getPesquisador() {
		/* 127 */return new PesquisadorCotacaoAcao();
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.timer.CotacaoOpcao2ThreadPai JD-Core Version: 0.6.0
 */
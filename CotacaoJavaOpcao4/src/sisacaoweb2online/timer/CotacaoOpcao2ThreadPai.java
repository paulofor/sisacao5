package sisacaoweb2online.timer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.digicom.cotacao.dao.CotacaoDao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;
import br.com.digicom.cotacao.threads.ThreadPaiBase;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import coletorjava.app.EscolhaOpcaoColetaObj;
import coletorjava.app.EscolhedorOpcaoSextaObj;

import sisacaoweb2online.dao.DBB;
import sisacaoweb2online.webservice.OpcaoSisacaoFiltro;
import sisacaoweb2online.webservice.OpcaoSisacaoObjetoWs;
import sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerFiltro;
import sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWSLocator;
import sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWSSoap;
import sisacaoweb2online.webservice.OpcaoSisacaoWSLocator;
import sisacaoweb2online.webservice.OpcaoSisacaoWSSoap;
import sisacaoweb2online.webservice.TickerFiltro;
import sisacaoweb2online.webservice.TickerObjetoWs;
import sisacaoweb2online.webservice.TickerWSLocator;
import sisacaoweb2online.webservice.TickerWSSoap;

public class CotacaoOpcao2ThreadPai extends ThreadPaiBase {
	TickerWSLocator locatorTicker = null;
	OpcaoSisacaoSerieTickerWSLocator locatorOpcaoSisacaoSerie = null;
	OpcaoSisacaoWSLocator locatorOpcaoSisacao = null;

	public boolean criaNovasOpcoes(String data) {
		List listaTicker = obtemListaTicker();
		Iterator it = listaTicker.iterator();
		OpcaoSisacaoSerieTickerFiltro filtro = new OpcaoSisacaoSerieTickerFiltro();
		filtro.setDataAtual(data);

		CotacaoDao dao = DBB.getInstancia().getCotacaoDao();
		try {
			DaoConexao conexao = dao.criaConexao();
			dao.setConexao(conexao);
			while (it.hasNext()) {
				String nomeTicker = ((String) it.next()).toString();
				filtro.setNomeTicker(nomeTicker);
				Cotacao ult = dao.obtemMaisRecente(nomeTicker);
				filtro.setPrecoReferencia(Float.parseFloat(ult.getUlt()));
				filtro.setDataCotacaoReferencia(ult.getData());
				OpcaoSisacaoSerieTickerWSSoap ws = this.locatorOpcaoSisacaoSerie.getOpcaoSisacaoSerieTickerWSSoap();
				ws.criaOpcaoSisacaoTicker(filtro);
			}
			dao.liberaConexao(conexao);
			return true;
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em criaNovasOpcoes:" + e);
			ArquivoLog.getInstancia().salvaErro(e);
		}
		return false;
	}

	public CotacaoOpcao2ThreadPai() {
		this.locatorTicker = new TickerWSLocator();
		this.locatorOpcaoSisacaoSerie = new OpcaoSisacaoSerieTickerWSLocator();
		this.locatorOpcaoSisacao = new OpcaoSisacaoWSLocator();
	}

	protected List obtemListaTicker() {
		List listaSaida = null;
		int tentativas = 24;
		while ((listaSaida == null) && (tentativas-- > 0)) {
			listaSaida = obtemListaAtivo();
		}
		List listaOpcoes = null;
		tentativas = 24;
		while ((listaOpcoes == null) && (tentativas-- > 0)) {
			listaOpcoes = obtemListaOpcoes();
		}
		listaSaida.addAll(listaOpcoes);
		verificaTabelas(listaSaida);
		return listaSaida;
	}

	private void verificaTabelas(List<String> listaAtivos) {
		CotacaoDao dao = DBB.getInstancia().getCotacaoDao();
		try {
			DaoConexao conexao = dao.criaConexao();
			dao.setConexao(conexao);
			Iterator it = listaAtivos.iterator();
			while (it.hasNext()) {
				String ativo = ((String) it.next()).toString();
				dao.CriaTabelaSeNecessario(ativo);
			}
			dao.liberaConexao(conexao);
		} catch (Exception e) {
			ArquivoLog.getInstancia().salvaLog("Exception em verificaTabelas:" + e.getMessage());
			e.printStackTrace();
		}
	}

	
	protected List<String> obtemListaAtivo()
	/* 117: */{
		/* 118:105 */List listaSaida = null;
		/* 119:106 */String dataAtual = DatasUtils.getDataDD_MM_AAAA();
		/* 120:107 */TickerFiltro filtro = new TickerFiltro();
		/* 121:108 */filtro.setDataAtivo(dataAtual);
		/* 122: */try
		/* 123: */{
			/* 124:110 */TickerWSSoap servico = this.locatorTicker.getTickerWSSoap();
			/* 125:111 */TickerObjetoWs[] lista = servico.listaAtivoOpcao(filtro);
			/* 126:112 */listaSaida = new ArrayList();
			/* 127:113 */for (int i = 0; i < lista.length; i++)
			/* 128: */{
				/* 129:114 */TickerObjetoWs item = lista[i];
				/* 130:115 */listaSaida.add(item.getNome());
				/* 131: */}
			/* 132:117 */return listaSaida;
			/* 133: */}
		/* 134: */catch (Exception e)
		/* 135: */{
			/* 136:119 */ArquivoLog.getInstancia().salvaLog(
			/* 137:120 */"Exception em obtemListAtivo:" + e.getMessage());
			/* 138: */}
		/* 139:122 */return listaSaida;
		/* 140: */}

	/* 141: */
	/* 142: */protected List<String> obtemListaOpcoes()
	/* 143: */{
		/* 144:126 */List listaSaida = null;
		/* 145:127 */String dataAtual = DatasUtils.getDataDD_MM_AAAA();
		/* 146:128 */OpcaoSisacaoFiltro filtro = new OpcaoSisacaoFiltro();
		/* 147:129 */filtro.setDataAtivo(dataAtual);
		/* 148: */try
		/* 149: */{
			/* 150:131 */OpcaoSisacaoWSSoap servico = this.locatorOpcaoSisacao
			/* 151:132 */.getOpcaoSisacaoWSSoap();
			/* 152:133 */OpcaoSisacaoObjetoWs[] lista = servico.listaAtivoOpcao(filtro);
			/* 153:134 */listaSaida = new ArrayList();
			/* 154:135 */for (int i = 0; i < lista.length; i++)
			/* 155: */{
				/* 156:136 */OpcaoSisacaoObjetoWs item = lista[i];
				/* 157:137 */listaSaida.add(item.getCodigoMercado());
				/* 158: */}
			/* 159:139 */return listaSaida;
			/* 160: */}
		/* 161: */catch (Exception e)
		/* 162: */{
			/* 163:141 */ArquivoLog.getInstancia().salvaLog(
			/* 164:142 */"Exception em obtemListaOpcoes:" + e.getMessage());
			/* 165: */}
		/* 166:144 */return listaSaida;
		/* 167: */}

	/* 168: */
	/* 169: */protected int minutos()
	/* 170: */{
		/* 171:148 */return 2;
		/* 172: */}

	/* 173: */
	/* 174: */protected void mudouAno(String anoAtual, String anoAnterior)
	/* 175: */{
		/* 176:152 */System.out.println("Novo Ano");
		/* 177: */}

	/* 178: */
	protected void mudouDia(String diaAtual, String dataAnterior, boolean existePregaoDiaAnterior) {
		System.out.println("Novo Dia");
		if ((diaAtual.substring(0, 2).compareTo("27") == 0) || (diaAtual.substring(0, 2).compareTo("28") == 0)
				|| (diaAtual.substring(0, 2).compareTo("29") == 0) || (diaAtual.substring(0, 2).compareTo("30") == 0)
				|| (diaAtual.substring(0, 2).compareTo("31") == 0)) {
			criaNovasOpcoes(diaAtual);
		}
		
	}
	
	

	/* 190: */
	/* 191: */protected void mudouMes(String mesAtual, String mesAnterior)
	/* 192: */{
		/* 193:167 */System.out.println("Novo Mes");
		/* 194: */}

	/* 195: */
	/* 196: */protected PesquisadorTicker getPesquisador()
	/* 197: */{
		/* 198:171 */return new PesquisadorCotacaoOpcao();
		/* 199: */}
	/* 200: */
}

/*
 * Location: D:\Documentos de
 * Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * 
 * Qualified Name: sisacaoweb2online.timer.CotacaoOpcao2ThreadPai
 * 
 * JD-Core Version: 0.7.0.1
 */
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.TickerDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class TickerDadosParseBase extends DadosParseDao {

	protected TickerDao dao = null;
	protected Ticker itemDetalhe = null;
	protected List<Ticker> lista = null;
	
	private boolean debug;
	
	public void setDebug() {
		debug = true;
	}
	
	private String proximaPagina = null;
	public void setProximaPagina(String url) {
		proximaPagina = url;
	}
	@Override
	public void setJson(JSONObject json) {
		throw new RuntimeException("voce deve implmentar o metodo setJson em " + this.getClass().toString());
	}
	
	// Para ser utilizado quando se esta obtendo o detalhe 
	// do Objeto Ticker
	// Para listas usar itemCorrente.
	public Ticker getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Ticker itemCorrente = null;
	
	//Possui 
	private	OpcaoSisacaoGeral correnteOpcaoSisacaoGeral;
	protected List<OpcaoSisacaoGeral> listaOpcaoSisacaoGeral = new ArrayList<OpcaoSisacaoGeral>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoSisacaoGeral(OpcaoSisacaoGeral itemLista) {
		itemLista.setIdTickerRa(itemDetalhe.getIdTicker());
		//ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoSisacaoGeral):" + OpcaoSisacaoGeralDadosParseBase.displayLog(correnteOpcaoSisacaoGeral));
		listaOpcaoSisacaoGeral.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoSisacaoGeral getCorrenteOpcaoSisacaoGeral() {
		return correnteOpcaoSisacaoGeral;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoSisacaoGeral() {
		correnteOpcaoSisacaoGeral.setIdTickerRa(itemDetalhe.getIdTicker());
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoSisacaoGeral):" + OpcaoSisacaoGeralDadosParseBase.displayLog(correnteOpcaoSisacaoGeral));
		
		listaOpcaoSisacaoGeral.add(correnteOpcaoSisacaoGeral);
	}
	@Deprecated
	public void criaCorrenteOpcaoSisacaoGeral() {
		correnteOpcaoSisacaoGeral = FabricaVo.criaOpcaoSisacaoGeral();
	}
 		
	//Gera 
	private	OpcaoSisacao correnteOpcaoSisacao;
	protected List<OpcaoSisacao> listaOpcaoSisacao = new ArrayList<OpcaoSisacao>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoSisacao(OpcaoSisacao itemLista) {
		itemLista.setIdTickerDd(itemDetalhe.getIdTicker());
		//ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoSisacao):" + OpcaoSisacaoDadosParseBase.displayLog(correnteOpcaoSisacao));
		listaOpcaoSisacao.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoSisacao getCorrenteOpcaoSisacao() {
		return correnteOpcaoSisacao;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoSisacao() {
		correnteOpcaoSisacao.setIdTickerDd(itemDetalhe.getIdTicker());
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoSisacao):" + OpcaoSisacaoDadosParseBase.displayLog(correnteOpcaoSisacao));
		
		listaOpcaoSisacao.add(correnteOpcaoSisacao);
	}
	@Deprecated
	public void criaCorrenteOpcaoSisacao() {
		correnteOpcaoSisacao = FabricaVo.criaOpcaoSisacao();
	}
 		
	//Possui 
	private	EscolhaOpcao correnteEscolhaOpcao;
	protected List<EscolhaOpcao> listaEscolhaOpcao = new ArrayList<EscolhaOpcao>();
	
	// Adicionado em 01-08-2016
	public void adicionaEscolhaOpcao(EscolhaOpcao itemLista) {
		itemLista.setIdTickerRa(itemDetalhe.getIdTicker());
		//ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		listaEscolhaOpcao.add(itemLista);
	}
	
	
	
	@Deprecated
	public EscolhaOpcao getCorrenteEscolhaOpcao() {
		return correnteEscolhaOpcao;
	}
	@Deprecated
	public void adicionaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao.setIdTickerRa(itemDetalhe.getIdTicker());
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		
		listaEscolhaOpcao.add(correnteEscolhaOpcao);
	}
	@Deprecated
	public void criaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao = FabricaVo.criaEscolhaOpcao();
	}
 		
	//Gera 
	private	ProjetoDadoTreino correnteProjetoDadoTreino;
	protected List<ProjetoDadoTreino> listaProjetoDadoTreino = new ArrayList<ProjetoDadoTreino>();
	
	// Adicionado em 01-08-2016
	public void adicionaProjetoDadoTreino(ProjetoDadoTreino itemLista) {
		itemLista.setIdTickerRa(itemDetalhe.getIdTicker());
		//ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteProjetoDadoTreino):" + ProjetoDadoTreinoDadosParseBase.displayLog(correnteProjetoDadoTreino));
		listaProjetoDadoTreino.add(itemLista);
	}
	
	
	
	@Deprecated
	public ProjetoDadoTreino getCorrenteProjetoDadoTreino() {
		return correnteProjetoDadoTreino;
	}
	@Deprecated
	public void adicionaCorrenteProjetoDadoTreino() {
		correnteProjetoDadoTreino.setIdTickerRa(itemDetalhe.getIdTicker());
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteProjetoDadoTreino):" + ProjetoDadoTreinoDadosParseBase.displayLog(correnteProjetoDadoTreino));
		
		listaProjetoDadoTreino.add(correnteProjetoDadoTreino);
	}
	@Deprecated
	public void criaCorrenteProjetoDadoTreino() {
		correnteProjetoDadoTreino = FabricaVo.criaProjetoDadoTreino();
	}
 		
	//Possui 
	private	OpcaoReferencia correnteOpcaoReferencia;
	protected List<OpcaoReferencia> listaOpcaoReferencia = new ArrayList<OpcaoReferencia>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoReferencia(OpcaoReferencia itemLista) {
		itemLista.setIdTickerRa(itemDetalhe.getIdTicker());
		//ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		listaOpcaoReferencia.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoReferencia getCorrenteOpcaoReferencia() {
		return correnteOpcaoReferencia;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia.setIdTickerRa(itemDetalhe.getIdTicker());
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		
		listaOpcaoReferencia.add(correnteOpcaoReferencia);
	}
	@Deprecated
	public void criaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia = FabricaVo.criaOpcaoReferencia();
	}
 		
	
	public TickerDadosParseBase() {
		super();
		lista = new ArrayList<Ticker>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Ticker getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Ticker item) {
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Ticker item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Ticker(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaTicker();
	}


	public void setItemDetalhe(Ticker item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em TickerDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em TickerDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getTickerDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getTickerDao();
			dao.setConexao(getConexao());
			List<Ticker> listaBanco = dao.ListaCorrente();
			List<Ticker> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Ticker> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Ticker> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Ticker item = it.next();
				System.out.println("Ticker Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Ticker> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Ticker item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Ticker item, TickerDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Ticker item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Ticker item) {
		try {
			dao = DBB.getInstancia().getTickerDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Ticker> subtraiListaPorNome(List<Ticker> listaMaior, List<Ticker> listaMenor) {
		Iterator<Ticker> itMaior = listaMaior.iterator();
		Iterator<Ticker> itMenor = null;
		List<Ticker> listaDiferenca = new ArrayList<Ticker>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Ticker corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Ticker comparador = itMenor.next();
				if (iguais(comparador,corrente)) {
					achou = true;
					break;
				}
			}
			if (!achou) {
				listaDiferenca.add(corrente);
			}
		}
		return listaDiferenca;
	}
	protected boolean iguais(Ticker item1, Ticker item2) {
		throw new RuntimeException("Fazer override em TickerDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Ticker item) {
		return "Fazer override em TickerDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaOpcaoSisacaoGeral.clear();
		listaOpcaoSisacao.clear();
		listaEscolhaOpcao.clear();
		listaProjetoDadoTreino.clear();
		listaOpcaoReferencia.clear();
	
	}
	
	
	public void displayLogLista(List<Ticker> lista, String codigo) {
		for (Ticker item : lista) {
			ArquivoLog.getInstancia().salvaLog("Ticker(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Ticker item) {
		StringBuffer display = new StringBuffer();
		display.append("Ticker {");
		
		display.append("IdTicker:" + item.getIdTicker() + ";");
		
		display.append("Nome:" + item.getNome() + ";");
		
		display.append("Empresa:" + item.getEmpresa() + ";");
		
		display.append("TipoAcao:" + item.getTipoAcao() + ";");
		
		display.append("DataInicioDiario:" + item.getDataInicioDiario() + ";");
		
		display.append("DataMaisRecenteDiario:" + item.getDataMaisRecenteDiario() + ";");
		
		display.append("DataInicioColetaOpcao:" + item.getDataInicioColetaOpcao() + ";");
		
		display.append("DataFinalColetaOpcao:" + item.getDataFinalColetaOpcao() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.OpcaoSisacaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OpcaoSisacaoDadosParseBase extends DadosParseDao {

	protected OpcaoSisacaoDao dao = null;
	protected OpcaoSisacao itemDetalhe = null;
	protected List<OpcaoSisacao> lista = null;
	
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
	// do Objeto OpcaoSisacao
	// Para listas usar itemCorrente.
	public OpcaoSisacao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OpcaoSisacao itemCorrente = null;
	
	//Escolhida 
	private	EscolhaOpcao correnteEscolhaOpcao;
	protected List<EscolhaOpcao> listaEscolhaOpcao = new ArrayList<EscolhaOpcao>();
	
	// Adicionado em 01-08-2016
	public void adicionaEscolhaOpcao(EscolhaOpcao itemLista) {
		itemLista.setIdOpcaoSisacaoE(itemDetalhe.getIdOpcaoSisacao());
		//ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		listaEscolhaOpcao.add(itemLista);
	}
	
	
	
	@Deprecated
	public EscolhaOpcao getCorrenteEscolhaOpcao() {
		return correnteEscolhaOpcao;
	}
	@Deprecated
	public void adicionaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao.setIdOpcaoSisacaoE(itemDetalhe.getIdOpcaoSisacao());
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		
		listaEscolhaOpcao.add(correnteEscolhaOpcao);
	}
	@Deprecated
	public void criaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao = FabricaVo.criaEscolhaOpcao();
	}
 		
	//EstaEm 
	private	CotacaoProcessadaOpcaoResultado correnteCotacaoProcessadaOpcaoResultado;
	protected List<CotacaoProcessadaOpcaoResultado> listaCotacaoProcessadaOpcaoResultado = new ArrayList<CotacaoProcessadaOpcaoResultado>();
	
	// Adicionado em 01-08-2016
	public void adicionaCotacaoProcessadaOpcaoResultado(CotacaoProcessadaOpcaoResultado itemLista) {
		itemLista.setIdOpcaoSisacaoRa(itemDetalhe.getIdOpcaoSisacao());
		//ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteCotacaoProcessadaOpcaoResultado):" + CotacaoProcessadaOpcaoResultadoDadosParseBase.displayLog(correnteCotacaoProcessadaOpcaoResultado));
		listaCotacaoProcessadaOpcaoResultado.add(itemLista);
	}
	
	
	
	@Deprecated
	public CotacaoProcessadaOpcaoResultado getCorrenteCotacaoProcessadaOpcaoResultado() {
		return correnteCotacaoProcessadaOpcaoResultado;
	}
	@Deprecated
	public void adicionaCorrenteCotacaoProcessadaOpcaoResultado() {
		correnteCotacaoProcessadaOpcaoResultado.setIdOpcaoSisacaoRa(itemDetalhe.getIdOpcaoSisacao());
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteCotacaoProcessadaOpcaoResultado):" + CotacaoProcessadaOpcaoResultadoDadosParseBase.displayLog(correnteCotacaoProcessadaOpcaoResultado));
		
		listaCotacaoProcessadaOpcaoResultado.add(correnteCotacaoProcessadaOpcaoResultado);
	}
	@Deprecated
	public void criaCorrenteCotacaoProcessadaOpcaoResultado() {
		correnteCotacaoProcessadaOpcaoResultado = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
	}
 		
	//Possui 
	private	OpcaoReferencia correnteOpcaoReferencia;
	protected List<OpcaoReferencia> listaOpcaoReferencia = new ArrayList<OpcaoReferencia>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoReferencia(OpcaoReferencia itemLista) {
		itemLista.setIdOpcaoSisacaoRa(itemDetalhe.getIdOpcaoSisacao());
		//ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		listaOpcaoReferencia.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoReferencia getCorrenteOpcaoReferencia() {
		return correnteOpcaoReferencia;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia.setIdOpcaoSisacaoRa(itemDetalhe.getIdOpcaoSisacao());
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		
		listaOpcaoReferencia.add(correnteOpcaoReferencia);
	}
	@Deprecated
	public void criaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia = FabricaVo.criaOpcaoReferencia();
	}
 		
	
	public OpcaoSisacaoDadosParseBase() {
		super();
		lista = new ArrayList<OpcaoSisacao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OpcaoSisacao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OpcaoSisacao item) {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OpcaoSisacao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOpcaoSisacao();
	}


	public void setItemDetalhe(OpcaoSisacao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OpcaoSisacaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OpcaoSisacaoDadosParse";
 	}

	
	private OpcaoSisacaoSerie _opcaoSisacaoSerie_PertenceA; 
	
	@Deprecated
	public void setOpcaoSisacaoSerie_PertenceA(OpcaoSisacaoSerie item) {
		_opcaoSisacaoSerie_PertenceA = item;
	}
	@Deprecated
	public OpcaoSisacaoSerie getOpcaoSisacaoSerie_PertenceA() {
		return _opcaoSisacaoSerie_PertenceA;
	}
 	
	private Ticker _ticker_DerivativoDe; 
	
	@Deprecated
	public void setTicker_DerivativoDe(Ticker item) {
		_ticker_DerivativoDe = item;
	}
	@Deprecated
	public Ticker getTicker_DerivativoDe() {
		return _ticker_DerivativoDe;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoDao();
			dao.setConexao(getConexao());
			List<OpcaoSisacao> listaBanco = dao.ListaCorrente();
			List<OpcaoSisacao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OpcaoSisacao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OpcaoSisacao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OpcaoSisacao item = it.next();
				System.out.println("OpcaoSisacao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OpcaoSisacao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OpcaoSisacao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OpcaoSisacao item, OpcaoSisacaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OpcaoSisacao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OpcaoSisacao item) {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OpcaoSisacao> subtraiListaPorNome(List<OpcaoSisacao> listaMaior, List<OpcaoSisacao> listaMenor) {
		Iterator<OpcaoSisacao> itMaior = listaMaior.iterator();
		Iterator<OpcaoSisacao> itMenor = null;
		List<OpcaoSisacao> listaDiferenca = new ArrayList<OpcaoSisacao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OpcaoSisacao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OpcaoSisacao comparador = itMenor.next();
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
	protected boolean iguais(OpcaoSisacao item1, OpcaoSisacao item2) {
		throw new RuntimeException("Fazer override em OpcaoSisacaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OpcaoSisacao item) {
		return "Fazer override em OpcaoSisacaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaEscolhaOpcao.clear();
		listaCotacaoProcessadaOpcaoResultado.clear();
		listaOpcaoReferencia.clear();
	
	}
	
	
	public void displayLogLista(List<OpcaoSisacao> lista, String codigo) {
		for (OpcaoSisacao item : lista) {
			ArquivoLog.getInstancia().salvaLog("OpcaoSisacao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OpcaoSisacao item) {
		StringBuffer display = new StringBuffer();
		display.append("OpcaoSisacao {");
		
		display.append("IdOpcaoSisacao:" + item.getIdOpcaoSisacao() + ";");
		
		display.append("CodigoMercado:" + item.getCodigoMercado() + ";");
		
		display.append("PrecoExercicio:" + item.getPrecoExercicio() + ";");
		
		display.append("DataInicioColeta:" + item.getDataInicioColeta() + ";");
		
		display.append("IdOpcaoSisacaoSeriePa:" + item.getIdOpcaoSisacaoSeriePa() + ";");
		
		display.append("IdTickerDd:" + item.getIdTickerDd() + ";");
		
		
		
		if (item.getOpcaoSisacaoSeriePertenceA(false)!=null) {
			display.append("OpcaoSisacaoSerie{");
			display.append(OpcaoSisacaoSerieDadosParse.displayLog(item.getOpcaoSisacaoSeriePertenceA(false)));
			display.append("}");
		}
 		
		if (item.getTickerDerivativoDe(false)!=null) {
			display.append("Ticker{");
			display.append(TickerDadosParse.displayLog(item.getTickerDerivativoDe(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
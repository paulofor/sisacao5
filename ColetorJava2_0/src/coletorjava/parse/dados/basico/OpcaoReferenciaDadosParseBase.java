package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.OpcaoReferenciaDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OpcaoReferenciaDadosParseBase extends DadosParseDao {

	protected OpcaoReferenciaDao dao = null;
	protected OpcaoReferencia itemDetalhe = null;
	protected List<OpcaoReferencia> lista = null;
	
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
	// do Objeto OpcaoReferencia
	// Para listas usar itemCorrente.
	public OpcaoReferencia getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OpcaoReferencia itemCorrente = null;
	
	
	public OpcaoReferenciaDadosParseBase() {
		super();
		lista = new ArrayList<OpcaoReferencia>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OpcaoReferencia getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OpcaoReferencia item) {
		ArquivoLog.getInstancia().salvaLog("OpcaoReferencia(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OpcaoReferencia item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OpcaoReferencia(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOpcaoReferencia();
	}


	public void setItemDetalhe(OpcaoReferencia item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OpcaoReferenciaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OpcaoReferenciaDadosParse";
 	}

	
	private Ticker _ticker_ReferenteA; 
	
	@Deprecated
	public void setTicker_ReferenteA(Ticker item) {
		_ticker_ReferenteA = item;
	}
	@Deprecated
	public Ticker getTicker_ReferenteA() {
		return _ticker_ReferenteA;
	}
 	
	private DiaPregao _diaPregao_ReferenteA; 
	
	@Deprecated
	public void setDiaPregao_ReferenteA(DiaPregao item) {
		_diaPregao_ReferenteA = item;
	}
	@Deprecated
	public DiaPregao getDiaPregao_ReferenteA() {
		return _diaPregao_ReferenteA;
	}
 	
	private OpcaoSisacao _opcaoSisacao_ReferenteA; 
	
	@Deprecated
	public void setOpcaoSisacao_ReferenteA(OpcaoSisacao item) {
		_opcaoSisacao_ReferenteA = item;
	}
	@Deprecated
	public OpcaoSisacao getOpcaoSisacao_ReferenteA() {
		return _opcaoSisacao_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getOpcaoReferenciaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOpcaoReferenciaDao();
			dao.setConexao(getConexao());
			List<OpcaoReferencia> listaBanco = dao.ListaCorrente();
			List<OpcaoReferencia> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OpcaoReferencia> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OpcaoReferencia> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OpcaoReferencia item = it.next();
				System.out.println("OpcaoReferencia Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OpcaoReferencia> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OpcaoReferencia item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OpcaoReferencia item, OpcaoReferenciaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OpcaoReferencia item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OpcaoReferencia item) {
		try {
			dao = DBB.getInstancia().getOpcaoReferenciaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OpcaoReferencia> subtraiListaPorNome(List<OpcaoReferencia> listaMaior, List<OpcaoReferencia> listaMenor) {
		Iterator<OpcaoReferencia> itMaior = listaMaior.iterator();
		Iterator<OpcaoReferencia> itMenor = null;
		List<OpcaoReferencia> listaDiferenca = new ArrayList<OpcaoReferencia>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OpcaoReferencia corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OpcaoReferencia comparador = itMenor.next();
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
	protected boolean iguais(OpcaoReferencia item1, OpcaoReferencia item2) {
		throw new RuntimeException("Fazer override em OpcaoReferenciaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OpcaoReferencia item) {
		return "Fazer override em OpcaoReferenciaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<OpcaoReferencia> lista, String codigo) {
		for (OpcaoReferencia item : lista) {
			ArquivoLog.getInstancia().salvaLog("OpcaoReferencia(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OpcaoReferencia item) {
		StringBuffer display = new StringBuffer();
		display.append("OpcaoReferencia {");
		
		display.append("IdOpcaoReferencia:" + item.getIdOpcaoReferencia() + ";");
		
		display.append("CodigoMercado:" + item.getCodigoMercado() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("IdTickerRa:" + item.getIdTickerRa() + ";");
		
		display.append("IdDiaPregaoRa:" + item.getIdDiaPregaoRa() + ";");
		
		display.append("IdOpcaoSisacaoRa:" + item.getIdOpcaoSisacaoRa() + ";");
		
		
		
		if (item.getTickerReferenteA(false)!=null) {
			display.append("Ticker{");
			display.append(TickerDadosParse.displayLog(item.getTickerReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getDiaPregaoReferenteA(false)!=null) {
			display.append("DiaPregao{");
			display.append(DiaPregaoDadosParse.displayLog(item.getDiaPregaoReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getOpcaoSisacaoReferenteA(false)!=null) {
			display.append("OpcaoSisacao{");
			display.append(OpcaoSisacaoDadosParse.displayLog(item.getOpcaoSisacaoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
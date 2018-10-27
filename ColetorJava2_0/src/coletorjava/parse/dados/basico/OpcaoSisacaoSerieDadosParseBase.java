package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.OpcaoSisacaoSerieDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OpcaoSisacaoSerieDadosParseBase extends DadosParseDao {

	protected OpcaoSisacaoSerieDao dao = null;
	protected OpcaoSisacaoSerie itemDetalhe = null;
	protected List<OpcaoSisacaoSerie> lista = null;
	
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
	// do Objeto OpcaoSisacaoSerie
	// Para listas usar itemCorrente.
	public OpcaoSisacaoSerie getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OpcaoSisacaoSerie itemCorrente = null;
	
	//Possui 
	private	OpcaoSisacao correnteOpcaoSisacao;
	protected List<OpcaoSisacao> listaOpcaoSisacao = new ArrayList<OpcaoSisacao>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoSisacao(OpcaoSisacao itemLista) {
		itemLista.setIdOpcaoSisacaoSeriePa(itemDetalhe.getIdOpcaoSisacaoSerie());
		//ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoSerie(adicionaCorrenteOpcaoSisacao):" + OpcaoSisacaoDadosParseBase.displayLog(correnteOpcaoSisacao));
		listaOpcaoSisacao.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoSisacao getCorrenteOpcaoSisacao() {
		return correnteOpcaoSisacao;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoSisacao() {
		correnteOpcaoSisacao.setIdOpcaoSisacaoSeriePa(itemDetalhe.getIdOpcaoSisacaoSerie());
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoSerie(adicionaCorrenteOpcaoSisacao):" + OpcaoSisacaoDadosParseBase.displayLog(correnteOpcaoSisacao));
		
		listaOpcaoSisacao.add(correnteOpcaoSisacao);
	}
	@Deprecated
	public void criaCorrenteOpcaoSisacao() {
		correnteOpcaoSisacao = FabricaVo.criaOpcaoSisacao();
	}
 		
	
	public OpcaoSisacaoSerieDadosParseBase() {
		super();
		lista = new ArrayList<OpcaoSisacaoSerie>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OpcaoSisacaoSerie getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OpcaoSisacaoSerie item) {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoSerie(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OpcaoSisacaoSerie item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoSerie(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOpcaoSisacaoSerie();
	}


	public void setItemDetalhe(OpcaoSisacaoSerie item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OpcaoSisacaoSerieDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OpcaoSisacaoSerieDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoSerieDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoSerieDao();
			dao.setConexao(getConexao());
			List<OpcaoSisacaoSerie> listaBanco = dao.ListaCorrente();
			List<OpcaoSisacaoSerie> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OpcaoSisacaoSerie> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OpcaoSisacaoSerie> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OpcaoSisacaoSerie item = it.next();
				System.out.println("OpcaoSisacaoSerie Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OpcaoSisacaoSerie> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OpcaoSisacaoSerie item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OpcaoSisacaoSerie item, OpcaoSisacaoSerieDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OpcaoSisacaoSerie item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OpcaoSisacaoSerie item) {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoSerieDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OpcaoSisacaoSerie> subtraiListaPorNome(List<OpcaoSisacaoSerie> listaMaior, List<OpcaoSisacaoSerie> listaMenor) {
		Iterator<OpcaoSisacaoSerie> itMaior = listaMaior.iterator();
		Iterator<OpcaoSisacaoSerie> itMenor = null;
		List<OpcaoSisacaoSerie> listaDiferenca = new ArrayList<OpcaoSisacaoSerie>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OpcaoSisacaoSerie corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OpcaoSisacaoSerie comparador = itMenor.next();
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
	protected boolean iguais(OpcaoSisacaoSerie item1, OpcaoSisacaoSerie item2) {
		throw new RuntimeException("Fazer override em OpcaoSisacaoSerieDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OpcaoSisacaoSerie item) {
		return "Fazer override em OpcaoSisacaoSerieDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaOpcaoSisacao.clear();
	
	}
	
	
	public void displayLogLista(List<OpcaoSisacaoSerie> lista, String codigo) {
		for (OpcaoSisacaoSerie item : lista) {
			ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoSerie(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OpcaoSisacaoSerie item) {
		StringBuffer display = new StringBuffer();
		display.append("OpcaoSisacaoSerie {");
		
		display.append("IdOpcaoSisacaoSerie:" + item.getIdOpcaoSisacaoSerie() + ";");
		
		display.append("MesAno:" + item.getMesAno() + ";");
		
		display.append("Letra:" + item.getLetra() + ";");
		
		display.append("DataVencimento:" + item.getDataVencimento() + ";");
		
		display.append("DataInicioColeta:" + item.getDataInicioColeta() + ";");
		
		display.append("Construida:" + item.getConstruida() + ";");
		
		display.append("PossuiIntraday:" + item.getPossuiIntraday() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
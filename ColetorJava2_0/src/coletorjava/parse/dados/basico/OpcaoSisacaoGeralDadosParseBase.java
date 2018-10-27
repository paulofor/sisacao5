package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.OpcaoSisacaoGeralDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class OpcaoSisacaoGeralDadosParseBase extends DadosParseDao {

	protected OpcaoSisacaoGeralDao dao = null;
	protected OpcaoSisacaoGeral itemDetalhe = null;
	protected List<OpcaoSisacaoGeral> lista = null;
	
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
	// do Objeto OpcaoSisacaoGeral
	// Para listas usar itemCorrente.
	public OpcaoSisacaoGeral getItemDetalhe() {
		return itemDetalhe;
	}
	
	private OpcaoSisacaoGeral itemCorrente = null;
	
	
	public OpcaoSisacaoGeralDadosParseBase() {
		super();
		lista = new ArrayList<OpcaoSisacaoGeral>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public OpcaoSisacaoGeral getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(OpcaoSisacaoGeral item) {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoGeral(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(OpcaoSisacaoGeral item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoGeral(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaOpcaoSisacaoGeral();
	}


	public void setItemDetalhe(OpcaoSisacaoGeral item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em OpcaoSisacaoGeralDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em OpcaoSisacaoGeralDadosParse";
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
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoGeralDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoGeralDao();
			dao.setConexao(getConexao());
			List<OpcaoSisacaoGeral> listaBanco = dao.ListaCorrente();
			List<OpcaoSisacaoGeral> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<OpcaoSisacaoGeral> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<OpcaoSisacaoGeral> it = listaInclusao.iterator();
			while (it.hasNext()) {
				OpcaoSisacaoGeral item = it.next();
				System.out.println("OpcaoSisacaoGeral Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<OpcaoSisacaoGeral> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				OpcaoSisacaoGeral item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(OpcaoSisacaoGeral item, OpcaoSisacaoGeralDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(OpcaoSisacaoGeral item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(OpcaoSisacaoGeral item) {
		try {
			dao = DBB.getInstancia().getOpcaoSisacaoGeralDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<OpcaoSisacaoGeral> subtraiListaPorNome(List<OpcaoSisacaoGeral> listaMaior, List<OpcaoSisacaoGeral> listaMenor) {
		Iterator<OpcaoSisacaoGeral> itMaior = listaMaior.iterator();
		Iterator<OpcaoSisacaoGeral> itMenor = null;
		List<OpcaoSisacaoGeral> listaDiferenca = new ArrayList<OpcaoSisacaoGeral>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			OpcaoSisacaoGeral corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				OpcaoSisacaoGeral comparador = itMenor.next();
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
	protected boolean iguais(OpcaoSisacaoGeral item1, OpcaoSisacaoGeral item2) {
		throw new RuntimeException("Fazer override em OpcaoSisacaoGeralDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(OpcaoSisacaoGeral item) {
		return "Fazer override em OpcaoSisacaoGeralDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<OpcaoSisacaoGeral> lista, String codigo) {
		for (OpcaoSisacaoGeral item : lista) {
			ArquivoLog.getInstancia().salvaLog("OpcaoSisacaoGeral(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(OpcaoSisacaoGeral item) {
		StringBuffer display = new StringBuffer();
		display.append("OpcaoSisacaoGeral {");
		
		display.append("IdOpcaoSisacaoGeral:" + item.getIdOpcaoSisacaoGeral() + ";");
		
		display.append("CodigoMercado:" + item.getCodigoMercado() + ";");
		
		display.append("PrecoExercicio:" + item.getPrecoExercicio() + ";");
		
		display.append("DataInclusao:" + item.getDataInclusao() + ";");
		
		display.append("MesAno:" + item.getMesAno() + ";");
		
		display.append("DescricaoBdi:" + item.getDescricaoBdi() + ";");
		
		display.append("ColetaDiario:" + item.getColetaDiario() + ";");
		
		display.append("PossuiColetaIntraday:" + item.getPossuiColetaIntraday() + ";");
		
		display.append("Possui15minutos:" + item.getPossui15minutos() + ";");
		
		display.append("IdTickerRa:" + item.getIdTickerRa() + ";");
		
		
		
		if (item.getTickerReferenteA(false)!=null) {
			display.append("Ticker{");
			display.append(TickerDadosParse.displayLog(item.getTickerReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
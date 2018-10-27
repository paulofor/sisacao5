package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.RegraEntradaDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class RegraEntradaDadosParseBase extends DadosParseDao {

	protected RegraEntradaDao dao = null;
	protected RegraEntrada itemDetalhe = null;
	protected List<RegraEntrada> lista = null;
	
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
	// do Objeto RegraEntrada
	// Para listas usar itemCorrente.
	public RegraEntrada getItemDetalhe() {
		return itemDetalhe;
	}
	
	private RegraEntrada itemCorrente = null;
	
	
	public RegraEntradaDadosParseBase() {
		super();
		lista = new ArrayList<RegraEntrada>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public RegraEntrada getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(RegraEntrada item) {
		ArquivoLog.getInstancia().salvaLog("RegraEntrada(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(RegraEntrada item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("RegraEntrada(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaRegraEntrada();
	}


	public void setItemDetalhe(RegraEntrada item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em RegraEntradaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em RegraEntradaDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getRegraEntradaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getRegraEntradaDao();
			dao.setConexao(getConexao());
			List<RegraEntrada> listaBanco = dao.ListaCorrente();
			List<RegraEntrada> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<RegraEntrada> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<RegraEntrada> it = listaInclusao.iterator();
			while (it.hasNext()) {
				RegraEntrada item = it.next();
				System.out.println("RegraEntrada Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<RegraEntrada> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				RegraEntrada item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(RegraEntrada item, RegraEntradaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(RegraEntrada item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(RegraEntrada item) {
		try {
			dao = DBB.getInstancia().getRegraEntradaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<RegraEntrada> subtraiListaPorNome(List<RegraEntrada> listaMaior, List<RegraEntrada> listaMenor) {
		Iterator<RegraEntrada> itMaior = listaMaior.iterator();
		Iterator<RegraEntrada> itMenor = null;
		List<RegraEntrada> listaDiferenca = new ArrayList<RegraEntrada>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			RegraEntrada corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				RegraEntrada comparador = itMenor.next();
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
	protected boolean iguais(RegraEntrada item1, RegraEntrada item2) {
		throw new RuntimeException("Fazer override em RegraEntradaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(RegraEntrada item) {
		return "Fazer override em RegraEntradaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<RegraEntrada> lista, String codigo) {
		for (RegraEntrada item : lista) {
			ArquivoLog.getInstancia().salvaLog("RegraEntrada(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(RegraEntrada item) {
		StringBuffer display = new StringBuffer();
		display.append("RegraEntrada {");
		
		display.append("IdRegraEntrada:" + item.getIdRegraEntrada() + ";");
		
		display.append("NomeRegra:" + item.getNomeRegra() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
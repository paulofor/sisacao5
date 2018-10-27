package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.CotacaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CotacaoDadosParseBase extends DadosParseDao {

	protected CotacaoDao dao = null;
	protected Cotacao itemDetalhe = null;
	protected List<Cotacao> lista = null;
	
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
	// do Objeto Cotacao
	// Para listas usar itemCorrente.
	public Cotacao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Cotacao itemCorrente = null;
	
	
	public CotacaoDadosParseBase() {
		super();
		lista = new ArrayList<Cotacao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Cotacao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Cotacao item) {
		ArquivoLog.getInstancia().salvaLog("Cotacao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Cotacao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Cotacao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCotacao();
	}


	public void setItemDetalhe(Cotacao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CotacaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CotacaoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCotacaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCotacaoDao();
			dao.setConexao(getConexao());
			List<Cotacao> listaBanco = dao.ListaCorrente();
			List<Cotacao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Cotacao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Cotacao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Cotacao item = it.next();
				System.out.println("Cotacao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Cotacao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Cotacao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Cotacao item, CotacaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Cotacao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Cotacao item) {
		try {
			dao = DBB.getInstancia().getCotacaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cotacao> subtraiListaPorNome(List<Cotacao> listaMaior, List<Cotacao> listaMenor) {
		Iterator<Cotacao> itMaior = listaMaior.iterator();
		Iterator<Cotacao> itMenor = null;
		List<Cotacao> listaDiferenca = new ArrayList<Cotacao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Cotacao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Cotacao comparador = itMenor.next();
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
	protected boolean iguais(Cotacao item1, Cotacao item2) {
		throw new RuntimeException("Fazer override em CotacaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Cotacao item) {
		return "Fazer override em CotacaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<Cotacao> lista, String codigo) {
		for (Cotacao item : lista) {
			ArquivoLog.getInstancia().salvaLog("Cotacao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Cotacao item) {
		StringBuffer display = new StringBuffer();
		display.append("Cotacao {");
		
		display.append("Id:" + item.getId() + ";");
		
		display.append("Neg:" + item.getNeg() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Ult:" + item.getUlt() + ";");
		
		display.append("HoraReal:" + item.getHoraReal() + ";");
		
		display.append("HoraNeg:" + item.getHoraNeg() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
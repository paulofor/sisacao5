package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.RedeDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class RedeDadosParseBase extends DadosParseDao {

	protected RedeDao dao = null;
	protected Rede itemDetalhe = null;
	protected List<Rede> lista = null;
	
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
	// do Objeto Rede
	// Para listas usar itemCorrente.
	public Rede getItemDetalhe() {
		return itemDetalhe;
	}
	
	private Rede itemCorrente = null;
	
	//Gerou 
	private	TreinoRede correnteTreinoRede;
	protected List<TreinoRede> listaTreinoRede = new ArrayList<TreinoRede>();
	
	// Adicionado em 01-08-2016
	public void adicionaTreinoRede(TreinoRede itemLista) {
		itemLista.setIdRedePa(itemDetalhe.getIdRede());
		//ArquivoLog.getInstancia().salvaLog("Rede(adicionaCorrenteTreinoRede):" + TreinoRedeDadosParseBase.displayLog(correnteTreinoRede));
		listaTreinoRede.add(itemLista);
	}
	
	
	
	@Deprecated
	public TreinoRede getCorrenteTreinoRede() {
		return correnteTreinoRede;
	}
	@Deprecated
	public void adicionaCorrenteTreinoRede() {
		correnteTreinoRede.setIdRedePa(itemDetalhe.getIdRede());
		ArquivoLog.getInstancia().salvaLog("Rede(adicionaCorrenteTreinoRede):" + TreinoRedeDadosParseBase.displayLog(correnteTreinoRede));
		
		listaTreinoRede.add(correnteTreinoRede);
	}
	@Deprecated
	public void criaCorrenteTreinoRede() {
		correnteTreinoRede = FabricaVo.criaTreinoRede();
	}
 		
	
	public RedeDadosParseBase() {
		super();
		lista = new ArrayList<Rede>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public Rede getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(Rede item) {
		ArquivoLog.getInstancia().salvaLog("Rede(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(Rede item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("Rede(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaRede();
	}


	public void setItemDetalhe(Rede item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em RedeDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em RedeDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getRedeDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getRedeDao();
			dao.setConexao(getConexao());
			List<Rede> listaBanco = dao.ListaCorrente();
			List<Rede> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<Rede> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<Rede> it = listaInclusao.iterator();
			while (it.hasNext()) {
				Rede item = it.next();
				System.out.println("Rede Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<Rede> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				Rede item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(Rede item, RedeDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(Rede item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(Rede item) {
		try {
			dao = DBB.getInstancia().getRedeDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Rede> subtraiListaPorNome(List<Rede> listaMaior, List<Rede> listaMenor) {
		Iterator<Rede> itMaior = listaMaior.iterator();
		Iterator<Rede> itMenor = null;
		List<Rede> listaDiferenca = new ArrayList<Rede>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			Rede corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				Rede comparador = itMenor.next();
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
	protected boolean iguais(Rede item1, Rede item2) {
		throw new RuntimeException("Fazer override em RedeDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(Rede item) {
		return "Fazer override em RedeDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaTreinoRede.clear();
	
	}
	
	
	public void displayLogLista(List<Rede> lista, String codigo) {
		for (Rede item : lista) {
			ArquivoLog.getInstancia().salvaLog("Rede(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(Rede item) {
		StringBuffer display = new StringBuffer();
		display.append("Rede {");
		
		display.append("IdRede:" + item.getIdRede() + ";");
		
		display.append("QtdeHidden1:" + item.getQtdeHidden1() + ";");
		
		display.append("QtdeHidden2:" + item.getQtdeHidden2() + ";");
		
		display.append("QtdeHidden3:" + item.getQtdeHidden3() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
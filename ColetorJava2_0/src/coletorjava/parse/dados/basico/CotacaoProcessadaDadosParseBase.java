package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.CotacaoProcessadaDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CotacaoProcessadaDadosParseBase extends DadosParseDao {

	protected CotacaoProcessadaDao dao = null;
	protected CotacaoProcessada itemDetalhe = null;
	protected List<CotacaoProcessada> lista = null;
	
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
	// do Objeto CotacaoProcessada
	// Para listas usar itemCorrente.
	public CotacaoProcessada getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CotacaoProcessada itemCorrente = null;
	
	
	public CotacaoProcessadaDadosParseBase() {
		super();
		lista = new ArrayList<CotacaoProcessada>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CotacaoProcessada getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CotacaoProcessada item) {
		ArquivoLog.getInstancia().salvaLog("CotacaoProcessada(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CotacaoProcessada item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CotacaoProcessada(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCotacaoProcessada();
	}


	public void setItemDetalhe(CotacaoProcessada item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CotacaoProcessadaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CotacaoProcessadaDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaDao();
			dao.setConexao(getConexao());
			List<CotacaoProcessada> listaBanco = dao.ListaCorrente();
			List<CotacaoProcessada> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CotacaoProcessada> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CotacaoProcessada> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CotacaoProcessada item = it.next();
				System.out.println("CotacaoProcessada Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CotacaoProcessada> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CotacaoProcessada item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CotacaoProcessada item, CotacaoProcessadaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CotacaoProcessada item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CotacaoProcessada item) {
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CotacaoProcessada> subtraiListaPorNome(List<CotacaoProcessada> listaMaior, List<CotacaoProcessada> listaMenor) {
		Iterator<CotacaoProcessada> itMaior = listaMaior.iterator();
		Iterator<CotacaoProcessada> itMenor = null;
		List<CotacaoProcessada> listaDiferenca = new ArrayList<CotacaoProcessada>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CotacaoProcessada corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CotacaoProcessada comparador = itMenor.next();
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
	protected boolean iguais(CotacaoProcessada item1, CotacaoProcessada item2) {
		throw new RuntimeException("Fazer override em CotacaoProcessadaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CotacaoProcessada item) {
		return "Fazer override em CotacaoProcessadaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CotacaoProcessada> lista, String codigo) {
		for (CotacaoProcessada item : lista) {
			ArquivoLog.getInstancia().salvaLog("CotacaoProcessada(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CotacaoProcessada item) {
		StringBuffer display = new StringBuffer();
		display.append("CotacaoProcessada {");
		
		display.append("IdCotacaoProcessada:" + item.getIdCotacaoProcessada() + ";");
		
		display.append("HoraCotacaoTempoReal:" + item.getHoraCotacaoTempoReal() + ";");
		
		display.append("ValorTempoReal:" + item.getValorTempoReal() + ";");
		
		display.append("ValorCorrigido:" + item.getValorCorrigido() + ";");
		
		display.append("ContadorDia:" + item.getContadorDia() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("HoraSerieTemporal:" + item.getHoraSerieTemporal() + ";");
		
		display.append("HoraCotacao:" + item.getHoraCotacao() + ";");
		
		display.append("Negocios:" + item.getNegocios() + ";");
		
		display.append("Valor:" + item.getValor() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
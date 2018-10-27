package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.CotacaoDiarioDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CotacaoDiarioDadosParseBase extends DadosParseDao {

	protected CotacaoDiarioDao dao = null;
	protected CotacaoDiario itemDetalhe = null;
	protected List<CotacaoDiario> lista = null;
	
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
	// do Objeto CotacaoDiario
	// Para listas usar itemCorrente.
	public CotacaoDiario getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CotacaoDiario itemCorrente = null;
	
	
	public CotacaoDiarioDadosParseBase() {
		super();
		lista = new ArrayList<CotacaoDiario>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CotacaoDiario getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CotacaoDiario item) {
		ArquivoLog.getInstancia().salvaLog("CotacaoDiario(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CotacaoDiario item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CotacaoDiario(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCotacaoDiario();
	}


	public void setItemDetalhe(CotacaoDiario item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CotacaoDiarioDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CotacaoDiarioDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCotacaoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCotacaoDiarioDao();
			dao.setConexao(getConexao());
			List<CotacaoDiario> listaBanco = dao.ListaCorrente();
			List<CotacaoDiario> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CotacaoDiario> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CotacaoDiario> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CotacaoDiario item = it.next();
				System.out.println("CotacaoDiario Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CotacaoDiario> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CotacaoDiario item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CotacaoDiario item, CotacaoDiarioDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CotacaoDiario item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CotacaoDiario item) {
		try {
			dao = DBB.getInstancia().getCotacaoDiarioDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CotacaoDiario> subtraiListaPorNome(List<CotacaoDiario> listaMaior, List<CotacaoDiario> listaMenor) {
		Iterator<CotacaoDiario> itMaior = listaMaior.iterator();
		Iterator<CotacaoDiario> itMenor = null;
		List<CotacaoDiario> listaDiferenca = new ArrayList<CotacaoDiario>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CotacaoDiario corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CotacaoDiario comparador = itMenor.next();
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
	protected boolean iguais(CotacaoDiario item1, CotacaoDiario item2) {
		throw new RuntimeException("Fazer override em CotacaoDiarioDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CotacaoDiario item) {
		return "Fazer override em CotacaoDiarioDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CotacaoDiario> lista, String codigo) {
		for (CotacaoDiario item : lista) {
			ArquivoLog.getInstancia().salvaLog("CotacaoDiario(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CotacaoDiario item) {
		StringBuffer display = new StringBuffer();
		display.append("CotacaoDiario {");
		
		display.append("IdCotacaoDiario:" + item.getIdCotacaoDiario() + ";");
		
		display.append("MinimoCorrigido:" + item.getMinimoCorrigido() + ";");
		
		display.append("MaximoCorrigido:" + item.getMaximoCorrigido() + ";");
		
		display.append("AberturaCorrigido:" + item.getAberturaCorrigido() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Volume:" + item.getVolume() + ";");
		
		display.append("Negocios:" + item.getNegocios() + ";");
		
		display.append("FechamentoOriginal:" + item.getFechamentoOriginal() + ";");
		
		display.append("MinimoOriginal:" + item.getMinimoOriginal() + ";");
		
		display.append("MaximoOriginal:" + item.getMaximoOriginal() + ";");
		
		display.append("AberturaOriginal:" + item.getAberturaOriginal() + ";");
		
		display.append("FechamentoCorrigido:" + item.getFechamentoCorrigido() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
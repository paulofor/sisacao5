package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.ExperimentoOpcaoCurtoPrazoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ExperimentoOpcaoCurtoPrazoDadosParseBase extends DadosParseDao {

	protected ExperimentoOpcaoCurtoPrazoDao dao = null;
	protected ExperimentoOpcaoCurtoPrazo itemDetalhe = null;
	protected List<ExperimentoOpcaoCurtoPrazo> lista = null;
	
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
	// do Objeto ExperimentoOpcaoCurtoPrazo
	// Para listas usar itemCorrente.
	public ExperimentoOpcaoCurtoPrazo getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ExperimentoOpcaoCurtoPrazo itemCorrente = null;
	
	
	public ExperimentoOpcaoCurtoPrazoDadosParseBase() {
		super();
		lista = new ArrayList<ExperimentoOpcaoCurtoPrazo>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ExperimentoOpcaoCurtoPrazo getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ExperimentoOpcaoCurtoPrazo item) {
		ArquivoLog.getInstancia().salvaLog("ExperimentoOpcaoCurtoPrazo(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ExperimentoOpcaoCurtoPrazo item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ExperimentoOpcaoCurtoPrazo(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaExperimentoOpcaoCurtoPrazo();
	}


	public void setItemDetalhe(ExperimentoOpcaoCurtoPrazo item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ExperimentoOpcaoCurtoPrazoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ExperimentoOpcaoCurtoPrazoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao();
			dao.setConexao(getConexao());
			List<ExperimentoOpcaoCurtoPrazo> listaBanco = dao.ListaCorrente();
			List<ExperimentoOpcaoCurtoPrazo> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ExperimentoOpcaoCurtoPrazo> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ExperimentoOpcaoCurtoPrazo> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ExperimentoOpcaoCurtoPrazo item = it.next();
				System.out.println("ExperimentoOpcaoCurtoPrazo Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ExperimentoOpcaoCurtoPrazo> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ExperimentoOpcaoCurtoPrazo item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ExperimentoOpcaoCurtoPrazo item, ExperimentoOpcaoCurtoPrazoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ExperimentoOpcaoCurtoPrazo item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ExperimentoOpcaoCurtoPrazo item) {
		try {
			dao = DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ExperimentoOpcaoCurtoPrazo> subtraiListaPorNome(List<ExperimentoOpcaoCurtoPrazo> listaMaior, List<ExperimentoOpcaoCurtoPrazo> listaMenor) {
		Iterator<ExperimentoOpcaoCurtoPrazo> itMaior = listaMaior.iterator();
		Iterator<ExperimentoOpcaoCurtoPrazo> itMenor = null;
		List<ExperimentoOpcaoCurtoPrazo> listaDiferenca = new ArrayList<ExperimentoOpcaoCurtoPrazo>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ExperimentoOpcaoCurtoPrazo corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ExperimentoOpcaoCurtoPrazo comparador = itMenor.next();
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
	protected boolean iguais(ExperimentoOpcaoCurtoPrazo item1, ExperimentoOpcaoCurtoPrazo item2) {
		throw new RuntimeException("Fazer override em ExperimentoOpcaoCurtoPrazoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ExperimentoOpcaoCurtoPrazo item) {
		return "Fazer override em ExperimentoOpcaoCurtoPrazoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<ExperimentoOpcaoCurtoPrazo> lista, String codigo) {
		for (ExperimentoOpcaoCurtoPrazo item : lista) {
			ArquivoLog.getInstancia().salvaLog("ExperimentoOpcaoCurtoPrazo(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ExperimentoOpcaoCurtoPrazo item) {
		StringBuffer display = new StringBuffer();
		display.append("ExperimentoOpcaoCurtoPrazo {");
		
		display.append("IdExperimentoOpcaoCurtoPrazo:" + item.getIdExperimentoOpcaoCurtoPrazo() + ";");
		
		display.append("DescricaoExperimento:" + item.getDescricaoExperimento() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.PeriodoPregaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class PeriodoPregaoDadosParseBase extends DadosParseDao {

	protected PeriodoPregaoDao dao = null;
	protected PeriodoPregao itemDetalhe = null;
	protected List<PeriodoPregao> lista = null;
	
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
	// do Objeto PeriodoPregao
	// Para listas usar itemCorrente.
	public PeriodoPregao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private PeriodoPregao itemCorrente = null;
	
	
	public PeriodoPregaoDadosParseBase() {
		super();
		lista = new ArrayList<PeriodoPregao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public PeriodoPregao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(PeriodoPregao item) {
		ArquivoLog.getInstancia().salvaLog("PeriodoPregao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(PeriodoPregao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("PeriodoPregao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaPeriodoPregao();
	}


	public void setItemDetalhe(PeriodoPregao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em PeriodoPregaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em PeriodoPregaoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getPeriodoPregaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getPeriodoPregaoDao();
			dao.setConexao(getConexao());
			List<PeriodoPregao> listaBanco = dao.ListaCorrente();
			List<PeriodoPregao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<PeriodoPregao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<PeriodoPregao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				PeriodoPregao item = it.next();
				System.out.println("PeriodoPregao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<PeriodoPregao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				PeriodoPregao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(PeriodoPregao item, PeriodoPregaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(PeriodoPregao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(PeriodoPregao item) {
		try {
			dao = DBB.getInstancia().getPeriodoPregaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<PeriodoPregao> subtraiListaPorNome(List<PeriodoPregao> listaMaior, List<PeriodoPregao> listaMenor) {
		Iterator<PeriodoPregao> itMaior = listaMaior.iterator();
		Iterator<PeriodoPregao> itMenor = null;
		List<PeriodoPregao> listaDiferenca = new ArrayList<PeriodoPregao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			PeriodoPregao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				PeriodoPregao comparador = itMenor.next();
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
	protected boolean iguais(PeriodoPregao item1, PeriodoPregao item2) {
		throw new RuntimeException("Fazer override em PeriodoPregaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(PeriodoPregao item) {
		return "Fazer override em PeriodoPregaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<PeriodoPregao> lista, String codigo) {
		for (PeriodoPregao item : lista) {
			ArquivoLog.getInstancia().salvaLog("PeriodoPregao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(PeriodoPregao item) {
		StringBuffer display = new StringBuffer();
		display.append("PeriodoPregao {");
		
		display.append("IdPeriodoPregao:" + item.getIdPeriodoPregao() + ";");
		
		display.append("HoraInicio:" + item.getHoraInicio() + ";");
		
		display.append("HoraTermino:" + item.getHoraTermino() + ";");
		
		display.append("DataInicioPeriodo:" + item.getDataInicioPeriodo() + ";");
		
		display.append("DataTerminoPeriodo:" + item.getDataTerminoPeriodo() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
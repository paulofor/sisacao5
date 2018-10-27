package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.MesAnoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class MesAnoDadosParseBase extends DadosParseDao {

	protected MesAnoDao dao = null;
	protected MesAno itemDetalhe = null;
	protected List<MesAno> lista = null;
	
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
	// do Objeto MesAno
	// Para listas usar itemCorrente.
	public MesAno getItemDetalhe() {
		return itemDetalhe;
	}
	
	private MesAno itemCorrente = null;
	
	//Gera 
	private	ResultadoPrevisao correnteResultadoPrevisao;
	protected List<ResultadoPrevisao> listaResultadoPrevisao = new ArrayList<ResultadoPrevisao>();
	
	// Adicionado em 01-08-2016
	public void adicionaResultadoPrevisao(ResultadoPrevisao itemLista) {
		itemLista.setIdMesAnoRa(itemDetalhe.getIdMesAno());
		//ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		listaResultadoPrevisao.add(itemLista);
	}
	
	
	
	@Deprecated
	public ResultadoPrevisao getCorrenteResultadoPrevisao() {
		return correnteResultadoPrevisao;
	}
	@Deprecated
	public void adicionaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao.setIdMesAnoRa(itemDetalhe.getIdMesAno());
		ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		
		listaResultadoPrevisao.add(correnteResultadoPrevisao);
	}
	@Deprecated
	public void criaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao = FabricaVo.criaResultadoPrevisao();
	}
 		
	//BasePara 
	private	ResultadoMes correnteResultadoMes;
	protected List<ResultadoMes> listaResultadoMes = new ArrayList<ResultadoMes>();
	
	// Adicionado em 01-08-2016
	public void adicionaResultadoMes(ResultadoMes itemLista) {
		itemLista.setIdMesAnoRa(itemDetalhe.getIdMesAno());
		//ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrenteResultadoMes):" + ResultadoMesDadosParseBase.displayLog(correnteResultadoMes));
		listaResultadoMes.add(itemLista);
	}
	
	
	
	@Deprecated
	public ResultadoMes getCorrenteResultadoMes() {
		return correnteResultadoMes;
	}
	@Deprecated
	public void adicionaCorrenteResultadoMes() {
		correnteResultadoMes.setIdMesAnoRa(itemDetalhe.getIdMesAno());
		ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrenteResultadoMes):" + ResultadoMesDadosParseBase.displayLog(correnteResultadoMes));
		
		listaResultadoMes.add(correnteResultadoMes);
	}
	@Deprecated
	public void criaCorrenteResultadoMes() {
		correnteResultadoMes = FabricaVo.criaResultadoMes();
	}
 		
	
	public MesAnoDadosParseBase() {
		super();
		lista = new ArrayList<MesAno>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public MesAno getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(MesAno item) {
		ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(MesAno item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("MesAno(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaMesAno();
	}


	public void setItemDetalhe(MesAno item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em MesAnoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em MesAnoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getMesAnoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getMesAnoDao();
			dao.setConexao(getConexao());
			List<MesAno> listaBanco = dao.ListaCorrente();
			List<MesAno> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<MesAno> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<MesAno> it = listaInclusao.iterator();
			while (it.hasNext()) {
				MesAno item = it.next();
				System.out.println("MesAno Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<MesAno> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				MesAno item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(MesAno item, MesAnoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(MesAno item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(MesAno item) {
		try {
			dao = DBB.getInstancia().getMesAnoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<MesAno> subtraiListaPorNome(List<MesAno> listaMaior, List<MesAno> listaMenor) {
		Iterator<MesAno> itMaior = listaMaior.iterator();
		Iterator<MesAno> itMenor = null;
		List<MesAno> listaDiferenca = new ArrayList<MesAno>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			MesAno corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				MesAno comparador = itMenor.next();
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
	protected boolean iguais(MesAno item1, MesAno item2) {
		throw new RuntimeException("Fazer override em MesAnoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(MesAno item) {
		return "Fazer override em MesAnoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaResultadoPrevisao.clear();
		listaResultadoMes.clear();
	
	}
	
	
	public void displayLogLista(List<MesAno> lista, String codigo) {
		for (MesAno item : lista) {
			ArquivoLog.getInstancia().salvaLog("MesAno(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(MesAno item) {
		StringBuffer display = new StringBuffer();
		display.append("MesAno {");
		
		display.append("IdMesAno:" + item.getIdMesAno() + ";");
		
		display.append("NomeMes:" + item.getNomeMes() + ";");
		
		display.append("NumeroAno:" + item.getNumeroAno() + ";");
		
		display.append("MesAnoData:" + item.getMesAnoData() + ";");
		
		display.append("NumeroMes:" + item.getNumeroMes() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
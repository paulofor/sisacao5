package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.ProjetoDadoTreinoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ProjetoDadoTreinoDadosParseBase extends DadosParseDao {

	protected ProjetoDadoTreinoDao dao = null;
	protected ProjetoDadoTreino itemDetalhe = null;
	protected List<ProjetoDadoTreino> lista = null;
	
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
	// do Objeto ProjetoDadoTreino
	// Para listas usar itemCorrente.
	public ProjetoDadoTreino getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ProjetoDadoTreino itemCorrente = null;
	
	//Gerou 
	private	DadoTreino correnteDadoTreino;
	protected List<DadoTreino> listaDadoTreino = new ArrayList<DadoTreino>();
	
	// Adicionado em 01-08-2016
	public void adicionaDadoTreino(DadoTreino itemLista) {
		itemLista.setIdProjetoDadoTreinoP(itemDetalhe.getIdProjetoDadoTreino());
		//ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrenteDadoTreino):" + DadoTreinoDadosParseBase.displayLog(correnteDadoTreino));
		listaDadoTreino.add(itemLista);
	}
	
	
	
	@Deprecated
	public DadoTreino getCorrenteDadoTreino() {
		return correnteDadoTreino;
	}
	@Deprecated
	public void adicionaCorrenteDadoTreino() {
		correnteDadoTreino.setIdProjetoDadoTreinoP(itemDetalhe.getIdProjetoDadoTreino());
		ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrenteDadoTreino):" + DadoTreinoDadosParseBase.displayLog(correnteDadoTreino));
		
		listaDadoTreino.add(correnteDadoTreino);
	}
	@Deprecated
	public void criaCorrenteDadoTreino() {
		correnteDadoTreino = FabricaVo.criaDadoTreino();
	}
 		
	//Gerou 
	private	ResultadoMes correnteResultadoMes;
	protected List<ResultadoMes> listaResultadoMes = new ArrayList<ResultadoMes>();
	
	// Adicionado em 01-08-2016
	public void adicionaResultadoMes(ResultadoMes itemLista) {
		itemLista.setIdProjetoDadoTreinoGp(itemDetalhe.getIdProjetoDadoTreino());
		//ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrenteResultadoMes):" + ResultadoMesDadosParseBase.displayLog(correnteResultadoMes));
		listaResultadoMes.add(itemLista);
	}
	
	
	
	@Deprecated
	public ResultadoMes getCorrenteResultadoMes() {
		return correnteResultadoMes;
	}
	@Deprecated
	public void adicionaCorrenteResultadoMes() {
		correnteResultadoMes.setIdProjetoDadoTreinoGp(itemDetalhe.getIdProjetoDadoTreino());
		ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrenteResultadoMes):" + ResultadoMesDadosParseBase.displayLog(correnteResultadoMes));
		
		listaResultadoMes.add(correnteResultadoMes);
	}
	@Deprecated
	public void criaCorrenteResultadoMes() {
		correnteResultadoMes = FabricaVo.criaResultadoMes();
	}
 		
	
	public ProjetoDadoTreinoDadosParseBase() {
		super();
		lista = new ArrayList<ProjetoDadoTreino>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ProjetoDadoTreino getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ProjetoDadoTreino item) {
		ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ProjetoDadoTreino item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaProjetoDadoTreino();
	}


	public void setItemDetalhe(ProjetoDadoTreino item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ProjetoDadoTreinoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ProjetoDadoTreinoDadosParse";
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
			dao = DBB.getInstancia().getProjetoDadoTreinoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getProjetoDadoTreinoDao();
			dao.setConexao(getConexao());
			List<ProjetoDadoTreino> listaBanco = dao.ListaCorrente();
			List<ProjetoDadoTreino> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ProjetoDadoTreino> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ProjetoDadoTreino> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ProjetoDadoTreino item = it.next();
				System.out.println("ProjetoDadoTreino Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ProjetoDadoTreino> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ProjetoDadoTreino item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ProjetoDadoTreino item, ProjetoDadoTreinoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ProjetoDadoTreino item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ProjetoDadoTreino item) {
		try {
			dao = DBB.getInstancia().getProjetoDadoTreinoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ProjetoDadoTreino> subtraiListaPorNome(List<ProjetoDadoTreino> listaMaior, List<ProjetoDadoTreino> listaMenor) {
		Iterator<ProjetoDadoTreino> itMaior = listaMaior.iterator();
		Iterator<ProjetoDadoTreino> itMenor = null;
		List<ProjetoDadoTreino> listaDiferenca = new ArrayList<ProjetoDadoTreino>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ProjetoDadoTreino corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ProjetoDadoTreino comparador = itMenor.next();
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
	protected boolean iguais(ProjetoDadoTreino item1, ProjetoDadoTreino item2) {
		throw new RuntimeException("Fazer override em ProjetoDadoTreinoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ProjetoDadoTreino item) {
		return "Fazer override em ProjetoDadoTreinoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaDadoTreino.clear();
		listaResultadoMes.clear();
	
	}
	
	
	public void displayLogLista(List<ProjetoDadoTreino> lista, String codigo) {
		for (ProjetoDadoTreino item : lista) {
			ArquivoLog.getInstancia().salvaLog("ProjetoDadoTreino(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ProjetoDadoTreino item) {
		StringBuffer display = new StringBuffer();
		display.append("ProjetoDadoTreino {");
		
		display.append("IdProjetoDadoTreino:" + item.getIdProjetoDadoTreino() + ";");
		
		display.append("Target:" + item.getTarget() + ";");
		
		display.append("Stop:" + item.getStop() + ";");
		
		display.append("PosicaoCompraVenda:" + item.getPosicaoCompraVenda() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
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
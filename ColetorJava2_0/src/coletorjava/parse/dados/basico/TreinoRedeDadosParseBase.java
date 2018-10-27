package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.TreinoRedeDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class TreinoRedeDadosParseBase extends DadosParseDao {

	protected TreinoRedeDao dao = null;
	protected TreinoRede itemDetalhe = null;
	protected List<TreinoRede> lista = null;
	
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
	// do Objeto TreinoRede
	// Para listas usar itemCorrente.
	public TreinoRede getItemDetalhe() {
		return itemDetalhe;
	}
	
	private TreinoRede itemCorrente = null;
	
	//Resultado 
	private	DadoTheta correnteDadoTheta;
	protected List<DadoTheta> listaDadoTheta = new ArrayList<DadoTheta>();
	
	// Adicionado em 01-08-2016
	public void adicionaDadoTheta(DadoTheta itemLista) {
		itemLista.setIdTreinoRedeGp(itemDetalhe.getIdTreinoRede());
		//ArquivoLog.getInstancia().salvaLog("TreinoRede(adicionaCorrenteDadoTheta):" + DadoThetaDadosParseBase.displayLog(correnteDadoTheta));
		listaDadoTheta.add(itemLista);
	}
	
	
	
	@Deprecated
	public DadoTheta getCorrenteDadoTheta() {
		return correnteDadoTheta;
	}
	@Deprecated
	public void adicionaCorrenteDadoTheta() {
		correnteDadoTheta.setIdTreinoRedeGp(itemDetalhe.getIdTreinoRede());
		ArquivoLog.getInstancia().salvaLog("TreinoRede(adicionaCorrenteDadoTheta):" + DadoThetaDadosParseBase.displayLog(correnteDadoTheta));
		
		listaDadoTheta.add(correnteDadoTheta);
	}
	@Deprecated
	public void criaCorrenteDadoTheta() {
		correnteDadoTheta = FabricaVo.criaDadoTheta();
	}
 		
	
	public TreinoRedeDadosParseBase() {
		super();
		lista = new ArrayList<TreinoRede>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public TreinoRede getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(TreinoRede item) {
		ArquivoLog.getInstancia().salvaLog("TreinoRede(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(TreinoRede item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("TreinoRede(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaTreinoRede();
	}


	public void setItemDetalhe(TreinoRede item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em TreinoRedeDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em TreinoRedeDadosParse";
 	}

	
	private Rede _rede_PertenceA; 
	
	@Deprecated
	public void setRede_PertenceA(Rede item) {
		_rede_PertenceA = item;
	}
	@Deprecated
	public Rede getRede_PertenceA() {
		return _rede_PertenceA;
	}
 	
	private DadoTreino _dadoTreino_GeradoPor; 
	
	@Deprecated
	public void setDadoTreino_GeradoPor(DadoTreino item) {
		_dadoTreino_GeradoPor = item;
	}
	@Deprecated
	public DadoTreino getDadoTreino_GeradoPor() {
		return _dadoTreino_GeradoPor;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getTreinoRedeDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getTreinoRedeDao();
			dao.setConexao(getConexao());
			List<TreinoRede> listaBanco = dao.ListaCorrente();
			List<TreinoRede> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<TreinoRede> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<TreinoRede> it = listaInclusao.iterator();
			while (it.hasNext()) {
				TreinoRede item = it.next();
				System.out.println("TreinoRede Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<TreinoRede> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				TreinoRede item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(TreinoRede item, TreinoRedeDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(TreinoRede item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(TreinoRede item) {
		try {
			dao = DBB.getInstancia().getTreinoRedeDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<TreinoRede> subtraiListaPorNome(List<TreinoRede> listaMaior, List<TreinoRede> listaMenor) {
		Iterator<TreinoRede> itMaior = listaMaior.iterator();
		Iterator<TreinoRede> itMenor = null;
		List<TreinoRede> listaDiferenca = new ArrayList<TreinoRede>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			TreinoRede corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				TreinoRede comparador = itMenor.next();
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
	protected boolean iguais(TreinoRede item1, TreinoRede item2) {
		throw new RuntimeException("Fazer override em TreinoRedeDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(TreinoRede item) {
		return "Fazer override em TreinoRedeDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaDadoTheta.clear();
	
	}
	
	
	public void displayLogLista(List<TreinoRede> lista, String codigo) {
		for (TreinoRede item : lista) {
			ArquivoLog.getInstancia().salvaLog("TreinoRede(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(TreinoRede item) {
		StringBuffer display = new StringBuffer();
		display.append("TreinoRede {");
		
		display.append("IdTreinoRede:" + item.getIdTreinoRede() + ";");
		
		display.append("Lambda:" + item.getLambda() + ";");
		
		display.append("Iteracoes:" + item.getIteracoes() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		display.append("IdRedePa:" + item.getIdRedePa() + ";");
		
		display.append("IdDadoTreinoGp:" + item.getIdDadoTreinoGp() + ";");
		
		
		
		if (item.getRedePertenceA(false)!=null) {
			display.append("Rede{");
			display.append(RedeDadosParse.displayLog(item.getRedePertenceA(false)));
			display.append("}");
		}
 		
		if (item.getDadoTreinoGeradoPor(false)!=null) {
			display.append("DadoTreino{");
			display.append(DadoTreinoDadosParse.displayLog(item.getDadoTreinoGeradoPor(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
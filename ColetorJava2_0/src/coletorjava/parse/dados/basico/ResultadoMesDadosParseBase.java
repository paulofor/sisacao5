package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.ResultadoMesDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ResultadoMesDadosParseBase extends DadosParseDao {

	protected ResultadoMesDao dao = null;
	protected ResultadoMes itemDetalhe = null;
	protected List<ResultadoMes> lista = null;
	
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
	// do Objeto ResultadoMes
	// Para listas usar itemCorrente.
	public ResultadoMes getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ResultadoMes itemCorrente = null;
	
	//Semelhante 
	private	ResultadoPrevisao correnteResultadoPrevisao;
	protected List<ResultadoPrevisao> listaResultadoPrevisao = new ArrayList<ResultadoPrevisao>();
	
	// Adicionado em 01-08-2016
	public void adicionaResultadoPrevisao(ResultadoPrevisao itemLista) {
		itemLista.setIdResultadoMesMp(itemDetalhe.getIdResultadoMes());
		//ArquivoLog.getInstancia().salvaLog("ResultadoMes(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		listaResultadoPrevisao.add(itemLista);
	}
	
	
	
	@Deprecated
	public ResultadoPrevisao getCorrenteResultadoPrevisao() {
		return correnteResultadoPrevisao;
	}
	@Deprecated
	public void adicionaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao.setIdResultadoMesMp(itemDetalhe.getIdResultadoMes());
		ArquivoLog.getInstancia().salvaLog("ResultadoMes(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		
		listaResultadoPrevisao.add(correnteResultadoPrevisao);
	}
	@Deprecated
	public void criaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao = FabricaVo.criaResultadoPrevisao();
	}
 		
	
	public ResultadoMesDadosParseBase() {
		super();
		lista = new ArrayList<ResultadoMes>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ResultadoMes getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ResultadoMes item) {
		ArquivoLog.getInstancia().salvaLog("ResultadoMes(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ResultadoMes item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ResultadoMes(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaResultadoMes();
	}


	public void setItemDetalhe(ResultadoMes item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ResultadoMesDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ResultadoMesDadosParse";
 	}

	
	private ProjetoDadoTreino _projetoDadoTreino_GeradoPor; 
	
	@Deprecated
	public void setProjetoDadoTreino_GeradoPor(ProjetoDadoTreino item) {
		_projetoDadoTreino_GeradoPor = item;
	}
	@Deprecated
	public ProjetoDadoTreino getProjetoDadoTreino_GeradoPor() {
		return _projetoDadoTreino_GeradoPor;
	}
 	
	private MesAno _mesAno_ReferenteA; 
	
	@Deprecated
	public void setMesAno_ReferenteA(MesAno item) {
		_mesAno_ReferenteA = item;
	}
	@Deprecated
	public MesAno getMesAno_ReferenteA() {
		return _mesAno_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getResultadoMesDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getResultadoMesDao();
			dao.setConexao(getConexao());
			List<ResultadoMes> listaBanco = dao.ListaCorrente();
			List<ResultadoMes> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ResultadoMes> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ResultadoMes> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ResultadoMes item = it.next();
				System.out.println("ResultadoMes Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ResultadoMes> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ResultadoMes item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ResultadoMes item, ResultadoMesDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ResultadoMes item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ResultadoMes item) {
		try {
			dao = DBB.getInstancia().getResultadoMesDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ResultadoMes> subtraiListaPorNome(List<ResultadoMes> listaMaior, List<ResultadoMes> listaMenor) {
		Iterator<ResultadoMes> itMaior = listaMaior.iterator();
		Iterator<ResultadoMes> itMenor = null;
		List<ResultadoMes> listaDiferenca = new ArrayList<ResultadoMes>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ResultadoMes corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ResultadoMes comparador = itMenor.next();
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
	protected boolean iguais(ResultadoMes item1, ResultadoMes item2) {
		throw new RuntimeException("Fazer override em ResultadoMesDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ResultadoMes item) {
		return "Fazer override em ResultadoMesDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaResultadoPrevisao.clear();
	
	}
	
	
	public void displayLogLista(List<ResultadoMes> lista, String codigo) {
		for (ResultadoMes item : lista) {
			ArquivoLog.getInstancia().salvaLog("ResultadoMes(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ResultadoMes item) {
		StringBuffer display = new StringBuffer();
		display.append("ResultadoMes {");
		
		display.append("IdResultadoMes:" + item.getIdResultadoMes() + ";");
		
		display.append("QtdeTotal:" + item.getQtdeTotal() + ";");
		
		display.append("QtdeSucesso:" + item.getQtdeSucesso() + ";");
		
		display.append("QtdeFracasso:" + item.getQtdeFracasso() + ";");
		
		display.append("QtdeNeutro:" + item.getQtdeNeutro() + ";");
		
		display.append("PercentualSucesso:" + item.getPercentualSucesso() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		display.append("IdProjetoDadoTreinoGp:" + item.getIdProjetoDadoTreinoGp() + ";");
		
		display.append("IdMesAnoRa:" + item.getIdMesAnoRa() + ";");
		
		
		
		if (item.getProjetoDadoTreinoGeradoPor(false)!=null) {
			display.append("ProjetoDadoTreino{");
			display.append(ProjetoDadoTreinoDadosParse.displayLog(item.getProjetoDadoTreinoGeradoPor(false)));
			display.append("}");
		}
 		
		if (item.getMesAnoReferenteA(false)!=null) {
			display.append("MesAno{");
			display.append(MesAnoDadosParse.displayLog(item.getMesAnoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
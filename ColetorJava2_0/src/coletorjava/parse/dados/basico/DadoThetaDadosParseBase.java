package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.DadoThetaDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class DadoThetaDadosParseBase extends DadosParseDao {

	protected DadoThetaDao dao = null;
	protected DadoTheta itemDetalhe = null;
	protected List<DadoTheta> lista = null;
	
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
	// do Objeto DadoTheta
	// Para listas usar itemCorrente.
	public DadoTheta getItemDetalhe() {
		return itemDetalhe;
	}
	
	private DadoTheta itemCorrente = null;
	
	//Gera 
	private	ResultadoPrevisao correnteResultadoPrevisao;
	protected List<ResultadoPrevisao> listaResultadoPrevisao = new ArrayList<ResultadoPrevisao>();
	
	// Adicionado em 01-08-2016
	public void adicionaResultadoPrevisao(ResultadoPrevisao itemLista) {
		itemLista.setIdDadoThetaGd(itemDetalhe.getIdDadoTheta());
		//ArquivoLog.getInstancia().salvaLog("DadoTheta(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		listaResultadoPrevisao.add(itemLista);
	}
	
	
	
	@Deprecated
	public ResultadoPrevisao getCorrenteResultadoPrevisao() {
		return correnteResultadoPrevisao;
	}
	@Deprecated
	public void adicionaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao.setIdDadoThetaGd(itemDetalhe.getIdDadoTheta());
		ArquivoLog.getInstancia().salvaLog("DadoTheta(adicionaCorrenteResultadoPrevisao):" + ResultadoPrevisaoDadosParseBase.displayLog(correnteResultadoPrevisao));
		
		listaResultadoPrevisao.add(correnteResultadoPrevisao);
	}
	@Deprecated
	public void criaCorrenteResultadoPrevisao() {
		correnteResultadoPrevisao = FabricaVo.criaResultadoPrevisao();
	}
 		
	
	public DadoThetaDadosParseBase() {
		super();
		lista = new ArrayList<DadoTheta>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public DadoTheta getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(DadoTheta item) {
		ArquivoLog.getInstancia().salvaLog("DadoTheta(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(DadoTheta item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("DadoTheta(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaDadoTheta();
	}


	public void setItemDetalhe(DadoTheta item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em DadoThetaDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em DadoThetaDadosParse";
 	}

	
	private TreinoRede _treinoRede_GeradoPor; 
	
	@Deprecated
	public void setTreinoRede_GeradoPor(TreinoRede item) {
		_treinoRede_GeradoPor = item;
	}
	@Deprecated
	public TreinoRede getTreinoRede_GeradoPor() {
		return _treinoRede_GeradoPor;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getDadoThetaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getDadoThetaDao();
			dao.setConexao(getConexao());
			List<DadoTheta> listaBanco = dao.ListaCorrente();
			List<DadoTheta> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<DadoTheta> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<DadoTheta> it = listaInclusao.iterator();
			while (it.hasNext()) {
				DadoTheta item = it.next();
				System.out.println("DadoTheta Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<DadoTheta> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				DadoTheta item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(DadoTheta item, DadoThetaDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(DadoTheta item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(DadoTheta item) {
		try {
			dao = DBB.getInstancia().getDadoThetaDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<DadoTheta> subtraiListaPorNome(List<DadoTheta> listaMaior, List<DadoTheta> listaMenor) {
		Iterator<DadoTheta> itMaior = listaMaior.iterator();
		Iterator<DadoTheta> itMenor = null;
		List<DadoTheta> listaDiferenca = new ArrayList<DadoTheta>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			DadoTheta corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				DadoTheta comparador = itMenor.next();
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
	protected boolean iguais(DadoTheta item1, DadoTheta item2) {
		throw new RuntimeException("Fazer override em DadoThetaDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(DadoTheta item) {
		return "Fazer override em DadoThetaDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaResultadoPrevisao.clear();
	
	}
	
	
	public void displayLogLista(List<DadoTheta> lista, String codigo) {
		for (DadoTheta item : lista) {
			ArquivoLog.getInstancia().salvaLog("DadoTheta(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(DadoTheta item) {
		StringBuffer display = new StringBuffer();
		display.append("DadoTheta {");
		
		display.append("IdDadoTheta:" + item.getIdDadoTheta() + ";");
		
		display.append("NomeArquivo:" + item.getNomeArquivo() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		display.append("IdTreinoRedeGp:" + item.getIdTreinoRedeGp() + ";");
		
		
		
		if (item.getTreinoRedeGeradoPor(false)!=null) {
			display.append("TreinoRede{");
			display.append(TreinoRedeDadosParse.displayLog(item.getTreinoRedeGeradoPor(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.DiaPregaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class DiaPregaoDadosParseBase extends DadosParseDao {

	protected DiaPregaoDao dao = null;
	protected DiaPregao itemDetalhe = null;
	protected List<DiaPregao> lista = null;
	
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
	// do Objeto DiaPregao
	// Para listas usar itemCorrente.
	public DiaPregao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private DiaPregao itemCorrente = null;
	
	//Possui 
	private	EscolhaOpcao correnteEscolhaOpcao;
	protected List<EscolhaOpcao> listaEscolhaOpcao = new ArrayList<EscolhaOpcao>();
	
	// Adicionado em 01-08-2016
	public void adicionaEscolhaOpcao(EscolhaOpcao itemLista) {
		itemLista.setIdDiaPregaoRa(itemDetalhe.getIdDiaPregao());
		//ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		listaEscolhaOpcao.add(itemLista);
	}
	
	
	
	@Deprecated
	public EscolhaOpcao getCorrenteEscolhaOpcao() {
		return correnteEscolhaOpcao;
	}
	@Deprecated
	public void adicionaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao.setIdDiaPregaoRa(itemDetalhe.getIdDiaPregao());
		ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrenteEscolhaOpcao):" + EscolhaOpcaoDadosParseBase.displayLog(correnteEscolhaOpcao));
		
		listaEscolhaOpcao.add(correnteEscolhaOpcao);
	}
	@Deprecated
	public void criaCorrenteEscolhaOpcao() {
		correnteEscolhaOpcao = FabricaVo.criaEscolhaOpcao();
	}
 		
	//Possui 
	private	OpcaoReferencia correnteOpcaoReferencia;
	protected List<OpcaoReferencia> listaOpcaoReferencia = new ArrayList<OpcaoReferencia>();
	
	// Adicionado em 01-08-2016
	public void adicionaOpcaoReferencia(OpcaoReferencia itemLista) {
		itemLista.setIdDiaPregaoRa(itemDetalhe.getIdDiaPregao());
		//ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		listaOpcaoReferencia.add(itemLista);
	}
	
	
	
	@Deprecated
	public OpcaoReferencia getCorrenteOpcaoReferencia() {
		return correnteOpcaoReferencia;
	}
	@Deprecated
	public void adicionaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia.setIdDiaPregaoRa(itemDetalhe.getIdDiaPregao());
		ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrenteOpcaoReferencia):" + OpcaoReferenciaDadosParseBase.displayLog(correnteOpcaoReferencia));
		
		listaOpcaoReferencia.add(correnteOpcaoReferencia);
	}
	@Deprecated
	public void criaCorrenteOpcaoReferencia() {
		correnteOpcaoReferencia = FabricaVo.criaOpcaoReferencia();
	}
 		
	
	public DiaPregaoDadosParseBase() {
		super();
		lista = new ArrayList<DiaPregao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public DiaPregao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(DiaPregao item) {
		ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(DiaPregao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("DiaPregao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaDiaPregao();
	}


	public void setItemDetalhe(DiaPregao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em DiaPregaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em DiaPregaoDadosParse";
 	}

	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getDiaPregaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getDiaPregaoDao();
			dao.setConexao(getConexao());
			List<DiaPregao> listaBanco = dao.ListaCorrente();
			List<DiaPregao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<DiaPregao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<DiaPregao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				DiaPregao item = it.next();
				System.out.println("DiaPregao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<DiaPregao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				DiaPregao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(DiaPregao item, DiaPregaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(DiaPregao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(DiaPregao item) {
		try {
			dao = DBB.getInstancia().getDiaPregaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<DiaPregao> subtraiListaPorNome(List<DiaPregao> listaMaior, List<DiaPregao> listaMenor) {
		Iterator<DiaPregao> itMaior = listaMaior.iterator();
		Iterator<DiaPregao> itMenor = null;
		List<DiaPregao> listaDiferenca = new ArrayList<DiaPregao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			DiaPregao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				DiaPregao comparador = itMenor.next();
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
	protected boolean iguais(DiaPregao item1, DiaPregao item2) {
		throw new RuntimeException("Fazer override em DiaPregaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(DiaPregao item) {
		return "Fazer override em DiaPregaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaEscolhaOpcao.clear();
		listaOpcaoReferencia.clear();
	
	}
	
	
	public void displayLogLista(List<DiaPregao> lista, String codigo) {
		for (DiaPregao item : lista) {
			ArquivoLog.getInstancia().salvaLog("DiaPregao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(DiaPregao item) {
		StringBuffer display = new StringBuffer();
		display.append("DiaPregao {");
		
		display.append("IdDiaPregao:" + item.getIdDiaPregao() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("Feriado:" + item.getFeriado() + ";");
		
		
		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
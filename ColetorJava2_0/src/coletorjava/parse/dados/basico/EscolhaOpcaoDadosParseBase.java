package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.EscolhaOpcaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class EscolhaOpcaoDadosParseBase extends DadosParseDao {

	protected EscolhaOpcaoDao dao = null;
	protected EscolhaOpcao itemDetalhe = null;
	protected List<EscolhaOpcao> lista = null;
	
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
	// do Objeto EscolhaOpcao
	// Para listas usar itemCorrente.
	public EscolhaOpcao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private EscolhaOpcao itemCorrente = null;
	
	
	public EscolhaOpcaoDadosParseBase() {
		super();
		lista = new ArrayList<EscolhaOpcao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public EscolhaOpcao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(EscolhaOpcao item) {
		ArquivoLog.getInstancia().salvaLog("EscolhaOpcao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(EscolhaOpcao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("EscolhaOpcao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaEscolhaOpcao();
	}


	public void setItemDetalhe(EscolhaOpcao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em EscolhaOpcaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em EscolhaOpcaoDadosParse";
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
 	
	private OpcaoSisacao _opcaoSisacao_Escolha; 
	
	@Deprecated
	public void setOpcaoSisacao_Escolha(OpcaoSisacao item) {
		_opcaoSisacao_Escolha = item;
	}
	@Deprecated
	public OpcaoSisacao getOpcaoSisacao_Escolha() {
		return _opcaoSisacao_Escolha;
	}
 	
	private DiaPregao _diaPregao_ReferenteA; 
	
	@Deprecated
	public void setDiaPregao_ReferenteA(DiaPregao item) {
		_diaPregao_ReferenteA = item;
	}
	@Deprecated
	public DiaPregao getDiaPregao_ReferenteA() {
		return _diaPregao_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getEscolhaOpcaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getEscolhaOpcaoDao();
			dao.setConexao(getConexao());
			List<EscolhaOpcao> listaBanco = dao.ListaCorrente();
			List<EscolhaOpcao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<EscolhaOpcao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<EscolhaOpcao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				EscolhaOpcao item = it.next();
				System.out.println("EscolhaOpcao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<EscolhaOpcao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				EscolhaOpcao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(EscolhaOpcao item, EscolhaOpcaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(EscolhaOpcao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(EscolhaOpcao item) {
		try {
			dao = DBB.getInstancia().getEscolhaOpcaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<EscolhaOpcao> subtraiListaPorNome(List<EscolhaOpcao> listaMaior, List<EscolhaOpcao> listaMenor) {
		Iterator<EscolhaOpcao> itMaior = listaMaior.iterator();
		Iterator<EscolhaOpcao> itMenor = null;
		List<EscolhaOpcao> listaDiferenca = new ArrayList<EscolhaOpcao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			EscolhaOpcao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				EscolhaOpcao comparador = itMenor.next();
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
	protected boolean iguais(EscolhaOpcao item1, EscolhaOpcao item2) {
		throw new RuntimeException("Fazer override em EscolhaOpcaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(EscolhaOpcao item) {
		return "Fazer override em EscolhaOpcaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<EscolhaOpcao> lista, String codigo) {
		for (EscolhaOpcao item : lista) {
			ArquivoLog.getInstancia().salvaLog("EscolhaOpcao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(EscolhaOpcao item) {
		StringBuffer display = new StringBuffer();
		display.append("EscolhaOpcao {");
		
		display.append("IdEscolhaOpcao:" + item.getIdEscolhaOpcao() + ";");
		
		display.append("DataReferencia:" + item.getDataReferencia() + ";");
		
		display.append("HoraReferencia:" + item.getHoraReferencia() + ";");
		
		display.append("FaixaEscolha:" + item.getFaixaEscolha() + ";");
		
		display.append("IdTickerRa:" + item.getIdTickerRa() + ";");
		
		display.append("IdOpcaoSisacaoE:" + item.getIdOpcaoSisacaoE() + ";");
		
		display.append("IdDiaPregaoRa:" + item.getIdDiaPregaoRa() + ";");
		
		
		
		if (item.getTickerReferenteA(false)!=null) {
			display.append("Ticker{");
			display.append(TickerDadosParse.displayLog(item.getTickerReferenteA(false)));
			display.append("}");
		}
 		
		if (item.getOpcaoSisacaoEscolha(false)!=null) {
			display.append("OpcaoSisacao{");
			display.append(OpcaoSisacaoDadosParse.displayLog(item.getOpcaoSisacaoEscolha(false)));
			display.append("}");
		}
 		
		if (item.getDiaPregaoReferenteA(false)!=null) {
			display.append("DiaPregao{");
			display.append(DiaPregaoDadosParse.displayLog(item.getDiaPregaoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.CotacaoProcessadaOpcaoResultadoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class CotacaoProcessadaOpcaoResultadoDadosParseBase extends DadosParseDao {

	protected CotacaoProcessadaOpcaoResultadoDao dao = null;
	protected CotacaoProcessadaOpcaoResultado itemDetalhe = null;
	protected List<CotacaoProcessadaOpcaoResultado> lista = null;
	
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
	// do Objeto CotacaoProcessadaOpcaoResultado
	// Para listas usar itemCorrente.
	public CotacaoProcessadaOpcaoResultado getItemDetalhe() {
		return itemDetalhe;
	}
	
	private CotacaoProcessadaOpcaoResultado itemCorrente = null;
	
	
	public CotacaoProcessadaOpcaoResultadoDadosParseBase() {
		super();
		lista = new ArrayList<CotacaoProcessadaOpcaoResultado>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public CotacaoProcessadaOpcaoResultado getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(CotacaoProcessadaOpcaoResultado item) {
		ArquivoLog.getInstancia().salvaLog("CotacaoProcessadaOpcaoResultado(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(CotacaoProcessadaOpcaoResultado item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("CotacaoProcessadaOpcaoResultado(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
	}


	public void setItemDetalhe(CotacaoProcessadaOpcaoResultado item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em CotacaoProcessadaOpcaoResultadoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em CotacaoProcessadaOpcaoResultadoDadosParse";
 	}

	
	private OpcaoSisacao _opcaoSisacao_ReferenteA; 
	
	@Deprecated
	public void setOpcaoSisacao_ReferenteA(OpcaoSisacao item) {
		_opcaoSisacao_ReferenteA = item;
	}
	@Deprecated
	public OpcaoSisacao getOpcaoSisacao_ReferenteA() {
		return _opcaoSisacao_ReferenteA;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaOpcaoResultadoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaOpcaoResultadoDao();
			dao.setConexao(getConexao());
			List<CotacaoProcessadaOpcaoResultado> listaBanco = dao.ListaCorrente();
			List<CotacaoProcessadaOpcaoResultado> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<CotacaoProcessadaOpcaoResultado> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<CotacaoProcessadaOpcaoResultado> it = listaInclusao.iterator();
			while (it.hasNext()) {
				CotacaoProcessadaOpcaoResultado item = it.next();
				System.out.println("CotacaoProcessadaOpcaoResultado Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<CotacaoProcessadaOpcaoResultado> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				CotacaoProcessadaOpcaoResultado item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(CotacaoProcessadaOpcaoResultado item, CotacaoProcessadaOpcaoResultadoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(CotacaoProcessadaOpcaoResultado item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(CotacaoProcessadaOpcaoResultado item) {
		try {
			dao = DBB.getInstancia().getCotacaoProcessadaOpcaoResultadoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<CotacaoProcessadaOpcaoResultado> subtraiListaPorNome(List<CotacaoProcessadaOpcaoResultado> listaMaior, List<CotacaoProcessadaOpcaoResultado> listaMenor) {
		Iterator<CotacaoProcessadaOpcaoResultado> itMaior = listaMaior.iterator();
		Iterator<CotacaoProcessadaOpcaoResultado> itMenor = null;
		List<CotacaoProcessadaOpcaoResultado> listaDiferenca = new ArrayList<CotacaoProcessadaOpcaoResultado>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			CotacaoProcessadaOpcaoResultado corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				CotacaoProcessadaOpcaoResultado comparador = itMenor.next();
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
	protected boolean iguais(CotacaoProcessadaOpcaoResultado item1, CotacaoProcessadaOpcaoResultado item2) {
		throw new RuntimeException("Fazer override em CotacaoProcessadaOpcaoResultadoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(CotacaoProcessadaOpcaoResultado item) {
		return "Fazer override em CotacaoProcessadaOpcaoResultadoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<CotacaoProcessadaOpcaoResultado> lista, String codigo) {
		for (CotacaoProcessadaOpcaoResultado item : lista) {
			ArquivoLog.getInstancia().salvaLog("CotacaoProcessadaOpcaoResultado(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(CotacaoProcessadaOpcaoResultado item) {
		StringBuffer display = new StringBuffer();
		display.append("CotacaoProcessadaOpcaoResultado {");
		
		display.append("IdCotacaoProcessadaOpcaoResultado:" + item.getIdCotacaoProcessadaOpcaoResultado() + ";");
		
		display.append("Data:" + item.getData() + ";");
		
		display.append("HoraSerieTemporal:" + item.getHoraSerieTemporal() + ";");
		
		display.append("ContadorDia:" + item.getContadorDia() + ";");
		
		display.append("CodigoMercadoOpcao:" + item.getCodigoMercadoOpcao() + ";");
		
		display.append("ValorOpcao:" + item.getValorOpcao() + ";");
		
		display.append("ResultadoT70S60:" + item.getResultadoT70S60() + ";");
		
		display.append("ResultadoT60S60:" + item.getResultadoT60S60() + ";");
		
		display.append("ResultadoT50S60:" + item.getResultadoT50S60() + ";");
		
		display.append("ResultadoT40S60:" + item.getResultadoT40S60() + ";");
		
		display.append("ResultadoT70S50:" + item.getResultadoT70S50() + ";");
		
		display.append("ResultadoT60S50:" + item.getResultadoT60S50() + ";");
		
		display.append("ResultadoT50S50:" + item.getResultadoT50S50() + ";");
		
		display.append("ResultadoT40S50:" + item.getResultadoT40S50() + ";");
		
		display.append("ValorSaidaT40S60:" + item.getValorSaidaT40S60() + ";");
		
		display.append("ValorSaidaT50S60:" + item.getValorSaidaT50S60() + ";");
		
		display.append("ValorSaidaT60S60:" + item.getValorSaidaT60S60() + ";");
		
		display.append("ValorSaidaT70S60:" + item.getValorSaidaT70S60() + ";");
		
		display.append("ValorSaidaT40S50:" + item.getValorSaidaT40S50() + ";");
		
		display.append("ValorSaidaT50S50:" + item.getValorSaidaT50S50() + ";");
		
		display.append("ValorSaidaT60S50:" + item.getValorSaidaT60S50() + ";");
		
		display.append("ValorSaidaT70S50:" + item.getValorSaidaT70S50() + ";");
		
		display.append("DataHoraSaidaT40S60:" + item.getDataHoraSaidaT40S60() + ";");
		
		display.append("DataHoraSaidaT50S60:" + item.getDataHoraSaidaT50S60() + ";");
		
		display.append("DataHoraSaidaT60S60:" + item.getDataHoraSaidaT60S60() + ";");
		
		display.append("DataHoraSaidaT70S60:" + item.getDataHoraSaidaT70S60() + ";");
		
		display.append("DataHoraSaidaT40S50:" + item.getDataHoraSaidaT40S50() + ";");
		
		display.append("DataHoraSaidaT50S50:" + item.getDataHoraSaidaT50S50() + ";");
		
		display.append("DataHoraSaidaT60S50:" + item.getDataHoraSaidaT60S50() + ";");
		
		display.append("DataHoraSaidaT70S50:" + item.getDataHoraSaidaT70S50() + ";");
		
		display.append("ValorAcao:" + item.getValorAcao() + ";");
		
		display.append("LimiteDiaT50S50:" + item.getLimiteDiaT50S50() + ";");
		
		display.append("LimiteDiaT60S60:" + item.getLimiteDiaT60S60() + ";");
		
		display.append("IdOpcaoSisacaoRa:" + item.getIdOpcaoSisacaoRa() + ";");
		
		
		
		if (item.getOpcaoSisacaoReferenteA(false)!=null) {
			display.append("OpcaoSisacao{");
			display.append(OpcaoSisacaoDadosParse.displayLog(item.getOpcaoSisacaoReferenteA(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
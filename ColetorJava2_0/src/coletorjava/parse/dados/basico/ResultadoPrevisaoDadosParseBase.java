package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.ResultadoPrevisaoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class ResultadoPrevisaoDadosParseBase extends DadosParseDao {

	protected ResultadoPrevisaoDao dao = null;
	protected ResultadoPrevisao itemDetalhe = null;
	protected List<ResultadoPrevisao> lista = null;
	
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
	// do Objeto ResultadoPrevisao
	// Para listas usar itemCorrente.
	public ResultadoPrevisao getItemDetalhe() {
		return itemDetalhe;
	}
	
	private ResultadoPrevisao itemCorrente = null;
	
	
	public ResultadoPrevisaoDadosParseBase() {
		super();
		lista = new ArrayList<ResultadoPrevisao>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public ResultadoPrevisao getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(ResultadoPrevisao item) {
		ArquivoLog.getInstancia().salvaLog("ResultadoPrevisao(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(ResultadoPrevisao item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("ResultadoPrevisao(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaResultadoPrevisao();
	}


	public void setItemDetalhe(ResultadoPrevisao item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em ResultadoPrevisaoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em ResultadoPrevisaoDadosParse";
 	}

	
	private DadoTheta _dadoTheta_GeradoDe; 
	
	@Deprecated
	public void setDadoTheta_GeradoDe(DadoTheta item) {
		_dadoTheta_GeradoDe = item;
	}
	@Deprecated
	public DadoTheta getDadoTheta_GeradoDe() {
		return _dadoTheta_GeradoDe;
	}
 	
	private ResultadoMes _resultadoMes_MesmoPeriodo; 
	
	@Deprecated
	public void setResultadoMes_MesmoPeriodo(ResultadoMes item) {
		_resultadoMes_MesmoPeriodo = item;
	}
	@Deprecated
	public ResultadoMes getResultadoMes_MesmoPeriodo() {
		return _resultadoMes_MesmoPeriodo;
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
			dao = DBB.getInstancia().getResultadoPrevisaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getResultadoPrevisaoDao();
			dao.setConexao(getConexao());
			List<ResultadoPrevisao> listaBanco = dao.ListaCorrente();
			List<ResultadoPrevisao> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<ResultadoPrevisao> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<ResultadoPrevisao> it = listaInclusao.iterator();
			while (it.hasNext()) {
				ResultadoPrevisao item = it.next();
				System.out.println("ResultadoPrevisao Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<ResultadoPrevisao> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				ResultadoPrevisao item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(ResultadoPrevisao item, ResultadoPrevisaoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(ResultadoPrevisao item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(ResultadoPrevisao item) {
		try {
			dao = DBB.getInstancia().getResultadoPrevisaoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<ResultadoPrevisao> subtraiListaPorNome(List<ResultadoPrevisao> listaMaior, List<ResultadoPrevisao> listaMenor) {
		Iterator<ResultadoPrevisao> itMaior = listaMaior.iterator();
		Iterator<ResultadoPrevisao> itMenor = null;
		List<ResultadoPrevisao> listaDiferenca = new ArrayList<ResultadoPrevisao>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			ResultadoPrevisao corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				ResultadoPrevisao comparador = itMenor.next();
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
	protected boolean iguais(ResultadoPrevisao item1, ResultadoPrevisao item2) {
		throw new RuntimeException("Fazer override em ResultadoPrevisaoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(ResultadoPrevisao item) {
		return "Fazer override em ResultadoPrevisaoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
	
	}
	
	
	public void displayLogLista(List<ResultadoPrevisao> lista, String codigo) {
		for (ResultadoPrevisao item : lista) {
			ArquivoLog.getInstancia().salvaLog("ResultadoPrevisao(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(ResultadoPrevisao item) {
		StringBuffer display = new StringBuffer();
		display.append("ResultadoPrevisao {");
		
		display.append("IdResultadoPrevisao:" + item.getIdResultadoPrevisao() + ";");
		
		display.append("QtdeVerdadeiroPostivo:" + item.getQtdeVerdadeiroPostivo() + ";");
		
		display.append("QtdeFalsoPositivo:" + item.getQtdeFalsoPositivo() + ";");
		
		display.append("QtdeTotal:" + item.getQtdeTotal() + ";");
		
		display.append("PercentualSucessoPrevisao:" + item.getPercentualSucessoPrevisao() + ";");
		
		display.append("PercentualPrecisao:" + item.getPercentualPrecisao() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		display.append("IdDadoThetaGd:" + item.getIdDadoThetaGd() + ";");
		
		display.append("IdResultadoMesMp:" + item.getIdResultadoMesMp() + ";");
		
		display.append("IdMesAnoRa:" + item.getIdMesAnoRa() + ";");
		
		
		
		if (item.getDadoThetaGeradoDe(false)!=null) {
			display.append("DadoTheta{");
			display.append(DadoThetaDadosParse.displayLog(item.getDadoThetaGeradoDe(false)));
			display.append("}");
		}
 		
		if (item.getResultadoMesMesmoPeriodo(false)!=null) {
			display.append("ResultadoMes{");
			display.append(ResultadoMesDadosParse.displayLog(item.getResultadoMesMesmoPeriodo(false)));
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
package coletorjava.parse.dados.basico;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coletorjava.dao.DadoTreinoDao;
import coletorjava.dao.DBB;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.parse.dao.DadosParseDao;
import coletorjava.parse.dados.*;
import coletorjava.modelo.*;
import coletorjava.log.ArquivoLog;
import org.json.JSONObject;



public abstract class DadoTreinoDadosParseBase extends DadosParseDao {

	protected DadoTreinoDao dao = null;
	protected DadoTreino itemDetalhe = null;
	protected List<DadoTreino> lista = null;
	
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
	// do Objeto DadoTreino
	// Para listas usar itemCorrente.
	public DadoTreino getItemDetalhe() {
		return itemDetalhe;
	}
	
	private DadoTreino itemCorrente = null;
	
	//Gerou 
	private	TreinoRede correnteTreinoRede;
	protected List<TreinoRede> listaTreinoRede = new ArrayList<TreinoRede>();
	
	// Adicionado em 01-08-2016
	public void adicionaTreinoRede(TreinoRede itemLista) {
		itemLista.setIdDadoTreinoGp(itemDetalhe.getIdDadoTreino());
		//ArquivoLog.getInstancia().salvaLog("DadoTreino(adicionaCorrenteTreinoRede):" + TreinoRedeDadosParseBase.displayLog(correnteTreinoRede));
		listaTreinoRede.add(itemLista);
	}
	
	
	
	@Deprecated
	public TreinoRede getCorrenteTreinoRede() {
		return correnteTreinoRede;
	}
	@Deprecated
	public void adicionaCorrenteTreinoRede() {
		correnteTreinoRede.setIdDadoTreinoGp(itemDetalhe.getIdDadoTreino());
		ArquivoLog.getInstancia().salvaLog("DadoTreino(adicionaCorrenteTreinoRede):" + TreinoRedeDadosParseBase.displayLog(correnteTreinoRede));
		
		listaTreinoRede.add(correnteTreinoRede);
	}
	@Deprecated
	public void criaCorrenteTreinoRede() {
		correnteTreinoRede = FabricaVo.criaTreinoRede();
	}
 		
	
	public DadoTreinoDadosParseBase() {
		super();
		lista = new ArrayList<DadoTreino>();
	}

	// Para ser chamado pelos CallbackParsing
	@Deprecated
	public DadoTreino getCorrente() {
		return itemCorrente;
	}
	public void adicionaCorrenteExterno(DadoTreino item) {
		ArquivoLog.getInstancia().salvaLog("DadoTreino(adicionaCorrenteExterno):" + displayLog(item));
		if (debug) {
			displayDebug(item);
		}
		lista.add(item);
	}
	protected void displayDebug(DadoTreino item) {
		System.out.println(displayLog(item));
	}
	
	@Deprecated
	public void adicionaCorrente() {
		ArquivoLog.getInstancia().salvaLog("DadoTreino(adicionaCorrente):" + displayLog(itemCorrente));
		lista.add(itemCorrente);
	}
	
	@Deprecated
	public void criaCorrente() {
		itemCorrente = FabricaVo.criaDadoTreino();
	}


	public void setItemDetalhe(DadoTreino item){
		itemDetalhe = item;
	}

	public String getUrlLista() {
 		return "implementar getUrlLista() em DadoTreinoDadosParse";
 	}
 	public String getUrlDetalhe() {
 		return "implementar getUrlDetalhe() em DadoTreinoDadosParse";
 	}

	
	private ProjetoDadoTreino _projetoDadoTreino_Possui; 
	
	@Deprecated
	public void setProjetoDadoTreino_Possui(ProjetoDadoTreino item) {
		_projetoDadoTreino_Possui = item;
	}
	@Deprecated
	public ProjetoDadoTreino getProjetoDadoTreino_Possui() {
		return _projetoDadoTreino_Possui;
	}
 	

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getDadoTreinoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(itemDetalhe);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

	public void finalizacaoOkLista() {
		try {
			dao = DBB.getInstancia().getDadoTreinoDao();
			dao.setConexao(getConexao());
			List<DadoTreino> listaBanco = dao.ListaCorrente();
			List<DadoTreino> listaInclusao = subtraiListaPorNome(lista,listaBanco);
			List<DadoTreino> listaExclusao = subtraiListaPorNome(listaBanco,lista);
			displayLogLista(listaInclusao,"Inclusao");
			displayLogLista(listaExclusao,"Exclusao");
			Iterator<DadoTreino> it = listaInclusao.iterator();
			while (it.hasNext()) {
				DadoTreino item = it.next();
				System.out.println("DadoTreino Nova: " + toString(item));
				setDataInclusaoItemLista(item);
				dao.insereItem(item);
			}
			Iterator<DadoTreino> itExclusao = listaExclusao.iterator();
			while (itExclusao.hasNext()) {
				DadoTreino item = itExclusao.next();
				excluiItemLista(item, dao);
			}
			//Nao se pode fechar a conexao aqui, preciso arrumar outro ponto.
			//dao.liberaConexao(getConexao());
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	protected void excluiItemLista(DadoTreino item, DadoTreinoDao dao) throws DaoException{
		//dao.insereHistorico(item,  DCConvert.getDataDD_MM_AAAA());
		//dao.excluiItem(item);
	}
	protected void setDataInclusaoItemLista(DadoTreino item) {
		//item.setDataInclusao(DCConvert.getDataDD_MM_AAAA());
	}
	
	
	public void finalizacaoOk(DadoTreino item) {
		try {
			dao = DBB.getInstancia().getDadoTreinoDao();
			dao.setConexao(getConexao());
			dao.alteraItem(item);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public List<DadoTreino> subtraiListaPorNome(List<DadoTreino> listaMaior, List<DadoTreino> listaMenor) {
		Iterator<DadoTreino> itMaior = listaMaior.iterator();
		Iterator<DadoTreino> itMenor = null;
		List<DadoTreino> listaDiferenca = new ArrayList<DadoTreino>();
		boolean achou = false;
		while (itMaior.hasNext()) {
			achou = false;
			DadoTreino corrente = itMaior.next();
			itMenor = listaMenor.iterator();
			while (itMenor.hasNext()) {
				DadoTreino comparador = itMenor.next();
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
	protected boolean iguais(DadoTreino item1, DadoTreino item2) {
		throw new RuntimeException("Fazer override em DadoTreinoDadosParse.iguais()");
		//return (item1.getNome().compareTo(item2.getNome())==0);
	}
	
	protected String toString(DadoTreino item) {
		return "Fazer override em DadoTreinoDadosParse.toString()";
	}
	
	public void inicializacaoLista() {
		lista.clear();
	}
	
	public void inicializacaoDetalhe() {
	
		listaTreinoRede.clear();
	
	}
	
	
	public void displayLogLista(List<DadoTreino> lista, String codigo) {
		for (DadoTreino item : lista) {
			ArquivoLog.getInstancia().salvaLog("DadoTreino(lista" + codigo + "):" + displayLog(item));
		}
	}
	public static String displayLog(DadoTreino item) {
		StringBuffer display = new StringBuffer();
		display.append("DadoTreino {");
		
		display.append("IdDadoTreino:" + item.getIdDadoTreino() + ";");
		
		display.append("NomeArquivoX:" + item.getNomeArquivoX() + ";");
		
		display.append("DiasEntradaDiario:" + item.getDiasEntradaDiario() + ";");
		
		display.append("DiasEntradaIntraday:" + item.getDiasEntradaIntraday() + ";");
		
		display.append("TipoPeriodo:" + item.getTipoPeriodo() + ";");
		
		display.append("QtdeNeuronioEntrada:" + item.getQtdeNeuronioEntrada() + ";");
		
		display.append("CodigoFaixa:" + item.getCodigoFaixa() + ";");
		
		display.append("UltimaAlteracao:" + item.getUltimaAlteracao() + ";");
		
		display.append("QtdeTickIntraday:" + item.getQtdeTickIntraday() + ";");
		
		display.append("NomeArquivoY:" + item.getNomeArquivoY() + ";");
		
		display.append("Ano:" + item.getAno() + ";");
		
		display.append("ContadorPorAno:" + item.getContadorPorAno() + ";");
		
		display.append("MinutosIntraday:" + item.getMinutosIntraday() + ";");
		
		display.append("IdProjetoDadoTreinoP:" + item.getIdProjetoDadoTreinoP() + ";");
		
		
		
		if (item.getProjetoDadoTreinoPossui(false)!=null) {
			display.append("ProjetoDadoTreino{");
			display.append(ProjetoDadoTreinoDadosParse.displayLog(item.getProjetoDadoTreinoPossui(false)));
			display.append("}");
		}
 		

		display.append("}");
		return display.toString();
	}
	
	public List camposPost() {
		return null;
	}
}
package sisacao.app.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.OpcaoReferencia;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoReferenciaRegraColecao;

// Tarefa dessa classe

// 1 - Verificar mudança de dia. ( obter dado do dia para ver se tem pregão )
// 2 - Se aconteceu mudança obter os ticker que precisam coletar
// 3 - Criar as threads necessárias


public class ThreadPai  extends TimerTask {

	private List<Timer1para15> listaThreads = null;
	private Timer timer = null;
	private List<CotacaoProcessada> listaHorarios = null; 
	
	private String diaAtual = null;
	private String diaAnterior = null;
	
	private DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	private DiaPregao dia = null;
	private OpcaoReferenciaRegraColecao opcaoRefSrv = FabricaRegra.getInstancia().getOpcaoReferenciaRegraColecao();
	
	
	public ThreadPai() {
		super();
		inicializaHorarios();
		CotacaoProcessadaDaoThread.criaConexaoUnica();
	}
	
	private void inicializaHorarios() {
		CotacaoProcessadaRegraColecao cotacaoProcSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		try {
			this.listaHorarios = cotacaoProcSrv.ListaHorarios15Minutos();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		boolean mudouDia = verificaMudancaDia();
		System.out.println("Testando dia");
		try {
		if (mudouDia) {
			System.out.println("Novo Dia");
			ArquivoLog.getInstancia().salvaLog("Novo dia");
			diaSrv.getFiltro().setDataPesquisa(diaAtual);
			dia = diaSrv.ObtemPorDataPesquisa();
			if (dia!=null && !dia.getFeriado()) {
				temPregao();
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaLog("Erro ThreadPaiBase" + e);
		}
		
	}
	
	
	private void temPregao() throws DaoException {
		this.opcaoRefSrv.getFiltro().setData(dia.getData());
		List<OpcaoReferencia> listaOpcao = this.opcaoRefSrv.ListaAtivoParaColetaNaData();
		verificaTabelaOnline(listaOpcao);
		disparaTimer(listaOpcao);
	}
	
	private void verificaTabelaOnline(List<OpcaoReferencia> lista) {
		CotacaoProcessadaRegraColecao cotacaoProcRC = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		for (OpcaoReferencia opcao : lista) {
			cotacaoProcRC.getFiltro().setNomeTicker(opcao.getCodigoMercado());
			try {
				cotacaoProcRC.CriaObjetoOnline();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void disparaTimer(List<OpcaoReferencia> lista) {
		int ms = 60000;
		limpaListaThread();
		this.timer = new Timer();
		this.listaThreads = new ArrayList<Timer1para15>();
		for (OpcaoReferencia opcao : lista) {
			
			System.out.println("Criaou Timer1para15 " + opcao.getCodigoMercado());
			Timer1para15 tempo1 = new Timer1para15(opcao.getCodigoMercado());
			tempo1.setListaCotacaoTempo(this.listaHorarios);
			this.timer.schedule(tempo1, 0L, ms);
			this.listaThreads.add(tempo1);
		}
	}
	
	private void limpaListaThread() {
		if (listaThreads!=null) {
			for (Timer1para15 thread : listaThreads) {
				thread.cancel();
				thread = null;
			}
		}
		if (this.timer!= null) {
			this.timer.cancel();
			this.timer.purge();
		}
	}
	
	
	private boolean verificaMudancaDia() {
		String dataAgora = DatasUtils.getDataDD_MM_AAAA();
		boolean novaData = (this.diaAtual==null) || (this.diaAtual.compareTo(dataAgora) != 0);
		if (novaData) {
			this.diaAnterior = this.diaAtual;
			this.diaAtual = dataAgora;
		}
		return novaData;
	}


	

}

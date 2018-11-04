package br.com.digicom.cotacao.threads;

import br.com.digicom.cotacao.webservice.DiaPregaoFiltro;
import br.com.digicom.cotacao.webservice.DiaPregaoObjetoWs;
import br.com.digicom.cotacao.webservice.DiaPregaoWSLocator;
import br.com.digicom.cotacao.webservice.DiaPregaoWSSoap;
import br.com.digicom.cotacao.webservice.PeriodoPregaoFiltro;
import br.com.digicom.cotacao.webservice.PeriodoPregaoObjetoWs;
import br.com.digicom.cotacao.webservice.PeriodoPregaoWSLocator;
import br.com.digicom.cotacao.webservice.PeriodoPregaoWSSoap;
import br.com.digicom.parse.RestricaoTempo;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;

public abstract class ThreadPaiBase extends TimerTask {
	private List listaThreads = null;

	private Timer timer = null;
	private String diaAtual = null;
	private String diaAnterior = null;
	private boolean existePregao;
	private boolean dadosParaCarregar = true;
	private PeriodoPregaoObjetoWs periodoPregao = null;

	PeriodoPregaoWSLocator locatorPeriodoPregao = null;
	DiaPregaoWSLocator locatorDiaPregao = null;

	public ThreadPaiBase() {
		this.locatorPeriodoPregao = new PeriodoPregaoWSLocator();
		this.locatorDiaPregao = new DiaPregaoWSLocator();
		this.diaAtual = "";
	}

	protected abstract void mudouDia(String paramString1, String paramString2, boolean paramBoolean);

	protected abstract void mudouMes(String paramString1, String paramString2);

	protected abstract void mudouAno(String paramString1, String paramString2);

	private boolean verificaMudancaDia() {
		String dataAgora = DatasUtils.getDataDD_MM_AAAA();
		boolean novaData = this.diaAtual.compareTo(dataAgora) != 0;
		if (novaData) {
			this.diaAnterior = this.diaAtual;
			this.diaAtual = dataAgora;
		}
		return novaData;
	}

	private boolean trataVariaveisNovoDia() {
		try {
			PeriodoPregaoWSSoap periodoPregaoRC = this.locatorPeriodoPregao.getPeriodoPregaoWSSoap();
			PeriodoPregaoFiltro filtroPeriodoPregao = new PeriodoPregaoFiltro();
			filtroPeriodoPregao.setData(this.diaAtual);
			PeriodoPregaoObjetoWs novo = periodoPregaoRC.pesquisaPorDia(filtroPeriodoPregao);
			if (novo == null) {
				System.out.println("Periodo Pregao não encontrado");
				return false;
			}
			if ((this.periodoPregao == null)
					|| (this.periodoPregao.getIdPeriodoPregao() != novo.getIdPeriodoPregao())) {
				this.periodoPregao = novo;
			}
			DiaPregaoWSSoap diaPregaoRC = this.locatorDiaPregao.getDiaPregaoWSSoap();
			DiaPregaoObjetoWs diaPregaoPesquisa = new DiaPregaoObjetoWs();
			DiaPregaoFiltro filtroDiaPregao = new DiaPregaoFiltro();
			diaPregaoPesquisa.setData(this.diaAtual);
			filtroDiaPregao.setDiaPregaoPesquisa(diaPregaoPesquisa);
			DiaPregaoObjetoWs diaNovo = diaPregaoRC.obtemPorDiaPregaoData(filtroDiaPregao);
			if ((diaNovo == null) || (diaNovo.isFeriado()))
				this.existePregao = false;
			else
				this.existePregao = true;
			return true;
		} catch (AxisFault e1) {
			System.out.println("Erro:" + e1.getMessage());

			return false;
		} catch (ServiceException e2) {
			e2.printStackTrace();
			return false;
		} catch (RemoteException e3) {
			e3.printStackTrace();
		}
		return false;
	}

	private void trataThreadsNovoDia() {
		if (this.listaThreads != null)
			limpaThreadsLista();
		if (this.existePregao) {
			List listaTicker = obtemListaTicker();
			disparaThreadsLista(listaTicker);
		}
	}

	protected abstract List obtemListaTicker();

	private void limpaThreadsLista() {
		Iterator itThreads = this.listaThreads.iterator();
		while (itThreads.hasNext()) {
			PesquisadorTicker timerThread = (PesquisadorTicker) itThreads.next();
			timerThread.cancel();
			timerThread = null;
		}
		this.listaThreads = null;
	}

	private void disparaThreadsLista(List listaTicker) {
		int ms = 60000 * minutos();
		this.timer = new Timer();
		Iterator it = listaTicker.iterator();
		RestricaoTempo restricao = getRestricaoTempo(this.periodoPregao);
		if (this.listaThreads == null)
			this.listaThreads = new ArrayList();
		while (it.hasNext()) {
			String ticker = (String) it.next();

			PesquisadorTicker timerThread = getPesquisador();
			timerThread.inicializa(ticker, restricao);
			this.timer.schedule(timerThread, 0L, ms);
			this.listaThreads.add(timerThread);
		}
	}

	protected abstract PesquisadorTicker getPesquisador();

	protected abstract int minutos();

	private void verificaMudancaMes() {
		if (this.diaAtual.substring(3, 5).compareTo(this.diaAnterior.substring(3, 5)) != 0)
			mudouMes(this.diaAtual, this.diaAnterior);
	}

	private void verificaMudancaAno() {
		if (this.diaAtual.substring(6).compareTo(this.diaAnterior.substring(6)) != 0)
			mudouAno(this.diaAtual, this.diaAnterior);
	}

	public void run() {
		boolean mudouDia = verificaMudancaDia();
		if (mudouDia) {
			this.dadosParaCarregar = true;
			if (this.diaAnterior.length() > 0) {
				mudouDia(this.diaAtual, this.diaAnterior, this.existePregao);
				verificaMudancaMes();
				verificaMudancaAno();
			}
		}
		try {
			if ((mudouDia) || (this.dadosParaCarregar)) {
				boolean carregou = trataVariaveisNovoDia();
				this.dadosParaCarregar = (!carregou);
				if (carregou)
					trataThreadsNovoDia();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ArquivoLog.getInstancia().salvaLog("Erro ThreadPaiBase" + e);
		}
	}

	private RestricaoTempo getRestricaoTempo(PeriodoPregaoObjetoWs periodo) {
		Tempo restricao = new Tempo();
		int horaInicial = Integer.parseInt(periodo.getHoraInicio().substring(0, 2));
		int horaFinal = Integer.parseInt(periodo.getHoraTermino().substring(0, 2));
		restricao.inicializaHorarios(horaInicial, horaFinal);
		return restricao;
	}
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.threads.ThreadPaiBase JD-Core Version: 0.6.0
 */
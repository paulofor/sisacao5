package sisacao.intraday.coletor.thread;

import java.util.TimerTask;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.ArquivoLog;
import br.com.digicom.parse.log.DatasUtils;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioCriptomoedaBase;
import sisacao.intraday.coletor.agregador.AgregadorThread;

public abstract class ThreadPaiBase extends TimerTask {

	private String diaAtual = null;
	private String diaAnterior = null;
	private boolean existePregao;

	private AgregadorThread agregador = null;

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	RepositorioCriptomoedaBase.AtivoCriptomoedaRepository repCripto  = adapter.createRepository(RepositorioCriptomoedaBase.AtivoCriptomoedaRepository.class);

	public ThreadPaiBase() {
		// this.locatorPeriodoPregao = new PeriodoPregaoWSLocator();
		// this.locatorDiaPregao = new DiaPregaoWSLocator();
		this.diaAtual = "";
		this.agregador = getAgregador();
	}

	protected abstract AgregadorThread getAgregador();

	@Override
	public void run() {
		boolean mudouDia = verificaMudancaDia();
		System.out.println("Novo dia ?:" + mudouDia + ", diaAtual: " + this.diaAtual);
		if (mudouDia) {
			System.out.println("[debug] ThreadPaiBase.run: diaAtual:" + diaAtual + ", diaAnterior:" + diaAnterior);
			try {
	
				if (this.diaAnterior.length() > 0) {
					mudouDia(this.diaAtual, this.diaAnterior, true);
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.exit(0);
				} else {
					this.mudouDiaColetores(diaAtual);
				}
				
			} catch (DaoException e) {
				ArquivoLog.getInstancia().salvaLog("Erro ThreadPaiBase" + e);
				e.printStackTrace();
			}

		}
	}



	
	protected abstract void mudouDia(String paramString1, String paramString2, boolean paramBoolean)
			throws DaoException;

	private boolean verificaMudancaDia() {
		String dataAgora = DatasUtils.getDataDD_MM_AAAA();
		boolean novaData = this.diaAtual.compareTo(dataAgora) != 0;
		if (novaData) {
			this.diaAnterior = this.diaAtual;
			this.diaAtual = dataAgora;
		}
		return novaData;
	}

	/*
	private boolean existePregao(String data) {
		diaSrv.getFiltro().setDataPesquisa(data);
		DiaPregao dia = null;
		try {
			dia = diaSrv.ObtemPorDataPesquisa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return (dia != null && !dia.getFeriado());
	}
	*/
	
	protected final void mudouDiaColetores(String novoDia) throws DaoException {
		agregador.limpaColetoresAtual();
   		agregador.disparaColetoresDia(novoDia);
	}
}

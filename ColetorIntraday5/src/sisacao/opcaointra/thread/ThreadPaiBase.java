package sisacao.opcaointra.thread;

import java.util.TimerTask;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.ArquivoLog;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.modelo.DiaPregao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;



public abstract class ThreadPaiBase extends TimerTask {

	
	private String diaAtual = null;
	private String diaAnterior = null;
	private boolean existePregao;
	
	private DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	
	public ThreadPaiBase() {
		//this.locatorPeriodoPregao = new PeriodoPregaoWSLocator();
		//this.locatorDiaPregao = new DiaPregaoWSLocator();
		this.diaAtual = "";
	}
	
	
	@Override
	public void run() {
		//System.out.println("Verifica dia");
		boolean mudouDia = verificaMudancaDia();
		if (mudouDia) {
			//this.dadosParaCarregar = true;
			if (this.diaAnterior.length() > 0) {
				try {
					mudouDia(this.diaAtual, this.diaAnterior, existePregao(diaAnterior));
				} catch (DaoException e) {
					ArquivoLog.getInstancia().salvaLog("Erro ThreadPaiBase" + e);
					e.printStackTrace();
				}
				//verificaMudancaMes();
				//verificaMudancaAno();
			}
		}
//		try {
//			if ((mudouDia) || (this.dadosParaCarregar)) {
//				boolean carregou = trataVariaveisNovoDia();
//				this.dadosParaCarregar = (!carregou);
//				if (carregou)
//					trataThreadsNovoDia();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			//ArquivoLog.getInstancia().salvaLog("Erro ThreadPaiBase" + e);
//		}
		
	}
	
	protected abstract void mudouDia(String paramString1, String paramString2, boolean paramBoolean) throws DaoException;

	private boolean verificaMudancaDia() {
		String dataAgora = DatasUtils.getDataDD_MM_AAAA();
		boolean novaData = this.diaAtual.compareTo(dataAgora) != 0;
		if (novaData) {
			this.diaAnterior = this.diaAtual;
			this.diaAtual = dataAgora;
		}
		return novaData;
	}
	
	private boolean existePregao(String data) {
		diaSrv.getFiltro().setDataPesquisa(data);
		DiaPregao dia = null;
		try {
			dia = diaSrv.ObtemPorDataPesquisa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return (dia!=null && !dia.getFeriado());
	}

}

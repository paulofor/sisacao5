package sisacao.app.thread;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import sisacao.app.util.CriaListaHorario;
import sisacao.app.util.DatasUtils15;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.util.DatasUtils;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;

public class Timer1para15 extends TimerTask {

	private String nomeTicker;
	private List<CotacaoProcessada> listaCotacaoTempo;
	private int posicao;
	private boolean fimDoDia;
	private Date diaAtual;
	
	private CotacaoRegraColecao cotacaoRC = FabricaRegra.getInstancia().getCotacaoRegraColecao();
	private CotacaoProcessadaRegraColecao cotProcRC = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();

	public void posicionaNaLista() {
		this.posicao = 0;
		CotacaoProcessada cotacao = (CotacaoProcessada) this.listaCotacaoTempo.get(posicao);
		while ((this.posicao < this.listaCotacaoTempo.size()) && (DatasUtils15.jaPassou(cotacao))) {
			this.posicao += 1;
			if (this.listaCotacaoTempo.size() > this.posicao)
				cotacao = (CotacaoProcessada) this.listaCotacaoTempo.get(this.posicao);
		}
	}

	private CotacaoProcessada getCorrente() {
		if (this.posicao>=listaCotacaoTempo.size()) return null;
		CotacaoProcessada corrente = (CotacaoProcessada) this.listaCotacaoTempo.get(this.posicao);
		return corrente;
	}

	public void setListaCotacaoTempo(List lista) {
		this.listaCotacaoTempo = lista;
		posicionaNaLista();
	}

	public Timer1para15(String nomeTicker) {
		this.nomeTicker = nomeTicker;
		this.diaAtual = DatasUtils.diaAtual();
	}

	private void atualizaValor(CotacaoProcessada hora) throws DaoException {
		System.out.println("Procedimento de Atualizacao: (" + this.nomeTicker + ") : " + hora.getHoraSerieTemporal());
		cotacaoRC.getFiltro().setNomeTicker(this.nomeTicker);
		Cotacao cotacao = cotacaoRC.ObtemMaisRecente();
		hora.setHoraCotacao(cotacao.getHoraReal());
		hora.setValor(cotacao.getUlt());
		hora.setNegocios(cotacao.getNeg());
		hora.setData(DatasUtils.getDataDD_MM_AAAA());
		hora.setValorCorrigido(cotacao.getUlt());
		CotacaoProcessadaDaoThread daoTh = new CotacaoProcessadaDaoThread();
		daoTh.setCotacao(hora, this.nomeTicker);
		daoTh.start();
	}

	protected void novaData() {
		this.posicao = 0;
	}

	protected void executa() throws DaoException {
		CotacaoProcessada corrente = getCorrente();
		if (corrente==null) {
			System.out.println("Fora de horário");
			return;
		}
		boolean passou = DatasUtils15.jaPassou(corrente);
		System.out.println("Resultado passou = " + passou);
		if (passou) {
			this.posicao += 1;
			atualizaValor(corrente);
		}
	}

	@Override
	public void run() {
		try {
			executa();
		} catch (DaoException e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	

}

/*
 * Location: C:\Fontes\ProjetosJava2\Recuperacao-CotacaoJava15\Cotacao15\
 * Qualified Name: sisacaoweb2.timer.Timer1para15 JD-Core Version: 0.6.0
 */
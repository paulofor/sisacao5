package sisacao.deeplearning.desenvolvimento.dao;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinalDS;
import sisacao.deeplearning.desenvolvimento.processamento.TradePrevisao;

public class DatasetResultadoPrevisao implements IDatasetComum,
		DiaPregao_ObtemIntradayResultadoTickerAteFinalDS{

	private long idTreinoRede;
	private long diaNumInicial;
	private long diaNumFinal;
	private double valorLimite;
	
	private List<PrevisaoRede> listaPrevisao;
	
	private List<TradePrevisao> listaTrade = new LinkedList<TradePrevisao>();
	
	private TradePrevisao tradeCorrente = null;
	
	private List<DiaPregao> listaCotacaoResultado;
	private AtivoAcao ativoAcaoCorrente;
	
	// Intraday da Previsao
	private int tamanhoAmostra;
	private int diaNumInicio;
	
	private PrevisaoRede previsaoCorrente;
	
	
	
	
	private void adicionaTrade(TradePrevisao trade) {
		this.listaTrade.add(trade);
	}
	
	public boolean podeProcessar(PrevisaoRede previsao) {
		boolean saida = true;
		for (TradePrevisao trade : listaTrade) {
			if (trade.getTicker().compareTo(previsao.getTicker())==0) {
				if (previsao.getDiaNumPrevisao() <= trade.getDiaNumSaida() && previsao.getDiaNumPrevisao() >= trade.getDiaNumEntrada()) {
					saida = false;
					break;
				}
			}
		}
		return saida;
	}
	

	public long getIdTreinoRede() {
		return idTreinoRede;
	}

	public void setIdTreinoRede(long idTreinoRede) {
		this.idTreinoRede = idTreinoRede;
	}

	public long getDiaNumInicial() {
		return diaNumInicial;
	}

	public void setDiaNumInicial(long diaNumInicial) {
		this.diaNumInicial = diaNumInicial;
	}

	public long getDiaNumFinal() {
		return diaNumFinal;
	}

	public void setDiaNumFinal(long diaNumFinal) {
		this.diaNumFinal = diaNumFinal;
	}

	public double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(double valorLimite) {
		this.valorLimite = valorLimite;
	}

	public List<PrevisaoRede> getListaPrevisao() {
		return listaPrevisao;
	}

	public void setListaPrevisao(List<PrevisaoRede> listaPrevisao) {
		this.listaPrevisao = listaPrevisao;
	}

	public void criaTrade(PrevisaoRede previsao) {
		this.tradeCorrente = new TradePrevisao(previsao);
		this.adicionaTrade(tradeCorrente);
	}

	public void setListaCotacaoResultado(List<DiaPregao> listaCotacao) {
		this.listaCotacaoResultado = listaCotacao;
		
		
	}

	public List<TradePrevisao> getListaTrade() {
		return listaTrade;
	}

	public void setListaTrade(List<TradePrevisao> listaTrade) {
		this.listaTrade = listaTrade;
	}

	public TradePrevisao getTradeCorrente() {
		return tradeCorrente;
	}

	public void setTradeCorrente(TradePrevisao tradeCorrente) {
		this.tradeCorrente = tradeCorrente;
	}

	public AtivoAcao getAtivoAcaoCorrente() {
		return ativoAcaoCorrente;
	}

	public void setAtivoAcaoCorrente(AtivoAcao ativoAcaoCorrente) {
		this.ativoAcaoCorrente = ativoAcaoCorrente;
	}


	public List<DiaPregao> getListaCotacaoResultado() {
		return listaCotacaoResultado;
	}

	public int getTamanhoAmostra() {
		return tamanhoAmostra;
	}

	public void setTamanhoAmostra(int tamanhoAmostra) {
		this.tamanhoAmostra = tamanhoAmostra;
	}

	public int getDiaNumInicio() {
		return diaNumInicio;
	}

	public void setDiaNumInicio(int diaNumInicio) {
		this.diaNumInicio = diaNumInicio;
	}

	public PrevisaoRede getPrevisaoCorrente() {
		return previsaoCorrente;
	}

	public void setPrevisaoCorrente(PrevisaoRede previsaoCorrente) {
		this.previsaoCorrente = previsaoCorrente;
	}

	



	
	
	
}

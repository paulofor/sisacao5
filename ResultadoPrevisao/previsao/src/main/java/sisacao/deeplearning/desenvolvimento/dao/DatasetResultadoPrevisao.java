package sisacao.deeplearning.desenvolvimento.dao;

import java.util.LinkedList;
import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_CotacaoDiaDS;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinalDS;
import sisacao.deeplearning.comum.TradeI;
import sisacao.deeplearning.desenvolvimento.processamento.TradePrevisao;
import sisacao.deeplearning.execucao.processamento.TradePrevisaoExecucao;

public class DatasetResultadoPrevisao implements IDatasetComum,
		CotacaoDiarioAcao_CotacaoDiaDS,
		DiaPregao_ObtemIntradayResultadoTickerAteFinalDS{

	//private long idTreinoRede;
	//private long diaNumInicial;
	//private long diaNumFinal;
	//private double valorLimite;
	
	private final int LIMITE_TRADES_ABERTOS = 3;
	
	
	private List<PrevisaoTeste> listaPrevisao;
	
	private List<TradeI> listaTrade =  new LinkedList<TradeI>();
	
	private TradeI tradeCorrente = null;
	
	private List<DiaPregao> listaCotacaoResultado;
	private AtivoAcao ativoAcaoCorrente;
	
	// Intraday da Previsao
	private int tamanhoAmostra;
	private int diaNumInicio;
	
	private PrevisaoTeste previsaoCorrente;
	private PrevisaoRede previsaoExecucaoCorrente;
	
	private TreinoRede treinoCorrente;
	
	private int diaNumExecucao;
	
	private TradeTreinoRede tradeTreinoRede;
	
	private int diaNum;
	private String ticker;
	private CotacaoDiarioAcao cotacaoDiarioAcao;
	
	private DiaPregao diaPrevisaoCorrente;
	
	private List<DiaPregao> listaDiaPrevisao;
	
	
	
	
	public List<DiaPregao> getListaDiaPrevisao() {
		return listaDiaPrevisao;
	}

	public void setListaDiaPrevisao(List<DiaPregao> listaDiaPrevisao) {
		this.listaDiaPrevisao = listaDiaPrevisao;
	}

	public DiaPregao getDiaPrevisaoCorrente() {
		return diaPrevisaoCorrente;
	}

	public void setDiaPrevisaoCorrente(DiaPregao diaPrevisaoCorrente) {
		this.diaPrevisaoCorrente = diaPrevisaoCorrente;
	}

	public List<PrevisaoTeste> getListaPrevisao() {
		
		return listaPrevisao;
	}
	
	public TreinoRede getTreinoCorrente() {
		return treinoCorrente;
	}

	public void setTreinoCorrente(TreinoRede treinoCorrente) {
		this.treinoCorrente = treinoCorrente;
		if (this.listaTrade!=null) this.listaTrade.clear();
	}

	private void adicionaTrade(TradeI trade) {
		this.listaTrade.add(trade);
	}
	
	public boolean podeProcessar(PrevisaoTeste previsao) {
		if (listaTrade==null) return true;
		int abertos = abertosNaData(previsao);
		System.out.println("Abertos: " + abertos + "(" + previsao.getDiaNumPrevisao() + ")");
		if (abertos>=this.treinoCorrente.getSimultaneoTradeTeste()) return false;
		boolean saida = true;
		for (TradeI trade : listaTrade) {
			if (trade.getTicker().compareTo(previsao.getTicker())==0) {
				if (previsao.getDiaNumPrevisao() <= trade.getDiaNumSaida() && previsao.getDiaNumPrevisao() >= trade.getDiaNumEntrada()) {
					saida = false;
					break;
				}
			}
		}
		return saida;
	}
	public boolean podeProcessarTreinoCorrente(PrevisaoRede previsao) {
		TreinoRede treino = this.treinoCorrente;
		List<TradeTreinoRede> listaTrade = treino.getTradeTreinoRedes();
		if (listaTrade.size()>=LIMITE_TRADES_ABERTOS) {
			System.out.println("Limite de ativos");
			return false;
		}
		for (TradeTreinoRede trade : listaTrade) {
			if (previsao.getTicker().compareTo(trade.getTicker())==0) {
				System.out.println(trade.getTicker() + " está na carteeira");
				return false;
			}
		}
		return true;
	}
	
	
	private int abertosNaData(PrevisaoTeste previsao) {
		int total = 0;
		for (TradeI trade : listaTrade) {
			int diaPrevisao = previsao.getDiaNumPrevisao();
			long inicioTrade = trade.getDiaNumEntrada();
			int finalTrade = trade.getDiaNumSaida();
			if (diaPrevisao >= inicioTrade && diaPrevisao <= finalTrade) {
				total++;
			}
		}
		return total;
	}
	private int abertosNaData(PrevisaoRede previsao) {
		int total = 0;
		for (TradeI trade : listaTrade) {
			int diaPrevisao = previsao.getDiaNumPrevisao();
			long inicioTrade = trade.getDiaNumEntrada();
			int finalTrade = trade.getDiaNumSaida();
			if (diaPrevisao >= inicioTrade && diaPrevisao <= finalTrade) {
				total++;
			}
		}
		return total;
	}
	

	

	public void setListaPrevisao(List<PrevisaoTeste> listaPrevisao) {
		this.listaPrevisao = listaPrevisao;
	}

	public void criaTrade(PrevisaoTeste previsao) {
		this.tradeCorrente = new TradePrevisao(previsao);
		this.adicionaTrade(tradeCorrente);
	}
	public void criaTrade(PrevisaoRede previsao) {
		this.tradeCorrente = new TradePrevisaoExecucao(previsao);
		this.adicionaTrade(tradeCorrente);
	}

	public void setListaCotacaoResultado(List<DiaPregao> listaCotacao) {
		this.listaCotacaoResultado = listaCotacao;
		
		
	}

	public List<TradeI> getListaTrade() {
		return listaTrade;
	}

	public void setListaTrade(List<TradeI> listaTrade) {
		this.listaTrade = listaTrade;
	}

	public TradeI getTradeCorrente() {
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

	public PrevisaoTeste getPrevisaoCorrente() {
		return previsaoCorrente;
	}

	public void setPrevisaoCorrente(PrevisaoTeste previsaoCorrente) {
		this.previsaoCorrente = previsaoCorrente;
	}

	public void setPrevisaoExecucaoCorrente(PrevisaoRede previsao) {
		this.previsaoExecucaoCorrente = previsao;
	}
	public PrevisaoRede getPrevisaoExecucaoCorrente() {
		return previsaoExecucaoCorrente;
	}

	public int getDiaNumExecucao() {
		return diaNumExecucao;
	}

	public void setDiaNumExecucao(int diaNumExecucao) {
		this.diaNumExecucao = diaNumExecucao;
	}

	public TradeTreinoRede getTradeTreinoRede() {
		return tradeTreinoRede;
	}

	public void setTradeTreinoRede(TradeTreinoRede tradeTreinoRede) {
		this.tradeTreinoRede = tradeTreinoRede;
	}

	public int getDiaNum() {
		return diaNum;
	}

	public void setDiaNum(int diaNum) {
		this.diaNum = diaNum;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public CotacaoDiarioAcao getCotacaoDiarioAcao() {
		return cotacaoDiarioAcao;
	}

	public void setCotacaoDiarioAcao(CotacaoDiarioAcao cotacaoDiarioAcao) {
		this.cotacaoDiarioAcao = cotacaoDiarioAcao;
	}

	

	

	
	
	
	
	
}

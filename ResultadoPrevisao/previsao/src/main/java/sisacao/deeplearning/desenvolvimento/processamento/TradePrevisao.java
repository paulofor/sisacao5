package sisacao.deeplearning.desenvolvimento.processamento;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.PrevisaoTeste;

public class TradePrevisao {
	
	private PrevisaoTeste previsao;
	
	public TradePrevisao(PrevisaoTeste previsao) {
		this.previsao = previsao;
		this.previsao.setDiaNumSaida(99999999);
		
	}
	public PrevisaoTeste getPrevisao() {
		return this.previsao;
	}
	public void saidaTrade(PrevisaoTeste previsao) {
		this.previsao = previsao;
	}
	
	public void saidaInferior(CotacaoDiarioAcao cotacao) {
		this.previsao.setPrecoSaida(this.limiteInferior());
		this.previsao.setDiaNumSaida(cotacao.getDiaNum());
		if ("V".contentEquals(previsao.getTipoCompraVenda())) {
			// lucro
			this.previsao.setResultado(1L);
		} else {
			// prejuizo
			this.previsao.setResultado(-1L);
		}
	}

	public void saidaSuperior(CotacaoDiarioAcao cotacao) {
		this.previsao.setPrecoSaida(this.limiteSuperior());
		this.previsao.setDiaNumSaida(cotacao.getDiaNum());
		if ("V".contentEquals(previsao.getTipoCompraVenda())) {
			// prejuizo
			this.previsao.setResultado(-1L);
		} else {
			// lucro
			this.previsao.setResultado(1L);
		}
		
	}
	
	public double limiteInferior() {
		if ("V".contentEquals(previsao.getTipoCompraVenda())) {
			return previsao.getPrecoEntrada() * (1-previsao.getTarget());
		} else {
			return previsao.getPrecoEntrada() * (1-previsao.getStop());
		}
	}
	public double limiteSuperior() {
		if ("V".contentEquals(previsao.getTipoCompraVenda())) {
			return previsao.getPrecoEntrada() * (1+previsao.getStop());
		} else {
			return previsao.getPrecoEntrada() * (1+previsao.getTarget());
		}
	}
	
	
	public long getDiaNumEntrada() {
		return previsao.getDiaNumPrevisao();
	}
	
	public String getTicker() {
		return previsao.getTicker();
	}
	
	public Double getValorEntrada() {
		return previsao.getPrecoEntrada();
	}
	
	public String getTipoCompraVenda() {
		return this.previsao.getTipoCompraVenda();
	}

	public int getDiaNumSaida() {
		return this.previsao.getDiaNumSaida();
	}

	
		
	

}

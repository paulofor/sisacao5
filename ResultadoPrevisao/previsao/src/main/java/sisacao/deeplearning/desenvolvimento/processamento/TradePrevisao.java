package sisacao.deeplearning.desenvolvimento.processamento;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import sisacao.deeplearning.comum.TradeI;

public class TradePrevisao implements TradeI{
	
	private PrevisaoTeste previsao;
	
	private boolean fechado = false;
	
	public boolean getFechado() {
		return fechado;
	}
	
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
		this.fechado = true;
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
		this.fechado = true;
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
	
	
	public int getDiaNumEntrada() {
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

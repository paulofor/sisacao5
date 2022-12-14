package sisacao.deeplearning.execucao.processamento;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import sisacao.deeplearning.comum.TradeI;

public class TradePrevisaoExecucao implements TradeI{
	
	private PrevisaoRede previsao;
	
	private boolean fechado = false;
	
	private double menorPreco = 9999999;
	private double maiorPreco = 0;
	private int dias = 0;
	
	
	
	public double getMenorPreco() {
		return menorPreco;
	}

	public double getMaiorPreco() {
		return maiorPreco;
	}

	public int getDias() {
		return dias;
	}

	public boolean getFechado() {
		return fechado;
	}

	public boolean verificaSaida(CotacaoDiarioAcao cotacao) {
		double limiteInferior = this.limiteInferior();
		double limiteSuperior = this.limiteSuperior();
		System.out.println("Limite Superior: " + limiteSuperior + " <= Maximo: " + cotacao.getMaximo());
		verificaMaiorMenor(cotacao);
		if (cotacao.getMaximo()>=limiteSuperior) {
			// Saiu superior
			System.out.println("-> Saiu superior - " + this.previsao.getTicker() + " " + this.dias + " dias.");
			this.saidaSuperior(cotacao);
			return true;
		}
		System.out.println("Limite Inferior: " + limiteInferior + ">= Minimo: " + cotacao.getMinimo());
		if (cotacao.getMinimo()<=limiteInferior) {
			// Saiu superior
			System.out.println("-> Saiu inferior - " + this.previsao.getTicker() + " " + this.dias + " dias.");;
			this.saidaInferior(cotacao);
			return true;
		}
		this.dias++;
		return false;
	}
	
	public void verificaMaiorMenor(CotacaoDiarioAcao cotacao) {
		if (cotacao.getMaximo() > this.maiorPreco) {
			this.maiorPreco = cotacao.getMaximo();
		}
		if (cotacao.getMinimo() < this.menorPreco) {
			this.menorPreco = cotacao.getMinimo();
		}
	}
	
	public TradePrevisaoExecucao(PrevisaoRede previsao) {
		this.previsao = previsao;
		this.previsao.setDiaNumSaida(99999999);
		
	}
	public PrevisaoRede getPrevisao() {
		return this.previsao;
	}
	public void saidaTrade(PrevisaoRede previsao) {
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
		this.getFechado();
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

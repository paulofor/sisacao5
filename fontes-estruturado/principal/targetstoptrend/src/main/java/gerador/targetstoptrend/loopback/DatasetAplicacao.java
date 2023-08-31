package gerador.targetstoptrend.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private FechamentoRegraDia fechamentoRegraDiaCorrente;
	private AtivoAcao ativoCorrente;
	private CotacaoIntradayAcaoResultado entrada;
	private CotacaoIntradayAcaoResultado pontoSaida;
	private List<CotacaoIntradayAcaoResultado> possivelSaida;
	private int resultado;
	private int passo;


	public void setFechamentoRegraDiaCorrente(FechamentoRegraDia valor) { 
		this.fechamentoRegraDiaCorrente = valor;
	}
	public FechamentoRegraDia getFechamentoRegraDiaCorrente() { 
		return this.fechamentoRegraDiaCorrente;
	}
	public void setAtivoCorrente(AtivoAcao valor) { 
		this.ativoCorrente = valor;
	}
	public AtivoAcao getAtivoCorrente() { 
		return this.ativoCorrente;
	}
	public void setEntrada(CotacaoIntradayAcaoResultado valor) { 
		this.entrada = valor;
	}
	public CotacaoIntradayAcaoResultado getEntrada() { 
		return this.entrada;
	}
	public void setPontoSaida(CotacaoIntradayAcaoResultado valor) { 
		this.pontoSaida = valor;
	}
	public CotacaoIntradayAcaoResultado getPontoSaida() { 
		return this.pontoSaida;
	}
	public void setPossivelSaida(List<CotacaoIntradayAcaoResultado> valor) { 
		this.possivelSaida = valor;
	}
	public List<CotacaoIntradayAcaoResultado> getPossivelSaida() { 
		return this.possivelSaida;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setPasso(int valor) { 
		this.passo = valor;
	}
	public int getPasso() { 
		return this.passo;
	}
}

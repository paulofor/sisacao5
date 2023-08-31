package gerador.resultadoprevisaoapp.loopback;


import br.com.gersis.daobase.IDatasetComum;
import br.com.gersis.loopback.modelo.*;
import java.util.List;

public class DatasetAplicacao  implements IDatasetComum {
	private TreinoRede treinoCorrente;
	private PrevisaoTeste previsaoCorrente;
	private int diaNumInicio;
	private int tamanhoAmostra;
	private String ticker;
	private List<DiaPregao> listaCotacaoResultado;


	public void setTreinoCorrente(TreinoRede valor) { 
		this.treinoCorrente = valor;
	}
	public TreinoRede getTreinoCorrente() { 
		return this.treinoCorrente;
	}
	public void setPrevisaoCorrente(PrevisaoTeste valor) { 
		this.previsaoCorrente = valor;
	}
	public PrevisaoTeste getPrevisaoCorrente() { 
		return this.previsaoCorrente;
	}
	public void setDiaNumInicio(int valor) { 
		this.diaNumInicio = valor;
	}
	public int getDiaNumInicio() { 
		return this.diaNumInicio;
	}
	public void setTamanhoAmostra(int valor) { 
		this.tamanhoAmostra = valor;
	}
	public int getTamanhoAmostra() { 
		return this.tamanhoAmostra;
	}
	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setListaCotacaoResultado(List<DiaPregao> valor) { 
		this.listaCotacaoResultado = valor;
	}
	public List<DiaPregao> getListaCotacaoResultado() { 
		return this.listaCotacaoResultado;
	}
}

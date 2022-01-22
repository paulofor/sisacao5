package sisacao.dataset.treino.singleton;

import java.util.List;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public class DatasetComum {
	
	private RegraProjecao regraProjecao = null;
	private int inicioPeriodo = 0;
	private String ticker = null;
	private List<DiaPregao> listaPregao;

	public RegraProjecao getRegraProjecao() {
		return regraProjecao;
	}

	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}

	public int getInicioPeriodo() {
		return inicioPeriodo;
	}

	public void setInicioPeriodo(int inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public List<DiaPregao> getListaPregao() {
		return listaPregao;
	}

	public void setListaPregao(List<DiaPregao> listaPregao) {
		this.listaPregao = listaPregao;
	}

	
	
	


}

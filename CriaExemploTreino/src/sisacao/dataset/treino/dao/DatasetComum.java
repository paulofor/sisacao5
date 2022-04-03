package sisacao.dataset.treino.dao;

import java.util.List;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.IDatasetComum;

public class DatasetComum implements IDatasetComum {
	
	private RegraProjecao regraProjecao = null;
	private int inicioPeriodo = 0;
	private String ticker = null;
	private List<DiaPregao> listaPregao;
	private String codigoRegra;
	private int quantidadeDiasX = 0;
	
	

	public int getQuantidadeDiasX() {
		return quantidadeDiasX;
	}

	public void setQuantidadeDiasX(int quantidadeDiasX) {
		this.quantidadeDiasX = quantidadeDiasX;
	}

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

	

	public void setCodigoRegra(String codigoRegra) {
		this.codigoRegra = codigoRegra;
	}
	public String getCodigoRegra() {
		return this.codigoRegra;
	}
	
	
	


}

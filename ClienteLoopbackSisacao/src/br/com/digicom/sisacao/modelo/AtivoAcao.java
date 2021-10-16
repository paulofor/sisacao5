package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class AtivoAcao extends Ativo{

	
	private String ticker;
	private String nome;
	private Integer intraday5;
	private Integer intraday15;
	private Integer intraday30;
	private Integer intraday10;
	
	private List<ExecucaoSimulacao> execucaoSimulacaos;
	
	
	
	
	public Integer getIntraday10() {
		return intraday10;
	}
	public void setIntraday10(Integer intraday10) {
		this.intraday10 = intraday10;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIntraday5() {
		return intraday5;
	}
	public void setIntraday5(Integer intraday5) {
		this.intraday5 = intraday5;
	}
	public Integer getIntraday15() {
		return intraday15;
	}
	public void setIntraday15(Integer intraday15) {
		this.intraday15 = intraday15;
	}
	public Integer getIntraday30() {
		return intraday30;
	}
	public void setIntraday30(Integer intraday30) {
		this.intraday30 = intraday30;
	}
	public List<ExecucaoSimulacao> getExecucaoSimulacaos() {
		return execucaoSimulacaos;
	}
	public void setExecucaoSimulacaos(List<ExecucaoSimulacao> execucaoSimulacaos) {
		this.execucaoSimulacaos = new ArrayList<ExecucaoSimulacao>();
		for (int i = 0; i < execucaoSimulacaos.size(); i++) {
			Object objeto = new ExecucaoSimulacao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) execucaoSimulacaos.get(i), true);
			this.execucaoSimulacaos.add((ExecucaoSimulacao) objeto);
		}
	}
	
	
	
}

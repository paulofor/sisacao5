package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ExecucaoSimulacao extends Model{
	
	Integer quantidadeLucro;
	Integer quantidadePrejuizo;
	String ticker;
	Integer combinacaoParametroId;
	
	List<Trade> trades;

	public Integer getQuantidadeLucro() {
		return quantidadeLucro;
	}

	public void setQuantidadeLucro(Integer quantidadeLucro) {
		this.quantidadeLucro = quantidadeLucro;
	}

	public Integer getQuantidadePrejuizo() {
		return quantidadePrejuizo;
	}

	public void setQuantidadePrejuizo(Integer quantidadePrejuizo) {
		this.quantidadePrejuizo = quantidadePrejuizo;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Integer getCombinacaoParametroId() {
		return combinacaoParametroId;
	}

	public void setCombinacaoParametroId(Integer combinacaoParametroId) {
		this.combinacaoParametroId = combinacaoParametroId;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = new ArrayList<Trade>();
		for (int i = 0; i < trades.size(); i++) {
			Object objeto = new Trade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) trades.get(i), true);
			this.trades.add((Trade) objeto);
		}
	}
	
	

}

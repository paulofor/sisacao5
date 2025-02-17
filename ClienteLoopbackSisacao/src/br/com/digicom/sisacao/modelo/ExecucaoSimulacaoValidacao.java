package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ExecucaoSimulacaoValidacao extends Model{
	
	Integer quantidadeLucro;
	Integer quantidadePrejuizo;
	String ticker;
	Long combinacaoParametroId;
	Double target;
	Double stop;
	Double precoEntrada;
	Integer experimentoSimulacaoId;
	Integer id;
	Integer regraSimulacaoId;
	Integer periodoExperimentoId;
	String primeiraEntrada = "";
	String tipo;
	Integer execucaoSimulacaoId;
	Integer execucaoSimulacaoValidacaoId;
	
	List<Trade> trades = new ArrayList<Trade>();
	CombinacaoParametro combinacaoParametro = null;
	
	final int PESO_ZERADAS_PADRAO = 2;
	final int PESO_ZERADAS_8MESES = 3;
	
	public Integer getRegraSimulacaoId() {
		return regraSimulacaoId;
	}


	public void setRegraSimulacaoId(Integer regraSimulacaoId) {
		this.regraSimulacaoId = regraSimulacaoId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public CombinacaoParametro getCombinacaoParametro() {
		return combinacaoParametro;
	}


	public void setCombinacaoParametro(Object combinacaoParametro) {
		this.combinacaoParametro = new CombinacaoParametro();;
		BeanUtil.setProperties(this.combinacaoParametro, (Map<String, ? extends Object>) combinacaoParametro, true);
	}


	public Integer getExperimentoSimulacaoId() {
		return experimentoSimulacaoId;
	}


	public void setExperimentoSimulacaoId(Integer experimentoSimulacaoId) {
		this.experimentoSimulacaoId = experimentoSimulacaoId;
	}


	public Double getPrecoEntrada() {
		return precoEntrada;
	}


	public void setPrecoEntrada(Double precoEntrada) {
		this.precoEntrada = precoEntrada;
	}


	public Double getTarget() {
		return target;
	}


	public void setTarget(Double target) {
		this.target = target;
	}


	public Double getStop() {
		return stop;
	}


	public void setStop(Double stop) {
		this.stop = stop;
	}


	private int getPesoZeradas() {
		if (this.periodoExperimentoId == 3) 
			return PESO_ZERADAS_8MESES;
		return PESO_ZERADAS_PADRAO;
	}
	
	public JSONObject jSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("quantidadeLucro", this.quantidadeLucro);
			obj.put("quantidadePrejuizo", this.quantidadePrejuizo);
			obj.put("ticker", this.ticker);
			obj.put("combinacaoParametroId", this.combinacaoParametroId);
			obj.put("experimentoSimulacaoId", this.experimentoSimulacaoId);
			if (this.execucaoSimulacaoId!=null)
				obj.put("execucaoSimulacaoId", this.execucaoSimulacaoId);
			if (this.execucaoSimulacaoValidacaoId!=null)
				obj.put("execucaoSimulacaoValidacaoId", this.execucaoSimulacaoValidacaoId);
			obj.put("target", target);
			obj.put("stop", stop);
			double resultado = (100*this.target*(this.quantidadeLucro+1)) - (100*this.stop*(this.quantidadePrejuizo+1)) +
					(getPesoZeradas() - (quantidadePrejuizo*getPesoZeradas()) );
			obj.put("resultado", resultado );
			obj.put("monitorar", 0);
			obj.put("id", this.id);
			obj.put("regraSimulacaoId", this.regraSimulacaoId);
			obj.put("periodoExperimentoId", this.periodoExperimentoId);
			obj.put("primeiraEntrada", this.primeiraEntrada);
			obj.put("tipo", tipo);
			JSONArray trades = new JSONArray();
			for (Trade trade : this.trades) {
				trades.put(trade.getJSON());
			}
			obj.put("trades", trades);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public void addTrade(Trade trade) {
		trades.add(trade);
	}

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

	public Long getCombinacaoParametroId() {
		return combinacaoParametroId;
	}

	public void setCombinacaoParametroId(Long combinacaoParametroId) {
		this.combinacaoParametroId = combinacaoParametroId;
	}
	public void setCombinacaoParametroId(Integer combinacaoParametroId) {
		this.combinacaoParametroId = combinacaoParametroId.longValue();
	}

	public List<Trade> getTrades() {
		return trades;
	}

	
	
	public Integer getExecucaoSimulacaoId() {
		return execucaoSimulacaoId;
	}


	public void setExecucaoSimulacaoId(Integer execucaoSimulacaoId) {
		this.execucaoSimulacaoId = execucaoSimulacaoId;
	}


	public Integer getPeriodoExperimentoId() {
		return periodoExperimentoId;
	}


	public void setPeriodoExperimentoId(Integer periodoExperimentoId) {
		this.periodoExperimentoId = periodoExperimentoId;
	}


	public void setTrades(List<Trade> trades) {
		this.trades = new ArrayList<Trade>();
		for (int i = 0; i < trades.size(); i++) {
			Object objeto = new Trade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) trades.get(i), true);
			this.trades.add((Trade) objeto);
		}
	}


	public String getPrimeiraEntrada() {
		return primeiraEntrada;
	}


	public void setPrimeiraEntrada(String primeiraEntrada) {
		this.primeiraEntrada = primeiraEntrada;
	}

	
	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Integer getExecucaoSimulacaoValidacaoId() {
		return execucaoSimulacaoValidacaoId;
	}


	public void setExecucaoSimulacaoValidacaoId(Integer execucaoSimulacaoValidacaoId) {
		this.execucaoSimulacaoValidacaoId = execucaoSimulacaoValidacaoId;
	}
	
	

}

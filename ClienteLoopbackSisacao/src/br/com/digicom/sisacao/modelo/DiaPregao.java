package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class DiaPregao extends Model{
	
	private List<CotacaoIntradayAcao> cotacaoIntradayAcaos;
	private List<CotacaoDiarioAcao> cotacaoDiarioAcaos;
	private List<CotacaoIntradayAcaoResultado> cotacaoDiarioAcaoResultados;
	
	private Integer diaNum;
	
	
	
	public List<CotacaoIntradayAcaoResultado> getCotacaoIntradayAcaoResultados() {
		return cotacaoDiarioAcaoResultados;
	}

	public void setCotacaoIntradayAcaoResultados(List<CotacaoIntradayAcaoResultado> cotacaoDiarioAcaoResultados) {
		this.cotacaoDiarioAcaoResultados = new ArrayList<CotacaoIntradayAcaoResultado>();
		for (int i = 0; i < cotacaoDiarioAcaoResultados.size(); i++) {
			Object objeto = new CotacaoIntradayAcaoResultado();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) cotacaoDiarioAcaoResultados.get(i), true);
			this.cotacaoDiarioAcaoResultados.add((CotacaoIntradayAcaoResultado) objeto);
		}
	}

	public List<CotacaoIntradayAcao> getCotacaoIntradayAcaos() {
		return cotacaoIntradayAcaos;
	}

	public void setCotacaoIntradayAcaos(List<CotacaoIntradayAcao> cotacaoIntradayAcaos) {
		this.cotacaoIntradayAcaos = new ArrayList<CotacaoIntradayAcao>();
		for (int i = 0; i < cotacaoIntradayAcaos.size(); i++) {
			Object objeto = new CotacaoIntradayAcao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) cotacaoIntradayAcaos.get(i), true);
			this.cotacaoIntradayAcaos.add((CotacaoIntradayAcao) objeto);
		}
	}

	public Integer getDiaNum() {
		return diaNum;
	}

	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}

	public List<CotacaoDiarioAcao> getCotacaoDiarioAcaos() {
		return cotacaoDiarioAcaos;
	}

	public void setCotacaoDiarioAcaos(List<CotacaoDiarioAcao> cotacaoDiarioAcaos) {
		this.cotacaoDiarioAcaos = new ArrayList<CotacaoDiarioAcao>();
		for (int i = 0; i < cotacaoDiarioAcaos.size(); i++) {
			Object objeto = new CotacaoDiarioAcao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) cotacaoDiarioAcaos.get(i), true);
			this.cotacaoDiarioAcaos.add((CotacaoDiarioAcao) objeto);
		}
	}
	
	

}

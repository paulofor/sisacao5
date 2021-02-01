package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class DiaPregao extends Model{
	
	private List<CotacaoIntradayAcao> cotacaoIntradayAcaos;
	
	private Integer diaNum;
	
	

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
	
	

}

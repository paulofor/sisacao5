package br.com.digicom.sisacao.modelo;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ExperimentoSimulacaoPeriodo extends Model{

	private PeriodoExperimento periodoExperimento;

	public PeriodoExperimento getPeriodoExperimento() {
		return periodoExperimento;
	}

	public void setPeriodoExperimento(HashMap periodoExperimento) {
		this.periodoExperimento = new PeriodoExperimento();
		BeanUtil.setProperties(this.periodoExperimento, (Map<String, ? extends Object>) periodoExperimento, true);
	}
	
	
}

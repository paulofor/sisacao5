package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ExperimentoSimulacao extends Model{

	private String codigo;
	private Integer quantidadeCombinacao;
	private Integer posicaoExecucao;
	private RegraSimulacao regraSimulacao;
	private Integer grupoAcaoId;
	private Integer id;
	//private String dataInicial;
	//private String dataFinal;
	
	//private int dataInicialNum;
	//private int dataFinalNum;
	
	private List<ExperimentoSimulacaoPeriodo> experimentoSimulacaoPeriodos;
	private PeriodoExperimento periodoExperimento = null;

	private boolean validacao = false;
	
	public void setValidacao() {
		validacao = true;
	}
	
	

	public PeriodoExperimento getPeriodoExperimento() {
		return periodoExperimento;
	}



	public void setPeriodoExperimento(Object periodoExperimento) {
		this.periodoExperimento = new PeriodoExperimento();
		BeanUtil.setProperties(this.periodoExperimento, (Map<String, ? extends Object>) periodoExperimento, true);
	}



	public void setExperimentoSimulacaoPeriodos(List<ExperimentoSimulacaoPeriodo> experimentoSimulacaoPeriodos) {
		this.experimentoSimulacaoPeriodos = new ArrayList<ExperimentoSimulacaoPeriodo>();
		for (int i = 0; i < experimentoSimulacaoPeriodos.size(); i++) {
			Object objeto = new ExperimentoSimulacaoPeriodo();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) experimentoSimulacaoPeriodos.get(i), true);
			this.experimentoSimulacaoPeriodos.add((ExperimentoSimulacaoPeriodo) objeto);
		}
	}
	
	
	/*
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
		String valorNum = dataInicial.substring(6) + dataInicial.substring(3,5) + dataInicial.substring(0,2);
		this.dataInicialNum = Integer.parseInt(valorNum);
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
		String valorNum = dataFinal.substring(6) + dataFinal.substring(3,5) + dataFinal.substring(0,2);
		this.dataFinalNum = Integer.parseInt(valorNum);
	}
	*/

	public Integer getGrupoAcaoId() {
		return grupoAcaoId;
	}

	public void setGrupoAcaoId(Integer grupoAcaoId) {
		this.grupoAcaoId = grupoAcaoId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidadeCombinacao() {
		return quantidadeCombinacao;
	}

	public void setQuantidadeCombinacao(Integer quantidadeCombinacao) {
		this.quantidadeCombinacao = quantidadeCombinacao;
	}

	public Integer getPosicaoExecucao() {
		return posicaoExecucao;
	}

	public void setPosicaoExecucao(Integer posicaoExecucao) {
		this.posicaoExecucao = posicaoExecucao;
	}

	public RegraSimulacao getRegraSimulacao() {
		return regraSimulacao;
	}

	public void setRegraSimulacao(Object regraSimulacao) {
		this.regraSimulacao = new RegraSimulacao();
		BeanUtil.setProperties(this.regraSimulacao, (Map<String, ? extends Object>) regraSimulacao, true);
	}

	public int diaInicio() {
		if (this.periodoExperimento==null) {
			throw new RuntimeException("Experimento sem periodo selecionado");
		}
		if (this.validacao) {
			return this.periodoExperimento.getDataNumInicioValidacao();
		} else {
			return this.periodoExperimento.getDataNumInicial();
		}
	}

	public int diaFinal() {
		if (this.periodoExperimento==null) {
			throw new RuntimeException("Experimento sem periodo selecionado");
		}
		if (this.validacao) {
			return this.periodoExperimento.getDataNumFinalValidacao();
		} else {
			return this.periodoExperimento.getDataNumFinal();
		}
	}
	public int diaInicioColeta() {
		if (this.periodoExperimento==null) {
			throw new RuntimeException("Experimento sem periodo selecionado");
		}
		return this.periodoExperimento.getDataNumInicioColeta();
	}
	public int periodoExperimentoId() {
		if (this.periodoExperimento==null) {
			throw new RuntimeException("Experimento sem periodo selecionado");
		}
		return this.periodoExperimento.getId();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

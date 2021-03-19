package br.com.digicom.sisacao.modelo;

import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ExperimentoSimulacao extends Model{

	private String codigo;
	private Integer quantidadeCombinacao;
	private Integer posicaoExecucao;
	private RegraSimulacao regraSimulacao;
	private Integer grupoAcaoId;
	private String dataInicial;
	private String dataFinal;
	
	private int dataInicialNum;
	private int dataFinalNum;

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
		return this.dataInicialNum;
	}

	public int diaFinal() {
		return this.dataFinalNum;
	}
	
	
	
}

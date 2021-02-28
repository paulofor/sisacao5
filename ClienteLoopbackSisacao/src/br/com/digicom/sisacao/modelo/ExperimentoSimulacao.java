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
	
}

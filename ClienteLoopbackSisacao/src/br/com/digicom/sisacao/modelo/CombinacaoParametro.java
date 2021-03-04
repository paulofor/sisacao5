package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class CombinacaoParametro extends Model{

	private Integer posicaoCombinacao;
	//private Long experimentoSimulacaoId;
	private String dataExecucao;
	private Integer id;
	
	private List<ValorParametro> valorParametros;
	
	
	
	public List<ValorParametro> getValorParametros() {
		return valorParametros;
	}

	public void setValorParametros(List<ValorParametro> valorParametros) {
		this.valorParametros = new ArrayList<ValorParametro>();
		for (int i = 0; i < valorParametros.size(); i++) {
			Object objeto = new ValorParametro();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valorParametros.get(i), true);
			this.valorParametros.add((ValorParametro) objeto);
		}
	}
	
	public Integer getPosicaoCombinacao() {
		return posicaoCombinacao;
	}
	public void setPosicaoCombinacao(Integer posicaoCombinacao) {
		this.posicaoCombinacao = posicaoCombinacao;
	}
	
	public String getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString() {
		String saida = "";
		for(ValorParametro valor : this.valorParametros) {
			saida += " " + valor;
		}
		return saida;
	}
	
}

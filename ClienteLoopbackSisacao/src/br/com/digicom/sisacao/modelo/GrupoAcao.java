package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class GrupoAcao extends Model {
	
	private Integer id;
	private String descricao;
	private Integer quantidade;
	private String nome;
	private List<RelGrupoAcao> relGrupoAcaos;
	
	
	
	public List<RelGrupoAcao> getRelGrupoAcaos() {
		return relGrupoAcaos;
	}
	public void setRelGrupoAcaos(List<HashMap> relGrupoAcaos) {
		this.relGrupoAcaos = new ArrayList<RelGrupoAcao>();
		for (int i = 0; i < relGrupoAcaos.size(); i++) {
			Object objeto = new RelGrupoAcao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) relGrupoAcaos.get(i), true);
			this.relGrupoAcaos.add((RelGrupoAcao) objeto);
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}

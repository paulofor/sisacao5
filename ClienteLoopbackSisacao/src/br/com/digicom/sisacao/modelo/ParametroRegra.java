package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class ParametroRegra extends Model{

	//private String tipo;
	private String nome;
	//private String descricao;
	private String atributoClasse;
	private Integer id;
	private String siglaDescricao;
	
	

	
	public String getSiglaDescricao() {
		return siglaDescricao;
	}

	public void setSiglaDescricao(String siglaDescricao) {
		this.siglaDescricao = siglaDescricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtributoClasse() {
		return atributoClasse;
	}

	public void setAtributoClasse(String atributoClasse) {
		this.atributoClasse = atributoClasse;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}

package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class ParametroRegra extends Model{

	//private String tipo;
	private String nome;
	//private String descricao;
	private String atributoClasse;

	
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

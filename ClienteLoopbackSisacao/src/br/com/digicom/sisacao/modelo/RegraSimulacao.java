package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class RegraSimulacao extends Model {

	private String nome;
	private String nomeClasse;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeClasse() {
		return nomeClasse;
	}
	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	
	
}

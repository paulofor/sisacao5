package br.com.digicom.sisacao.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class RegraSimulacao extends Model {

	private String nome;
	private String nomeClasse;
	private List<ParametroRegra> parametroRegras;
	
	
	
	public List<ParametroRegra> getParametroRegras() {
		return parametroRegras;
	}
	public void setParametroRegras(List<ParametroRegra> parametroRegras) {
		this.parametroRegras = new ArrayList<ParametroRegra>();
		for (int i = 0; i < parametroRegras.size(); i++) {
			Object objeto = new ParametroRegra();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) parametroRegras.get(i), true);
			this.parametroRegras.add((ParametroRegra) objeto);
		}
	}
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

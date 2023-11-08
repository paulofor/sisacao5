package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoRegra extends Model {


	private double targetInicial;
	private double targetFinal;
	private double targetPasso;
	private double stopInicial;
	private double stopFinal;
	private double stopPasso;
	private double diaLimiteInicial;
	private double diaLimiteFinal;
	private double diaLimitePasso;
	private String nome;
	private int quantidade;
	private int quantidadeDia;
	// Relacionamentos 1
	// Relacionamentos N
	private List<GrupoRegraRel> GrupoRegraRels;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("targetInicial", targetInicial);
			obj.put("targetFinal", targetFinal);
			obj.put("targetPasso", targetPasso);
			obj.put("stopInicial", stopInicial);
			obj.put("stopFinal", stopFinal);
			obj.put("stopPasso", stopPasso);
			obj.put("diaLimiteInicial", diaLimiteInicial);
			obj.put("diaLimiteFinal", diaLimiteFinal);
			obj.put("diaLimitePasso", diaLimitePasso);
			obj.put("nome", nome);
			obj.put("quantidade", quantidade);
			obj.put("quantidadeDia", quantidadeDia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTargetInicial(double valor) { 
		this.targetInicial = valor;
	}
	public double getTargetInicial() { 
		return this.targetInicial;
	}
	public void setTargetFinal(double valor) { 
		this.targetFinal = valor;
	}
	public double getTargetFinal() { 
		return this.targetFinal;
	}
	public void setTargetPasso(double valor) { 
		this.targetPasso = valor;
	}
	public double getTargetPasso() { 
		return this.targetPasso;
	}
	public void setStopInicial(double valor) { 
		this.stopInicial = valor;
	}
	public double getStopInicial() { 
		return this.stopInicial;
	}
	public void setStopFinal(double valor) { 
		this.stopFinal = valor;
	}
	public double getStopFinal() { 
		return this.stopFinal;
	}
	public void setStopPasso(double valor) { 
		this.stopPasso = valor;
	}
	public double getStopPasso() { 
		return this.stopPasso;
	}
	public void setDiaLimiteInicial(double valor) { 
		this.diaLimiteInicial = valor;
	}
	public double getDiaLimiteInicial() { 
		return this.diaLimiteInicial;
	}
	public void setDiaLimiteFinal(double valor) { 
		this.diaLimiteFinal = valor;
	}
	public double getDiaLimiteFinal() { 
		return this.diaLimiteFinal;
	}
	public void setDiaLimitePasso(double valor) { 
		this.diaLimitePasso = valor;
	}
	public double getDiaLimitePasso() { 
		return this.diaLimitePasso;
	}
	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setQuantidade(int valor) { 
		this.quantidade = valor;
	}
	public int getQuantidade() { 
		return this.quantidade;
	}
	public void setQuantidadeDia(int valor) { 
		this.quantidadeDia = valor;
	}
	public int getQuantidadeDia() { 
		return this.quantidadeDia;
	}

	public List<GrupoRegraRel> getGrupoRegraRels() {
		return  GrupoRegraRels;
	}
	public void setGrupoRegraRels(List<GrupoRegraRel> valores) {
		this.GrupoRegraRels = new ArrayList<GrupoRegraRel>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new GrupoRegraRel();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.GrupoRegraRels.add((GrupoRegraRel) objeto);
		}
	}
}

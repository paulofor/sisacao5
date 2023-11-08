package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class PreRedeNeural extends Model {


	private String nome;
	private String conceito;
	private String dataCriacao;
	private int finalizada;
	private int tipoExemploTreinoId1;
	private int tipoExemploTreinoId2;
	// Relacionamentos 1
	private PeriodoTreinoRede periodoTreinoRede;
	private TipoExemploTreino tipoExemploTreino1;
	private TipoExemploTreino tipoExemploTreino2;
	// Relacionamentos N
	private List<VersaoPreRede> versaoPreRedes;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("conceito", conceito);
			obj.put("dataCriacao", dataCriacao);
			obj.put("finalizada", finalizada);
			obj.put("tipoExemploTreinoId1", tipoExemploTreinoId1);
			obj.put("tipoExemploTreinoId2", tipoExemploTreinoId2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setConceito(String valor) { 
		this.conceito = valor;
	}
	public String getConceito() { 
		return this.conceito;
	}
	public void setDataCriacao(String valor) { 
		this.dataCriacao = valor;
	}
	public String getDataCriacao() { 
		return this.dataCriacao;
	}
	public void setFinalizada(int valor) { 
		this.finalizada = valor;
	}
	public int getFinalizada() { 
		return this.finalizada;
	}
	public void setTipoExemploTreinoId1(int valor) { 
		this.tipoExemploTreinoId1 = valor;
	}
	public int getTipoExemploTreinoId1() { 
		return this.tipoExemploTreinoId1;
	}
	public void setTipoExemploTreinoId2(int valor) { 
		this.tipoExemploTreinoId2 = valor;
	}
	public int getTipoExemploTreinoId2() { 
		return this.tipoExemploTreinoId2;
	}

	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return periodoTreinoRede;
	}
	public void setPeriodoTreinoRede(HashMap valor) {
		this.periodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.periodoTreinoRede, (Map<String, ? extends Object>) valor, true);
	}
	public TipoExemploTreino getTipoExemploTreino1() {
		return tipoExemploTreino1;
	}
	public void setTipoExemploTreino1(HashMap valor) {
		this.tipoExemploTreino1 = new TipoExemploTreino();
		BeanUtil.setProperties(this.tipoExemploTreino1, (Map<String, ? extends Object>) valor, true);
	}
	public TipoExemploTreino getTipoExemploTreino2() {
		return tipoExemploTreino2;
	}
	public void setTipoExemploTreino2(HashMap valor) {
		this.tipoExemploTreino2 = new TipoExemploTreino();
		BeanUtil.setProperties(this.tipoExemploTreino2, (Map<String, ? extends Object>) valor, true);
	}
	public List<VersaoPreRede> getVersaoPreRedes() {
		return  versaoPreRedes;
	}
	public void setVersaoPreRedes(List<VersaoPreRede> valores) {
		this.versaoPreRedes = new ArrayList<VersaoPreRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new VersaoPreRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.versaoPreRedes.add((VersaoPreRede) objeto);
		}
	}
}

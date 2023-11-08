package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class AmostraDadoSintetico extends Model {


	private String nome;
	private int qtdeExemplo;
	private double percentualSubida;
	private double percentualDescida;
	private double magnitudeTrend;
	private double magnitudeContraTrend;
	private double magnitudeRuido;
	private double percentualFlat;
	private double percentualContraTrend;
	private int tipoExemploTreinoId;
	private int qtdeAtivo;
	private int qtdeDiaColetado;
	// Relacionamentos 1
	private TipoExemploTreino TipoExemploTreino;
	// Relacionamentos N
	private List<ExemploDadoSintetico> ExemploDadoSinteticos;
	private List<ExperimentoPreRede> ExperimentoPreRedes;
	private List<ExperimentoPreRede> ExperimentoPreRedes;
	private List<ExemploDadoSinteticoTeste> ExemploDadoSinteticoTestes;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("qtdeExemplo", qtdeExemplo);
			obj.put("percentualSubida", percentualSubida);
			obj.put("percentualDescida", percentualDescida);
			obj.put("magnitudeTrend", magnitudeTrend);
			obj.put("magnitudeContraTrend", magnitudeContraTrend);
			obj.put("magnitudeRuido", magnitudeRuido);
			obj.put("percentualFlat", percentualFlat);
			obj.put("percentualContraTrend", percentualContraTrend);
			obj.put("tipoExemploTreinoId", tipoExemploTreinoId);
			obj.put("qtdeAtivo", qtdeAtivo);
			obj.put("qtdeDiaColetado", qtdeDiaColetado);
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
	public void setQtdeExemplo(int valor) { 
		this.qtdeExemplo = valor;
	}
	public int getQtdeExemplo() { 
		return this.qtdeExemplo;
	}
	public void setPercentualSubida(double valor) { 
		this.percentualSubida = valor;
	}
	public double getPercentualSubida() { 
		return this.percentualSubida;
	}
	public void setPercentualDescida(double valor) { 
		this.percentualDescida = valor;
	}
	public double getPercentualDescida() { 
		return this.percentualDescida;
	}
	public void setMagnitudeTrend(double valor) { 
		this.magnitudeTrend = valor;
	}
	public double getMagnitudeTrend() { 
		return this.magnitudeTrend;
	}
	public void setMagnitudeContraTrend(double valor) { 
		this.magnitudeContraTrend = valor;
	}
	public double getMagnitudeContraTrend() { 
		return this.magnitudeContraTrend;
	}
	public void setMagnitudeRuido(double valor) { 
		this.magnitudeRuido = valor;
	}
	public double getMagnitudeRuido() { 
		return this.magnitudeRuido;
	}
	public void setPercentualFlat(double valor) { 
		this.percentualFlat = valor;
	}
	public double getPercentualFlat() { 
		return this.percentualFlat;
	}
	public void setPercentualContraTrend(double valor) { 
		this.percentualContraTrend = valor;
	}
	public double getPercentualContraTrend() { 
		return this.percentualContraTrend;
	}
	public void setTipoExemploTreinoId(int valor) { 
		this.tipoExemploTreinoId = valor;
	}
	public int getTipoExemploTreinoId() { 
		return this.tipoExemploTreinoId;
	}
	public void setQtdeAtivo(int valor) { 
		this.qtdeAtivo = valor;
	}
	public int getQtdeAtivo() { 
		return this.qtdeAtivo;
	}
	public void setQtdeDiaColetado(int valor) { 
		this.qtdeDiaColetado = valor;
	}
	public int getQtdeDiaColetado() { 
		return this.qtdeDiaColetado;
	}

	public TipoExemploTreino getTipoExemploTreino() {
		return TipoExemploTreino;
	}
	public void setTipoExemploTreino(HashMap valor) {
		this.TipoExemploTreino = new TipoExemploTreino();
		BeanUtil.setProperties(this.TipoExemploTreino, (Map<String, ? extends Object>) valor, true);
	}
	public List<ExemploDadoSintetico> getExemploDadoSinteticos() {
		return  ExemploDadoSinteticos;
	}
	public void setExemploDadoSinteticos(List<ExemploDadoSintetico> valores) {
		this.ExemploDadoSinteticos = new ArrayList<ExemploDadoSintetico>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExemploDadoSintetico();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExemploDadoSinteticos.add((ExemploDadoSintetico) objeto);
		}
	}
	public List<ExperimentoPreRede> getExperimentoPreRedes() {
		return  ExperimentoPreRedes;
	}
	public void setExperimentoPreRedes(List<ExperimentoPreRede> valores) {
		this.ExperimentoPreRedes = new ArrayList<ExperimentoPreRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedes.add((ExperimentoPreRede) objeto);
		}
	}
	public List<ExperimentoPreRede> getExperimentoPreRedes() {
		return  ExperimentoPreRedes;
	}
	public void setExperimentoPreRedes(List<ExperimentoPreRede> valores) {
		this.ExperimentoPreRedes = new ArrayList<ExperimentoPreRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedes.add((ExperimentoPreRede) objeto);
		}
	}
	public List<ExemploDadoSinteticoTeste> getExemploDadoSinteticoTestes() {
		return  ExemploDadoSinteticoTestes;
	}
	public void setExemploDadoSinteticoTestes(List<ExemploDadoSinteticoTeste> valores) {
		this.ExemploDadoSinteticoTestes = new ArrayList<ExemploDadoSinteticoTeste>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExemploDadoSinteticoTeste();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExemploDadoSinteticoTestes.add((ExemploDadoSinteticoTeste) objeto);
		}
	}
}

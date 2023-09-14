package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExperimentoPreRede extends Model {


	private String nome;
	private int versaoPreRedeId;
	private int amostraDadoSinteticoEntrada1Id;
	private String nomeArquivoRede;
	private double mediaTotal;
	private double mediaResultadoPositivo;
	private double mediaResultadoNegativo;
	private double mediaResultadoNeutro;
	private double mediaY1;
	private double mediaY0;
	private int qtdeY1;
	private int qtdeY0;
	private double desvioTotal;
	private double desvioY1;
	private double desvioY0;
	private double desvioResultadoPositivo;
	private double desvioResultadoNeutro;
	private double desvioResultadoNegativo;
	private double mediaResultadoPositivoCtrl1;
	private double mediaResultadoPositivoCtrl2;
	private double mediaResultadoPositivoCtrl3;
	private double mediaResultadoNeutroCtrl1;
	private double mediaResultadoNeutroCtrl2;
	private double mediaResultadoNeutroCtrl3;
	private double mediaResultadoNegativoCtrl1;
	private double mediaResultadoNegativoCtrl2;
	private double mediaResultadoNegativoCtrl3;
	private int amostraDadoSinteticoEntrada2Id;
	private String geraScoreTesteSintetico;
	// Relacionamentos 1
	private VersaoPreRede VersaoPreRede;
	private AmostraDadoSintetico amostraDadoSinteticoEntrada1;
	private AmostraDadoSintetico amostraDadoSinteticoEntrada2;
	// Relacionamentos N
	private List<ExperimentoPreRedeTreinada> ExperimentoPreRedeTreinadas;
	private List<ExperimentoPreRedeResultado> ExperimentoPreRedeResultados;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("versaoPreRedeId", versaoPreRedeId);
			obj.put("amostraDadoSinteticoEntrada1Id", amostraDadoSinteticoEntrada1Id);
			obj.put("nomeArquivoRede", nomeArquivoRede);
			obj.put("mediaTotal", mediaTotal);
			obj.put("mediaResultadoPositivo", mediaResultadoPositivo);
			obj.put("mediaResultadoNegativo", mediaResultadoNegativo);
			obj.put("mediaResultadoNeutro", mediaResultadoNeutro);
			obj.put("mediaY1", mediaY1);
			obj.put("mediaY0", mediaY0);
			obj.put("qtdeY1", qtdeY1);
			obj.put("qtdeY0", qtdeY0);
			obj.put("desvioTotal", desvioTotal);
			obj.put("desvioY1", desvioY1);
			obj.put("desvioY0", desvioY0);
			obj.put("desvioResultadoPositivo", desvioResultadoPositivo);
			obj.put("desvioResultadoNeutro", desvioResultadoNeutro);
			obj.put("desvioResultadoNegativo", desvioResultadoNegativo);
			obj.put("mediaResultadoPositivoCtrl1", mediaResultadoPositivoCtrl1);
			obj.put("mediaResultadoPositivoCtrl2", mediaResultadoPositivoCtrl2);
			obj.put("mediaResultadoPositivoCtrl3", mediaResultadoPositivoCtrl3);
			obj.put("mediaResultadoNeutroCtrl1", mediaResultadoNeutroCtrl1);
			obj.put("mediaResultadoNeutroCtrl2", mediaResultadoNeutroCtrl2);
			obj.put("mediaResultadoNeutroCtrl3", mediaResultadoNeutroCtrl3);
			obj.put("mediaResultadoNegativoCtrl1", mediaResultadoNegativoCtrl1);
			obj.put("mediaResultadoNegativoCtrl2", mediaResultadoNegativoCtrl2);
			obj.put("mediaResultadoNegativoCtrl3", mediaResultadoNegativoCtrl3);
			obj.put("amostraDadoSinteticoEntrada2Id", amostraDadoSinteticoEntrada2Id);
			obj.put("geraScoreTesteSintetico", geraScoreTesteSintetico);
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
	public void setVersaoPreRedeId(int valor) { 
		this.versaoPreRedeId = valor;
	}
	public int getVersaoPreRedeId() { 
		return this.versaoPreRedeId;
	}
	public void setAmostraDadoSinteticoEntrada1Id(int valor) { 
		this.amostraDadoSinteticoEntrada1Id = valor;
	}
	public int getAmostraDadoSinteticoEntrada1Id() { 
		return this.amostraDadoSinteticoEntrada1Id;
	}
	public void setNomeArquivoRede(String valor) { 
		this.nomeArquivoRede = valor;
	}
	public String getNomeArquivoRede() { 
		return this.nomeArquivoRede;
	}
	public void setMediaTotal(double valor) { 
		this.mediaTotal = valor;
	}
	public double getMediaTotal() { 
		return this.mediaTotal;
	}
	public void setMediaResultadoPositivo(double valor) { 
		this.mediaResultadoPositivo = valor;
	}
	public double getMediaResultadoPositivo() { 
		return this.mediaResultadoPositivo;
	}
	public void setMediaResultadoNegativo(double valor) { 
		this.mediaResultadoNegativo = valor;
	}
	public double getMediaResultadoNegativo() { 
		return this.mediaResultadoNegativo;
	}
	public void setMediaResultadoNeutro(double valor) { 
		this.mediaResultadoNeutro = valor;
	}
	public double getMediaResultadoNeutro() { 
		return this.mediaResultadoNeutro;
	}
	public void setMediaY1(double valor) { 
		this.mediaY1 = valor;
	}
	public double getMediaY1() { 
		return this.mediaY1;
	}
	public void setMediaY0(double valor) { 
		this.mediaY0 = valor;
	}
	public double getMediaY0() { 
		return this.mediaY0;
	}
	public void setQtdeY1(int valor) { 
		this.qtdeY1 = valor;
	}
	public int getQtdeY1() { 
		return this.qtdeY1;
	}
	public void setQtdeY0(int valor) { 
		this.qtdeY0 = valor;
	}
	public int getQtdeY0() { 
		return this.qtdeY0;
	}
	public void setDesvioTotal(double valor) { 
		this.desvioTotal = valor;
	}
	public double getDesvioTotal() { 
		return this.desvioTotal;
	}
	public void setDesvioY1(double valor) { 
		this.desvioY1 = valor;
	}
	public double getDesvioY1() { 
		return this.desvioY1;
	}
	public void setDesvioY0(double valor) { 
		this.desvioY0 = valor;
	}
	public double getDesvioY0() { 
		return this.desvioY0;
	}
	public void setDesvioResultadoPositivo(double valor) { 
		this.desvioResultadoPositivo = valor;
	}
	public double getDesvioResultadoPositivo() { 
		return this.desvioResultadoPositivo;
	}
	public void setDesvioResultadoNeutro(double valor) { 
		this.desvioResultadoNeutro = valor;
	}
	public double getDesvioResultadoNeutro() { 
		return this.desvioResultadoNeutro;
	}
	public void setDesvioResultadoNegativo(double valor) { 
		this.desvioResultadoNegativo = valor;
	}
	public double getDesvioResultadoNegativo() { 
		return this.desvioResultadoNegativo;
	}
	public void setMediaResultadoPositivoCtrl1(double valor) { 
		this.mediaResultadoPositivoCtrl1 = valor;
	}
	public double getMediaResultadoPositivoCtrl1() { 
		return this.mediaResultadoPositivoCtrl1;
	}
	public void setMediaResultadoPositivoCtrl2(double valor) { 
		this.mediaResultadoPositivoCtrl2 = valor;
	}
	public double getMediaResultadoPositivoCtrl2() { 
		return this.mediaResultadoPositivoCtrl2;
	}
	public void setMediaResultadoPositivoCtrl3(double valor) { 
		this.mediaResultadoPositivoCtrl3 = valor;
	}
	public double getMediaResultadoPositivoCtrl3() { 
		return this.mediaResultadoPositivoCtrl3;
	}
	public void setMediaResultadoNeutroCtrl1(double valor) { 
		this.mediaResultadoNeutroCtrl1 = valor;
	}
	public double getMediaResultadoNeutroCtrl1() { 
		return this.mediaResultadoNeutroCtrl1;
	}
	public void setMediaResultadoNeutroCtrl2(double valor) { 
		this.mediaResultadoNeutroCtrl2 = valor;
	}
	public double getMediaResultadoNeutroCtrl2() { 
		return this.mediaResultadoNeutroCtrl2;
	}
	public void setMediaResultadoNeutroCtrl3(double valor) { 
		this.mediaResultadoNeutroCtrl3 = valor;
	}
	public double getMediaResultadoNeutroCtrl3() { 
		return this.mediaResultadoNeutroCtrl3;
	}
	public void setMediaResultadoNegativoCtrl1(double valor) { 
		this.mediaResultadoNegativoCtrl1 = valor;
	}
	public double getMediaResultadoNegativoCtrl1() { 
		return this.mediaResultadoNegativoCtrl1;
	}
	public void setMediaResultadoNegativoCtrl2(double valor) { 
		this.mediaResultadoNegativoCtrl2 = valor;
	}
	public double getMediaResultadoNegativoCtrl2() { 
		return this.mediaResultadoNegativoCtrl2;
	}
	public void setMediaResultadoNegativoCtrl3(double valor) { 
		this.mediaResultadoNegativoCtrl3 = valor;
	}
	public double getMediaResultadoNegativoCtrl3() { 
		return this.mediaResultadoNegativoCtrl3;
	}
	public void setAmostraDadoSinteticoEntrada2Id(int valor) { 
		this.amostraDadoSinteticoEntrada2Id = valor;
	}
	public int getAmostraDadoSinteticoEntrada2Id() { 
		return this.amostraDadoSinteticoEntrada2Id;
	}
	public void setGeraScoreTesteSintetico(String valor) { 
		this.geraScoreTesteSintetico = valor;
	}
	public String getGeraScoreTesteSintetico() { 
		return this.geraScoreTesteSintetico;
	}

	public VersaoPreRede getVersaoPreRede() {
		return VersaoPreRede;
	}
	public void setVersaoPreRede(HashMap valor) {
		this.VersaoPreRede = new VersaoPreRede();
		BeanUtil.setProperties(this.VersaoPreRede, (Map<String, ? extends Object>) valor, true);
	}
	public AmostraDadoSintetico getAmostraDadoSinteticoEntrada1() {
		return amostraDadoSinteticoEntrada1;
	}
	public void setAmostraDadoSinteticoEntrada1(HashMap valor) {
		this.amostraDadoSinteticoEntrada1 = new AmostraDadoSintetico();
		BeanUtil.setProperties(this.amostraDadoSinteticoEntrada1, (Map<String, ? extends Object>) valor, true);
	}
	public AmostraDadoSintetico getAmostraDadoSinteticoEntrada2() {
		return amostraDadoSinteticoEntrada2;
	}
	public void setAmostraDadoSinteticoEntrada2(HashMap valor) {
		this.amostraDadoSinteticoEntrada2 = new AmostraDadoSintetico();
		BeanUtil.setProperties(this.amostraDadoSinteticoEntrada2, (Map<String, ? extends Object>) valor, true);
	}
	public List<ExperimentoPreRedeTreinada> getExperimentoPreRedeTreinadas() {
		return  ExperimentoPreRedeTreinadas;
	}
	public void setExperimentoPreRedeTreinadas(List<ExperimentoPreRedeTreinada> valores) {
		this.ExperimentoPreRedeTreinadas = new ArrayList<ExperimentoPreRedeTreinada>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRedeTreinada();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeTreinadas.add((ExperimentoPreRedeTreinada) objeto);
		}
	}
	public List<ExperimentoPreRedeResultado> getExperimentoPreRedeResultados() {
		return  ExperimentoPreRedeResultados;
	}
	public void setExperimentoPreRedeResultados(List<ExperimentoPreRedeResultado> valores) {
		this.ExperimentoPreRedeResultados = new ArrayList<ExperimentoPreRedeResultado>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRedeResultado();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeResultados.add((ExperimentoPreRedeResultado) objeto);
		}
	}
}

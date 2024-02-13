package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExperimentoPreRedeTreinada extends Model {


	private String nome;
	private int experimentoPreRedeId;
	private int grupoAcaoId;
	private int regraProjecaoId;
	private String geraScore;
	private int periodoTreinoRedeId;
	private String dataComResultado;
	private String dataComScore;
	private int totalResultadoPositivo;
	private int totalResultadoNegativo;
	private int totalResultadoNeutro;
	private int totalResultadoPositivoCtrl1;
	private int totalResultadoPositivoCtrl2;
	private int totalResultadoPositivoCtrl3;
	private int totalResultadoNegativoCtrl1;
	private int totalResultadoNegativoCtrl2;
	private int totalResultadoNegativoCtrl3;
	private int totalResultadoNeutroCtrl1;
	private int totalResultadoNeutroCtrl2;
	private int totalResultadoNeutroCtrl3;
	private double percentualResultadoPositivo;
	private double percentualResultadoNegativo;
	private double percentualResultadoNeutro;
	private double percentualPositivoCtrl1;
	private double percentualPositivoCtrl2;
	private double percentualPositivoCtrl3;
	private double percentualNegativoCtrl1;
	private double percentualNegativoCtrl2;
	private double percentualNegativoCtrl3;
	private double percentualNeutroCtrl1;
	private double percentualNeutroCtrl2;
	private double percentualNeutroCtrl3;
	private int posicaoCtrl;
	// Relacionamentos 1
	private ExperimentoPreRede ExperimentoPreRede;
	private GrupoAcao GrupoAcao;
	private RegraProjecao RegraProjecao;
	private PeriodoTreinoRede PeriodoTreinoRede;
	// Relacionamentos N
	private List<ExperimentoPreRedeTreinadaScore> ExperimentoPreRedeTreinadaScores;
	private List<ExperimentoPreRedeTreinadaControle> ExperimentoPreRedeTreinadaControles;

	public void setId(Long id) {
		this.setIdObjeto(id);
	}
	public void setId(Integer id) {
		this.setIdObjeto(id);
	}

	public int getIdInteger() {
		return new Integer(getId().toString());
	}
	public long getIdLong() {
		return new Long(getId().toString());
	}

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("experimentoPreRedeId", experimentoPreRedeId);
			obj.put("grupoAcaoId", grupoAcaoId);
			obj.put("regraProjecaoId", regraProjecaoId);
			obj.put("geraScore", geraScore);
			obj.put("periodoTreinoRedeId", periodoTreinoRedeId);
			obj.put("dataComResultado", dataComResultado);
			obj.put("dataComScore", dataComScore);
			obj.put("totalResultadoPositivo", totalResultadoPositivo);
			obj.put("totalResultadoNegativo", totalResultadoNegativo);
			obj.put("totalResultadoNeutro", totalResultadoNeutro);
			obj.put("totalResultadoPositivoCtrl1", totalResultadoPositivoCtrl1);
			obj.put("totalResultadoPositivoCtrl2", totalResultadoPositivoCtrl2);
			obj.put("totalResultadoPositivoCtrl3", totalResultadoPositivoCtrl3);
			obj.put("totalResultadoNegativoCtrl1", totalResultadoNegativoCtrl1);
			obj.put("totalResultadoNegativoCtrl2", totalResultadoNegativoCtrl2);
			obj.put("totalResultadoNegativoCtrl3", totalResultadoNegativoCtrl3);
			obj.put("totalResultadoNeutroCtrl1", totalResultadoNeutroCtrl1);
			obj.put("totalResultadoNeutroCtrl2", totalResultadoNeutroCtrl2);
			obj.put("totalResultadoNeutroCtrl3", totalResultadoNeutroCtrl3);
			obj.put("percentualResultadoPositivo", percentualResultadoPositivo);
			obj.put("percentualResultadoNegativo", percentualResultadoNegativo);
			obj.put("percentualResultadoNeutro", percentualResultadoNeutro);
			obj.put("percentualPositivoCtrl1", percentualPositivoCtrl1);
			obj.put("percentualPositivoCtrl2", percentualPositivoCtrl2);
			obj.put("percentualPositivoCtrl3", percentualPositivoCtrl3);
			obj.put("percentualNegativoCtrl1", percentualNegativoCtrl1);
			obj.put("percentualNegativoCtrl2", percentualNegativoCtrl2);
			obj.put("percentualNegativoCtrl3", percentualNegativoCtrl3);
			obj.put("percentualNeutroCtrl1", percentualNeutroCtrl1);
			obj.put("percentualNeutroCtrl2", percentualNeutroCtrl2);
			obj.put("percentualNeutroCtrl3", percentualNeutroCtrl3);
			obj.put("posicaoCtrl", posicaoCtrl);
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
	public void setExperimentoPreRedeId(int valor) { 
		this.experimentoPreRedeId = valor;
	}
	public int getExperimentoPreRedeId() { 
		return this.experimentoPreRedeId;
	}
	public void setGrupoAcaoId(int valor) { 
		this.grupoAcaoId = valor;
	}
	public int getGrupoAcaoId() { 
		return this.grupoAcaoId;
	}
	public void setRegraProjecaoId(int valor) { 
		this.regraProjecaoId = valor;
	}
	public int getRegraProjecaoId() { 
		return this.regraProjecaoId;
	}
	public void setGeraScore(String valor) { 
		this.geraScore = valor;
	}
	public String getGeraScore() { 
		return this.geraScore;
	}
	public void setPeriodoTreinoRedeId(int valor) { 
		this.periodoTreinoRedeId = valor;
	}
	public int getPeriodoTreinoRedeId() { 
		return this.periodoTreinoRedeId;
	}
	public void setDataComResultado(String valor) { 
		this.dataComResultado = valor;
	}
	public String getDataComResultado() { 
		return this.dataComResultado;
	}
	public void setDataComScore(String valor) { 
		this.dataComScore = valor;
	}
	public String getDataComScore() { 
		return this.dataComScore;
	}
	public void setTotalResultadoPositivo(int valor) { 
		this.totalResultadoPositivo = valor;
	}
	public int getTotalResultadoPositivo() { 
		return this.totalResultadoPositivo;
	}
	public void setTotalResultadoNegativo(int valor) { 
		this.totalResultadoNegativo = valor;
	}
	public int getTotalResultadoNegativo() { 
		return this.totalResultadoNegativo;
	}
	public void setTotalResultadoNeutro(int valor) { 
		this.totalResultadoNeutro = valor;
	}
	public int getTotalResultadoNeutro() { 
		return this.totalResultadoNeutro;
	}
	public void setTotalResultadoPositivoCtrl1(int valor) { 
		this.totalResultadoPositivoCtrl1 = valor;
	}
	public int getTotalResultadoPositivoCtrl1() { 
		return this.totalResultadoPositivoCtrl1;
	}
	public void setTotalResultadoPositivoCtrl2(int valor) { 
		this.totalResultadoPositivoCtrl2 = valor;
	}
	public int getTotalResultadoPositivoCtrl2() { 
		return this.totalResultadoPositivoCtrl2;
	}
	public void setTotalResultadoPositivoCtrl3(int valor) { 
		this.totalResultadoPositivoCtrl3 = valor;
	}
	public int getTotalResultadoPositivoCtrl3() { 
		return this.totalResultadoPositivoCtrl3;
	}
	public void setTotalResultadoNegativoCtrl1(int valor) { 
		this.totalResultadoNegativoCtrl1 = valor;
	}
	public int getTotalResultadoNegativoCtrl1() { 
		return this.totalResultadoNegativoCtrl1;
	}
	public void setTotalResultadoNegativoCtrl2(int valor) { 
		this.totalResultadoNegativoCtrl2 = valor;
	}
	public int getTotalResultadoNegativoCtrl2() { 
		return this.totalResultadoNegativoCtrl2;
	}
	public void setTotalResultadoNegativoCtrl3(int valor) { 
		this.totalResultadoNegativoCtrl3 = valor;
	}
	public int getTotalResultadoNegativoCtrl3() { 
		return this.totalResultadoNegativoCtrl3;
	}
	public void setTotalResultadoNeutroCtrl1(int valor) { 
		this.totalResultadoNeutroCtrl1 = valor;
	}
	public int getTotalResultadoNeutroCtrl1() { 
		return this.totalResultadoNeutroCtrl1;
	}
	public void setTotalResultadoNeutroCtrl2(int valor) { 
		this.totalResultadoNeutroCtrl2 = valor;
	}
	public int getTotalResultadoNeutroCtrl2() { 
		return this.totalResultadoNeutroCtrl2;
	}
	public void setTotalResultadoNeutroCtrl3(int valor) { 
		this.totalResultadoNeutroCtrl3 = valor;
	}
	public int getTotalResultadoNeutroCtrl3() { 
		return this.totalResultadoNeutroCtrl3;
	}
	public void setPercentualResultadoPositivo(double valor) { 
		this.percentualResultadoPositivo = valor;
	}
	public double getPercentualResultadoPositivo() { 
		return this.percentualResultadoPositivo;
	}
	public void setPercentualResultadoNegativo(double valor) { 
		this.percentualResultadoNegativo = valor;
	}
	public double getPercentualResultadoNegativo() { 
		return this.percentualResultadoNegativo;
	}
	public void setPercentualResultadoNeutro(double valor) { 
		this.percentualResultadoNeutro = valor;
	}
	public double getPercentualResultadoNeutro() { 
		return this.percentualResultadoNeutro;
	}
	public void setPercentualPositivoCtrl1(double valor) { 
		this.percentualPositivoCtrl1 = valor;
	}
	public double getPercentualPositivoCtrl1() { 
		return this.percentualPositivoCtrl1;
	}
	public void setPercentualPositivoCtrl2(double valor) { 
		this.percentualPositivoCtrl2 = valor;
	}
	public double getPercentualPositivoCtrl2() { 
		return this.percentualPositivoCtrl2;
	}
	public void setPercentualPositivoCtrl3(double valor) { 
		this.percentualPositivoCtrl3 = valor;
	}
	public double getPercentualPositivoCtrl3() { 
		return this.percentualPositivoCtrl3;
	}
	public void setPercentualNegativoCtrl1(double valor) { 
		this.percentualNegativoCtrl1 = valor;
	}
	public double getPercentualNegativoCtrl1() { 
		return this.percentualNegativoCtrl1;
	}
	public void setPercentualNegativoCtrl2(double valor) { 
		this.percentualNegativoCtrl2 = valor;
	}
	public double getPercentualNegativoCtrl2() { 
		return this.percentualNegativoCtrl2;
	}
	public void setPercentualNegativoCtrl3(double valor) { 
		this.percentualNegativoCtrl3 = valor;
	}
	public double getPercentualNegativoCtrl3() { 
		return this.percentualNegativoCtrl3;
	}
	public void setPercentualNeutroCtrl1(double valor) { 
		this.percentualNeutroCtrl1 = valor;
	}
	public double getPercentualNeutroCtrl1() { 
		return this.percentualNeutroCtrl1;
	}
	public void setPercentualNeutroCtrl2(double valor) { 
		this.percentualNeutroCtrl2 = valor;
	}
	public double getPercentualNeutroCtrl2() { 
		return this.percentualNeutroCtrl2;
	}
	public void setPercentualNeutroCtrl3(double valor) { 
		this.percentualNeutroCtrl3 = valor;
	}
	public double getPercentualNeutroCtrl3() { 
		return this.percentualNeutroCtrl3;
	}
	public void setPosicaoCtrl(int valor) { 
		this.posicaoCtrl = valor;
	}
	public int getPosicaoCtrl() { 
		return this.posicaoCtrl;
	}

	public ExperimentoPreRede getExperimentoPreRede() {
		return ExperimentoPreRede;
	}
	public void setExperimentoPreRede(HashMap valor) {
		this.ExperimentoPreRede = new ExperimentoPreRede();
		BeanUtil.setProperties(this.ExperimentoPreRede, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoAcao getGrupoAcao() {
		return GrupoAcao;
	}
	public void setGrupoAcao(HashMap valor) {
		this.GrupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.GrupoAcao, (Map<String, ? extends Object>) valor, true);
	}
	public RegraProjecao getRegraProjecao() {
		return RegraProjecao;
	}
	public void setRegraProjecao(HashMap valor) {
		this.RegraProjecao = new RegraProjecao();
		BeanUtil.setProperties(this.RegraProjecao, (Map<String, ? extends Object>) valor, true);
	}
	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return PeriodoTreinoRede;
	}
	public void setPeriodoTreinoRede(HashMap valor) {
		this.PeriodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.PeriodoTreinoRede, (Map<String, ? extends Object>) valor, true);
	}
	public List<ExperimentoPreRedeTreinadaScore> getExperimentoPreRedeTreinadaScores() {
		return  ExperimentoPreRedeTreinadaScores;
	}
	public void setExperimentoPreRedeTreinadaScores(List<ExperimentoPreRedeTreinadaScore> valores) {
		this.ExperimentoPreRedeTreinadaScores = new ArrayList<ExperimentoPreRedeTreinadaScore>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRedeTreinadaScore();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeTreinadaScores.add((ExperimentoPreRedeTreinadaScore) objeto);
		}
	}
	public List<ExperimentoPreRedeTreinadaControle> getExperimentoPreRedeTreinadaControles() {
		return  ExperimentoPreRedeTreinadaControles;
	}
	public void setExperimentoPreRedeTreinadaControles(List<ExperimentoPreRedeTreinadaControle> valores) {
		this.ExperimentoPreRedeTreinadaControles = new ArrayList<ExperimentoPreRedeTreinadaControle>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRedeTreinadaControle();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeTreinadaControles.add((ExperimentoPreRedeTreinadaControle) objeto);
		}
	}
}

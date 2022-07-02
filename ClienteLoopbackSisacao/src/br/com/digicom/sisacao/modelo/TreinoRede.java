package br.com.digicom.sisacao.modelo;

import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class TreinoRede extends Model {
	
	private Integer id;
	private Integer redeNeuralId;
	private Integer grupoAcaoId;
	private Integer periodoTreinoRedeId;
	private Integer tipoExemploTreinoId;
	private Integer regraProjecaoId;
	
	private RedeNeural redeNeural;
	private GrupoAcao grupoAcao;
	private PeriodoTreinoRede periodoTreinoRede;
	private TipoExemploTreino tipoExemploTreino;
	private RegraProjecao regraProjecao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRedeNeuralId() {
		return redeNeuralId;
	}
	public void setRedeNeuralId(Integer redeNeuralId) {
		this.redeNeuralId = redeNeuralId;
	}
	
	public Integer getGrupoAcaoId() {
		return grupoAcaoId;
	}
	public void setGrupoAcaoId(Integer grupoAcaoId) {
		this.grupoAcaoId = grupoAcaoId;
	}
	
	public Integer getPeriodoTreinoRedeId() {
		return periodoTreinoRedeId;
	}
	public void setPeriodoTreinoRedeId(Integer periodoTreinoRedeId) {
		this.periodoTreinoRedeId = periodoTreinoRedeId;
	}
	
	public Integer getTipoExemploTreinoId() {
		return tipoExemploTreinoId;
	}
	public void setTipoExemploTreinoId(Integer tipoExemploTreinoId) {
		this.tipoExemploTreinoId = tipoExemploTreinoId;
	}
	
	
	// RegraProjecao
	public RegraProjecao getRegraProjecao() {
		return regraProjecao;
	}
	public void setRegraProjecao(Object regraProjecao) {
		this.regraProjecao = new RegraProjecao();
		BeanUtil.setProperties(this.regraProjecao, (Map<String, ? extends Object>) regraProjecao, true);
	}
	
	// RedeNeural
	public RedeNeural getRedeNeural() {
		return redeNeural;
	}
	
	public void setRedeNeural(Object redeNeural) {
		this.redeNeural = new RedeNeural();
		BeanUtil.setProperties(this.redeNeural, (Map<String, ? extends Object>) redeNeural, true);
	}

	// GrupoAcao
	public GrupoAcao getGrupoAcao() {
		return grupoAcao;
	}
	public void setGrupoAcao(Object grupoAcao) {
		this.grupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.grupoAcao, (Map<String, ? extends Object>) grupoAcao, true);
	}
	
	// PeriodoTreinoRede
	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return periodoTreinoRede;
	}
	public void setPeriodoTreinoRede(Object periodoTreinoRede) {
		this.periodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.periodoTreinoRede, (Map<String, ? extends Object>) periodoTreinoRede, true);
	}
	
	// TipoExemploTreino
	public TipoExemploTreino getTipoExemploTreino() {
		return tipoExemploTreino;
	}
	public void setTipoExemploTreino(Object tipoExemploTreino) {
		this.tipoExemploTreino = new TipoExemploTreino();
		BeanUtil.setProperties(this.tipoExemploTreino, (Map<String, ? extends Object>) tipoExemploTreino, true);
	}
	public Integer getRegraProjecaoId() {
		return regraProjecaoId;
	}
	public void setRegraProjecaoId(Integer regraProjecaoId) {
		this.regraProjecaoId = regraProjecaoId;
	}

}

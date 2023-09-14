package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class TreinoRede extends Model {


	private int tipoExemploTreino2Id;
	private int grupoAcaoId;
	private int regraProjecaoId;
	private int tipoExemploTreinoId;
	// Relacionamentos 1
	private RedeNeural RedeNeural;
	private PeriodoTreinoRede PeriodoTreinoRede;
	private GrupoAcao GrupoAcao;
	private RegraProjecao RegraProjecao;
	private TipoExemploTreino TipoExemploTreino;
	private TipoExemploTreino entrada2;
	private TreinoGrupoRede TreinoGrupoRede;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("tipoExemploTreino2Id", tipoExemploTreino2Id);
			obj.put("grupoAcaoId", grupoAcaoId);
			obj.put("regraProjecaoId", regraProjecaoId);
			obj.put("tipoExemploTreinoId", tipoExemploTreinoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTipoExemploTreino2Id(int valor) { 
		this.tipoExemploTreino2Id = valor;
	}
	public int getTipoExemploTreino2Id() { 
		return this.tipoExemploTreino2Id;
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
	public void setTipoExemploTreinoId(int valor) { 
		this.tipoExemploTreinoId = valor;
	}
	public int getTipoExemploTreinoId() { 
		return this.tipoExemploTreinoId;
	}

	public RedeNeural getRedeNeural() {
		return RedeNeural;
	}
	public void setRedeNeural(HashMap valor) {
		this.RedeNeural = new RedeNeural();
		BeanUtil.setProperties(this.RedeNeural, (Map<String, ? extends Object>) valor, true);
	}
	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return PeriodoTreinoRede;
	}
	public void setPeriodoTreinoRede(HashMap valor) {
		this.PeriodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.PeriodoTreinoRede, (Map<String, ? extends Object>) valor, true);
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
	public TipoExemploTreino getTipoExemploTreino() {
		return TipoExemploTreino;
	}
	public void setTipoExemploTreino(HashMap valor) {
		this.TipoExemploTreino = new TipoExemploTreino();
		BeanUtil.setProperties(this.TipoExemploTreino, (Map<String, ? extends Object>) valor, true);
	}
	public TipoExemploTreino getEntrada2() {
		return entrada2;
	}
	public void setEntrada2(HashMap valor) {
		this.entrada2 = new TipoExemploTreino();
		BeanUtil.setProperties(this.entrada2, (Map<String, ? extends Object>) valor, true);
	}
	public TreinoGrupoRede getTreinoGrupoRede() {
		return TreinoGrupoRede;
	}
	public void setTreinoGrupoRede(HashMap valor) {
		this.TreinoGrupoRede = new TreinoGrupoRede();
		BeanUtil.setProperties(this.TreinoGrupoRede, (Map<String, ? extends Object>) valor, true);
	}
}

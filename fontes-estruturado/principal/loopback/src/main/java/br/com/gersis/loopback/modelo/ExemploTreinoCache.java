package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExemploTreinoCache extends Model {


	private int grupoAcaoId;
	private int regraProjecaoSaidaId;
	private int tipoExemploCurtaId;
	private int tipoExemploLongaId;
	private int periodoTreinoRedeId;
	private int diaNumPrevisao;
	private String ticker;
	private String campoXCurta;
	private String campoXCurtaIndice;
	private int campoY;
	private String campoXLonga;
	private String campoXLongaIndice;
	private int idExperimentoRedeNeural;
	// Relacionamentos 1
	// Relacionamentos N

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
			obj.put("grupoAcaoId", grupoAcaoId);
			obj.put("regraProjecaoSaidaId", regraProjecaoSaidaId);
			obj.put("tipoExemploCurtaId", tipoExemploCurtaId);
			obj.put("tipoExemploLongaId", tipoExemploLongaId);
			obj.put("periodoTreinoRedeId", periodoTreinoRedeId);
			obj.put("diaNumPrevisao", diaNumPrevisao);
			obj.put("ticker", ticker);
			obj.put("campoXCurta", campoXCurta);
			obj.put("campoXCurtaIndice", campoXCurtaIndice);
			obj.put("campoY", campoY);
			obj.put("campoXLonga", campoXLonga);
			obj.put("campoXLongaIndice", campoXLongaIndice);
			obj.put("idExperimentoRedeNeural", idExperimentoRedeNeural);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setGrupoAcaoId(int valor) { 
		this.grupoAcaoId = valor;
	}
	public int getGrupoAcaoId() { 
		return this.grupoAcaoId;
	}
	public void setRegraProjecaoSaidaId(int valor) { 
		this.regraProjecaoSaidaId = valor;
	}
	public int getRegraProjecaoSaidaId() { 
		return this.regraProjecaoSaidaId;
	}
	public void setTipoExemploCurtaId(int valor) { 
		this.tipoExemploCurtaId = valor;
	}
	public int getTipoExemploCurtaId() { 
		return this.tipoExemploCurtaId;
	}
	public void setTipoExemploLongaId(int valor) { 
		this.tipoExemploLongaId = valor;
	}
	public int getTipoExemploLongaId() { 
		return this.tipoExemploLongaId;
	}
	public void setPeriodoTreinoRedeId(int valor) { 
		this.periodoTreinoRedeId = valor;
	}
	public int getPeriodoTreinoRedeId() { 
		return this.periodoTreinoRedeId;
	}
	public void setDiaNumPrevisao(int valor) { 
		this.diaNumPrevisao = valor;
	}
	public int getDiaNumPrevisao() { 
		return this.diaNumPrevisao;
	}
	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setCampoXCurta(String valor) { 
		this.campoXCurta = valor;
	}
	public String getCampoXCurta() { 
		return this.campoXCurta;
	}
	public void setCampoXCurtaIndice(String valor) { 
		this.campoXCurtaIndice = valor;
	}
	public String getCampoXCurtaIndice() { 
		return this.campoXCurtaIndice;
	}
	public void setCampoY(int valor) { 
		this.campoY = valor;
	}
	public int getCampoY() { 
		return this.campoY;
	}
	public void setCampoXLonga(String valor) { 
		this.campoXLonga = valor;
	}
	public String getCampoXLonga() { 
		return this.campoXLonga;
	}
	public void setCampoXLongaIndice(String valor) { 
		this.campoXLongaIndice = valor;
	}
	public String getCampoXLongaIndice() { 
		return this.campoXLongaIndice;
	}
	public void setIdExperimentoRedeNeural(int valor) { 
		this.idExperimentoRedeNeural = valor;
	}
	public int getIdExperimentoRedeNeural() { 
		return this.idExperimentoRedeNeural;
	}

}

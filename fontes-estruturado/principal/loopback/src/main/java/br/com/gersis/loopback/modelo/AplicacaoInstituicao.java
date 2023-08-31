package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class AplicacaoInstituicao extends Model {


	private double saldoAtual;
	private int instituicaoFinanceiraId;
	private int tipoAplicacaoId;
	// Relacionamentos 1
	private InstituicaoFinanceira InstituicaoFinanceira;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("saldoAtual", saldoAtual);
			obj.put("instituicaoFinanceiraId", instituicaoFinanceiraId);
			obj.put("tipoAplicacaoId", tipoAplicacaoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setSaldoAtual(double valor) { 
		this.saldoAtual = valor;
	}
	public double getSaldoAtual() { 
		return this.saldoAtual;
	}
	public void setInstituicaoFinanceiraId(int valor) { 
		this.instituicaoFinanceiraId = valor;
	}
	public int getInstituicaoFinanceiraId() { 
		return this.instituicaoFinanceiraId;
	}
	public void setTipoAplicacaoId(int valor) { 
		this.tipoAplicacaoId = valor;
	}
	public int getTipoAplicacaoId() { 
		return this.tipoAplicacaoId;
	}

	public InstituicaoFinanceira getInstituicaoFinanceira() {
		return InstituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(HashMap valor) {
		this.InstituicaoFinanceira = new InstituicaoFinanceira();
		BeanUtil.setProperties(this.InstituicaoFinanceira, (Map<String, ? extends Object>) valor, true);
	}
}

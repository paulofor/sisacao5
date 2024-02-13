package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class FechamentoRegraDiaQuantidade extends Model {


	private int diaNum;
	private int quantidadeCompra;
	private int quantidadeVenda;
	private int fechamentoRegraDiaId;
	// Relacionamentos 1
	private FechamentoRegraDia FechamentoRegraDia;
	private DiaPregao DiaPregao;
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
			obj.put("diaNum", diaNum);
			obj.put("quantidadeCompra", quantidadeCompra);
			obj.put("quantidadeVenda", quantidadeVenda);
			obj.put("fechamentoRegraDiaId", fechamentoRegraDiaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setQuantidadeCompra(int valor) { 
		this.quantidadeCompra = valor;
	}
	public int getQuantidadeCompra() { 
		return this.quantidadeCompra;
	}
	public void setQuantidadeVenda(int valor) { 
		this.quantidadeVenda = valor;
	}
	public int getQuantidadeVenda() { 
		return this.quantidadeVenda;
	}
	public void setFechamentoRegraDiaId(int valor) { 
		this.fechamentoRegraDiaId = valor;
	}
	public int getFechamentoRegraDiaId() { 
		return this.fechamentoRegraDiaId;
	}

	public FechamentoRegraDia getFechamentoRegraDia() {
		return FechamentoRegraDia;
	}
	public void setFechamentoRegraDia(HashMap valor) {
		this.FechamentoRegraDia = new FechamentoRegraDia();
		BeanUtil.setProperties(this.FechamentoRegraDia, (Map<String, ? extends Object>) valor, true);
	}
	public DiaPregao getDiaPregao() {
		return DiaPregao;
	}
	public void setDiaPregao(HashMap valor) {
		this.DiaPregao = new DiaPregao();
		BeanUtil.setProperties(this.DiaPregao, (Map<String, ? extends Object>) valor, true);
	}
}

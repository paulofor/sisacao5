package br.com.digicom.sisacao.modelo;

import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ValorParametro extends Model{

	private Double valorParametro;
	//private Long combinacaoParametroId;
	private Integer parametroRegraId;
	private ParametroRegra parametroRegra;
	public Double getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(Double valorParametro) {
		this.valorParametro = valorParametro;
	}
	public void setValorParametro(Integer valorParametro) {
		this.valorParametro = valorParametro.doubleValue();
	}
	public ParametroRegra getParametroRegra() {
		return parametroRegra;
	}
	public void setParametroRegra(Object parametroRegra) {
		this.parametroRegra = new ParametroRegra();
		BeanUtil.setProperties(this.parametroRegra, (Map<String, ? extends Object>) parametroRegra, true);
	}
	
	
	
	public void setParametroRegra(ParametroRegra parametroRegra) {
		this.parametroRegra = parametroRegra;
	}
	public String toString() {
		return this.parametroRegra.getNome() + "=" + this.valorParametro;
	}
	public Integer getParametroRegraId() {
		return parametroRegraId;
	}
	public void setParametroRegraId(Integer parametroRegraId) {
		this.parametroRegraId = parametroRegraId;
	}
	public boolean isTargetStop() {
		if ("TARGET".equalsIgnoreCase(this.parametroRegra.getNome()) || "STOP".equalsIgnoreCase(this.parametroRegra.getNome()))
			return true;
		else
			return false;
	}
	public String descricao() {
		return this.parametroRegra.getSiglaDescricao() + "=" + this.valorParametro;
	}
	
}

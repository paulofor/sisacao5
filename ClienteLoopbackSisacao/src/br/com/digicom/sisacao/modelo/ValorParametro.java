package br.com.digicom.sisacao.modelo;

import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class ValorParametro extends Model{

	private Double valorParametro;
	//private Long combinacaoParametroId;
	//private Long parametroRegraId;
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
	
	
	public String toString() {
		return this.parametroRegra.getNome() + "=" + this.valorParametro;
	}
}

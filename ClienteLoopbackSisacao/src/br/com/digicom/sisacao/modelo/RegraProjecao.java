package br.com.digicom.sisacao.modelo;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;

public class RegraProjecao extends Model {

	private Integer id;
	private String tipoCompraVenda;
	private Double target;
	private Double stop;
	private Integer diaLimite;
	private Integer processando;
	private String codigoRegraProjecao;
	private Double percentualEntradaDataset;
	private Integer indiceHoraReferenciaDataset;
	
	private GrupoAcao grupoAcao;
	
	
	
	
	public Double getPercentualEntradaDataset() {
		return percentualEntradaDataset;
	}
	public void setPercentualEntradaDataset(Double percentualEntradaDataset) {
		this.percentualEntradaDataset = percentualEntradaDataset;
	}
	public Integer getIndiceHoraReferenciaDataset() {
		return indiceHoraReferenciaDataset;
	}
	public void setIndiceHoraReferenciaDataset(Integer indiceHoraReferenciaDataset) {
		this.indiceHoraReferenciaDataset = indiceHoraReferenciaDataset;
	}
	public GrupoAcao getGrupoAcao() {
		return grupoAcao;
	}
	public void setGrupoAcao(HashMap grupoAcao) {
		this.grupoAcao = new GrupoAcao();;
		BeanUtil.setProperties(this.grupoAcao, (Map<String, ? extends Object>) grupoAcao, true);

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoCompraVenda() {
		return tipoCompraVenda;
	}
	public void setTipoCompraVenda(String tipoCompraVenda) {
		this.tipoCompraVenda = tipoCompraVenda;
	}
	public Double getTarget() {
		return target;
	}
	public void setTarget(Double target) {
		this.target = target;
	}
	public Double getStop() {
		return stop;
	}
	public void setStop(Double stop) {
		this.stop = stop;
	}
	public Integer getDiaLimite() {
		return diaLimite;
	}
	public void setDiaLimite(Integer diaLimite) {
		this.diaLimite = diaLimite;
	}
	public Integer getProcessando() {
		return processando;
	}
	public void setProcessando(Integer processando) {
		this.processando = processando;
	}
	public String getCodigoRegraProjecao() {
		return codigoRegraProjecao;
	}
	public void setCodigoRegraProjecao(String codigoRegraProjecao) {
		this.codigoRegraProjecao = codigoRegraProjecao;
	}
	
	
	
	
	
}

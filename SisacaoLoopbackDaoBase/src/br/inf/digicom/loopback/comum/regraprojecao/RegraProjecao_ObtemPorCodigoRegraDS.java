package br.inf.digicom.loopback.comum.regraprojecao;

import br.com.digicom.sisacao.modelo.RegraProjecao;

public interface RegraProjecao_ObtemPorCodigoRegraDS {

	public String getCodigoRegraProjecao();
	public void setCodigoRegraProjecao(String codigoRegra);
	
	public void setRegraProjecao(RegraProjecao regra);
	public RegraProjecao getRegraProjecao();
}

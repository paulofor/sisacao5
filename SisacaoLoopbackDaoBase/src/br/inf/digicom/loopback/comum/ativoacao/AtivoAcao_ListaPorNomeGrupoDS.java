package br.inf.digicom.loopback.comum.ativoacao;

import br.com.digicom.sisacao.modelo.AtivoAcao;

public interface AtivoAcao_ListaPorNomeGrupoDS {
	
	public void setAtivoAcaoCorrente(AtivoAcao item);
	public AtivoAcao getAtivoAcaoCorrente();
	
	void setCodigoGrupoAcao(String codigo);
	String getCodigoGrupoAcao();
	
	
	
}

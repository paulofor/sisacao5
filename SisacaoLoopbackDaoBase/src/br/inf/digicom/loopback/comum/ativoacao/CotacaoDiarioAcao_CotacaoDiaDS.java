package br.inf.digicom.loopback.comum.ativoacao;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;

public interface CotacaoDiarioAcao_CotacaoDiaDS {

	int getDiaNum();
	void setDiaNum(int valor);

	String getTicker();
	void setTicker(String valor);

	void setCotacaoDiarioAcao(CotacaoDiarioAcao cotacaoDia);
	CotacaoDiarioAcao getCotacaoDiarioAcao();
	
	
	
	
}

package br.inf.digicom.loopback.comum.ativoacao;

import java.util.List;

import br.com.digicom.sisacao.modelo.Ativo;
import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;

public interface CotacaoDiarioAcao_ListaTickerDiaDS {

	int getDiaNum();
	void setDiaNum(int valor);
	List<Ativo> getListaTicker();
	void setListaCotacaoDiario(List<CotacaoDiarioAcao> listaCotacao);


		
	
	
}

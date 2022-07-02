package br.com.sisacao.coletor.diario.legado;

import br.com.digicom.cotacao.dao.DaoAplicacao;
import br.com.digicom.lib.dao.DataFonte;

public abstract class CotacaoDiarioTabelaUnicaDaoBase extends DaoAplicacao implements CotacaoDiarioTabelaUnicaDaoBaseI {


	public CotacaoDiarioTabelaUnicaDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	
}

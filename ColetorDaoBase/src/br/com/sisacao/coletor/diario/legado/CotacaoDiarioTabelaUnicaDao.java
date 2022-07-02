package br.com.sisacao.coletor.diario.legado;

import br.com.digicom.lib.dao.DaoException;

public interface CotacaoDiarioTabelaUnicaDao extends CotacaoDiarioTabelaUnicaDaoBaseI {
	public void insereDiarioAcao(CotacaoDiario cotacao) throws DaoException;
}

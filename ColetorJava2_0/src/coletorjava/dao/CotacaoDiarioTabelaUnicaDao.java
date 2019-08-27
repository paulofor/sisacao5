package coletorjava.dao;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.CotacaoDiarioTabelaUnicaDaoBaseI;
import coletorjava.modelo.CotacaoDiario;

public interface CotacaoDiarioTabelaUnicaDao extends CotacaoDiarioTabelaUnicaDaoBaseI {
	public void insereDiarioAcao(CotacaoDiario cotacao) throws DaoException;
}

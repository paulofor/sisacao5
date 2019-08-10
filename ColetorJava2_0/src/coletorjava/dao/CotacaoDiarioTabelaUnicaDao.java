package coletorjava.dao;

import coletorjava.dao.basica.CotacaoDiarioTabelaUnicaDaoBaseI;
import coletorjava.modelo.CotacaoDiario;

public interface CotacaoDiarioTabelaUnicaDao extends CotacaoDiarioTabelaUnicaDaoBaseI {
	public void insereDiarioAcao(CotacaoDiario cotacao);
}

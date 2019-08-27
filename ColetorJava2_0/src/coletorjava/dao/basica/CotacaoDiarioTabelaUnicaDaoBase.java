package coletorjava.dao.basica;

import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import coletorjava.dao.montador.CotacaoProcessadaMontador;

public abstract class CotacaoDiarioTabelaUnicaDaoBase extends DaoAplicacao implements CotacaoDiarioTabelaUnicaDaoBaseI {

	public CotacaoDiarioTabelaUnicaDaoBase() {
		super();
	}
	public CotacaoDiarioTabelaUnicaDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	
}

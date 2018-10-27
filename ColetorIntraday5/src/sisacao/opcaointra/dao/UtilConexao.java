package sisacao.opcaointra.dao;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import coletorjava.dao.basica.DataSourceLocalRNN;

public class UtilConexao {

	
	private static DaoConexao conn = null;
	
	public static DaoConexao getConexao5() throws DaoException {
		DataFonte dataSource = new DataSourceLocalRNN();
		conn =  dataSource.criaConexao();
		return conn;
	}
}

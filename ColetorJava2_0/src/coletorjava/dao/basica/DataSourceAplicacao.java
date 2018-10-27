package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceAplicacao extends MySqlDataSource {
	public DataSourceAplicacao() {
		super("jdbc:mysql://mysql.lojadigicom.com.br/lojadigicom06", "lojadigicom06", "aspnet");
	}
}

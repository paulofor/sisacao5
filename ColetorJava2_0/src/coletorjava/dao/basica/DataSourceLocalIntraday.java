package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalIntraday extends MySqlDataSource {
	public DataSourceLocalIntraday() {
		super("jdbc:mysql://DESENV-PC/intraday", "sisacaoweb2", "aspnet");
	}
}

package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalIntraday extends MySqlDataSource {
	public DataSourceLocalIntraday() {
		super("jdbc:mysql://192.168.1.14/intraday", "sisacaoweb2", "aspnet");
	}
}

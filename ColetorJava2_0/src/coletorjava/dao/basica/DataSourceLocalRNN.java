package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalRNN extends MySqlDataSource {
	public DataSourceLocalRNN() {
		super("jdbc:mysql://192.168.1.14/sisacao5", "sisacaoweb2", "aspnet");
	}
}

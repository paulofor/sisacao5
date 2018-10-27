package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalRNN extends MySqlDataSource {
	public DataSourceLocalRNN() {
		super("jdbc:mysql://DESENV-PC/sisacao5", "sisacaoweb2", "aspnet");
	}
}

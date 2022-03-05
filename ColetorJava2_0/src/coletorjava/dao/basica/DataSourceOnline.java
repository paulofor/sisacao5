package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceOnline extends MySqlDataSource {

	public DataSourceOnline() {
		super("jdbc:mysql://lojadigicom35/lojadigicom06", "lojadigicom06", "aspnet");
	}

}

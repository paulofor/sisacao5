package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSource2019 extends MySqlDataSource {

	public DataSource2019() {
		super("jdbc:mysql://mysql.lojadigicom.com.br/lojadigicom35", "lojadigicom35", "aspNet7");
	}
}

package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalIntradayOpcao extends MySqlDataSource {
	public DataSourceLocalIntradayOpcao() {
		super("jdbc:mysql://192.168.1.14/intradayopcao", "sisacaoweb2", "aspnet");
	}
}

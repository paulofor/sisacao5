package coletorjava.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceLocalIntradayOpcao extends MySqlDataSource {
	public DataSourceLocalIntradayOpcao() {
		super("jdbc:mysql://DESENV-PC/intradayopcao", "sisacaoweb2", "aspnet");
	}
}

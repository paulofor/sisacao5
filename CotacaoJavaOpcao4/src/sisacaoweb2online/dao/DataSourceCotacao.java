package sisacaoweb2online.dao;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceCotacao extends MySqlDataSource {
	public DataSourceCotacao() {
		super("jdbc:mysql://192.168.1.4/intradayopcao", "sisacaoweb2", "aspnet");
	}
}

/*
 * Location: D:\Documentos de
 * Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * 
 * Qualified Name: sisacaoweb2online.dao.DataSourceCotacao
 * 
 * JD-Core Version: 0.7.0.1
 * 
 */
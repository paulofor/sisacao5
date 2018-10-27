 package cotacaojava2.dao;
 
 import br.com.digicom.lib.dao.MySqlDataSource;
 
 public class DataSourceCotacaoOpcaoDiario extends MySqlDataSource
 {
   public DataSourceCotacaoOpcaoDiario()
   {
/* 8 */     super("jdbc:mysql://192.168.1.4/diario_opcao", "sisacaoweb2", "aspnet");
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.dao.DataSourceCotacaoOpcaoDiario
 * JD-Core Version:    0.6.0
 */
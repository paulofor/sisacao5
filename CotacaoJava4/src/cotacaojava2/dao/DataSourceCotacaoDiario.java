 package cotacaojava2.dao;
 
 import br.com.digicom.lib.dao.MySqlDataSource;
 
 public class DataSourceCotacaoDiario extends MySqlDataSource
 {
   public DataSourceCotacaoDiario()
   {
/* 8 */     super("jdbc:mysql://192.168.1.4/diario", "sisacaoweb2", "aspnet");
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.dao.DataSourceCotacaoDiario
 * JD-Core Version:    0.6.0
 */
 package cotacaojava2.dao;
 
 import br.com.digicom.lib.dao.MySqlDataSource;
 
 public class DataSourceCotacao extends MySqlDataSource
 {
   public DataSourceCotacao()
   {
/* 9 */     super("jdbc:mysql://192.168.1.4/intraday", "sisacaoweb2", "aspnet");
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.dao.DataSourceCotacao
 * JD-Core Version:    0.6.0
 */
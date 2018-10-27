 package cotacaojava2.regracolecao;
 
 import br.com.digicom.cotacao.dao.CotacaoDao;
 import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecaoImpl;
 import cotacaojava2.dao.DBB;
 
 public class CotacaoRegraColecaoImplApp extends CotacaoRegraColecaoImpl
 {
   protected CotacaoDao getDao()
   {
     return DBB.getInstancia().getCotacaoDao();
   }
 }


 package cotacaojava2.dao;
 
 import br.com.digicom.cotacao.dao.CotacaoDao;
 import br.com.digicom.cotacao.dao.CotacaoDiarioDao;
 
 public class DBB
 {
/* 19 */   private static DBB _instancia = null;
   private CotacaoDao _cotacaoDao;
   private CotacaoDiarioDao _cotacaoDiarioDao;
   private CotacaoDiarioDao _cotacaoDiarioOpcaoDao;
 
   public DBB()
   {
/* 16 */     this._cotacaoDao = null;
   }
 
   public static DBB getInstancia()
   {
/* 21 */     if (_instancia == null) _instancia = new DBB();
/* 22 */     return _instancia;
   }
 
   public CotacaoDao getCotacaoDao()
   {
/* 27 */     if (this._cotacaoDao == null) this._cotacaoDao = new CotacaoDaoExtendidaApp();
/* 28 */     return this._cotacaoDao;
   }
 
   public CotacaoDiarioDao getCotacaoDiarioDao() {
/* 32 */     if (this._cotacaoDiarioDao == null) this._cotacaoDiarioDao = new CotacaoDiarioDaoExtendidaApp();
/* 33 */     return this._cotacaoDiarioDao;
   }
 
   public CotacaoDiarioDao getCotacaoDiarioOpcaoDao() {
/* 37 */     if (this._cotacaoDiarioOpcaoDao == null) this._cotacaoDiarioOpcaoDao = new CotacaoDiarioOpcaoDaoExtendidaApp();
/* 38 */     return this._cotacaoDiarioOpcaoDao;
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.dao.DBB
 * JD-Core Version:    0.6.0
 */
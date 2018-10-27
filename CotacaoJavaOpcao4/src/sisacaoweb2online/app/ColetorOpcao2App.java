/*  1:   */ package sisacaoweb2online.app;
/*  2:   */ 
/*  3:   */ import sisacaoweb2online.dao.DBB;
import sisacaoweb2online.regracolecao.FabricaRegra;
import br.com.digicom.cotacao.dao.CotacaoDaoBaseI;
import br.com.digicom.cotacao.handle.DaoThread;
import br.com.digicom.cotacao.handle.FabricaRegraI;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
/*  4:   */ 
/*  5:   */ 
/*  6:   */ 
/*  7:   */ 
/*  8:   */ 
/*  9:   */ 
/* 10:   */ 
/* 11:   */ 
/* 12:   */ public class ColetorOpcao2App
/* 13:   */ {
/* 14:   */   public static void main(String[] args)
/* 15:   */   {
/* 16:16 */     System.out.println("Ola Mundo !");
/* 17:17 */     InicializaConexaoDaoThread();
/* 18:18 */     InicializaRegraColecaoDaoThread();
/* 19:19 */     ColetorOpcao2Obj objeto = new ColetorOpcao2Obj();
/* 20:20 */     objeto.main();
/* 21:   */   }
/* 22:   */   
/* 23:   */   private static void InicializaConexaoDaoThread()
/* 24:   */   {
/* 25:   */     try
/* 26:   */     {
/* 27:25 */       CotacaoDaoBaseI dao = DBB.getInstancia().getCotacaoDao();
/* 28:26 */       DaoConexao conexao = dao.criaConexao();
/* 29:27 */       DaoThread.setConexao(conexao);
/* 30:   */     }
/* 31:   */     catch (DaoException e)
/* 32:   */     {
/* 33:29 */       e.printStackTrace();
/* 34:30 */       System.out.println("Erro em InicializaConexaoDaoThread");
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   private static void InicializaRegraColecaoDaoThread()
/* 39:   */   {
/* 40:   */     try
/* 41:   */     {
/* 42:36 */       FabricaRegraI fabrica = FabricaRegra.getInstancia();
/* 43:37 */       DaoThread.setFabricaRegra(fabrica);
/* 44:   */     }
/* 45:   */     catch (Exception e)
/* 46:   */     {
/* 47:39 */       e.printStackTrace();
/* 48:40 */       System.out.println("Erro em InicializaRegraColecaoDaoThread");
/* 49:   */     }
/* 50:   */   }
/* 51:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.app.ColetorOpcao2App
 * JD-Core Version:    0.7.0.1
 */
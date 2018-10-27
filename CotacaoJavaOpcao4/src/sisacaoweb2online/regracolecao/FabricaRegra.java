/*  1:   */ package sisacaoweb2online.regracolecao;
/*  2:   */ 
/*  3:   */ import br.com.digicom.cotacao.handle.FabricaRegraI;
/*  4:   */ import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecao;
/*  5:   */ 
/*  6:   */ public class FabricaRegra
/*  7:   */   implements FabricaRegraI
/*  8:   */ {
/*  9: 9 */   private static FabricaRegra _instancia = null;
/* 10:   */   private CotacaoRegraColecao _opcaoCotacaoRegraColecao;
/* 11:   */   
/* 12:   */   public static FabricaRegra getInstancia()
/* 13:   */   {
/* 14:14 */     if (_instancia == null) {
/* 15:14 */       _instancia = new FabricaRegra();
/* 16:   */     }
/* 17:15 */     return _instancia;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public CotacaoRegraColecao getCotacaoRegraColecao()
/* 21:   */   {
/* 22:20 */     if (this._opcaoCotacaoRegraColecao == null) {
/* 23:20 */       this._opcaoCotacaoRegraColecao = new CotacaoRegraColecaoImplApp();
/* 24:   */     }
/* 25:21 */     return this._opcaoCotacaoRegraColecao;
/* 26:   */   }
/* 27:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.regracolecao.FabricaRegra
 * JD-Core Version:    0.7.0.1
 */
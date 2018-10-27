 package cotacaojava2.regracolecao;
 
 import br.com.digicom.cotacao.handle.FabricaRegraI;
 import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecao;
 
 public class FabricaRegra
   implements FabricaRegraI
 {
/* 10 */   private static FabricaRegra _instancia = null;
   private CotacaoRegraColecao _opcaoCotacaoRegraColecao;
 
   public static FabricaRegra getInstancia()
   {
/* 12 */     if (_instancia == null) _instancia = new FabricaRegra();
/* 13 */     return _instancia;
   }
 
   public CotacaoRegraColecao getCotacaoRegraColecao()
   {
/* 18 */     if (this._opcaoCotacaoRegraColecao == null) this._opcaoCotacaoRegraColecao = new CotacaoRegraColecaoImplApp();
/* 19 */     return this._opcaoCotacaoRegraColecao;
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.regracolecao.FabricaRegra
 * JD-Core Version:    0.6.0
 */
 package br.com.digicom.cotacao.regracolecao;
 
 import br.com.digicom.cotacao.vo.Cotacao;
 
 public class CotacaoFiltro
 {
   Cotacao _cotacao;
   String _NomeTicker;
 
   public Cotacao getCotacao()
   {
/* 11 */     return this._cotacao;
   }
   public void setCotacao(Cotacao dado) {
/* 14 */     this._cotacao = dado;
   }
 
   public String getNomeTicker() {
/* 18 */     return this._NomeTicker;
   }
   public void setNomeTicker(String dado) {
/* 21 */     this._NomeTicker = dado;
   }
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.regracolecao.CotacaoFiltro
 * JD-Core Version:    0.6.0
 */
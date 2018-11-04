/*    */ package br.com.digicom.parse.dao;
/*    */ 
/*    */ import br.com.digicom.lib.dao.DaoConexao;
/*    */ import br.com.digicom.parse.callback.IDadosParse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DadosParseDao
/*    */   implements IDadosParse
/*    */ {
/*    */   private DaoConexao conexao;
/*    */   
/*    */   public DaoConexao getConexao()
/*    */   {
/* 16 */     return this.conexao;
/*    */   }
/*    */   
/* 19 */   public void setConexao(DaoConexao valor) { this.conexao = valor; }
/*    */ }


/* Location:              D:\RobotWeb\ColetorGeralPrecos_1.0.jar!\br\com\digicom\parse\dao\DadosParseDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */
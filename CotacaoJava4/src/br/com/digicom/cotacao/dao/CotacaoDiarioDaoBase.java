 package br.com.digicom.cotacao.dao;
 
 import br.com.digicom.cotacao.vo.CotacaoDiario;
 import br.com.digicom.lib.dao.DaoException;
 import br.com.digicom.lib.dao.DataFonte;
 import br.com.digicom.lib.dao.MontadorDaoI;
 
 public class CotacaoDiarioDaoBase extends DaoAplicacao
   implements CotacaoDiarioDaoBaseI
 {
   public CotacaoDiarioDaoBase(DataFonte dataSource)
   {
/* 17 */     super(dataSource);
   }
 
   protected MontadorDaoI criaMontadorPadrao()
   {
/* 23 */     return new CotacaoDiarioMontador();
   }
 
   public void insereItem(CotacaoDiario item)
     throws DaoException
   {
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDiarioDaoBase
 * JD-Core Version:    0.6.0
 */
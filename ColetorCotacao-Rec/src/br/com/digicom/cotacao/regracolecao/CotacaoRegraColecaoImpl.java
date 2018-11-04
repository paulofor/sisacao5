 package br.com.digicom.cotacao.regracolecao;
 
 import br.com.digicom.cotacao.dao.CotacaoDao;
 import br.com.digicom.cotacao.vo.Cotacao;
 import br.com.digicom.lib.dao.DaoConexao;
 import br.com.digicom.lib.dao.DaoException;
 
 public abstract class CotacaoRegraColecaoImpl extends CotacaoRegraColecao
 {
   public Cotacao InsereCotacao(DaoConexao conexao)
     throws DaoException
   {
/* 14 */     CotacaoDao dao = getDao();
/* 15 */     dao.setConexao(conexao);
/* 16 */     Cotacao cotacao = getFiltro().getCotacao();
/* 17 */     String nomeTicker = getFiltro().getNomeTicker();
/* 18 */     dao.insereCotacao(cotacao, nomeTicker);
/* 19 */     return cotacao;
   }
 
   public Cotacao ObtemMaisRecente(DaoConexao conexao) throws DaoException {
/* 23 */     CotacaoDao dao = getDao();
/* 24 */     dao.setConexao(conexao);
/* 25 */     Cotacao cotacao = getFiltro().getCotacao();
/* 26 */     String nomeTicker = getFiltro().getNomeTicker();
/* 27 */     cotacao = dao.obtemMaisRecente(nomeTicker);
/* 28 */     return cotacao;
   }
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.regracolecao.CotacaoRegraColecaoImpl
 * JD-Core Version:    0.6.0
 */
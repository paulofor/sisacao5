package br.com.digicom.cotacao.dao;

import br.com.digicom.cotacao.regracolecao.CotacaoFiltro;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DaoI;
import java.util.List;

public abstract interface CotacaoDaoBaseI extends DaoI
{
  public abstract void insereItem(Cotacao paramCotacao)
    throws DaoException;

  public abstract void insereItemCompleto(Cotacao paramCotacao)
    throws DaoException;

  public abstract boolean insereSeNaoExiste(Cotacao paramCotacao)
    throws DaoException;

  public abstract void insereItemLoad(Cotacao paramCotacao)
    throws DaoException;

  public abstract void alteraItem(Cotacao paramCotacao)
    throws DaoException;

  public abstract void excluiItem(Cotacao paramCotacao)
    throws DaoException;

  public abstract Cotacao obtemPorChave(long paramLong)
    throws DaoException;

  public abstract List ListaFiltro(CotacaoFiltro paramCotacaoFiltro)
    throws DaoException;

  public abstract List ListaFiltroSimples(CotacaoFiltro paramCotacaoFiltro)
    throws DaoException;

  public abstract List ListaCorrente()
    throws DaoException;
}

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDaoBaseI
 * JD-Core Version:    0.6.0
 */
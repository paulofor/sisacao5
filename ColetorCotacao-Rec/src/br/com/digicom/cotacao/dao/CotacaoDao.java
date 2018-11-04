package br.com.digicom.cotacao.dao;

import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoException;

public abstract interface CotacaoDao extends CotacaoDaoBaseI
{
  public abstract void insereCotacao(Cotacao paramCotacao, String paramString)
    throws DaoException;

  public abstract void testaTabela(String paramString)
    throws DaoException;

  public abstract Cotacao obtemMaisRecente(String paramString)
    throws DaoException;

  public abstract void CriaTabelaSeNecessario(String paramString)
    throws DaoException;
}

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDao
 * JD-Core Version:    0.6.0
 */
package br.com.digicom.cotacao.dao;

import br.com.digicom.cotacao.vo.CotacaoDiario;
import br.com.digicom.cotacao.vo.CotacaoDiarioOpcao;
import br.com.digicom.lib.dao.DaoException;

public abstract interface CotacaoDiarioDao extends CotacaoDiarioDaoBaseI
{
  public abstract void insereCotacao(CotacaoDiario paramCotacaoDiario, String paramString)
    throws DaoException;

  public abstract void testaTabela(String paramString)
    throws DaoException;

  public abstract void CriaTabelaSeNecessario(String paramString)
    throws DaoException;

public abstract void insereOpcaoSeNecessario(CotacaoDiarioOpcao cotacao);
}

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDiarioDao
 * JD-Core Version:    0.6.0
 */
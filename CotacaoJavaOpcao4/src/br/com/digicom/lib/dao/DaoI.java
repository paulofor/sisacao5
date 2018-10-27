package br.com.digicom.lib.dao;

public abstract interface DaoI
{
  public abstract DaoConexao criaConexao()
    throws DaoException;
  
  public abstract void liberaConexao(DaoConexao paramDaoConexao)
    throws DaoException;
  
  public abstract void setConexao(DaoConexao paramDaoConexao);
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoI
 * JD-Core Version:    0.7.0.1
 */
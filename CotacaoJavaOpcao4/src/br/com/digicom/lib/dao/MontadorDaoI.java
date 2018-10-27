package br.com.digicom.lib.dao;

import br.com.digicom.lib.DCIObjetoDominio;
import java.lang.reflect.InvocationTargetException;

public abstract interface MontadorDaoI
{
  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista, DCIObjetoDominio paramDCIObjetoDominio, int paramInt)
    throws DaoException;
  
  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista)
    throws DaoException;
  
  public abstract DCIObjetoDominio extraiRegistro(ResultadoLista paramResultadoLista, int paramInt)
    throws DaoException;
  
  public abstract DaoItemRetorno extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio paramDCIObjetoDominio)
    throws DaoException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
  
  public abstract DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio paramDCIObjetoDominio)
    throws DaoException;
  
  public abstract int quantidadeCampos();
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.MontadorDaoI
 * JD-Core Version:    0.7.0.1
 */
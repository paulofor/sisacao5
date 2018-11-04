 package br.com.digicom.cotacao.dao;
 
 import java.lang.reflect.InvocationTargetException;

import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DaoItemRetorno;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.dao.ResultadoLista;
 
 public class CotacaoMontador
   implements MontadorDaoI
 {
   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista)
     throws DaoException
   {
/* 15 */     DCIObjetoDominio objeto = new Cotacao();
/* 16 */     return extraiRegistro(resultadoLista, objeto, 1);
   }
 
   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, int pos)
     throws DaoException
   {
/* 22 */     DCIObjetoDominio objeto = new Cotacao();
/* 23 */     return extraiRegistro(resultadoLista, objeto, pos);
   }
 
   public DCIObjetoDominio extraiRegistro(ResultadoLista resultadoLista, DCIObjetoDominio entrada, int pos)
     throws DaoException
   {
/* 29 */     Cotacao objeto = (Cotacao)entrada;
/* 30 */     objeto.setIdCotacao(resultadoLista.getInt(pos++));
/* 31 */     objeto.setNeg(resultadoLista.getString(pos++));
/* 32 */     objeto.setData(resultadoLista.getString(pos++));
/* 33 */     objeto.setUlt(resultadoLista.getString(pos++));
/* 34 */     objeto.setHoraReal(resultadoLista.getString(pos++));
/* 35 */     objeto.setHoraNegocio(resultadoLista.getString(pos++));
/* 36 */     return objeto;
   }
   public int quantidadeCampos() {
/* 39 */     return 6;
   }

@Override
public DaoItemRetorno extraiRegistroListaInterna(
		ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
		throws DaoException, ClassNotFoundException, NoSuchMethodException,
		InvocationTargetException, IllegalAccessException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista,
		DCIObjetoDominio objeto) throws DaoException {
	// TODO Auto-generated method stub
	return null;
}
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoMontador
 * JD-Core Version:    0.6.0
 */
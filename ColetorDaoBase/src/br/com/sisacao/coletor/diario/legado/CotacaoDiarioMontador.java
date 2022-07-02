package br.com.sisacao.coletor.diario.legado;


import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DaoItemRetorno;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.dao.ResultadoLista;



//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class CotacaoDiarioMontador   implements MontadorDaoI { 

	public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista result,DCIObjetoDominio objeto) throws  DaoException
    {
		DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
	
    public DaoItemRetorno extraiRegistroInterno(ResultadoLista result, DCIObjetoDominio objeto) throws  DaoException
    {
    	DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
    
    public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = new CotacaoDiarioVo();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = new CotacaoDiarioVo();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		CotacaoDiario objeto;
		objeto = (CotacaoDiario)entrada;
		  
	  	objeto.setIdCotacaoDiario(resultadoLista.getInt(pos++));  
	  	objeto.setMinimoCorrigido(resultadoLista.getFloat(pos++));  
	  	objeto.setMaximoCorrigido(resultadoLista.getFloat(pos++));  
	  	objeto.setAberturaCorrigido(resultadoLista.getFloat(pos++));  
	  	objeto.setData(resultadoLista.getString(pos++));  
	  	objeto.setVolume(resultadoLista.getFloat(pos++));  
	  	objeto.setNegocios(resultadoLista.getInt(pos++));  
	  	objeto.setFechamentoOriginal(resultadoLista.getFloat(pos++));  
	  	objeto.setMinimoOriginal(resultadoLista.getFloat(pos++));  
	  	objeto.setMaximoOriginal(resultadoLista.getFloat(pos++));  
	  	objeto.setAberturaOriginal(resultadoLista.getFloat(pos++));  
	  	objeto.setFechamentoCorrigido(resultadoLista.getFloat(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 12;
	}
	
	/*
	Acho que fiz errado criando isso.
	@Override
	public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto) throws DaoException, ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		throw new UnsupportedOperationException();
	}
	@Override
	public DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto) throws DaoException {
		throw new UnsupportedOperationException();
	}
	*/

}

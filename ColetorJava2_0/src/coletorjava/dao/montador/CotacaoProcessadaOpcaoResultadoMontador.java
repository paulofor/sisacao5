package coletorjava.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletorjava.modelo.CotacaoProcessadaOpcaoResultado;
import coletorjava.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class CotacaoProcessadaOpcaoResultadoMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		CotacaoProcessadaOpcaoResultado objeto;
		objeto = (CotacaoProcessadaOpcaoResultado)entrada;
		  
	  	objeto.setIdCotacaoProcessadaOpcaoResultado(resultadoLista.getInt(pos++));  
	  	objeto.setData(resultadoLista.getString(pos++));  
	  	objeto.setHoraSerieTemporal(resultadoLista.getHoraMinuto(pos++));  
	  	objeto.setContadorDia(resultadoLista.getInt(pos++));  
	  	objeto.setCodigoMercadoOpcao(resultadoLista.getString(pos++));  
	  	objeto.setValorOpcao(resultadoLista.getFloat(pos++));  
	  	objeto.setResultadoT70S60(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT60S60(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT50S60(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT40S60(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT70S50(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT60S50(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT50S50(resultadoLista.getInt(pos++));  
	  	objeto.setResultadoT40S50(resultadoLista.getInt(pos++));  
	  	objeto.setValorSaidaT40S60(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT50S60(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT60S60(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT70S60(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT40S50(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT50S50(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT60S50(resultadoLista.getFloat(pos++));  
	  	objeto.setValorSaidaT70S50(resultadoLista.getFloat(pos++));  
	  	objeto.setDataHoraSaidaT40S60(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT50S60(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT60S60(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT70S60(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT40S50(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT50S50(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT60S50(resultadoLista.getString(pos++));  
	  	objeto.setDataHoraSaidaT70S50(resultadoLista.getString(pos++));  
	  	objeto.setValorAcao(resultadoLista.getFloat(pos++));  
	  	objeto.setLimiteDiaT50S50(resultadoLista.getFloat(pos++));  
	  	objeto.setLimiteDiaT60S60(resultadoLista.getFloat(pos++));  
	  	objeto.setIdOpcaoSisacaoRa(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 34;
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

package coletorjava.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletorjava.modelo.DadoTreino;
import coletorjava.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class DadoTreinoMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaDadoTreino();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaDadoTreino();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		DadoTreino objeto;
		objeto = (DadoTreino)entrada;
		  
	  	objeto.setIdDadoTreino(resultadoLista.getInt(pos++));  
	  	objeto.setNomeArquivoX(resultadoLista.getString(pos++));  
	  	objeto.setDiasEntradaDiario(resultadoLista.getInt(pos++));  
	  	objeto.setDiasEntradaIntraday(resultadoLista.getInt(pos++));  
	  	objeto.setTipoPeriodo(resultadoLista.getString(pos++));  
	  	objeto.setQtdeNeuronioEntrada(resultadoLista.getInt(pos++));  
	  	objeto.setCodigoFaixa(resultadoLista.getInt(pos++));  
	  	objeto.setUltimaAlteracao(resultadoLista.getString(pos++));  
	  	objeto.setQtdeTickIntraday(resultadoLista.getInt(pos++));  
	  	objeto.setNomeArquivoY(resultadoLista.getString(pos++));  
	  	objeto.setAno(resultadoLista.getInt(pos++));  
	  	objeto.setContadorPorAno(resultadoLista.getInt(pos++));  
	  	objeto.setMinutosIntraday(resultadoLista.getInt(pos++));  
	  	objeto.setIdProjetoDadoTreinoP(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 14;
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

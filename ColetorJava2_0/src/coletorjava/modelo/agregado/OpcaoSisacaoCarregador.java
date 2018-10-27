package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class OpcaoSisacaoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemOpcaoSisacaoSerie_PertenceA(OpcaoSisacao vo) throws DaoException
    {
       	OpcaoSisacaoSerieRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
    	if (conexao!=null ) { 
            vo.setOpcaoSisacaoSeriePertenceA(servico.obtemPorChave(vo.getIdOpcaoSisacaoSeriePa(), conexao));
	    } else {
	    	vo.setOpcaoSisacaoSeriePertenceA(servico.obtemPorChave(vo.getIdOpcaoSisacaoSeriePa()));
    	}
    }
 	
	public void CarregaItemTicker_DerivativoDe(OpcaoSisacao vo) throws DaoException
    {
       	TickerRegraColecao servico = FabricaRegra.getInstancia().getTickerRegraColecao();
    	if (conexao!=null ) { 
            vo.setTickerDerivativoDe(servico.obtemPorChave(vo.getIdTickerDd(), conexao));
	    } else {
	    	vo.setTickerDerivativoDe(servico.obtemPorChave(vo.getIdTickerDd()));
    	}
    }
 	
	
	
}
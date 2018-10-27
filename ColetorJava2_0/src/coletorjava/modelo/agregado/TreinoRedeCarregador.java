package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class TreinoRedeCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemRede_PertenceA(TreinoRede vo) throws DaoException
    {
       	RedeRegraColecao servico = FabricaRegra.getInstancia().getRedeRegraColecao();
    	if (conexao!=null ) { 
            vo.setRedePertenceA(servico.obtemPorChave(vo.getIdRedePa(), conexao));
	    } else {
	    	vo.setRedePertenceA(servico.obtemPorChave(vo.getIdRedePa()));
    	}
    }
 	
	public void CarregaItemDadoTreino_GeradoPor(TreinoRede vo) throws DaoException
    {
       	DadoTreinoRegraColecao servico = FabricaRegra.getInstancia().getDadoTreinoRegraColecao();
    	if (conexao!=null ) { 
            vo.setDadoTreinoGeradoPor(servico.obtemPorChave(vo.getIdDadoTreinoGp(), conexao));
	    } else {
	    	vo.setDadoTreinoGeradoPor(servico.obtemPorChave(vo.getIdDadoTreinoGp()));
    	}
    }
 	
	
	
}
package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class ProjetoDadoTreinoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemTicker_ReferenteA(ProjetoDadoTreino vo) throws DaoException
    {
       	TickerRegraColecao servico = FabricaRegra.getInstancia().getTickerRegraColecao();
    	if (conexao!=null ) { 
            vo.setTickerReferenteA(servico.obtemPorChave(vo.getIdTickerRa(), conexao));
	    } else {
	    	vo.setTickerReferenteA(servico.obtemPorChave(vo.getIdTickerRa()));
    	}
    }
 	
	
	
}
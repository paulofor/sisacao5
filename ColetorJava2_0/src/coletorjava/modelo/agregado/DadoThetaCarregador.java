package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class DadoThetaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemTreinoRede_GeradoPor(DadoTheta vo) throws DaoException
    {
       	TreinoRedeRegraColecao servico = FabricaRegra.getInstancia().getTreinoRedeRegraColecao();
    	if (conexao!=null ) { 
            vo.setTreinoRedeGeradoPor(servico.obtemPorChave(vo.getIdTreinoRedeGp(), conexao));
	    } else {
	    	vo.setTreinoRedeGeradoPor(servico.obtemPorChave(vo.getIdTreinoRedeGp()));
    	}
    }
 	
	
	
}
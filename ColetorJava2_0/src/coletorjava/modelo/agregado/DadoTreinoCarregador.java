package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class DadoTreinoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProjetoDadoTreino_Possui(DadoTreino vo) throws DaoException
    {
       	ProjetoDadoTreinoRegraColecao servico = FabricaRegra.getInstancia().getProjetoDadoTreinoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProjetoDadoTreinoPossui(servico.obtemPorChave(vo.getIdProjetoDadoTreinoP(), conexao));
	    } else {
	    	vo.setProjetoDadoTreinoPossui(servico.obtemPorChave(vo.getIdProjetoDadoTreinoP()));
    	}
    }
 	
	
	
}
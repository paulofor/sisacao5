package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class DispositivoUsuarioCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemUsuario_ReferenteA(DispositivoUsuario vo) throws DaoException
    {
       	UsuarioRegraColecao servico = FabricaRegra.getInstancia().getUsuarioRegraColecao();
    	if (conexao!=null ) { 
            vo.setUsuarioReferenteA(servico.obtemPorChave(vo.getIdUsuarioRa(), conexao));
	    } else {
	    	vo.setUsuarioReferenteA(servico.obtemPorChave(vo.getIdUsuarioRa()));
    	}
    }
 	
	
	
}
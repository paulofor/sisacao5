package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class ResultadoMesCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProjetoDadoTreino_GeradoPor(ResultadoMes vo) throws DaoException
    {
       	ProjetoDadoTreinoRegraColecao servico = FabricaRegra.getInstancia().getProjetoDadoTreinoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProjetoDadoTreinoGeradoPor(servico.obtemPorChave(vo.getIdProjetoDadoTreinoGp(), conexao));
	    } else {
	    	vo.setProjetoDadoTreinoGeradoPor(servico.obtemPorChave(vo.getIdProjetoDadoTreinoGp()));
    	}
    }
 	
	public void CarregaItemMesAno_ReferenteA(ResultadoMes vo) throws DaoException
    {
       	MesAnoRegraColecao servico = FabricaRegra.getInstancia().getMesAnoRegraColecao();
    	if (conexao!=null ) { 
            vo.setMesAnoReferenteA(servico.obtemPorChave(vo.getIdMesAnoRa(), conexao));
	    } else {
	    	vo.setMesAnoReferenteA(servico.obtemPorChave(vo.getIdMesAnoRa()));
    	}
    }
 	
	
	
}
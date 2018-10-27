package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class ResultadoPrevisaoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemDadoTheta_GeradoDe(ResultadoPrevisao vo) throws DaoException
    {
       	DadoThetaRegraColecao servico = FabricaRegra.getInstancia().getDadoThetaRegraColecao();
    	if (conexao!=null ) { 
            vo.setDadoThetaGeradoDe(servico.obtemPorChave(vo.getIdDadoThetaGd(), conexao));
	    } else {
	    	vo.setDadoThetaGeradoDe(servico.obtemPorChave(vo.getIdDadoThetaGd()));
    	}
    }
 	
	public void CarregaItemResultadoMes_MesmoPeriodo(ResultadoPrevisao vo) throws DaoException
    {
       	ResultadoMesRegraColecao servico = FabricaRegra.getInstancia().getResultadoMesRegraColecao();
    	if (conexao!=null ) { 
            vo.setResultadoMesMesmoPeriodo(servico.obtemPorChave(vo.getIdResultadoMesMp(), conexao));
	    } else {
	    	vo.setResultadoMesMesmoPeriodo(servico.obtemPorChave(vo.getIdResultadoMesMp()));
    	}
    }
 	
	public void CarregaItemMesAno_ReferenteA(ResultadoPrevisao vo) throws DaoException
    {
       	MesAnoRegraColecao servico = FabricaRegra.getInstancia().getMesAnoRegraColecao();
    	if (conexao!=null ) { 
            vo.setMesAnoReferenteA(servico.obtemPorChave(vo.getIdMesAnoRa(), conexao));
	    } else {
	    	vo.setMesAnoReferenteA(servico.obtemPorChave(vo.getIdMesAnoRa()));
    	}
    }
 	
	
	
}
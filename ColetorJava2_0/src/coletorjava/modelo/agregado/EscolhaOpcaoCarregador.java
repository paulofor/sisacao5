package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class EscolhaOpcaoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemTicker_ReferenteA(EscolhaOpcao vo) throws DaoException
    {
       	TickerRegraColecao servico = FabricaRegra.getInstancia().getTickerRegraColecao();
    	if (conexao!=null ) { 
            vo.setTickerReferenteA(servico.obtemPorChave(vo.getIdTickerRa(), conexao));
	    } else {
	    	vo.setTickerReferenteA(servico.obtemPorChave(vo.getIdTickerRa()));
    	}
    }
 	
	public void CarregaItemOpcaoSisacao_Escolha(EscolhaOpcao vo) throws DaoException
    {
       	OpcaoSisacaoRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
    	if (conexao!=null ) { 
            vo.setOpcaoSisacaoEscolha(servico.obtemPorChave(vo.getIdOpcaoSisacaoE(), conexao));
	    } else {
	    	vo.setOpcaoSisacaoEscolha(servico.obtemPorChave(vo.getIdOpcaoSisacaoE()));
    	}
    }
 	
	public void CarregaItemDiaPregao_ReferenteA(EscolhaOpcao vo) throws DaoException
    {
       	DiaPregaoRegraColecao servico = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
    	if (conexao!=null ) { 
            vo.setDiaPregaoReferenteA(servico.obtemPorChave(vo.getIdDiaPregaoRa(), conexao));
	    } else {
	    	vo.setDiaPregaoReferenteA(servico.obtemPorChave(vo.getIdDiaPregaoRa()));
    	}
    }
 	
	
	
}
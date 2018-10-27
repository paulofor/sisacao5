package coletorjava.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.*;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.*;

public class CotacaoProcessadaOpcaoResultadoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemOpcaoSisacao_ReferenteA(CotacaoProcessadaOpcaoResultado vo) throws DaoException
    {
       	OpcaoSisacaoRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
    	if (conexao!=null ) { 
            vo.setOpcaoSisacaoReferenteA(servico.obtemPorChave(vo.getIdOpcaoSisacaoRa(), conexao));
	    } else {
	    	vo.setOpcaoSisacaoReferenteA(servico.obtemPorChave(vo.getIdOpcaoSisacaoRa()));
    	}
    }
 	
	
	
}
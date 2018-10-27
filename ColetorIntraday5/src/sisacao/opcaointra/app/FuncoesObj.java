package sisacao.opcaointra.app;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import sisacao.opcaointra.dao.UtilConexao;

public class FuncoesObj {

	
	public void pesquisOpcoesComVolume() throws DaoException{
		//OpcaoSisacaoGeralRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		//List<OpcaoSisacaoGeral> lista = opcaoSrv.MelhoresParaColeta();
		// Na hora de armazenar o objeto usado e esse :
		OpcaoSisacaoRegraColecao opcaoBdSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		DaoConexao conexao = UtilConexao.getConexao5();
		opcaoBdSrv.CriaParaColetaPorVolumeNegocioDiaAnterior(conexao);
		conexao.fechaConexao();
		conexao = null;
	}
}

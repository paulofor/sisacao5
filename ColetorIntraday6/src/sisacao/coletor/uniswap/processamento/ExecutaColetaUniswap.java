package sisacao.coletor.uniswap.processamento;


import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2Post;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.coletor.uniswap.daobase.ColetorUniswapDaoBase;
import sisacao.coletor.uniswap.daobase.DatasetColetorUniswap;

public class ExecutaColetaUniswap extends  ColetorUniswapDaoBase{
	
	private DummyDaoBase dummy = null;
	ExecutadorParseApache2Post executador =  new ExecutadorParseApache2Post();
	UniswapDado dados = new UniswapDado();
	UniswapCallback callback = new UniswapCallback();
	

	DatasetColetorUniswap ds = null;
	
	public ExecutaColetaUniswap() {
		//DatasetColetorCDB ds = new DatasetColetorCDB();
		//ds.setAtivoAcaoCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected void executaImpl() {

		dados.setDs((DatasetColetorUniswap) this.getComum());
		executador.setCallbackParse(callback);
		executador.setDadosParse(dados);
		try {
			executador.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		finalizar();
	}

}

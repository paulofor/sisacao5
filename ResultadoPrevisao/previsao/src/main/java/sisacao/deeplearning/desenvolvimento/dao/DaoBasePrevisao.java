package sisacao.deeplearning.desenvolvimento.dao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioPrevisaoRede;
import br.com.digicom.sisacao.repositorio.RepositorioPrevisaoTeste;
import br.com.digicom.sisacao.repositorio.RepositorioTradeTreinoRede;
import br.com.digicom.sisacao.repositorio.RepositorioTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoBasePrevisao extends DaoBase{
	
	
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioPrevisaoTeste repPrevisao = adapter.createRepository(RepositorioPrevisaoTeste.class);
	protected RepositorioTreinoRede repTreino = adapter.createRepository(RepositorioTreinoRede.class);
	protected RepositorioTradeTreinoRede repTrade = adapter.createRepository(RepositorioTradeTreinoRede.class);

	protected RepositorioPrevisaoRede repPrevisaoExecucao = adapter.createRepository(RepositorioPrevisaoRede.class);
	
	@Override
	protected long getTempo() {
		return 10000;
	}
	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetResultadoPrevisao();
	}

}

package sisacao.deeplearning.desenvolvimento.dao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioPrevisaoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoBasePrevisao extends DaoBase{
	
	
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioPrevisaoRede repPrevisao = adapter.createRepository(RepositorioPrevisaoRede.class);
	

	@Override
	protected long getTempo() {
		return 10000;
	}
	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetResultadoPrevisao();
	}

}

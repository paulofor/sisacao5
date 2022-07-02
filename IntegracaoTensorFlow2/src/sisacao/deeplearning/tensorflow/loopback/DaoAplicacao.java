package sisacao.deeplearning.tensorflow.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioRedeNeural;
import br.com.digicom.sisacao.repositorio.RepositorioTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoAplicacao extends DaoBase{
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioRedeNeural repRede = adapter.createRepository(RepositorioRedeNeural.class);
	protected RepositorioTreinoRede repTreinoRede = adapter.createRepository(RepositorioTreinoRede.class);

	@Override
	protected long getTempo() {
		return 10000;
	}

	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetTreinoRede();
	}

	

}

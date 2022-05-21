package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcaoEntrada;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcaoSaida;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoBaseApp extends DaoBase{
	
	
	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioAcaoBase.AtivoAcaoRepository repAtivoAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	protected RepositorioExemploTreinoAcao repExemploTreino = adapter.createRepository(RepositorioExemploTreinoAcao.class);
	
	protected RepositorioExemploTreinoAcaoEntrada repExemploTreinoEntrada 
			= adapter.createRepository(RepositorioExemploTreinoAcaoEntrada.class);
	protected RepositorioExemploTreinoAcaoSaida repExemploTreinoSaida
			= adapter.createRepository(RepositorioExemploTreinoAcaoSaida.class);

	@Override
	protected long getTempo() {
		return 300000;
	}
	
	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetComum();
	}

}

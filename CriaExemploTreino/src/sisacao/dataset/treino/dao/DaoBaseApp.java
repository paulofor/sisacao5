package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.loopback.DaoBase;
import sisacao.dataset.treino.app.CriaExemploTreinoAcaoApp;

public abstract class DaoBaseApp extends DaoBase{
	
	
	
	private RestAdapter adapter = new RestAdapter(CriaExemploTreinoAcaoApp.UrlLoopback); 
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioExemploTreinoAcao repExemploTreino = adapter.createRepository(RepositorioExemploTreinoAcao.class);
	

}

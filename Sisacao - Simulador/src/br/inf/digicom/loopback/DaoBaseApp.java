package br.inf.digicom.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExemploTreinoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioPeriodoExperimento;
import br.com.digicom.sisacao.repositorio.RepositorioPontoEntradaSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.Constantes;



public abstract class DaoBaseApp extends DaoBase {


	
	private RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	protected RepositorioPeriodoExperimento repPeriodo = adapter.createRepository(RepositorioPeriodoExperimento.class);
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioExemploTreinoAcao repExemploTreino = adapter.createRepository(RepositorioExemploTreinoAcao.class);
	protected final RepositorioAcaoBase.AtivoAcaoRepository repAcao = 
			adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	protected RepositorioPontoEntradaSimulacao repPontoEntrada = adapter.createRepository(RepositorioPontoEntradaSimulacao.class);
	
	

}

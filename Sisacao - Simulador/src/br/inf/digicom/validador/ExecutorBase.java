package br.inf.digicom.validador;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioCombinacaoParametro;
import br.com.digicom.sisacao.repositorio.RepositorioExperimentoSimulacao;
import br.inf.digicom.Constantes;

public abstract class ExecutorBase {
	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	protected RepositorioCombinacaoParametro repCombinacao = adapter.createRepository(RepositorioCombinacaoParametro.class);
	protected RepositorioExperimentoSimulacao repExperimento = adapter.createRepository(RepositorioExperimentoSimulacao.class);
	protected RepositorioAcaoBase.AtivoAcaoRepository repAtivoAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);

}

package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.desen.CotacaoRegraProjecaoValorApp;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.IDatasetComum;

public abstract class ExecutorRegraProjecao extends DaoBase{

	
	RestAdapter adapter = new RestAdapter(CotacaoRegraProjecaoValorApp.UrlLoopback); 
	
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository repValor = 
			adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository.class);
	
	protected final RepositorioAcaoBase.AtivoAcaoRepository repAcao = 
			adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	protected RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository repResultado = 
			adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository.class);

	@Override
	protected long getTempo() {
		return 0;
	}

	

	@Override
	protected IDatasetComum criaDataSet() {
		return new DatasetRegraProjecao();
	}

	
	
}

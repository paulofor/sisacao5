package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.desen.CotacaoRegraProjecaoValorApp;

public class ExecutorRegraProjecao {

	
	RestAdapter adapter = new RestAdapter(CotacaoRegraProjecaoValorApp.UrlLoopback); 
	
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository repValor = 
			adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository.class);
	
	protected final RepositorioAcaoBase.AtivoAcaoRepository repAcao = 
			adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	protected RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository repResultado = 
			adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoRepository.class);
	
}

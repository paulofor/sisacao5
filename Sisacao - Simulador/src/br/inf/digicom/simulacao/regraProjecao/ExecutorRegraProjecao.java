package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;

public class ExecutorRegraProjecao {

	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	protected RepositorioRegraProjecao repRegraProjecao = adapter.createRepository(RepositorioRegraProjecao.class);
	protected RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	protected RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository repValor = 
			adapter.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoResultadoValorRepository.class);
	
}

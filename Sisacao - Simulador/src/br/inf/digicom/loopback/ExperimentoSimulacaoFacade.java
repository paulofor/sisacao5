package br.inf.digicom.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioCombinacaoParametro;
import br.com.digicom.sisacao.repositorio.RepositorioExperimentoSimulacao;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExperimentoSimulacaoFacade {

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	RepositorioCombinacaoParametro repCombinacao = adapter.createRepository(RepositorioCombinacaoParametro.class);
	RepositorioExperimentoSimulacao repExperimento = adapter.createRepository(RepositorioExperimentoSimulacao.class);
	RepositorioAcaoBase.AtivoAcaoRepository repAtivoAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	ExperimentoSimulacao experimentoSimulacao = null;
	List<AtivoAcao> listaAtivo = null;
	
	ExecutadorSimulacao executador = new ExecutadorSimulacao();
	
	public void carregaExperimento(Long idExperimento) {
		repExperimento.carregaParaSimulacao(idExperimento, new ObjectCallback<ExperimentoSimulacao>() {

			@Override
			public void onSuccess(ExperimentoSimulacao experimento) {
				System.out.println(experimento.getCodigo());
				experimentoSimulacao = experimento;
				carregaAtivos(experimento.getGrupoAcaoId());
				//carregaCombinacao((Integer) experimento.getId());
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
	}
	
	public void carregaCombinacao(Integer id) {
		repCombinacao.getProximoExecucao(id, new ObjectCallback<CombinacaoParametro>() {
			@Override
			public void onSuccess(CombinacaoParametro combinacao) {
				System.out.println(combinacao);
				executador.executa(listaAtivo.get(0),combinacao,experimentoSimulacao);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
	}
	
	public void carregaAtivos(Integer idGrupo) {
		repAtivoAcao.listaPorGrupo(idGrupo, new ListCallback<AtivoAcao>() {
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				listaAtivo = objects;
				carregaCombinacao((Integer) experimentoSimulacao.getId());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}
	
	
	
	
}

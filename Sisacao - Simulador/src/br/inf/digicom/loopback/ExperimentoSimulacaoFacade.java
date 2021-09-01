package br.inf.digicom.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioCombinacaoParametro;
import br.com.digicom.sisacao.repositorio.RepositorioExperimentoSimulacao;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.validacao.ExecutadorSimulacaoValidacao;

public class ExperimentoSimulacaoFacade {

	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	RepositorioCombinacaoParametro repCombinacao = adapter.createRepository(RepositorioCombinacaoParametro.class);
	RepositorioExperimentoSimulacao repExperimento = adapter.createRepository(RepositorioExperimentoSimulacao.class);
	RepositorioAcaoBase.AtivoAcaoRepository repAtivoAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	ExperimentoSimulacao experimentoSimulacao = null;
	List<AtivoAcao> listaAtivo = null;
	
	ExecutadorSimulacao executador = new ExecutadorSimulacao();
	ExecutadorSimulacaoValidacao executadorValidacao = new ExecutadorSimulacaoValidacao();
	
	ExperimentoSimulacao experimentoValidacao = null;
	
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
	
	public void obtemExperimento() {
		repExperimento.obtemParaSimulacao( new ObjectCallback<ExperimentoSimulacao>() {

			@Override
			public void onSuccess(ExperimentoSimulacao experimento) {
				System.out.println(experimento.getCodigo());
				experimentoSimulacao = experimento;
				carregaAtivos(experimento.getGrupoAcaoId(),experimento.diaInicioColeta());
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
	}
	
	
	public void carregaCombinacao(Integer id) {
		repCombinacao.getListaExecucao(id, new ListCallback<CombinacaoParametro>() {
			@Override
			public void onSuccess(List<CombinacaoParametro> listaCombinacao) {
				for (CombinacaoParametro combinacao : listaCombinacao) {
					executador.executa(listaAtivo,combinacao,experimentoSimulacao);
					salvaDescricaoCombinacao(combinacao);
				}
				fechaExperimento(id);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
	}
	
	public void fechaExperimento(final Integer idExperimento) {
		repExperimento.fechaExperimento(idExperimento,new VoidCallback() {
			@Override
			public void onSuccess() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Terminou execucao");
				System.exit(0);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.out.println("Terminou execucao");
				System.exit(0);
			}
		});
	}
	
	public void salvaDescricaoCombinacao(final CombinacaoParametro combinacao) {
		repCombinacao.alteraDescricao(combinacao.getId(), combinacao.descricaoSemTargetStop(),  new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Alterou descrição");
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
				RepositorioCotacao.carregaAtivos(listaAtivo);
				carregaCombinacao((Integer) experimentoSimulacao.getId());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}
	
	public void carregaAtivos(Integer idGrupo,final int diaNumInicioColeta) {
		repAtivoAcao.listaPorGrupo(idGrupo, new ListCallback<AtivoAcao>() {
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				listaAtivo = objects;
				RepositorioCotacao.carregaAtivos(listaAtivo, diaNumInicioColeta);
				carregaCombinacao((Integer) experimentoSimulacao.getId());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}

	public void obtemExperimentoValidacao() {
		// TODO Auto-generated method stub
		repExperimento.obtemParaValidacao( new ObjectCallback<ExperimentoSimulacao>() {

			@Override
			public void onSuccess(ExperimentoSimulacao experimento) {
				System.out.println(experimento.getCodigo());
				experimentoValidacao = experimento;
				carregaMelhorAtivos(experimento);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
	}
	
	public void carregaMelhorAtivos(ExperimentoSimulacao experimento) {
		repAtivoAcao.melhorSimulacaoPorExperimento(experimento.getId(), 18, 3, new ListCallback<AtivoAcao>() {
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				listaAtivo = objects;
				RepositorioCotacao.carregaAtivos(listaAtivo, experimento.diaInicioColeta());
				carregaCombinacaoValidacao((Integer) experimentoSimulacao.getId());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
	}
	public void carregaCombinacaoValidacao(Integer id) {
		repCombinacao.getListaExecucao(id, new ListCallback<CombinacaoParametro>() {
			@Override
			public void onSuccess(List<CombinacaoParametro> listaCombinacao) {
				for (CombinacaoParametro combinacao : listaCombinacao) {
					executadorValidacao.executa(listaAtivo,combinacao,experimentoSimulacao);
					//salvaDescricaoCombinacao(combinacao);
				}
				fechaExperimento(id);
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
	}
	
}

package br.inf.digicom;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioCombinacaoParametro;
import br.com.digicom.sisacao.repositorio.RepositorioExperimentoSimulacao;

public class MontaValidacaoSimulacaoObj {

	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	RepositorioCombinacaoParametro repCombinacao = adapter.createRepository(RepositorioCombinacaoParametro.class);
	RepositorioExperimentoSimulacao repExperimento = adapter.createRepository(RepositorioExperimentoSimulacao.class);
	RepositorioAcaoBase.AtivoAcaoRepository repAtivoAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);

	private boolean obtemExperimentoValidacaoOk = false;
	public void executa() {
		repExperimento.obtemParaValidacao( new ObjectCallback<ExperimentoSimulacao>() {
			@Override
			public void onSuccess(ExperimentoSimulacao experimento) {
				System.out.println("Experimento:" + experimento.getCodigo());
	 			//experimentoValidacao = experimento;
				//carregaMelhorAtivos(experimento);
				obtemExperimentoValidacaoOk = true;
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		}); 
		while (!obtemExperimentoValidacaoOk) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}

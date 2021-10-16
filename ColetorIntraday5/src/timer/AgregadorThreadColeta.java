package timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.cotacao.threads.Tempo;
import br.com.digicom.parse.RestricaoTempo;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.Ativo;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.AtivoImobiliario;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.digicom.sisacao.modelo.AtivoOpcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioImobiliarioBase;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.com.digicom.sisacao.repositorio.RepositorioMercadoriaBase;
import br.com.digicom.sisacao.repositorio.RepositorioOpcaoBase;
import sisacao.opcaointra.cotacao.PesquisadorIntradayAtivo;
import sisacao.opcaointra.cotacao.PesquisadorIntradayAtivoIndice;

public class AgregadorThreadColeta {

	private List<PesquisadorIntradayAtivo> listaThreads = null;
	
	private List<ColetorIndividualTh> listaColetor = null;
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioAcaoBase.AtivoAcaoRepository repAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	RepositorioOpcaoBase.AtivoOpcaoRepository repOpcao = adapter.createRepository(RepositorioOpcaoBase.AtivoOpcaoRepository.class);
	RepositorioMercadoriaBase.AtivoMercadoriaRepository repMercadoria = adapter.createRepository(RepositorioMercadoriaBase.AtivoMercadoriaRepository.class);
	RepositorioImobiliarioBase.AtivoImobiliarioRepository repImobiliario = adapter.createRepository(RepositorioImobiliarioBase.AtivoImobiliarioRepository.class);
	RepositorioIndiceBase.AtivoIndiceRepository repIndice = adapter.createRepository(RepositorioIndiceBase.AtivoIndiceRepository.class);

	
	final Timer timer = new Timer();
	

	
	public AgregadorThreadColeta() {
		listaThreads = new ArrayList<PesquisadorIntradayAtivo>();
		listaColetor = new ArrayList<ColetorIndividualTh>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		for (PesquisadorIntradayAtivo item: listaThreads) {
			item.cancel();
		}
		listaThreads.clear();
	}


	


	

	public void disparaColetoresDia(String diaAtual) {
		this.disparaColetoresDiaAcao(diaAtual);
		this.disparaColetoresDiaImobiliario(diaAtual);
		this.disparaColetoresDiaMercadoria(diaAtual);
		//this.disparaColetoresDiaOpcao(diaAtual);
		this.disparaColetoresDiaIndice(diaAtual);
	}
	
	
	private void disparaColetoresDiaAcao(final String diaAtual) {
		final RestricaoTempo restricao = getRestricaoTempo();
		repAcao.findAll(new ListCallback<AtivoAcao>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				System.out.println("Total Acao: " + objects.size());
				for (AtivoAcao item : objects) {
					inicializaAtivo((Ativo)item, diaAtual, restricao);
				}
			} 
        });
		
	}

	public void disparaColetoresDiaIndice(final String diaAtual) {
		final RestricaoTempo restricao = getRestricaoTempo();
		repIndice.findAll(new ListCallback<AtivoIndice>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoIndice> objects) {
				System.out.println("Total Indice: " + objects.size());
				for (AtivoIndice item : objects) {
					inicializaAtivo((Ativo)item, diaAtual, restricao);
				}
			} 
        });
	}
	private void disparaColetoresDiaOpcao(final String diaAtual) {
		final RestricaoTempo restricao = getRestricaoTempo();
		repOpcao.findAll(new ListCallback<AtivoOpcao>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoOpcao> objects) {
				System.out.println("Total Acao: " + objects.size());
				for (AtivoOpcao item : objects) {
					inicializaAtivo((Ativo)item, diaAtual, restricao);
				}
			} 
        });
	}
	private void disparaColetoresDiaImobiliario(final String diaAtual) {
		final RestricaoTempo restricao = getRestricaoTempo();
		repImobiliario.findAll(new ListCallback<AtivoImobiliario>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoImobiliario> objects) {
				System.out.println("Total Acao: " + objects.size());
				for (AtivoImobiliario item : objects) {
					inicializaAtivo((Ativo)item, diaAtual, restricao);
				}
			} 
        });
	}
	private void disparaColetoresDiaMercadoria(final String diaAtual) {
		final RestricaoTempo restricao = getRestricaoTempo();
		repMercadoria.findAll(new ListCallback<AtivoMercadoria>() { 
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			@Override
			public void onSuccess(List<AtivoMercadoria> objects) {
				for (AtivoMercadoria item : objects) {
					inicializaAtivo((Ativo)item, diaAtual, restricao);
				}
			} 
        });
	}

	
	private final void inicializaAtivo(Ativo ativo, String diaAtual, RestricaoTempo restricao) {
		System.out.println("Inicializando: " + ativo.getTicker() + "(" + ativo.minutos() + ")");
		PesquisadorIntradayAtivo timerThread = null;
		if (ativo instanceof AtivoIndice) {
			timerThread = new PesquisadorIntradayAtivoIndice();
		} else {
			timerThread = new PesquisadorIntradayAtivo();
		}
		timerThread.inicializa(ativo, diaAtual, restricao);
		timer.schedule(timerThread, 0L, ativo.milisegundos());
		listaThreads.add(timerThread);
	}
	

	
	private RestricaoTempo getRestricaoTempo() {
		Tempo restricao = new Tempo();
		//restricao.inicializaHorarios(10, 23); // Parra testes
		restricao.inicializaHorarios(9, 50, 17,50);
		return restricao;
	}
}

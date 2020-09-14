package timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.cotacao.threads.Tempo;
import br.com.digicom.parse.RestricaoTempo;
import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import sisacao.opcaointra.cotacao.PesquisadorIntradayAtivo;

public class AgregadorThreadColeta {

	private List<PesquisadorIntradayAtivo> listaThreads = null;
	
	private List<ColetorIndividualTh> listaColetor = null;
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO);
	RepositorioAcaoBase.AtivoAcaoRepository repAcao = adapter.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);

	
	
	final Timer timer = new Timer();
	

	
	public AgregadorThreadColeta() {
		listaThreads = new ArrayList<PesquisadorIntradayAtivo>();
		listaColetor = new ArrayList<ColetorIndividualTh>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		
	}


	


	

	public void disparaColetoresDia(String diaAtual) {
		this.disparaColetoresDiaAcao(diaAtual);
		this.disparaColetoresDiaImobiliario(diaAtual);
		this.disparaColetoresDiaMercadoria(diaAtual);
		this.disparaColetoresDiaOpcao(diaAtual);
	}
	
	
	private void disparaColetoresDiaAcao(final String diaAtual) {
		final int ms = 60000 * 2;
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
					System.out.println("Token:" + item.getTicker());
					PesquisadorIntradayAtivo timerThread = new PesquisadorIntradayAtivo();
					timerThread.inicializa(item, diaAtual, restricao);
					timer.schedule(timerThread, 0L, ms);
					listaThreads.add(timerThread);
				}
			} 
        });
		
	}
	private void disparaColetoresDiaOpcao(final String diaAtual) {
		
	}
	private void disparaColetoresDiaImobiliario(final String diaAtual) {
		
	}
	private void disparaColetoresDiaMercadoria(final String diaAtual) {
		
	}
	
	
	private List<OpcaoSisacao> listaOpcaoDia(String diaAtual) {
		List<OpcaoSisacao> listaOpcao = new ArrayList<OpcaoSisacao>();
		OpcaoSisacao opcao = FabricaVo.criaOpcaoSisacao();
		opcao.setCodigoMercado("PETR4");
		listaOpcao.add(opcao);
		opcao = FabricaVo.criaOpcaoSisacao();
		opcao.setCodigoMercado("PETRU216");
		listaOpcao.add(opcao);
		opcao = FabricaVo.criaOpcaoSisacao();
		opcao.setCodigoMercado("HGLG11");
		listaOpcao.add(opcao);
		opcao = FabricaVo.criaOpcaoSisacao();
		opcao.setCodigoMercado("OZ1D");
		listaOpcao.add(opcao);
		return listaOpcao;
	}

	
	private RestricaoTempo getRestricaoTempo() {
		Tempo restricao = new Tempo();
		//restricao.inicializaHorarios(10, 23); // Parra testes
		restricao.inicializaHorarios(10, 18);
		return restricao;
	}
}

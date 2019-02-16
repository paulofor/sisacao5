package timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import sisacao.opcaointra.app.PesquisadorCotacaoOpcao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;
import br.com.digicom.cotacao.threads.Tempo;
import br.com.digicom.parse.RestricaoTempo;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;

public class AgregadorThreadColeta {

	private List<PesquisadorTicker> listaThreads = null;
	
	private List<ColetorIndividualTh> listaColetor = null;
	private OpcaoSisacaoRegraColecao opcaoBdSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
	
	Timer timer = new Timer();
	

	
	public AgregadorThreadColeta() {
		listaThreads = new ArrayList<PesquisadorTicker>();
		listaColetor = new ArrayList<ColetorIndividualTh>();
	}

	
	
	public void limpaColetoresAtual() {
		// TODO Auto-generated method stub
		
	}


	


	private PesquisadorTicker getPesquisador() {
		return new PesquisadorCotacaoOpcao();
	}


	public void disparaColetoresDia(String mesDia) {
		// TODO Auto-generated method stub
		int ms = 60000 * 2;
		RestricaoTempo restricao = getRestricaoTempo();
		listaColetor = new ArrayList<ColetorIndividualTh>();
		List<OpcaoSisacao> listaOpcao = listaOpcaoDia(mesDia, 2017);
		for (OpcaoSisacao opcaoDia : listaOpcao) {
			//ColetorIndividualTh th = new ColetorIndividualTh(opcaoDia.getCodigoMercado());
			PesquisadorTicker timerThread = getPesquisador();
			timerThread.inicializa(opcaoDia.getCodigoMercado(), restricao);
			this.timer.schedule(timerThread, 0L, ms);
			this.listaThreads.add(timerThread);
		}
		
		
		
	}
	
	private List<OpcaoSisacao> listaOpcaoDia(String mesDia, int ano) {
		List<OpcaoSisacao> listaOpcao = new ArrayList<OpcaoSisacao>();
		OpcaoSisacao opcao = FabricaVo.criaOpcaoSisacao();
		opcao.setCodigoMercado("PETR4");
		listaOpcao.add(opcao);
		return listaOpcao;
	}

	
	private RestricaoTempo getRestricaoTempo() {
		Tempo restricao = new Tempo();
		restricao.inicializaHorarios(10, 23); // Parra testes
		//restricao.inicializaHorarios(10, 18);
		return restricao;
	}
}

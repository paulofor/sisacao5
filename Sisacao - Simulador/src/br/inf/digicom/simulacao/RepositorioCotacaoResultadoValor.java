package br.inf.digicom.simulacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.Constantes;
import br.inf.digicom.TempoSleep;

public class RepositorioCotacaoResultadoValor {
	
	private static RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	private static Map<String,List<DiaPregao>> cotacoes = new HashMap<String,List<DiaPregao>>();
	private static RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	
	private static int contaLista = 0;
	
	public static void carregaAtivos(List<AtivoAcao> listaAtivo) {
		for (AtivoAcao ativo : listaAtivo) {
			carregaAtivo(ativo.getTicker());
		}
	}
	public static synchronized void carregaAtivos(List<AtivoAcao> listaAtivo, int diaNumInicioColeta) {
		for (AtivoAcao ativo : listaAtivo) {
			carregaAtivo(ativo.getTicker(), diaNumInicioColeta);
		}
	}
	
	public static void carregaPorTicker(String ticker) {
		if (cotacoes.get(ticker)==null) {
			carregaAtivo(ticker);
			try {
				Thread.sleep(TempoSleep.LOOP_CARREGA_ATIVO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	private static synchronized void carregaAtivo(String ticker) {
		ListCallback<DiaPregao> callback = new ListCallback<DiaPregao>() {
			@Override
			public void onSuccess(List<DiaPregao> lista) {
				cotacoes.put(ticker, lista);
				contaLista++;
				System.out.println("Contagem:" + contaLista + " " + ticker);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}
		};
		repDiaPregao.obtemPorDiaTicker(ticker, 0, callback); 
	}
	
	private static boolean carregaAtivoOk = false;
	private static synchronized void carregaAtivo(String ticker, final int diaNumInicio) {
		carregaAtivoOk = false;
		ListCallback<DiaPregao> callback = new ListCallback<DiaPregao>() {
			@Override
			public void onSuccess(List<DiaPregao> lista) {
				cotacoes.put(ticker, lista);
				contaLista++;
				System.out.println("Contagem:" + contaLista + " " + ticker);
				carregaAtivoOk = true;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}
		};
		repDiaPregao.obtemIntradayTickerPeriodo(ticker, diaNumInicio, callback); 
		while (!carregaAtivoOk) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static boolean carregaAtivoResultadoOk = false;
	public static synchronized void carregaAtivoResultado(String ticker, final int diaNumInicio) {
		carregaAtivoOk = false;
		ListCallback<DiaPregao> callback = new ListCallback<DiaPregao>() {
			@Override
			public void onSuccess(List<DiaPregao> lista) {
				cotacoes.put(ticker, lista);
				contaLista++;
				System.out.println("Contagem:" + contaLista + " " + ticker);
				carregaAtivoResultadoOk = true;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}
		};
		repDiaPregao.obtemIntradayResultadoTickerPeriodo(ticker, diaNumInicio, callback); 
		while (!carregaAtivoResultadoOk) {
			System.out.println(carregaAtivoResultadoOk);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<DiaPregao> getCotacao(AtivoAcao ativo) {
		return cotacoes.get(ativo.getTicker());
	}
	public static List<DiaPregao> getCotacao(String ticker) {
		return cotacoes.get(ticker);
	}
	

}

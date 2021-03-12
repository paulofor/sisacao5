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

public class RepositorioCotacao {
	
	private static RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	private static Map<String,List<DiaPregao>> cotacoes = new HashMap<String,List<DiaPregao>>();
	private static RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	
	private static int contaLista = 0;
	
	public static void carregaAtivos(List<AtivoAcao> listaAtivo) {
		for (AtivoAcao ativo : listaAtivo) {
			carregaAtivo(ativo);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private static synchronized void carregaAtivo(AtivoAcao ativo) {
		ListCallback<DiaPregao> callback = new ListCallback<DiaPregao>() {
			@Override
			public void onSuccess(List<DiaPregao> lista) {
				cotacoes.put(ativo.getTicker(), lista);
				contaLista++;
				System.out.println("Contagem:" + contaLista + " " + ativo.getTicker());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}
		};
		repDiaPregao.obtemPorDiaTicker(ativo.getTicker(), 0, callback); 
	}
	
	public static List<DiaPregao> getCotacao(AtivoAcao ativo) {
		return cotacoes.get(ativo.getTicker());
	}
	public static List<DiaPregao> getCotacao(String ticker) {
		return cotacoes.get(ticker);
	}
	

}

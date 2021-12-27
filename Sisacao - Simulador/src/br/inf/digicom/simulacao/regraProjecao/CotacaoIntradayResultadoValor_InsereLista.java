package br.inf.digicom.simulacao.regraProjecao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;

public class CotacaoIntradayResultadoValor_InsereLista extends ExecutorRegraProjecao {

	public boolean concluido = false;
	private List<CotacaoIntradayAcaoResultadoValor> listaValor;
	public void executa() {
		this.repValor.insereLista(listaValor, new VoidCallback() {

			@Override
			public void onSuccess() {
				//System.out.println("Dados enviados");
				concluido = true;
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
			
	
		while (!concluido) {
			try {
				Thread.sleep(Constantes.SLEEP_4_COTACAO_INTRADAY_RESULTADO_VALOR__INSERE_LISTA);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void setLista(List<CotacaoIntradayAcaoResultadoValor> listaValor) {
		this.listaValor = listaValor;
	}
}


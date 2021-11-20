package br.inf.digicom.simulacao.regraProjecao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public class DiaPregao_ObtemIntradayResultadoValor extends ExecutorRegraProjecao{


	private String ticker;
	private int dataNumInicio; 
	private RegraProjecao regraProjecao;
	
	
	
	
	public void setRegraProjecao(RegraProjecao regraProjecao) {
		this.regraProjecao = regraProjecao;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public void setDataNumInicio(int dataNumInicio) {
		this.dataNumInicio = dataNumInicio;
	}
	
	
	public boolean concluido = false;
	public void executa() {
		this.repDiaPregao.obtemIntradayResultadoValor(this.ticker, this.dataNumInicio, this.regraProjecao.getId(), new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				// TODO Auto-generated method stub
				System.out.println(objects.size());
				ProcessadorRegraProjecao proc = new ProcessadorRegraProjecao();
				proc.executa(ticker, regraProjecao, objects);
				concluido = true;
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			
			
		});
		while (!concluido) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

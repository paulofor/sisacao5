package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.com.digicom.sisacao.modelo.RelGrupoAcao;

public class RegraProjecao_ObtemProcessando extends ExecutorRegraProjecao {

	public boolean concluido = false;
	public void executa() {
		this.repRegraProjecao.obtemProcessando(new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao regra) {
				System.out.println("Recebi processando: " + regra);
				DiaPregao_ObtemIntradayResultadoValor processador = new DiaPregao_ObtemIntradayResultadoValor();
				for (RelGrupoAcao relAcao : regra.getGrupoAcao().getRelGrupoAcaos()) {
					processador.setDataNumInicio(20210101);
					processador.setTicker("B3SA3");
					//processador.setTicker(relAcao.getTicker());
					processador.setRegraProjecao(regra);
					processador.executa();
				}
				concluido = true;
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				t.printStackTrace();
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

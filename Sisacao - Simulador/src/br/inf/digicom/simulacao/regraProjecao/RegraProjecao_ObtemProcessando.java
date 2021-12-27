package br.inf.digicom.simulacao.regraProjecao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.com.digicom.sisacao.modelo.RelGrupoAcao;

public class RegraProjecao_ObtemProcessando extends ExecutorRegraProjecao {

	public boolean concluido = false;
	public void executa() {
		concluido = false;
		System.out.println("1.I");
		this.repRegraProjecao.obtemProcessando(new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao regra) {

				DiaPregao_ObtemIntradayResultadoValor processador = new DiaPregao_ObtemIntradayResultadoValor();
				for (RelGrupoAcao relAcao : regra.getGrupoAcao().getRelGrupoAcaos()) {
					//System.out.println("Ticker:" + relAcao.getTicker());
					processador.setDataNumInicio(20210101);
					processador.setTicker(relAcao.getTicker());
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
				Thread.sleep(Constantes.SLEEP_1_REGRA_PROJECAO__OBTEM_PROCESSANDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("1.F");
	}
	
	
	public void executa(Integer idRegraProjecao, Integer idGrupoAcao) {
		concluido = false;
		System.out.println("1.I");
		this.repRegraProjecao.obtemProcessando(new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao regra) {

				DiaPregao_ObtemIntradayResultadoValor processador = new DiaPregao_ObtemIntradayResultadoValor();
				for (RelGrupoAcao relAcao : regra.getGrupoAcao().getRelGrupoAcaos()) {
					//System.out.println("Ticker:" + relAcao.getTicker());
					processador.setDataNumInicio(20210101);
					processador.setTicker(relAcao.getTicker());
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
				Thread.sleep(Constantes.SLEEP_1_REGRA_PROJECAO__OBTEM_PROCESSANDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("1.F");
		
	}
}

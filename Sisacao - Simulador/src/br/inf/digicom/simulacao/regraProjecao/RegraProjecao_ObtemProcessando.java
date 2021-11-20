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
				for (RelGrupoAcao relAcao : regra.getGrupoAcao().getRelGrupoAcaos()) {
					
				}
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

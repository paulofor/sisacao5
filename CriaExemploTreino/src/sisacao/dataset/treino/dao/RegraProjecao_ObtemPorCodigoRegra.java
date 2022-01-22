package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.RegraProjecao;

public class RegraProjecao_ObtemPorCodigoRegra extends DaoBase {

	
	
	
	private String codigoRegra;

	
	
	
	public void setCodigoRegra(String codigoRegra) {
		this.codigoRegra = codigoRegra;
	}




	@Override
	public void executa() {
		repRegraProjecao.obtemPorCodigoRegra(codigoRegra, new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao object) {
				System.out.println("Regra Id: " + object.getId());
				getComum().setRegraProjecao(object);
				DiaPregao_ObtemIntradayResultadoDataset exec = new DiaPregao_ObtemIntradayResultadoDataset();
				exec.executa();
			}

			@Override
			public void onError(Throwable t) {
				this.onError(t);
			}
			
		});

	}

}

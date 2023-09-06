package br.inf.digicom.loopback.comum.regraprojecao;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.com.digicom.sisacao.repositorio.RepositorioRegraProjecao;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public class RegraProjecao_ProximoParaProcessamento extends DaoBaseComum {

	
	public static String NOME = "RegraProjecao_ProximoParaProcessamento";
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected RepositorioRegraProjecao rep = adapterItem.createRepository(RepositorioRegraProjecao.class);
	
	
	@Override
	public void executaImpl() {
		final RegraProjecao_ProximoParaProcessamentoDS ds = (RegraProjecao_ProximoParaProcessamentoDS) getComum();
		rep.proximoParaProcessamento( new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao object) {
				System.out.println("Regra(#" + object.getId() + ") : " + object.getCodigoRegraProjecao());
				ds.setRegraProjecao(object);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});

	}


	

	@Override
	protected long getTempo() {
		return 2000;
	}

	@Override
	protected String getNome() {
		return NOME;
	}
}

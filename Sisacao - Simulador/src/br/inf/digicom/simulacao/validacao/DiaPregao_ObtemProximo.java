package br.inf.digicom.simulacao.validacao;

import java.util.LinkedList;
import java.util.List;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.validacao.DiaPregao_ProximoParaValidador;

public class DiaPregao_ObtemProximo extends DiaPregao_ProximoParaValidador {

	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();

		this.repDiaPregao.obtemProximo(new ObjectCallback<DiaPregao>() {

			@Override
			public void onSuccess(DiaPregao object) {
				List<DiaPregao> listaDia = new LinkedList<DiaPregao>();
				listaDia.add(object);
				ds.setDiaValidacao(listaDia);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
				
			}});
	}
}

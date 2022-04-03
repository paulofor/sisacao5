package br.inf.digicom.atualizaProximo;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.validacao.DiaPregao_ObtemIntradayTickerPeriodo;

public class AtualizaProximoDiaPregao extends DiaPregao_ObtemIntradayTickerPeriodo {

	

	
	@Override
	protected DaoBaseApp getProximo() {
		return new AtualizaProximoDiaPregaoProximo();
	}

	
	
}

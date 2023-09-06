package br.inf.digicom.loopback.comum.diapregao;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.RegraProjecao;

public interface DiaPregao_ObtemIntradayResultadoValorDS {

	void setListaCotacaoResultado(List<DiaPregao> listaCotacao);
	AtivoAcao getAtivoAcaoCorrente();
	RegraProjecao getRegraProjecao();
	int getDiaNumInicio();
	int getTamanhoAmostra();

}

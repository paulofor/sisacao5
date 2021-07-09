package br.inf.digicom.simulacao;

import java.util.List;
import java.util.Map;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public interface IRegraPontoEntrada {

	void setExecucaoPontoEntrada(ExecucaoPontoEntrada execucao);

	void setDiaInicial(int indDia);

	double getPontoEntrada(int indDia, List<DiaPregao> dias);

	double getTarget();

	double getStop();

	void setParametros(Map parametros);
	
	String getTipo();

}

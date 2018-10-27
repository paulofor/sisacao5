package coletorjava.modelo.vo.custom;

import coletorjava.modelo.Cotacao;
import coletorjava.modelo.OpcaoSisacao;

public class OpcaoSisacaoECotacao {

	private Cotacao mCotacao = null;
	private OpcaoSisacao mOpcao = null;
	
	public OpcaoSisacaoECotacao(OpcaoSisacao opcao, Cotacao cotacao) {
		mOpcao = opcao;
		mCotacao = cotacao;
	}

	public long getNeg() {
		return mCotacao.getNeg();
	}
	public OpcaoSisacao getOpcao() {
		return mOpcao;
	}
	public float getUlt() {
		return mCotacao.getUlt();
	}
	
	public String getDataHora() {
		return mCotacao.getData() + "->" + mCotacao.getHoraReal();
	}
}

package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class EscolhaOpcaoAssembled   implements EscolhaOpcaoAssembledI { 
  private Ticker _TickerReferenteA;
	public Ticker getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( Ticker dado ) {
		_TickerReferenteA = dado;
	}
  private OpcaoSisacao _OpcaoSisacaoEscolha;
	public OpcaoSisacao getOpcaoSisacaoEscolha() {
		return _OpcaoSisacaoEscolha;
	}
	public void setOpcaoSisacaoEscolha( OpcaoSisacao dado ) {
		_OpcaoSisacaoEscolha = dado;
	}
  private DiaPregao _DiaPregaoReferenteA;
	public DiaPregao getDiaPregaoReferenteA() {
		return _DiaPregaoReferenteA;
	}
	public void setDiaPregaoReferenteA( DiaPregao dado ) {
		_DiaPregaoReferenteA = dado;
	}
}

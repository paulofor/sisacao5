package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class OpcaoReferenciaAssembled   implements OpcaoReferenciaAssembledI { 
  private Ticker _TickerReferenteA;
	public Ticker getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( Ticker dado ) {
		_TickerReferenteA = dado;
	}
  private DiaPregao _DiaPregaoReferenteA;
	public DiaPregao getDiaPregaoReferenteA() {
		return _DiaPregaoReferenteA;
	}
	public void setDiaPregaoReferenteA( DiaPregao dado ) {
		_DiaPregaoReferenteA = dado;
	}
  private OpcaoSisacao _OpcaoSisacaoReferenteA;
	public OpcaoSisacao getOpcaoSisacaoReferenteA() {
		return _OpcaoSisacaoReferenteA;
	}
	public void setOpcaoSisacaoReferenteA( OpcaoSisacao dado ) {
		_OpcaoSisacaoReferenteA = dado;
	}
}

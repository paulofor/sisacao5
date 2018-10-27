package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class OpcaoSisacaoGeralAssembled   implements OpcaoSisacaoGeralAssembledI { 
  private Ticker _TickerReferenteA;
	public Ticker getTickerReferenteA() {
		return _TickerReferenteA;
	}
	public void setTickerReferenteA( Ticker dado ) {
		_TickerReferenteA = dado;
	}
}

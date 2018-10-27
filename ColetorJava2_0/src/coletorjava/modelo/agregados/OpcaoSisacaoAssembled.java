package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class OpcaoSisacaoAssembled   implements OpcaoSisacaoAssembledI { 
  private OpcaoSisacaoSerie _OpcaoSisacaoSeriePertenceA;
	public OpcaoSisacaoSerie getOpcaoSisacaoSeriePertenceA() {
		return _OpcaoSisacaoSeriePertenceA;
	}
	public void setOpcaoSisacaoSeriePertenceA( OpcaoSisacaoSerie dado ) {
		_OpcaoSisacaoSeriePertenceA = dado;
	}
  private Ticker _TickerDerivativoDe;
	public Ticker getTickerDerivativoDe() {
		return _TickerDerivativoDe;
	}
	public void setTickerDerivativoDe( Ticker dado ) {
		_TickerDerivativoDe = dado;
	}
}

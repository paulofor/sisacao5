package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class DadoThetaAssembled   implements DadoThetaAssembledI { 
  private TreinoRede _TreinoRedeGeradoPor;
	public TreinoRede getTreinoRedeGeradoPor() {
		return _TreinoRedeGeradoPor;
	}
	public void setTreinoRedeGeradoPor( TreinoRede dado ) {
		_TreinoRedeGeradoPor = dado;
	}
}

package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class TreinoRedeAssembled   implements TreinoRedeAssembledI { 
  private Rede _RedePertenceA;
	public Rede getRedePertenceA() {
		return _RedePertenceA;
	}
	public void setRedePertenceA( Rede dado ) {
		_RedePertenceA = dado;
	}
  private DadoTreino _DadoTreinoGeradoPor;
	public DadoTreino getDadoTreinoGeradoPor() {
		return _DadoTreinoGeradoPor;
	}
	public void setDadoTreinoGeradoPor( DadoTreino dado ) {
		_DadoTreinoGeradoPor = dado;
	}
}

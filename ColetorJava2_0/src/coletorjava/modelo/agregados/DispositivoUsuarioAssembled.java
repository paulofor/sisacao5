package coletorjava.modelo.agregados;


import coletorjava.modelo.agregados.*;
import coletorjava.modelo.*;


public  class DispositivoUsuarioAssembled   implements DispositivoUsuarioAssembledI { 
  private Usuario _UsuarioReferenteA;
	public Usuario getUsuarioReferenteA() {
		return _UsuarioReferenteA;
	}
	public void setUsuarioReferenteA( Usuario dado ) {
		_UsuarioReferenteA = dado;
	}
}

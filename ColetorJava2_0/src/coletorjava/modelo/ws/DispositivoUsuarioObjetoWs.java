package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class DispositivoUsuarioObjetoWs   { 
      long _idDispositivoUsuario;
	public long getIdDispositivoUsuario() {
		return _idDispositivoUsuario;
	}
	public void setIdDispositivoUsuario( long dado ) {
		_idDispositivoUsuario = dado;
	}
      String _numeroCelular;
	public String getNumeroCelular() {
		return _numeroCelular;
	}
	public void setNumeroCelular( String dado ) {
		_numeroCelular = dado;
	}
      String _codigoDispositivo;
	public String getCodigoDispositivo() {
		return _codigoDispositivo;
	}
	public void setCodigoDispositivo( String dado ) {
		_codigoDispositivo = dado;
	}
      String _tipoAcesso;
	public String getTipoAcesso() {
		return _tipoAcesso;
	}
	public void setTipoAcesso( String dado ) {
		_tipoAcesso = dado;
	}
      String _melhorPath;
	public String getMelhorPath() {
		return _melhorPath;
	}
	public void setMelhorPath( String dado ) {
		_melhorPath = dado;
	}
      long _idUsuarioRa;
	public long getIdUsuarioRa() {
		return _idUsuarioRa;
	}
	public void setIdUsuarioRa( long dado ) {
		_idUsuarioRa = dado;
	}
  private UsuarioObjetoWs _UsuarioReferenteA;
	public UsuarioObjetoWs getUsuarioReferenteA() {
		return _UsuarioReferenteA;
	}
	public void setUsuarioReferenteA( UsuarioObjetoWs dado ) {
		_UsuarioReferenteA = dado;
	}
}

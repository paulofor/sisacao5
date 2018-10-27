package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class RegraEntradaObjetoWs   { 
      long _idRegraEntrada;
	public long getIdRegraEntrada() {
		return _idRegraEntrada;
	}
	public void setIdRegraEntrada( long dado ) {
		_idRegraEntrada = dado;
	}
      String _nomeRegra;
	public String getNomeRegra() {
		return _nomeRegra;
	}
	public void setNomeRegra( String dado ) {
		_nomeRegra = dado;
	}
}

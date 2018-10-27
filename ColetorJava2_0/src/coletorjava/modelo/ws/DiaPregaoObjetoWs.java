package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class DiaPregaoObjetoWs   { 
      long _idDiaPregao;
	public long getIdDiaPregao() {
		return _idDiaPregao;
	}
	public void setIdDiaPregao( long dado ) {
		_idDiaPregao = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      boolean _feriado;
	public boolean getFeriado() {
		return _feriado;
	}
	public void setFeriado( boolean dado ) {
		_feriado = dado;
	}
      DCIObjetoDominio _anterior;
	public DCIObjetoDominio getAnterior() {
		return _anterior;
	}
	public void setAnterior( DCIObjetoDominio dado ) {
		_anterior = dado;
	}
      long _dataInteiro;
	public long getDataInteiro() {
		return _dataInteiro;
	}
	public void setDataInteiro( long dado ) {
		_dataInteiro = dado;
	}
      DCIObjetoDominio _ultimaCotacaoProcessada;
	public DCIObjetoDominio getUltimaCotacaoProcessada() {
		return _ultimaCotacaoProcessada;
	}
	public void setUltimaCotacaoProcessada( DCIObjetoDominio dado ) {
		_ultimaCotacaoProcessada = dado;
	}
      List _listaCotacaoProcessada;
	public List getListaCotacaoProcessada() {
		return _listaCotacaoProcessada;
	}
	public void setListaCotacaoProcessada( List dado ) {
		_listaCotacaoProcessada = dado;
	}
}

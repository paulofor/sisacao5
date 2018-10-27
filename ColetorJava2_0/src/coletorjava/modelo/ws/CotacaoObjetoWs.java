package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class CotacaoObjetoWs   { 
      long _id;
	public long getId() {
		return _id;
	}
	public void setId( long dado ) {
		_id = dado;
	}
      long _neg;
	public long getNeg() {
		return _neg;
	}
	public void setNeg( long dado ) {
		_neg = dado;
	}
      String _dataVar;
	public String getData() {
		return _dataVar;
	}
	public void setData( String dado ) {
		_dataVar = dado;
	}
      float _ult;
	public float getUlt() {
		return _ult;
	}
	public void setUlt( float dado ) {
		_ult = dado;
	}
      String _horaReal;
	public String getHoraReal() {
		return _horaReal;
	}
	public void setHoraReal( String dado ) {
		_horaReal = dado;
	}
      String _horaNeg;
	public String getHoraNeg() {
		return _horaNeg;
	}
	public void setHoraNeg( String dado ) {
		_horaNeg = dado;
	}
      String _linhaLog;
	public String getLinhaLog() {
		return _linhaLog;
	}
	public void setLinhaLog( String dado ) {
		_linhaLog = dado;
	}
}

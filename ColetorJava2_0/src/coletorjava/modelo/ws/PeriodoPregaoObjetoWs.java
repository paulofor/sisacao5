package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class PeriodoPregaoObjetoWs   { 
      long _idPeriodoPregao;
	public long getIdPeriodoPregao() {
		return _idPeriodoPregao;
	}
	public void setIdPeriodoPregao( long dado ) {
		_idPeriodoPregao = dado;
	}
      String _horaInicio;
	public String getHoraInicio() {
		return _horaInicio;
	}
	public void setHoraInicio( String dado ) {
		_horaInicio = dado;
	}
      String _horaTermino;
	public String getHoraTermino() {
		return _horaTermino;
	}
	public void setHoraTermino( String dado ) {
		_horaTermino = dado;
	}
      String _dataInicioPeriodo;
	public String getDataInicioPeriodo() {
		return _dataInicioPeriodo;
	}
	public void setDataInicioPeriodo( String dado ) {
		_dataInicioPeriodo = dado;
	}
      String _dataTerminoPeriodo;
	public String getDataTerminoPeriodo() {
		return _dataTerminoPeriodo;
	}
	public void setDataTerminoPeriodo( String dado ) {
		_dataTerminoPeriodo = dado;
	}
}

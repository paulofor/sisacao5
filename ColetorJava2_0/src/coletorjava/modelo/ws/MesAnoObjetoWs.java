package coletorjava.modelo.ws;


import coletorjava.modelo.vo.*;
import coletorjava.modelo.*;
import br.com.digicom.lib.DCIObjetoDominio;
import java.util.List;


public  class MesAnoObjetoWs   { 
      long _idMesAno;
	public long getIdMesAno() {
		return _idMesAno;
	}
	public void setIdMesAno( long dado ) {
		_idMesAno = dado;
	}
      String _nomeMes;
	public String getNomeMes() {
		return _nomeMes;
	}
	public void setNomeMes( String dado ) {
		_nomeMes = dado;
	}
      long _numeroAno;
	public long getNumeroAno() {
		return _numeroAno;
	}
	public void setNumeroAno( long dado ) {
		_numeroAno = dado;
	}
      String _mesAnoData;
	public String getMesAnoData() {
		return _mesAnoData;
	}
	public void setMesAnoData( String dado ) {
		_mesAnoData = dado;
	}
      long _numeroMes;
	public long getNumeroMes() {
		return _numeroMes;
	}
	public void setNumeroMes( long dado ) {
		_numeroMes = dado;
	}
}
